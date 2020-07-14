package com.ytx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ytx.pojo.Student;
import com.ytx.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	private @Autowired StudentService studentService;
	
	//所有学生信息
	@RequestMapping("studentlist")
	public ModelAndView studentList(Student student,@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="5")Integer pageSize){
		PageInfo<Student> pageInfo=studentService.studentList(student, pageIndex, pageSize);
		ModelAndView modelAndView=new ModelAndView("stu/stu_list");
		modelAndView.addObject("studentlist", pageInfo.getList());
		return modelAndView;
	}
	
	//单个学生信息
	@RequestMapping("/studentone")
	public ModelAndView studentOne(HttpServletRequest request){
		HttpSession session=request.getSession();
		Student student=(Student) session.getAttribute("STUDENT");
		Student stu=studentService.studentone(student.getId());
		ModelAndView modelAndView=new ModelAndView("stu/stu_info");
		modelAndView.addObject("studentlist",stu);
		return modelAndView;
	}

}
