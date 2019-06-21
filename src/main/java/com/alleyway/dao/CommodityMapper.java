package com.alleyway.dao;

import com.alleyway.bean.Commodity;
import com.alleyway.bean.CommodityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int countByExample(CommodityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int deleteByExample(CommodityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int insert(Commodity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int insertSelective(Commodity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    List<Commodity> selectByExampleWithBLOBs(CommodityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    List<Commodity> selectByExample(CommodityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    Commodity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByExampleSelective(@Param("record") Commodity record, @Param("example") CommodityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") Commodity record, @Param("example") CommodityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByExample(@Param("record") Commodity record, @Param("example") CommodityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByPrimaryKeySelective(Commodity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(Commodity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_commodity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    int updateByPrimaryKey(Commodity record);
}