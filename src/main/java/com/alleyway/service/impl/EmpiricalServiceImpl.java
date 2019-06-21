package com.alleyway.service.impl;

import com.alleyway.bean.EmpiricalIncreaseRuleExample;
import com.alleyway.bean.UserGrade;
import com.alleyway.bean.UserGradeExample;
import com.alleyway.config.user_defined.DayOperationSizeConfig;
import com.alleyway.dao.*;
import com.alleyway.service.EmpiricalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author: 洪
 */
@Service
public class EmpiricalServiceImpl implements EmpiricalService {


    @Autowired
    private UserGradeMapper userGradeMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private EmpiricalRuleMapper empiricalRuleMapper;
    @Autowired
    private EmpiricalIncreaseRuleMapper empiricalIncreaseRuleMapper;
    @Autowired
    private DayOperationSizeConfig dayOperationSizeConfig;

    /**
     * 判断是否满足加经验的条件（每天的操作有没有超过次数），如果能加，则自动加
     * @param userId 用户id
     * @param operation 操作代表的数字 1：发布作品 2：发布评论回复 3：观看视频 4：每日登陆
     */
    @Override
    public void verifyOperationNumber(int userId,int operation){
        	// 各种操作加经验次数上限
        	int restrictSize=0;
        	// redis中的key
        	String redisKeyName="";
	switch (operation){
	    case 1:
	        // 获取每天加经验次数上限
	        restrictSize = dayOperationSizeConfig.getSaveWords();
	        // 修改key的名字
	        redisKeyName = "day_save_works_size_";
	        break;
	    case 2:
	        restrictSize = dayOperationSizeConfig.getComment();
	        redisKeyName = "day_comment_size_";
	        break;
	    case 3:
	        restrictSize = dayOperationSizeConfig.getLookVideo();
	        redisKeyName = "day_look_video_size_";
	        break;
	    case 4:
	        restrictSize = dayOperationSizeConfig.getLogin();
	        redisKeyName = "day_login_size_";
	        break;
	}
	// 获取redis中记录的当天此操作已经完成的次数
        	String daySizeRedis = stringRedisTemplate.opsForValue().get(redisKeyName + userId);
	int daySize = 0;
	if (daySizeRedis != null) {
	    daySize = Integer.valueOf(daySizeRedis);
	}
	// 如果这个操作在今天做的次数很多了，就不加经验了
        	if(daySize >= restrictSize){
	    return;
	}
	// 增加经验值
        	gradeControl(userId,operation);
	// 给redis中的内容进行+1
	daySize++;
	stringRedisTemplate.opsForValue().set(redisKeyName + userId, String.valueOf(daySize));
    }


    /**
     * 经验管理，控制用户的加经验与升级
     * @param userId    用户id
     * @param operation 用户所做的操作对应的数字  对应aw_user_operation_size表
     */
    @Override
    public void gradeControl(int userId, int operation) {
        // 存储这个操作可以增加的经验值，根据operation代表的操作redis中获取，redis中获取不到再去数据库获取
        Integer increaseEmpirica = 0;
        // 从redis中获取这个操作可添加多少经验值
        String value = stringRedisTemplate.opsForValue().get("operation_" + operation);
        if (value == null) {
	  // redis中获取不到，从数据库中获取，然后插入到redis中
	  EmpiricalIncreaseRuleExample empiricalIncreaseRuleExample = new EmpiricalIncreaseRuleExample();
	  EmpiricalIncreaseRuleExample.Criteria criteria1 = empiricalIncreaseRuleExample.createCriteria();
	  criteria1.andOperationEqualTo(operation);
	  increaseEmpirica = empiricalIncreaseRuleMapper.selectByExample(empiricalIncreaseRuleExample).get(0).getIncreaseEmpirica();
	  // 存入redis，存活时间为15天
	  stringRedisTemplate.opsForValue().set("operation_"+operation, String.valueOf(increaseEmpirica),1000*60*60*15,TimeUnit.MILLISECONDS);
        }else {
            //  redis中获取到了经验值，添加到变量中
	  increaseEmpirica = Integer.valueOf(value);
        }
        // 获取当前用户的等级与经验合
        UserGradeExample userGradeExample = new UserGradeExample();
        UserGradeExample.Criteria criteria2 = userGradeExample.createCriteria();
        criteria2.andUserIdEqualTo(userId);
        UserGrade userGrade = userGradeMapper.selectByExample(userGradeExample).get(0);
        // 将首次登录获取到的经验添加到经验合之中

        userGrade.setEmpirica(userGrade.getEmpirica() + increaseEmpirica);


        // 获取用户当前等级所需要的经验合
        Integer needEmpirica;
        Integer grade = userGrade.getGrade();
        // 如果等级为0，不需要去查等级经验规则数据库，直接把当前等级所需经验赋值为0
        if (grade != 0) {
            // 从redis中获取当前等级所需经验； 如果redis中没有，从数据库中获取
	  String needEmpiricaRedis = stringRedisTemplate.opsForValue().get("needEmpirica_" + grade);
	  if (needEmpiricaRedis != null) {
	      needEmpirica = Integer.valueOf(needEmpiricaRedis);
	  }else {
	      needEmpirica = empiricalRuleMapper.selectByPrimaryKey(grade).getNeedEmpirica();
	      stringRedisTemplate.opsForValue().set("needEmpirica_" + grade, String.valueOf(needEmpirica));
	  }
        } else {
	  needEmpirica = 0;
        }
        // 获取下一个等级所需经验
        Integer needEmpiricaNext;
        grade = userGrade.getGrade()+1;
        String needEmpiricaNextRedis = stringRedisTemplate.opsForValue().get("needEmpirica_" + grade);
        if (needEmpiricaNextRedis != null) {
            needEmpiricaNext = Integer.valueOf(needEmpiricaNextRedis);
        }else {
	  needEmpiricaNext = empiricalRuleMapper.selectByPrimaryKey(grade).getNeedEmpirica();
	  stringRedisTemplate.opsForValue().set("needEmpirica_" + grade, String.valueOf(needEmpiricaNext));
        }
        Integer empirica = userGrade.getEmpirica();
        // 判断经验是否已经达到下一等级的所需经验
        if (empirica < needEmpiricaNext) {
	  // 未达到
	  // 计算当前经验在本级中的百分比    本级中的经验/本级所需经验
	  float num = (float)(empirica - needEmpirica) / (needEmpiricaNext - needEmpirica);
	  DecimalFormat df = new DecimalFormat("0.00");
	  BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(df.format(num)));
	  userGrade.setPercent(bigDecimal);
        }else{
	  // 达到了
	  // 等级+1
	  userGrade.setGrade(userGrade.getGrade() + 1);
	  // 获取下下个等级所需的经验
	  Integer needEmpiricaAfterNext = 0;
	  grade = userGrade.getGrade() + 2;
	  String needEmpiricaAfterNextRedis = stringRedisTemplate.opsForValue().get("needEmpirica_" + grade);
	  if (needEmpiricaNextRedis != null) {
	      needEmpiricaAfterNext = Integer.valueOf(needEmpiricaAfterNextRedis);
	  }else {
	      needEmpiricaAfterNext = empiricalRuleMapper.selectByPrimaryKey(grade).getNeedEmpirica();
	      stringRedisTemplate.opsForValue().set("needEmpirica_" + grade, String.valueOf(needEmpiricaAfterNext));
	  }
	  // 计算当前经验在下个等级中占的百分比
	  float num = (float)(empirica - needEmpiricaNext) / (needEmpiricaAfterNext - needEmpiricaNext);
	  DecimalFormat df = new DecimalFormat("0.00");
	  BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(df.format(num)));
	  userGrade.setPercent(bigDecimal);
        }
        // 更新用户等级1
        userGradeMapper.updateByPrimaryKey(userGrade);
    }
}
