package com.alleyway.service;


import com.alleyway.bean.User;

public interface VerifyService {
    /**
     * 用户注册
     * @param userPhone 手机号
     * @param userName 用户名
     * @param userPassWord 密码
     * @return 是否注册成功
     */
    int register(String userPhone, String userName, String userPassWord);

    /**
     * 将用户录入用户等级表，初始化等级为0
     * @param userId 用户id
     */
    void enteringUserGradeTable(int userId);

    /**
     * 登录 判断用户名密码是否正确
     * @param account 用户名或手机号
     * @param userPassWord 密码
     * @return 当前登录的用户
     */
    User login(String account, String userPassWord);



    /**
     * 获取手机验证码
     * @param userPhone
     * @param ip
     */
    String getPhoneVerify(String userPhone, String ip);
}
