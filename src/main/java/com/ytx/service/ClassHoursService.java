package com.ytx.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ytx.pojo.Classhours;

public interface ClassHoursService {
	 //根据学生id查询对应的课时
	PageInfo<Classhours> hourslist(Long studentid,Integer pageIndex,Integer pageSize);
	
	//根据id删除课时
	int deleteByPrimaryKey(Long id);
	
	//添加课时
	int insertSelective(Classhours classhours);
}
