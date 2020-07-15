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
import com.ytx.pojo.Teacher;
import com.ytx.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	private @Autowired StudentService studentService;
	
	//老师所在班级所有学生信息
	@RequestMapping("studentlist")
	public ModelAndView studentList(Student student,@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="5")Integer pageSize,HttpServletRequest request){
		System.out.println(student.getSex());
		if("1".equals(student.getSex())){
			student.setSex("男");
		}else if("2".equals(student.getSex())){
			student.setSex("女");
		}else{
			student.setSex(null);
		}
		HttpSession session=request.getSession();
		Teacher teacher=(Teacher) session.getAttribute("TEACHER");
		PageInfo<Student> pageInfo=studentService.studentList(student, pageIndex, pageSize,teacher.getId());
		ModelAndView modelAndView=new ModelAndView("tea/tea_stu_list");
		modelAndView.addObject("studentlist", pageInfo.getList());
		modelAndView.addObject("pageCount",pageInfo.getPages());
		modelAndView.addObject("student",student);
		modelAndView.addObject("par","&"+request.getQueryString());
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
	
		//根据id单个学生信息
		@RequestMapping("/stuinfo")
		public ModelAndView studentOne(Long id,Integer mod){
			ModelAndView modelAndView;
			if(mod!=null){
				Student stu=studentService.studentone(id);
				modelAndView=new ModelAndView("tea/tea_stu_modify");
				modelAndView.addObject("stuone",stu);
			}else{
				Student stu=studentService.studentone(id);
				modelAndView=new ModelAndView("tea/tea_stu_view");
				modelAndView.addObject("stuone",stu);
			}
			
			return modelAndView;
		}
		
		//根据学生id删除学生
		@RequestMapping("/delstu")
		public String delStu(Long id){
			studentService.deleteByPrimaryKey(id);
			return "redirect:/student/studentlist";
		}
		
		//修改学生信息
		@RequestMapping("/modifystu")
		public String modifyStu(Student student){
			System.out.println(student.getMajorid()+"-");
			studentService.updateByPrimaryKeySelective(student);
			return "redirect:/student/studentlist";
		}
}
