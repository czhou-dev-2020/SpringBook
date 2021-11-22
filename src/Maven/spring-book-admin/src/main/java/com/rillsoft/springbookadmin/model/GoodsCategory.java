package com.rillsoft.springbookadmin.model;

import java.io.Serializable;

public class GoodsCategory implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_goods_category.id
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_goods_category.cate_name
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    private String cateName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_goods_category.cate_code
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    private String cateCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_goods_category.remark
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_goods_category.cate_status
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    private Integer cateStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_goods_category.cate_desc
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    private String cateDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tbl_goods_category
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_goods_category
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    public GoodsCategory(Integer id, String cateName, String cateCode, String remark, Integer cateStatus, String cateDesc) {
        this.id = id;
        this.cateName = cateName;
        this.cateCode = cateCode;
        this.remark = remark;
        this.cateStatus = cateStatus;
        this.cateDesc = cateDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_goods_category
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    public GoodsCategory() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_goods_category.id
     *
     * @return the value of tbl_goods_category.id
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_goods_category.id
     *
     * @param id the value for tbl_goods_category.id
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_goods_category.cate_name
     *
     * @return the value of tbl_goods_category.cate_name
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_goods_category.cate_name
     *
     * @param cateName the value for tbl_goods_category.cate_name
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    public void setCateName(String cateName) {
        this.cateName = cateName == null ? null : cateName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_goods_category.cate_code
     *
     * @return the value of tbl_goods_category.cate_code
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    public String getCateCode() {
        return cateCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_goods_category.cate_code
     *
     * @param cateCode the value for tbl_goods_category.cate_code
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    public void setCateCode(String cateCode) {
        this.cateCode = cateCode == null ? null : cateCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_goods_category.remark
     *
     * @return the value of tbl_goods_category.remark
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_goods_category.remark
     *
     * @param remark the value for tbl_goods_category.remark
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_goods_category.cate_status
     *
     * @return the value of tbl_goods_category.cate_status
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    public Integer getCateStatus() {
        return cateStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_goods_category.cate_status
     *
     * @param cateStatus the value for tbl_goods_category.cate_status
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    public void setCateStatus(Integer cateStatus) {
        this.cateStatus = cateStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_goods_category.cate_desc
     *
     * @return the value of tbl_goods_category.cate_desc
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    public String getCateDesc() {
        return cateDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_goods_category.cate_desc
     *
     * @param cateDesc the value for tbl_goods_category.cate_desc
     *
     * @mbg.generated Mon Oct 25 18:46:27 CST 2021
     */
    public void setCateDesc(String cateDesc) {
        this.cateDesc = cateDesc == null ? null : cateDesc.trim();
    }
}