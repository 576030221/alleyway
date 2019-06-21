package com.alleyway.service;

import com.alleyway.bean.User;
import com.alleyway.bean.UserGrade;

import java.util.Map;

public interface UserInformationService {



    /**
     * 查找数据库中是否存在此用户名
     * @param userName
     * @return 是否有重复 true：有重复
     */
    boolean comparatorUserName(String userName);

    /**
     * 查找数据库中是否存在此手机号
     * @param userPhone
     * @return 是否有重复 true：有重复
     */
    boolean comparatorUserPhone(String userPhone);


    /**
     * 查找数据库中是否存在此昵称
     * @param nickname
     * @return 是否有重复 true：有重复
     */
    boolean comparatorNickname(String nickname);

    /**
     * 获取用户的详细信息,在数据库中，并且更新redis
     * @param userName
     * @param userPassWord
     * @return
     */
    User getUserDataByDatabase(String userName, String userPassWord);

    /**
     * 获取用户的详细信息 在Redis中
     * @param userName
     * @param userPassWord
     * @return
     */
    User getUserData(String userName, String userPassWord);

    /**
     * 获取用户的等级信息
     * @param id    用户id
     * @return
     */
    UserGrade getUserGrade(Integer id);

    /**
     * 获取用户的操作记录信息，点赞了什么，收藏了什么
     * @param id 用户id
     * @return
     */
    Map<String,int[]> getUserOperation(Integer id);
}
