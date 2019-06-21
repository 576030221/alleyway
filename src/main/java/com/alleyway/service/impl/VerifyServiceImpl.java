package com.alleyway.service.impl;

import com.alleyway.bean.*;
import com.alleyway.bean.UserExample.Criteria;
import com.alleyway.dao.*;
import com.alleyway.service.EmpiricalService;
import com.alleyway.service.UserInformationService;
import com.alleyway.service.RedisTemplateService;
import com.alleyway.service.VerifyService;
import com.alleyway.utils.MD5Util;
import com.alleyway.utils.PhoneMessageUtil;
import com.alleyway.utils.SqlDateUtil;
import com.alleyway.utils.comparator.ContentJudgeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@Service
public class VerifyServiceImpl implements VerifyService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserGradeMapper userGradeMapper;
    @Autowired
    private UserInformationService userInformationService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplateService redisTemplateService;
    @Autowired
    private EmpiricalService empiricalService;

    /**
     * 用户注册
     * @param userPhone 手机号
     * @param userName 用户名
     * @param userPassWord 密码
     * @return 是否注册成功
     */
    public int register(String userPhone,String userName, String userPassWord){
        // 产生随机昵称
        String nickname="";
        boolean isWhile = true;
        while (isWhile){
	  nickname= getRandomJianHan(1)+getStringRandom(5)+getRandomJianHan(2);
	  // 判断昵称是否存在
	  boolean b = userInformationService.comparatorNickname(nickname);
	  if (!b){
	      isWhile = false;
	  }
        }

        // 封装User
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(MD5Util.getMD5(userName));
        user.setUserPhone(userPhone);
        user.setNickname(nickname);
        user.setUserCity("北京市");
        user.setBirthday("1990-01-01");
        user.setHeadPortraitId(1);
        user.setPendantId(1);
        user.setAddTime(SqlDateUtil.nowDataTimeToString());
        // 设定用户的角色为1，以后要改的，暂时为1
        user.setRoleId(1);
        // 将User存入用户表       若需要插入时直接返回id，需要在mapper.xml的inster标签中添加两个属性  useGeneratedKeys="true" keyProperty="id"
        int userId = userMapper.insert(user);
        // 如果成功插入数据，返回对象的id   否则返回0
        return userId > 0 ? user.getId() : 0;
    }

    /**
     * 登录 根据用户名密码获取User对象
     * @param account 用户名或密码
     * @param userPassWord 加密后密码
     * @return 当前登录的用户数据
     */
    public User login(String account, String userPassWord) {
        if (account.isEmpty() || userPassWord.isEmpty()){
	  return null;
        }
        // 判断redis中是否存在这个用户名密码的用户信息，如果有，直接返回，不查询数据库
        User userRedis = redisTemplateService.get("userInformation_" + account + "_" +userPassWord , User.class);
        if (userRedis != null){
	  return userRedis;
        }
        // redis中没有此用户数据，需要判断数据库有没有这条数据，然后返回User
        UserExample userExample = new UserExample();
        Criteria criteria = userExample.createCriteria();
        criteria.andUserPasswordEqualTo(userPassWord);
        // 判断传递过来的账号是否为是否为手机号码
        if (ContentJudgeUtil.isPhoneNumber(account)) {
	  criteria.andUserPhoneEqualTo(account);
        } else {
	  criteria.andUserNameEqualTo(account);
        }
        List<User> users = userMapper.selectByExample(userExample);
        return users.size() == 0 ? null : users.get(0);
    }

    /**
     * 初始化 将用户录入用户等级表，初始化等级为0
     */
    @Override
    public void enteringUserGradeTable(int userId) {
        UserGrade userGrade = new UserGrade();
        userGrade.setUserId(userId);
        // 等级为0
        userGrade.setEmpirica(0);
        // 经验为0
        userGrade.setGrade(0);
        // 升级经验百分比为0.00
        userGrade.setPercent(BigDecimal.valueOf(0.00));
        userGradeMapper.insert(userGrade);
    }




    /**
     * 获取手机验证码
     * @param userPhone
     * @param ip
     */
    @Override
    public String getPhoneVerify(String userPhone, String ip) {
        // 判断手机位数
        if (userPhone.length()!=11) {
	  return null;
        }

	// 判断你这个ip有没有在58秒内发送过验证码，如果不为空，表示刚刚发过了，不能发了
        String time = stringRedisTemplate.opsForValue().get("getPhoneVerifyTime_" + ip);
        if (time != null) {
            return null;
        }


        // 判断当天此手机号获取短信等次数是否超出
        String userPhoneSize = stringRedisTemplate.opsForValue().get("getPhoneVerify_" + userPhone);
        int userPhoneSizeInt = 0;
        if (userPhoneSize != null) {
	  userPhoneSizeInt = Integer.valueOf(userPhoneSize);
	  if (userPhoneSizeInt > 3) {
	      return null;
	  }
        }

        // 判断当天此IP获取短信的次数是否超出
        String ipSize = stringRedisTemplate.opsForValue().get("getPhoneVerify_" + ip);int ipSizeInt = 0;
        if (ipSize != null) {
	  ipSizeInt = Integer.valueOf(ipSize);
	  if (ipSizeInt > 5) {
	      return null;
	  }
        }

        String code= String.valueOf((int) (Math.random()*10000));   // 四位验证码的生成
        PhoneMessageUtil.mobileQuery(userPhone,"163954",code);
        userPhoneSizeInt++;
        ipSizeInt++;
        // 日志
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date())+"        成功发送手机验证码,手机号："+userPhone);

        stringRedisTemplate.opsForValue().set("getPhoneVerify_" + userPhone, String.valueOf(userPhoneSizeInt));
        //在58秒内，redis中有这条数据，在发送验证码的时候，判断redis中有没有这数据，如果有，则提示不能频繁发送
        stringRedisTemplate.opsForValue().set("getPhoneVerifyTime_" + ip, "true",58, TimeUnit.SECONDS);
        stringRedisTemplate.opsForValue().set("getPhoneVerify_" + ip, String.valueOf(ipSizeInt));
        return code;
    }


    //自动生成名字（中文）
    public static String getRandomJianHan(int len) {
        String ret = "";
        for (int i = 0; i < len; i++) {
	  String str = null;
	  int hightPos, lowPos; // 定义高低位
	  Random random = new Random();
	  hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
	  lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
	  byte[] b = new byte[2];
	  b[0] = (new Integer(hightPos).byteValue());
	  b[1] = (new Integer(lowPos).byteValue());
	  try {
	      str = new String(b, "GBK"); // 转成中文
	  } catch (Exception ex) {
	  }
	  ret += str;
        }
        return ret;
    }

    //生成随机用户名，数字和字母组成,
    public static String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {

	  String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
	  //输出字母还是数字
	  if( "char".equalsIgnoreCase(charOrNum) ) {
	      //输出是大写字母还是小写字母
	      int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
	      val += (char)(random.nextInt(26) + temp);
	  } else if( "num".equalsIgnoreCase(charOrNum) ) {
	      val += String.valueOf(random.nextInt(10));
	  }
        }
        return val;
    }

}
