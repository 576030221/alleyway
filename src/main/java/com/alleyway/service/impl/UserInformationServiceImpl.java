package com.alleyway.service.impl;

import com.alleyway.bean.*;
import com.alleyway.config.user_defined.FdfsConfig;
import com.alleyway.dao.*;
import com.alleyway.service.UserInformationService;
import com.alleyway.service.OperationService;
import com.alleyway.service.RedisTemplateService;
import com.alleyway.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    /**
     * redis中用于存放用户信息的前缀
     */
    public static final String USER_INFORMATION = "userInformation_";

    @Autowired
    private FdfsConfig fdfsConfig;
    @Autowired
    private RedisTemplateService redisTemplateService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserGradeMapper userGradeMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private EmpiricalRuleMapper empiricalRuleMapper;
    @Autowired
    private EmpiricalIncreaseRuleMapper empiricalIncreaseRuleMapper;
    @Autowired
    private UserOperationMapper userOperationMapper;
    @Autowired
    private OperationService operationService;




    /**
     * 查找数据库中是否存在此用户名
     * @param userName
     * @return 是否有重复 true：有重复
     */
    public boolean comparatorUserName(String userName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        int size = userMapper.countByExample(userExample);
        return size > 0;
    }

    /**
     * 查找数据库中是否存在此手机号
     * @param userPhone
     * @return 是否有重复 true：有重复
     */
    public boolean comparatorUserPhone(String userPhone) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserPhoneEqualTo(userPhone);
        int size = userMapper.countByExample(userExample);
        return size > 0;
    }

    /**
     * 查找数据库中是否存在此昵称
     * @param nickname
     * @return 是否有重复 true：有重复
     */
    public boolean comparatorNickname(String nickname) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNicknameEqualTo(nickname);
        int size = userMapper.countByExample(userExample);
        return size > 0;
    }

    /**
     * 获取用户基本信息，在Redis中，如果redis中没有，再去数据库拿，最后更新到redis
     * @param userName
     * @param userPassWord
     * @return
     */
    public User getUserData(String userName, String userPassWord) {
        // 判断帐号密码是否为空
        if (userName.isEmpty() || userPassWord.isEmpty()) {
            return null;
        }
        userPassWord = MD5Util.getMD5(userPassWord);
        // 获取redis中用户的基本信息,如果获取成功，直接返回user对象。redisTemplateService中封装了对象与redis的交互
        User userRedis = redisTemplateService.get(USER_INFORMATION + userName + "_" + userPassWord , User.class);
        if (null != userRedis) {
            return userRedis;
        }
        // redis获取数据为null，在数据库中获取，并且将获取的数据存入redis
        User userData = getUserDataByDatabase(userName, userPassWord);
        return userData;
    }

    /**
     * 获取用户基本细信息，在数据库中，然后存入redis
     *
     * 个人中心修改用户数据后，开个线程调用这个方法，作用：更新redis中的用户数据
     *
     * 之所以将从redis获取和从数据库获取的方法分离开来，是因为：
     *  如果用户修改了个人信息，那么redis中的数据就需要更新，只需要调用这个方法，就可以将数据库的最新数据更新到redis中
     *  如果只是想获取用户数据，则调用 getUserData 即可，那个方法会优先从redis中获取
     *
     * @param userName 用户名
     * @param userPassWord 加密后的密码
     * @return
     */
    public User getUserDataByDatabase(String userName, String userPassWord) {
        // 判断帐号密码是否为空
        if (userName.isEmpty() || userPassWord.isEmpty()) {
            return null;
        }
        // 获取用户的基本信息  自定义方法
        User user = userMapper.selectUserDataByUserNameUserPassword(userName, userPassWord);    //SELECT user.id,user.nickname,user.email,user.gender,user.head_portrait_id,user.pendant_id,user.status,user.birthday,user.user_city,head.file_path AS head_file_path,head.compress_file_path AS head_compress_file_path,pendant.file_path AS pendantFROM aw_user USER,aw_head_portrait head,aw_pendant pendantWHERE user.`user_name`=#{userName} AND user.`user_password`=#{userPassword}AND user.`head_portrait_id`=head.`id` AND user.`pendant_id`=pendant.`id`
        if (null != user) {
            // 给用户头像加上服务器ip前缀，ip前缀在配置文件里配置
            String serverUrl = fdfsConfig.getWebServerUrl();
            user.setPendant(serverUrl + user.getPendant());
            user.setHeadPortraitCompress(serverUrl + user.getHeadPortraitCompress());
            user.setHeadPortrait(serverUrl + user.getHeadPortrait());
            // 将用户基本信息存到redis中，储存或者覆盖，，设置过期时间为7天
            redisTemplateService.set("userInformation_" + userName + "_" + userPassWord , user);
	  stringRedisTemplate.expire("userInformation_" + userName + "_" + userPassWord ,1000*60*60*24*7,TimeUnit.MILLISECONDS);
        }
        return user;
    }

    /**
     * 获取用户的等级信息
     * @param id    用户id
     * @return
     */
    public UserGrade getUserGrade(Integer id) {
        UserGradeExample userGradeExample = new UserGradeExample();
        UserGradeExample.Criteria criteria = userGradeExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        UserGrade userGrade = userGradeMapper.selectByExample(userGradeExample).get(0);
        if (null == userGrade) {
            return null;
        }
        return userGrade;
    }

    /**
     * 获取用户的操作记录信息，点赞了什么，收藏了什么
     * @param id 用户id
     * @return
     */
    public Map<String, int[]> getUserOperation(Integer id) {
        Map<String,int[]> map = new HashMap<>();
        map.put("like_works",operationService.getOperation(id,1,1));
        map.put("like_video",operationService.getOperation(id,1,2));
        map.put("like_comment",operationService.getOperation(id,1,2));
        map.put("collect_works",operationService.getOperation(id,2,1));
        map.put("collect_video",operationService.getOperation(id,2,2));
        return map;
    }



}
