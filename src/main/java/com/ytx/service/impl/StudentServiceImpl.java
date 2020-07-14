package com.ytx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ytx.mapper.StudentMapper;
import com.ytx.pojo.Student;
import com.ytx.service.StudentService;
@Service
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class StudentServiceImpl implements StudentService {
	
	@Autowired private StudentMapper studentMapper;
	@Override
	public Student studentLogin(Student student) {
		
		return studentMapper.studentLogin(student);
	}
	@Override
	public PageInfo<Student> studentList(Student student, Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageIndex, pageSize);
		PageInfo<Student> pageInfo=new PageInfo<Student>(studentMapper.studentList(student));
		return pageInfo;
	}
	@Override
	public Student studentone(Long id) {
		// TODO Auto-generated method stub
		return studentMapper.studentone(id);
	}

}
