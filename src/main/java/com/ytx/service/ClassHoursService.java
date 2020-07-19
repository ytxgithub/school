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
	
	//根据老师id查询上课情况
	PageInfo<Classhours> teahourslist(Long teacherid,Integer pageIndex,Integer pageSize);
	
	/**
     * 审核课程
     * @param classhours
     * @return
     */
    PageInfo<Classhours> teahourssh(Long teacherid,Integer pageIndex,Integer pageSize);
    
    //审核通过或不通过
    int ident(Long classhoursid,Integer status);
}
