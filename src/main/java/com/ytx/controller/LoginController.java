package com.ytx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ytx.pojo.Sch;
import com.ytx.pojo.Student;
import com.ytx.pojo.Teacher;
import com.ytx.service.SchService;
import com.ytx.service.StudentService;
import com.ytx.service.TeacherService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired private StudentService studentService;
	@Autowired private TeacherService teacherService;
	@Autowired private SchService schService;
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
			}else if("老师".equals(shenfen)){
				Teacher t=new Teacher();
				t.setTeachercode(student.getStucode());
				t.setTeacherpwd(student.getStupwd());
				Teacher tea=teacherService.teacherone(t);
				if(tea!=null){
					HttpSession session=request.getSession();
					session.setAttribute("TEACHER",tea);
					return "tea/tea_main";
				}
			}else if ("校长".equals(shenfen)) {
				Sch sch=new Sch();	
				sch.setXzname(student.getStucode());
				sch.setXzpwd(student.getStupwd());
				schService.schone(sch);
				if(sch!=null){
					HttpSession session=request.getSession();
					session.setAttribute("SCH",sch);
					return "sch/sch_main";
				}
			}
			
		}
		return "stu/login";
		
	}
	
	@RequestMapping("/tealogout")
	public String tealogout(HttpServletRequest request){
		HttpSession session=request.getSession();
		session.setAttribute("TEACHER",null);
		session.invalidate();
		return "stu/login";
	}
	
	@RequestMapping("/stulogout")
	public String stulogout(HttpServletRequest request){
		HttpSession session=request.getSession();
		session.setAttribute("STUDENT",null);
		session.invalidate();
		return "stu/login";
	}
	
	@RequestMapping("/schlogout")
	public String schlogout(HttpServletRequest request){
		HttpSession session=request.getSession();
		session.setAttribute("SCH",null);
		session.invalidate();
		return "stu/login";
	}
	
	
}
