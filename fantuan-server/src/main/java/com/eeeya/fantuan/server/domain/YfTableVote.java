package com.eeeya.fantuan.server.domain;

import java.util.Date;

public class YfTableVote {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yf_table_vote.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yf_table_vote.vote_time
     *
     * @mbggenerated
     */
    private Date voteTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yf_table_vote.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yf_table_vote.table_id
     *
     * @mbggenerated
     */
    private Long tableId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yf_table_vote.food_id
     *
     * @mbggenerated
     */
    private Long foodId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yf_table_vote.id
     *
     * @return the value of yf_table_vote.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yf_table_vote.id
     *
     * @param id the value for yf_table_vote.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yf_table_vote.vote_time
     *
     * @return the value of yf_table_vote.vote_time
     *
     * @mbggenerated
     */
    public Date getVoteTime() {
        return voteTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yf_table_vote.vote_time
     *
     * @param voteTime the value for yf_table_vote.vote_time
     *
     * @mbggenerated
     */
    public void setVoteTime(Date voteTime) {
        this.voteTime = voteTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yf_table_vote.user_id
     *
     * @return the value of yf_table_vote.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yf_table_vote.user_id
     *
     * @param userId the value for yf_table_vote.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yf_table_vote.table_id
     *
     * @return the value of yf_table_vote.table_id
     *
     * @mbggenerated
     */
    public Long getTableId() {
        return tableId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yf_table_vote.table_id
     *
     * @param tableId the value for yf_table_vote.table_id
     *
     * @mbggenerated
     */
    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yf_table_vote.food_id
     *
     * @return the value of yf_table_vote.food_id
     *
     * @mbggenerated
     */
    public Long getFoodId() {
        return foodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yf_table_vote.food_id
     *
     * @param foodId the value for yf_table_vote.food_id
     *
     * @mbggenerated
     */
    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }
}