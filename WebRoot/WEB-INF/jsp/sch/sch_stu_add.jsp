<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./commons/head.jsp" %>

	 <!-- page content -->
      	<div class="right_col" role="main">
      		 <div class="row">
        		<div class="col-md-12">
        			<div class="alert alert-info">
        				欢迎${sessionScope.TEACHER.name }老师,进入学生管理系统
        			</div>
        		</div>
        	</div>
       	<div class="row">
       		<div class="col-md-10 col-md-offset-1">
       			<div class="panel panel-warning">
       				<div class="panel-heading">
       					<h4>新增学生基本信息</h4>
       				</div>
       				<div class="panel-body">
       					<form action="${pageContext.request.contextPath}/student/stuadd"
       					method="post" enctype="multipart/form-data" class="form-horizontal">
       						<input type="hidden" name="status" value="1"/>
       						<div class="form-group">
       							<label class="control-label col-md-2">学生姓名</label>
       							<div class="col-md-10">
       								<input type="text" name="name" class="form-control">
       							</div>
       						</div>
       						
       						<div class="form-group">
       							<label class="control-label col-md-2">学生学号</label>
       							<div class="col-md-10">
       								<input type="text" name="stuno" class="form-control">
       							</div>
       						</div>
       						
       						<div class="form-group">
       							<label class="control-label col-md-2">学生编码</label>
       							<div class="col-md-10">
       								<input type="text" name="stucode" class="form-control">
       							</div>
       						</div>
       						
       						<div class="form-group">
       							<label class="control-label col-md-2">学生密码</label>
       							<div class="col-md-10">
       								<input type="text" name="stupwd" class="form-control">
       							</div>
       						</div>
							
							<div class="form-group">
								<label class="control-label col-md-2">年龄</label>
								<div class="col-md-10">
									<input type="text" name="age" class="form-control">
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-2">性别</label>
								<div class="col-md-10">	
									<select name="sex" class="form-control">
										<option value="0">请选择</option>
										<option value="1">男</option>
										<option value="2">女</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-2">手机号</label>
								<div class="col-md-10">
									<input type="text" name="phone" class="form-control">
								</div>
							</div>
       						
       						<div class="form-group">
      							<label class="control-label col-md-2">所属班级</label>
      							<div class="col-md-10">
      								<select id="classnames" name="classid" class="form-control">
       									
       								</select>
      							</div>
      						</div>
							
       						
       						<div class="form-group">
      							<label class="control-label col-md-2">所属专业</label>
      							<div class="col-md-10">
      								<select id="subjectnames" name="majorid" class="form-control">
       									
       								</select>
      							</div>
      						</div>
      						
      						<div class="form-group">
								<label class="control-label col-md-2">省</label>
								<div class="col-md-10">
									<select id="sheng"   name="sheng" class="form-control">
										<option value="0">请选择</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-2">市</label>
								<div class="col-md-10">
									<select id="city" name="city" class="form-control">
										<option value="0">请选择</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-2">区/县</label>
								<div class="col-md-10">
									<select id="xian" name="xian" class="form-control">
										<option value="0">请选择</option>
									</select>
								</div>
							</div>
       						
       						<div class="form-group">
       							<label class="control-label col-md-2">上传照片</label>
       							<div class="col-md-10">
       								<input type="file" name="file" class="form-control" />
       							</div>
       						</div>
       						
       						<div class="form-group">
       							<div class="col-md-10 col-md-offset-2">
       								<button type="submit" class="btn btn-success">保存</button>
       								<a href="${pageContext.request.contextPath}/sch/schStulist" class="btn btn-danger">返回</a>
       							</div>
       						</div>
       					</form>
       				</div>
       			</div>
       		</div>
       	</div>
       </div>
      <!-- /page content -->
	
<%@ include file="./commons/foot.jsp" %>
<script type="text/javascript">
	/* 专业名称 */
		$.ajax({
			url:"/myschool/major/majors",
			dataType:"json",
			success:function(data){
				$.each(data,function(i){
					$("#subjectnames").append("<option value="+data[i].id+">"+data[i].name+"</option>");
				});
			}
		});
		
		/* 班级名称 */
		$.ajax({
			url:"/myschool/class/classall",
			dataType:"json",
			success:function(data){
				$.each(data,function(i){
					$("#classnames").append("<option value="+data[i].id+">"+data[i].name+"</option>");
				});
			}
		});
		
		/* 省名称 */
		$.ajax({
			url:"/myschool/chengshi/city",
			data:{"parentid":1},
			dataType:"json",
			success:function(data){
				$.each(data,function(i){
					$("#sheng").append("<option value="+data[i].areaId+">"+data[i].areaName+"</option>");
				});
			}
		});
		
		/* 改变省触发 */
		$("#sheng").change(function(){
			$.ajax({
			url:"/myschool/chengshi/city",
			data:{"parentid":$(this).val()},
			dataType:"json",
			success:function(data){
				$("#city").html("");
				$("#city").append("<option value='0'>请选择</option>");
				$("#xian").html("");
				$("#xian").append("<option value='0'>请选择</option>");
				$.each(data,function(i){
					$("#city").append("<option value="+data[i].areaId+">"+data[i].areaName+"</option>");
				});
			}
		});
	});
		/*市 */
		$.ajax({
			url:"/myschool/chengshi/city",
			dataType:"json",
			success:function(data){
				$.each(data,function(i){
					$("#city").append("<option value="+data[i].areaId+">"+data[i].areaName+"</option>");
				});
			}
		});
		
		/* 改变市触发 */
		$("#city").change(function(){
			$.ajax({
			url:"/myschool/chengshi/city",
			data:{"parentid":$(this).val()},
			dataType:"json",
			success:function(data){
				$("#xian").html("");
				$("#xian").append("<option value='0'>请选择</option>");
				$.each(data,function(i){
				
					$("#xian").append("<option value="+data[i].areaId+">"+data[i].areaName+"</option>");
				});
			}
		});
	});
</script>
	</body>
</html>
