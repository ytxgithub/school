package com.ytx.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ytx.pojo.Classhours;
import com.ytx.pojo.Student;
import com.ytx.pojo.Teacher;
import com.ytx.service.ClassHoursService;

@Controller
@RequestMapping("/classhours")
public class ClassHoursController {
	private @Autowired  ClassHoursService classHoursService;
	/**
	 * 查询课时并分页
	 * @param request
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/hourslist")
	public ModelAndView hoursList(HttpServletRequest request,
			@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="2")Integer pageSize){
			HttpSession session=request.getSession();
			Student student=(Student) session.getAttribute("STUDENT");
			PageInfo<Classhours> pageInfo=classHoursService.hourslist(student.getId(), pageIndex,pageSize);
			ModelAndView modelAndView=new ModelAndView("stu/stu_hours_list");
			modelAndView.addObject("classhours",pageInfo.getList());
			modelAndView.addObject("pageCount",pageInfo.getPages());
			return modelAndView;
	}
	
	/**
	 * 删除预约的课时
	 * @param id
	 * @return
	 */
	@RequestMapping("/delhours")
	public String delHours(Long id){
		classHoursService.deleteByPrimaryKey(id);
		return "redirect:/classhours/hourslist";
		
	}
	
	/**
	 * 跳转到预约课时的form
	 * @return
	 */
	@RequestMapping("/hours_form")
	public String hoursForm(){
		return "stu/stu_classhours";
	}
	
	/**
	 * 提交预约课时审核
	 * @param classhours
	 * @return
	 */
	@RequestMapping("/addhours")
	public String addHours(Classhours classhours,HttpServletRequest request){
		HttpSession session=request.getSession();
		Student student=(Student) session.getAttribute("STUDENT");
		classhours.setStudentid(student.getId());
		classhours.setIdent(2L);
		classhours.setModifyby(student.getId());
		classhours.setModifydate(new Date());
		classHoursService.insertSelective(classhours);
		return "redirect:/classhours/hourslist";
	}
	
	/**
	 * 跳转到上课时间页面
	 * @return
	 */
	@RequestMapping("/skform")
	public ModelAndView skForm(HttpServletRequest request,
			@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="2")Integer pageSize){
			HttpSession session=request.getSession();
			Teacher teacher=(Teacher) session.getAttribute("TEACHER");
			PageInfo<Classhours> pageInfo=classHoursService.teahourslist(teacher.getId(),pageIndex,pageSize);
			ModelAndView modelAndView=new ModelAndView("tea/tea_stu_onke");
			modelAndView.addObject("classhours",pageInfo.getList());
			modelAndView.addObject("pageCount",pageInfo.getPages());
			return modelAndView;
	}
	
	/**
	 * 老师审核课程
	 * @return
	 */
	@RequestMapping("/shform")
	public ModelAndView shForm(HttpServletRequest request,
			@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="2")Integer pageSize){
			HttpSession session=request.getSession();
			Teacher teacher=(Teacher) session.getAttribute("TEACHER");
			PageInfo<Classhours> pageInfo=classHoursService.teahourssh(teacher.getId(),pageIndex,pageSize);
			ModelAndView modelAndView=new ModelAndView("tea/tea_stu_sh");
			modelAndView.addObject("classhours",pageInfo.getList());
			modelAndView.addObject("pageCount",pageInfo.getPages());
			return modelAndView;
	}
		
	@RequestMapping("/ident")
	public String ident(Long classhoursid,Integer status){
		classHoursService.ident(classhoursid, status);
		return "redirect:/classhours/shform";
		
	}
	
}
