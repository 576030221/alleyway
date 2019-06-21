package com.alleyway.dao;

import com.alleyway.bean.SystematicNotification;
import com.alleyway.bean.SystematicNotificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystematicNotificationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_systematic_notification
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int countByExample(SystematicNotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_systematic_notification
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int deleteByExample(SystematicNotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_systematic_notification
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_systematic_notification
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int insert(SystematicNotification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_systematic_notification
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int insertSelective(SystematicNotification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_systematic_notification
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    List<SystematicNotification> selectByExample(SystematicNotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_systematic_notification
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    SystematicNotification selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_systematic_notification
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByExampleSelective(@Param("record") SystematicNotification record, @Param("example") SystematicNotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_systematic_notification
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByExample(@Param("record") SystematicNotification record, @Param("example") SystematicNotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_systematic_notification
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByPrimaryKeySelective(SystematicNotification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_systematic_notification
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByPrimaryKey(SystematicNotification record);
}