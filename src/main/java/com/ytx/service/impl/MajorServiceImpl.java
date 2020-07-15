package com.ytx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ytx.mapper.MajorMapper;
import com.ytx.pojo.Major;
import com.ytx.service.MajorService;
@Service
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class MajorServiceImpl implements MajorService{
	@Autowired private MajorMapper majorMapper;

	@Override
	public List<Major> majors() {
		// TODO Auto-generated method stub
		return majorMapper.majors();
	}

}
