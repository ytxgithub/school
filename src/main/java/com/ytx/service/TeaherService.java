package com.ytx.service;

import java.util.List;

import com.ytx.pojo.Teacher;

public interface TeaherService {
	
	List<Teacher> teacherList();
	
	int deleteByPrimaryKey(Long id);
}
