package com.ytx.service;

import java.util.List;

import com.ytx.pojo.Teacher;

public interface TeacherService {
	
	List<Teacher> teacherList();
	
	int deleteByPrimaryKey(Long id);
	
	Teacher teacherone(Teacher teacher);
}
