package com.ytx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ytx.mapper.ClasshoursMapper;
import com.ytx.pojo.Classhours;
import com.ytx.service.ClassHoursService;
@Service
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class ClassHoursServiceImpl implements ClassHoursService{
	private @Autowired ClasshoursMapper classhoursMapper;
	@Override
	public PageInfo<Classhours> hourslist(Long studentid,Integer pageIndex,Integer pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		PageInfo<Classhours> pageInfo=new PageInfo<Classhours>(classhoursMapper.hourslist(studentid));
		return pageInfo;
	}
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return classhoursMapper.deleteByPrimaryKey(id);
	}
	@Override
	public int insertSelective(Classhours classhours) {
		// TODO Auto-generated method stub
		return classhoursMapper.insertSelective(classhours);
	}

}
