package com.alleyway.dao;

import com.alleyway.bean.SensitiveWord;
import com.alleyway.bean.SensitiveWordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SensitiveWordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_sensitive_word
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int countByExample(SensitiveWordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_sensitive_word
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int deleteByExample(SensitiveWordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_sensitive_word
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_sensitive_word
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int insert(SensitiveWord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_sensitive_word
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int insertSelective(SensitiveWord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_sensitive_word
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    List<SensitiveWord> selectByExample(SensitiveWordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_sensitive_word
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    SensitiveWord selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_sensitive_word
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByExampleSelective(@Param("record") SensitiveWord record, @Param("example") SensitiveWordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_sensitive_word
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByExample(@Param("record") SensitiveWord record, @Param("example") SensitiveWordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_sensitive_word
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByPrimaryKeySelective(SensitiveWord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_sensitive_word
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByPrimaryKey(SensitiveWord record);
}