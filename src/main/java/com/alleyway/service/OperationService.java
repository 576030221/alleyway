package com.alleyway.service;


import com.alleyway.bean.UserOperation;

public interface OperationService {

    /**
     *  获取用户操作记录
     *
     * @param userId 用户id
     * @param operationTypen 操作的分类 1：点赞 2：收藏
     * @param targetType	目标分类 1：作品 2：视频 3：评论
     * @return 得到的目标id的数组
     */
    int[] getOperation(Integer userId, Integer operationTypen, Integer targetType);

    /**
     * 插入用户操作记录
     *
     * @param userOperation 封装操作记录的对象
     * @return 是否插入成功
     */
    boolean setOperation(UserOperation userOperation);
}
