package com.ytx.service;

import com.github.pagehelper.PageInfo;
import com.ytx.pojo.Student;

public interface StudentService {
	/**
	 * 学生登录
	 * @param student
	 * @return
	 */
	Student studentLogin(Student student);
	
	/**
	 * 动态条件  查询自己班级学生信息
	 * @param student
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	PageInfo<Student> studentList(Student student,Integer pageIndex,Integer pageSize,Long teacherid);
	
	/**
	 * 根据id查询学生
	 * @param id
	 * @return
	 */
	Student studentone(Long id);
	
	/**
	 * 根据id删除学生
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Long id);
	
	/**
	 * 修改student信息
	 * @param student
	 * @return
	 */
	int updateByPrimaryKeySelective(Student student);
	
	/**
	 * 增加student
	 * @param student
	 * @return
	 */
	int insertSelective(Student student);
	
	/**
	 * 校长查询学生
	 * @param student
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	PageInfo<Student> schstulist(Student student,Integer pageIndex,Integer pageSize);
}
