package com.fos9we.fm.bean;

public class Evaluate {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fm_evaluate.id
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fm_evaluate.date
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    private Long date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fm_evaluate.picture
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    private String picture;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fm_evaluate.user_id
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fm_evaluate.product_id
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    private Long productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fm_evaluate.content
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fm_evaluate.id
     *
     * @return the value of fm_evaluate.id
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fm_evaluate.id
     *
     * @param id the value for fm_evaluate.id
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fm_evaluate.date
     *
     * @return the value of fm_evaluate.date
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    public Long getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fm_evaluate.date
     *
     * @param date the value for fm_evaluate.date
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    public void setDate(Long date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fm_evaluate.picture
     *
     * @return the value of fm_evaluate.picture
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    public String getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fm_evaluate.picture
     *
     * @param picture the value for fm_evaluate.picture
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fm_evaluate.user_id
     *
     * @return the value of fm_evaluate.user_id
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fm_evaluate.user_id
     *
     * @param userId the value for fm_evaluate.user_id
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fm_evaluate.product_id
     *
     * @return the value of fm_evaluate.product_id
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fm_evaluate.product_id
     *
     * @param productId the value for fm_evaluate.product_id
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fm_evaluate.content
     *
     * @return the value of fm_evaluate.content
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fm_evaluate.content
     *
     * @param content the value for fm_evaluate.content
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}