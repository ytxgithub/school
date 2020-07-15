package com.ytx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ytx.pojo.Major;
import com.ytx.service.MajorService;
@Controller
@RequestMapping("/major")
public class MajorController {
	@Autowired private MajorService majorService;
	//查询专业信息
	@RequestMapping("/majors")
	@ResponseBody
	public List<Major> majors(){
		return majorService.majors();
	}

}
