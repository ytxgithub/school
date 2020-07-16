package com.ytx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ytx.pojo.Class;
import com.ytx.service.ClassService;

@Controller
@RequestMapping("/class")
public class ClassController {
	@Autowired private ClassService classService;
	//查询班级信息
	@RequestMapping("/classall")
	@ResponseBody
	public List<Class> classAll(){
		return classService.classAll();
	}
}
