package com.ytx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ytx.mapper.ClassMapper;
import com.ytx.pojo.Class;
import com.ytx.service.ClassService;
@Service
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class ClassServiceImpl implements ClassService{
	@Autowired private ClassMapper classMapper;
	@Override
	public List<Class> classAll() {
		// TODO Auto-generated method stub
		return classMapper.classAll();
	}
	@Override
	public String findNameByTeaid(Long teacherid) {
		// TODO Auto-generated method stub
		return classMapper.findNameByTeaid(teacherid);
	}

}
