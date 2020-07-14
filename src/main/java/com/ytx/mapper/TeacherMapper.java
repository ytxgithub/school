package com.ytx.mapper;

import java.util.List;

import com.ytx.pojo.Subject;
import com.ytx.pojo.Teacher;

public interface TeacherMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Sun Jul 12 23:13:43 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Sun Jul 12 23:13:43 CST 2020
     */
    int insert(Teacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Sun Jul 12 23:13:43 CST 2020
     */
    int insertSelective(Teacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Sun Jul 12 23:13:43 CST 2020
     */
    Teacher selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Sun Jul 12 23:13:43 CST 2020
     */
    int updateByPrimaryKeySelective(Teacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Sun Jul 12 23:13:43 CST 2020
     */
    int updateByPrimaryKey(Teacher record);
    
    /**
     * 查询所有老师名称
     * @return
     */
    List<Teacher> teacherList();
}