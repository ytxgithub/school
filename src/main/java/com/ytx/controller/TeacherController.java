package com.ytx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ytx.pojo.Teacher;
import com.ytx.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired private TeacherService teacherService;
	
	/**
	 * 老师名字下拉列表
	 * @return
	 */
	@RequestMapping("/teachernames")
	@ResponseBody
	public List<Teacher> teacherNames(){
		return teacherService.teacherList();
	}
	
	
	
	

}
