package com.alleyway.service.impl;

import com.alleyway.bean.UserOperation;
import com.alleyway.bean.UserOperationExample;
import com.alleyway.dao.UserOperationMapper;
import com.alleyway.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private UserOperationMapper userOperationMapper;

    /**
     *  获取用户操作记录
     *
     * @param userId 用户id
     * @param operationTypen 操作的分类 1：点赞 2：收藏
     * @param targetType	目标分类 1：作品 2：视频 3：评论
     * @return 得到的目标id的数组
     */
    public int[] getOperation(Integer userId, Integer operationTypen, Integer targetType) {
        UserOperationExample userOperationExample = new UserOperationExample();
        UserOperationExample.Criteria criteria = userOperationExample.createCriteria();
        criteria.andUserIdEqualTo(userId).andOperationTypeEqualTo(operationTypen).andTargetTypeEqualTo(targetType);
        List<UserOperation> userOperations = userOperationMapper.selectByExample(userOperationExample);
        int[] idArry = new int[userOperations.size()];
        for(int i = 0;i<userOperations.size();i++){
	  idArry[i] = userOperations.get(i).getTargetId();
        }
        return idArry;
    }

    /**
     * 插入用户操作记录
     *
     * @param userOperation 封装操作记录的对象
     * @return 是否插入成功
     */
    public boolean setOperation(UserOperation userOperation) {
        return false;
    }
}
