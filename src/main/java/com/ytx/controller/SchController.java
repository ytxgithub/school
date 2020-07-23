package com.ytx.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ytx.pojo.Student;
import com.ytx.pojo.Teacher;
import com.ytx.service.ClassHoursService;
import com.ytx.service.StudentService;
import com.ytx.service.TeacherService;

@Controller
@RequestMapping("/sch")
public class SchController {
	@Autowired private StudentService studentService;
	@Autowired private TeacherService teacherService;
	@Autowired private ClassHoursService classHoursService;
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
	public String schTeadel(Long id,HttpServletRequest request){
		Teacher t=teacherService.findTeaById(id);
		if(t.getPhoto()!=null && !t.getPhoto().equals("")){
				String targetFolder=request.getServletContext().getRealPath("/uploads/tea");
				File f=new File(targetFolder+File.separator+t.getPhoto());
				if(f.exists()){
					f.delete();
				}
		}
		//删除对应的课时
		classHoursService.delClasshoursfindstudentid(0L,id);
		teacherService.delTea(id);
		return "redirect:/sch/schTealist";
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
	public String teaModify(Teacher teacher,MultipartFile file,HttpServletRequest request){
		
		if("1".equals(teacher.getSex())){
			teacher.setSex("男");
		}else if("2".equals(teacher.getSex())){
			teacher.setSex("女");
		}else{
			teacher.setSex(null);
		}
		//修改老师图片  先删除原图片
		Teacher t=teacherService.findTeaById(teacher.getId());
		if(t.getPhoto()!=null && !t.getPhoto().equals("")){
				String targetFolder=request.getServletContext().getRealPath("/uploads/tea");
				File f=new File(targetFolder+File.separator+t.getPhoto());
				if(f.exists()){
					f.delete();
				}
		}
		String newFileName="";
		String savePathFile="";
		if(file!=null&&!file.isEmpty()){
			System.out.println("上传成功");
			/*把文件上传到哪里*/
			String targetFolder=request.getServletContext().getRealPath("/uploads/tea");
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
				teacher.setPhoto(newFileName);
			}
		}
		teacherService.teaModify(teacher);
		return "redirect:/sch/schTealist";
		
	}
}
