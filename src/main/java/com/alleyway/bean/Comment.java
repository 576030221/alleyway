package com.alleyway.bean;

public class Comment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_comment.id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_comment.user_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_comment.works_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private Integer worksId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_comment.content
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_comment.add_time
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private String addTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_comment.discuss_like_size
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private Integer discussLikeSize;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_comment.id
     *
     * @return the value of aw_comment.id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_comment.id
     *
     * @param id the value for aw_comment.id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_comment.user_id
     *
     * @return the value of aw_comment.user_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_comment.user_id
     *
     * @param userId the value for aw_comment.user_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_comment.works_id
     *
     * @return the value of aw_comment.works_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Integer getWorksId() {
        return worksId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_comment.works_id
     *
     * @param worksId the value for aw_comment.works_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setWorksId(Integer worksId) {
        this.worksId = worksId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_comment.content
     *
     * @return the value of aw_comment.content
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_comment.content
     *
     * @param content the value for aw_comment.content
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_comment.add_time
     *
     * @return the value of aw_comment.add_time
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public String getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_comment.add_time
     *
     * @param addTime the value for aw_comment.add_time
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_comment.discuss_like_size
     *
     * @return the value of aw_comment.discuss_like_size
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Integer getDiscussLikeSize() {
        return discussLikeSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_comment.discuss_like_size
     *
     * @param discussLikeSize the value for aw_comment.discuss_like_size
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setDiscussLikeSize(Integer discussLikeSize) {
        this.discussLikeSize = discussLikeSize;
    }
}