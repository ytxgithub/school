package com.ytx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ytx.pojo.Subject;
import com.ytx.service.SubjectService;

@Controller
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired private SubjectService subjectService;
	
	/**
	 * 专业下  查询所有科目
	 * @return
	 */
	@RequestMapping("/subjectnames")
	@ResponseBody
	public List<Subject> subjectNames(Long majorid){
		List<Subject> subjects=subjectService.subjectLists(majorid);
		return subjects;
	}

}
