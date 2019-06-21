package com.alleyway.service;

/**
 * describe:
 *
 * @author: 洪
 */
public interface EmpiricalService {

    /**
     * 判断是否满足加经验的条件（每天的操作有没有超过次数），如果能加，则自动加
     * @param userId 用户id
     * @param operation 操作代表的数字 1：发布作品 2：发布评论回复 3：观看视频 4：每日登陆
     */
    public void verifyOperationNumber(int userId, int operation);


    /**
     * 经验管理，控制用户的加经验与升级
     * @param userId    用户id
     * @param operation 用户所做的操作对应的数字  对应aw_user_operation_size表
     */
    public void gradeControl(int userId, int operation);
}
