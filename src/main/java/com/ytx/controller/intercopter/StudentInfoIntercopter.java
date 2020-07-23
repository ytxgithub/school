package com.ytx.controller.intercopter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ytx.pojo.Sch;
import com.ytx.pojo.Student;
import com.ytx.pojo.Teacher;

public class StudentInfoIntercopter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		Student student=(Student) session.getAttribute("STUDENT");
		Teacher teacher=(Teacher) session.getAttribute("TEACHER");
		Sch sch=(Sch) session.getAttribute("SCH");
		if(student!=null || teacher!=null || sch!=null){
			return true;
		}
		throw new RuntimeException("登录未授权");
	}

	
	
}
