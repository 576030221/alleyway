package com.alleyway.dao;

import com.alleyway.bean.CommodityComment;
import com.alleyway.bean.CommodityCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityCommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity_comment
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int countByExample(CommodityCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity_comment
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int deleteByExample(CommodityCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity_comment
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity_comment
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int insert(CommodityComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity_comment
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int insertSelective(CommodityComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity_comment
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    List<CommodityComment> selectByExample(CommodityCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity_comment
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    CommodityComment selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity_comment
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByExampleSelective(@Param("record") CommodityComment record, @Param("example") CommodityCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity_comment
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByExample(@Param("record") CommodityComment record, @Param("example") CommodityCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity_comment
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByPrimaryKeySelective(CommodityComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity_comment
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByPrimaryKey(CommodityComment record);
}