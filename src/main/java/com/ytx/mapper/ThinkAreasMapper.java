package com.ytx.mapper;

import com.ytx.pojo.ThinkAreas;

public interface ThinkAreasMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table think_areas
     *
     * @mbggenerated Sun Jul 12 23:13:43 CST 2020
     */
    int deleteByPrimaryKey(Short areaId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table think_areas
     *
     * @mbggenerated Sun Jul 12 23:13:43 CST 2020
     */
    int insert(ThinkAreas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table think_areas
     *
     * @mbggenerated Sun Jul 12 23:13:43 CST 2020
     */
    int insertSelective(ThinkAreas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table think_areas
     *
     * @mbggenerated Sun Jul 12 23:13:43 CST 2020
     */
    ThinkAreas selectByPrimaryKey(Short areaId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table think_areas
     *
     * @mbggenerated Sun Jul 12 23:13:43 CST 2020
     */
    int updateByPrimaryKeySelective(ThinkAreas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table think_areas
     *
     * @mbggenerated Sun Jul 12 23:13:43 CST 2020
     */
    int updateByPrimaryKey(ThinkAreas record);
}