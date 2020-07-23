package com.ytx.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ytx.pojo.Teacher;
import com.ytx.service.TeacherService;
import com.ytx.utils.MD5Util;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired private TeacherService teacherService;
	
	/**
	 * 老师名字下拉列表
	 * @return
	 */
	@RequestMapping("/teachernames")
	@ResponseBody
	public List<Teacher> teacherNames(){
		return teacherService.teacherList();
	}
	
	/**
	 * 跳转到增加老师界面
	 * @return
	 */
	@RequestMapping("/schTeaaddForm")
	public String schTeaaddForm(){
		return "sch/sch_tea_add";
	}
	
	@RequestMapping("/schTeaadd")
	public String schTeaadd(Teacher teacher,MultipartFile file,HttpServletRequest request){
		if("1".equals(teacher.getSex())){
			teacher.setSex("男");
		}else if("2".equals(teacher.getSex())){
			teacher.setSex("女");
		}else{
			teacher.setSex(null);
		}
		String newFileName="";
		String savePathFile="";
		if(file!=null&&!file.isEmpty()){
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
		teacher.setModifydate(new Date());
		teacher.setTeacherpwd(MD5Util.string2MD5(teacher.getTeacherpwd()));
		teacherService.addTeacher(teacher);
		return "redirect:/sch/schTealist";
	
	}

}
