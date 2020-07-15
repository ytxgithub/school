package com.ytx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ytx.mapper.ThinkAreasMapper;
import com.ytx.pojo.ThinkAreas;
import com.ytx.service.ThinkAreasService;
@Service
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class ThinkAreasServiceImpl implements ThinkAreasService {
	@Autowired private ThinkAreasMapper thinkAreasMapper;
	@Override
	public List<ThinkAreas> cityjl(Long parentid) {
		// TODO Auto-generated method stub
		return thinkAreasMapper.cityjl(parentid);
	}

}
