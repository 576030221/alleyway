package com.alleyway.bean;

public class SystematicNotification {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_systematic_notification.id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_systematic_notification.receive_user_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private Integer receiveUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_systematic_notification.content
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private Integer content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_systematic_notification.add_time
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private String addTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_systematic_notification.is_look
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private Integer isLook;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_systematic_notification.id
     *
     * @return the value of aw_systematic_notification.id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_systematic_notification.id
     *
     * @param id the value for aw_systematic_notification.id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_systematic_notification.receive_user_id
     *
     * @return the value of aw_systematic_notification.receive_user_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_systematic_notification.receive_user_id
     *
     * @param receiveUserId the value for aw_systematic_notification.receive_user_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_systematic_notification.content
     *
     * @return the value of aw_systematic_notification.content
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Integer getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_systematic_notification.content
     *
     * @param content the value for aw_systematic_notification.content
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setContent(Integer content) {
        this.content = content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_systematic_notification.add_time
     *
     * @return the value of aw_systematic_notification.add_time
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public String getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_systematic_notification.add_time
     *
     * @param addTime the value for aw_systematic_notification.add_time
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_systematic_notification.is_look
     *
     * @return the value of aw_systematic_notification.is_look
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Integer getIsLook() {
        return isLook;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_systematic_notification.is_look
     *
     * @param isLook the value for aw_systematic_notification.is_look
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setIsLook(Integer isLook) {
        this.isLook = isLook;
    }
}