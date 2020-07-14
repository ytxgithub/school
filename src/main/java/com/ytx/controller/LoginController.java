package com.ytx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ytx.pojo.Student;
import com.ytx.service.StudentService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired private StudentService studentService;
	/**
	 * 登录
	 * @param student
	 * @return
	 */
	@RequestMapping("/stulogin")
	public String stuLogin(Student student,HttpServletRequest request,String shenfen){
		if(student.getStucode()!=null && !student.getStucode().trim().equals("")&&
				student.getStupwd()!=null && !student.getStupwd().trim().equals("")){
			//学生登录就进入学生登录业务
			if("学生".equals(shenfen)){
				Student stu=studentService.studentLogin(student);
				if(stu!=null){
					//登录成功放入session中
					HttpSession session=request.getSession();
					session.setAttribute("STUDENT",stu);
					return "stu/stu_main";
				}
			}
			
		}
		return "stu/login";
		
	}
	
}
