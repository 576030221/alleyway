package com.alleyway.bean;

public class UserRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_user_role.id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_user_role.role_name
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private String roleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_user_role.parent_role_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private Integer parentRoleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_user_role.description
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_user_role.id
     *
     * @return the value of aw_user_role.id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_user_role.id
     *
     * @param id the value for aw_user_role.id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_user_role.role_name
     *
     * @return the value of aw_user_role.role_name
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_user_role.role_name
     *
     * @param roleName the value for aw_user_role.role_name
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_user_role.parent_role_id
     *
     * @return the value of aw_user_role.parent_role_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Integer getParentRoleId() {
        return parentRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_user_role.parent_role_id
     *
     * @param parentRoleId the value for aw_user_role.parent_role_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setParentRoleId(Integer parentRoleId) {
        this.parentRoleId = parentRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_user_role.description
     *
     * @return the value of aw_user_role.description
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_user_role.description
     *
     * @param description the value for aw_user_role.description
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}