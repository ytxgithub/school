package com.ytx.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ytx.pojo.Teacher;

public interface TeacherService {
	
	List<Teacher> teacherList();
	
	int deleteByPrimaryKey(Long id);
	
	Teacher teacherone(Teacher teacher);
	
	PageInfo<Teacher> teacherAll(Teacher teacher,Integer pageIndex,Integer pageSize);
	
	
    Teacher findTeaById(Long id);
    
    Integer delTea(Long id);
    
    Integer teaModify(Teacher teacher);
}
