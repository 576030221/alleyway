package com.alleyway.bean;

public class OrderDetail {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_order_detail.id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_order_detail.order_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private Integer orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_order_detail.commodity_numbered
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private String commodityNumbered;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_order_detail.price
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private Long price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column aw_order_detail.quantity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    private Integer quantity;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_order_detail.id
     *
     * @return the value of aw_order_detail.id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_order_detail.id
     *
     * @param id the value for aw_order_detail.id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_order_detail.order_id
     *
     * @return the value of aw_order_detail.order_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_order_detail.order_id
     *
     * @param orderId the value for aw_order_detail.order_id
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_order_detail.commodity_numbered
     *
     * @return the value of aw_order_detail.commodity_numbered
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public String getCommodityNumbered() {
        return commodityNumbered;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_order_detail.commodity_numbered
     *
     * @param commodityNumbered the value for aw_order_detail.commodity_numbered
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setCommodityNumbered(String commodityNumbered) {
        this.commodityNumbered = commodityNumbered == null ? null : commodityNumbered.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_order_detail.price
     *
     * @return the value of aw_order_detail.price
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Long getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_order_detail.price
     *
     * @param price the value for aw_order_detail.price
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column aw_order_detail.quantity
     *
     * @return the value of aw_order_detail.quantity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column aw_order_detail.quantity
     *
     * @param quantity the value for aw_order_detail.quantity
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}