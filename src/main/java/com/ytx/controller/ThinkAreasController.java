package com.ytx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ytx.pojo.ThinkAreas;
import com.ytx.service.ThinkAreasService;

@Controller
@RequestMapping("/chengshi")
public class ThinkAreasController {
	@Autowired private ThinkAreasService thinkAreasService;
	
	@RequestMapping("/city")
	@ResponseBody
	public List<ThinkAreas> city(Long parentid){
		List<ThinkAreas> thinkAreas=thinkAreasService.cityjl(parentid);
		return thinkAreas;
	}

}
