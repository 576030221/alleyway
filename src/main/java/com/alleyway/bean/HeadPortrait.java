package com.alleyway.bean;

public class HeadPortrait {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_head_portrait.id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_head_portrait.user_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_head_portrait.file_path
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private String filePath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_head_portrait.compress_file_path
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private String compressFilePath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_head_portrait.add_time
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private String addTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_head_portrait.id
     *
     * @return the value of aw_head_portrait.id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_head_portrait.id
     *
     * @param id the value for aw_head_portrait.id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_head_portrait.user_id
     *
     * @return the value of aw_head_portrait.user_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_head_portrait.user_id
     *
     * @param userId the value for aw_head_portrait.user_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_head_portrait.file_path
     *
     * @return the value of aw_head_portrait.file_path
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_head_portrait.file_path
     *
     * @param filePath the value for aw_head_portrait.file_path
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_head_portrait.compress_file_path
     *
     * @return the value of aw_head_portrait.compress_file_path
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public String getCompressFilePath() {
        return compressFilePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_head_portrait.compress_file_path
     *
     * @param compressFilePath the value for aw_head_portrait.compress_file_path
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setCompressFilePath(String compressFilePath) {
        this.compressFilePath = compressFilePath == null ? null : compressFilePath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_head_portrait.add_time
     *
     * @return the value of aw_head_portrait.add_time
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public String getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_head_portrait.add_time
     *
     * @param addTime the value for aw_head_portrait.add_time
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }
}