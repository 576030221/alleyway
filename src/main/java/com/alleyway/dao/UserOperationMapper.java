package com.alleyway.dao;

import com.alleyway.bean.UserOperation;
import com.alleyway.bean.UserOperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserOperationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_user_operation
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int countByExample(UserOperationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_user_operation
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int deleteByExample(UserOperationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_user_operation
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_user_operation
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int insert(UserOperation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_user_operation
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int insertSelective(UserOperation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_user_operation
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    List<UserOperation> selectByExample(UserOperationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_user_operation
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    UserOperation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_user_operation
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserOperation record, @Param("example") UserOperationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_user_operation
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByExample(@Param("record") UserOperation record, @Param("example") UserOperationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_user_operation
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByPrimaryKeySelective(UserOperation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_user_operation
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByPrimaryKey(UserOperation record);
}