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
	 * 动态条件  查询全部学生信息
	 * @param student
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	PageInfo<Student> studentList(Student student,Integer pageIndex,Integer pageSize);
	
	/**
	 * 根据id查询学生
	 * @param id
	 * @return
	 */
	Student studentone(Long id);
}
