package com.ytx.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ytx.pojo.Student;
import com.ytx.pojo.Teacher;
import com.ytx.service.StudentService;
import com.ytx.service.TeacherService;

@Controller
@RequestMapping("/sch")
public class SchController {
	@Autowired private StudentService studentService;
	@Autowired private TeacherService teacherService;
	//校长模块学生列表
	@RequestMapping("/schStulist")
	public ModelAndView studentList(Student student,@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="5")Integer pageSize,HttpServletRequest request){
		
		if("1".equals(student.getSex())){
			student.setSex("男");
		}else if("2".equals(student.getSex())){
			student.setSex("女");
		}else{
			student.setSex(null);
		}
			ModelAndView modelAndView=new ModelAndView("sch/sch_stu_list");
		
			PageInfo<Student> pageInfo=studentService.schstulist(student, pageIndex, pageSize);
			modelAndView.addObject("studentlist", pageInfo.getList());
			modelAndView.addObject("pageCount",pageInfo.getPages());
			modelAndView.addObject("par","&"+request.getQueryString());
			System.out.println(pageInfo.getList().size()+"---------------");
			return modelAndView;
	}
	//老师列表校长模块
	@RequestMapping("/schTealist")
	public ModelAndView schTealist(Teacher teacher,@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="2")Integer pageSize,HttpServletRequest request){
		
		if("1".equals(teacher.getSex())){
			teacher.setSex("男");
		}else if("2".equals(teacher.getSex())){
			teacher.setSex("女");
		}else{
			teacher.setSex(null);
		}
		PageInfo<Teacher> pageInfo=teacherService.teacherAll(teacher,pageIndex, pageSize);
		ModelAndView modelAndView=new ModelAndView("sch/sch_tea_list");
		modelAndView.addObject("teachertlist", pageInfo.getList());
		modelAndView.addObject("pageCount",pageInfo.getPages());
		modelAndView.addObject("par","&"+request.getQueryString());
		return modelAndView;
	}
	
	//查询单个老师
	@RequestMapping("/schTeaone")
	public ModelAndView schTeaone(Long id){
		Teacher teacher=teacherService.findTeaById(id);
		ModelAndView modelAndView=new ModelAndView("sch/sch_tea_view");
		modelAndView.addObject("tea",teacher);
		return modelAndView;
	}
	
	//根据id删除老师
	@RequestMapping("/schTeadel")
	public String schTeadel(Long id){
		teacherService.delTea(id);
		return "sch/sch_tea_list";
	}
	
	//跳转到修改页面
	@RequestMapping("/teaModifyForm")
	public ModelAndView teaModifyForm(Long id){
		Teacher teacher=teacherService.findTeaById(id);
		ModelAndView modelAndView=new ModelAndView("sch/sch_tea_modify");
		modelAndView.addObject("tea",teacher);
		return modelAndView;
	}
	
	//修改老师信息
	@RequestMapping("/teaModify")
	public String teaModify(Teacher teacher){
		
		if("1".equals(teacher.getSex())){
			teacher.setSex("男");
		}else if("2".equals(teacher.getSex())){
			teacher.setSex("女");
		}else{
			teacher.setSex(null);
		}
		
		teacherService.teaModify(teacher);
		return "redirect:/sch/schTealist";
		
	}
}
