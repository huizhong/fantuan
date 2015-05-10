package com.eeeya.fantuan.server.mapper;

import com.eeeya.fantuan.server.domain.YfRestaurantFood;
import com.eeeya.fantuan.server.domain.YfRestaurantFoodExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YfRestaurantFoodMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yf_restaurant_food
     *
     * @mbggenerated
     */
    int countByExample(YfRestaurantFoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yf_restaurant_food
     *
     * @mbggenerated
     */
    int deleteByExample(YfRestaurantFoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yf_restaurant_food
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yf_restaurant_food
     *
     * @mbggenerated
     */
    int insert(YfRestaurantFood record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yf_restaurant_food
     *
     * @mbggenerated
     */
    int insertSelective(YfRestaurantFood record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yf_restaurant_food
     *
     * @mbggenerated
     */
    List<YfRestaurantFood> selectByExample(YfRestaurantFoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yf_restaurant_food
     *
     * @mbggenerated
     */
    YfRestaurantFood selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yf_restaurant_food
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") YfRestaurantFood record, @Param("example") YfRestaurantFoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yf_restaurant_food
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") YfRestaurantFood record, @Param("example") YfRestaurantFoodExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yf_restaurant_food
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(YfRestaurantFood record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yf_restaurant_food
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(YfRestaurantFood record);
}