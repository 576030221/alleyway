package com.alleyway.bean;

import java.util.List;

public class WorksLabel {


    private List<WorksLabel> sonLabel;

    public List<WorksLabel> getSonLabel() {
        return sonLabel;
    }

    public void setSonLabel(List<WorksLabel> sonLabel) {
        this.sonLabel = sonLabel;
    }







    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_works_label.id
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_works_label.content
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_works_label.parent_id
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    private Integer parentId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_works_label.id
     *
     * @return the value of aw_works_label.id
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_works_label.id
     *
     * @param id the value for aw_works_label.id
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_works_label.content
     *
     * @return the value of aw_works_label.content
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_works_label.content
     *
     * @param content the value for aw_works_label.content
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_works_label.parent_id
     *
     * @return the value of aw_works_label.parent_id
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_works_label.parent_id
     *
     * @param parentId the value for aw_works_label.parent_id
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}