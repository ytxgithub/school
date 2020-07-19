package com.ytx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ytx.mapper.SchMapper;
import com.ytx.pojo.Sch;
import com.ytx.service.SchService;
@Service
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class SchServiceImpl implements SchService{
	@Autowired private SchMapper schMapper;
	@Override
	public Sch schone(Sch sch) {
		// TODO Auto-generated method stub
		return schMapper.schone(sch);
	}

}
