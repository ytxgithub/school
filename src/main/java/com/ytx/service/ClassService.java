package com.ytx.service;

import java.util.List;

import com.ytx.pojo.Class;

public interface ClassService {
	List<Class> classAll();
	
	String findNameByTeaid(Long teacherid);
}
