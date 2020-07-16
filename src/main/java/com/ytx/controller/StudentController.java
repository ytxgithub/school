package com.ytx.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ytx.pojo.Student;
import com.ytx.pojo.Teacher;
import com.ytx.service.ClassService;
import com.ytx.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	private @Autowired StudentService studentService;
	private @Autowired ClassService  classService;
	//老师所在班级所有学生信息
	@RequestMapping("studentlist")
	public ModelAndView studentList(Student student,@RequestParam(defaultValue="1")Integer pageIndex,
			@RequestParam(defaultValue="5")Integer pageSize,HttpServletRequest request){
		
		if("1".equals(student.getSex())){
			student.setSex("男");
		}else if("2".equals(student.getSex())){
			student.setSex("女");
		}else{
			student.setSex(null);
		}
		ModelAndView modelAndView=new ModelAndView("tea/tea_stu_list");
		HttpSession session=request.getSession();
		Teacher teacher=(Teacher) session.getAttribute("TEACHER");
		//根据老师的id查询班级的名字
		String classname=classService.findNameByTeaid(teacher.getId());
		modelAndView.addObject("classname",classname);

		PageInfo<Student> pageInfo=studentService.studentList(student, pageIndex, pageSize,teacher.getId());
		
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
				System.out.println(stu.getName()+"----------------");
				modelAndView=new ModelAndView("tea/tea_stu_modify");
				modelAndView.addObject("stuone",stu);
			}else{
				Student stu=studentService.studentone(id);
				modelAndView=new ModelAndView("tea/tea_stu_view");
				modelAndView.addObject("stuone",stu);
			}
			
			return modelAndView;
		}
		
		//根据学生id删除学生 同时删除照片
		@RequestMapping("/delstu")
		public String delStu(Long id,HttpServletRequest request){
			Student s=studentService.studentone(id);
			if(s.getPhoto()!=null && !s.getPhoto().equals("")){
				String targetFolder=request.getServletContext().getRealPath("/uploads");
				File file=new File(targetFolder+File.separator+s.getPhoto());
				if(file.exists()){
					file.delete();
				}
			}
			studentService.deleteByPrimaryKey(id);
			return "redirect:/student/studentlist";
		}
		
		//修改学生信息
		@RequestMapping("/modifystu")
		public String modifyStu(Student student){
			studentService.updateByPrimaryKeySelective(student);
			return "redirect:/student/studentlist";
		}
		
		//跳转到增加界面
		@RequestMapping("/stuaddform")
		public String stuAddForm(){
			return "tea/tea_stu_add";
		}
		
		//添加学生
		@RequestMapping("/stuadd")
		public String stuAdd(Student student,MultipartFile file,HttpServletRequest request){
			System.out.println(student.getSex()+"--------------");
			if("1".equals(student.getSex())){
				student.setSex("男");
			}else if("2".equals(student.getSex())){
				student.setSex("女");
			}else{
				student.setSex(null);
			}
			String newFileName="";
			String savePathFile="";
			if(file!=null&&!file.isEmpty()){
				/*把文件上传到哪里*/
				String targetFolder=request.getServletContext().getRealPath("/uploads");
				/*上传文件的新名字的前缀*/
				String prefixFileName=String.valueOf(System.currentTimeMillis());
				//上传文件的扩展名
				String extName=file.getOriginalFilename().split("\\.")
						[file.getOriginalFilename().split("\\.").length-1];
				/*上传文件的新名字*/
				newFileName=prefixFileName+"."+extName;
				/*保存到哪里*/
				savePathFile=targetFolder+File.separator+newFileName;
				try {
					file.transferTo(new File(savePathFile));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(!newFileName.equals("")&&!savePathFile.equals("")){
					student.setPhoto(newFileName);
				}
			}
			student.setModifydate(new Date());
			studentService.insertSelective(student);
			return "redirect:/student/studentlist";
		}
}
