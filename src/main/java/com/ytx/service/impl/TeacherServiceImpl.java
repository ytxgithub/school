package com.ytx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ytx.mapper.TeacherMapper;
import com.ytx.pojo.Teacher;
import com.ytx.service.TeacherService;
@Service
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class TeacherServiceImpl implements TeacherService {
	@Autowired private TeacherMapper teacherMapper;
	@Override
	public List<Teacher> teacherList() {
		// TODO Auto-generated method stub
		return teacherMapper.teacherList();
	}
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return teacherMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Teacher teacherone(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherMapper.teacherone(teacher);
	}

}
