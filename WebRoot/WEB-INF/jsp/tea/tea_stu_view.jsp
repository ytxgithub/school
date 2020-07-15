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
      					<h4>查看学生基本信息</h4>
      				</div>
      				<div class="panel-body">
      					<form action="" class="form-horizontal">
							
      						<div class="form-group">
      							<label class="control-label col-md-2">学生姓名</label>
      							<div class="col-md-10">
      								<input type="text" class="form-control" value="${stuone.name }" disabled>
      							</div>
      						</div>
							
							<div class="form-group">
								<label class="control-label col-md-2">性别</label>
								<div class="col-md-10">
									<input type="text" class="form-control" value="${stuone.sex }" disabled>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-2">年龄</label>
								<div class="col-md-10">
									<input type="text" class="form-control" value="${stuone.age }" disabled>
								</div>
							</div>
      
      						<div class="form-group">
      							<label class="control-label col-md-2">班级名称</label>
      							<div class="col-md-10">
      								<input type="text" class="form-control" value="${stuone.classname}" disabled>
      							</div>
      						</div>
      
      						<div class="form-group">
      							<label class="control-label col-md-2">专业名称</label>
      							<div class="col-md-10">
      								<input type="text" class="form-control" value="${stuone.majorname }" disabled>
      							</div>
      						</div>
      
      						<div class="form-group">
      							<label class="control-label col-md-2">手机号</label>
      							<div class="col-md-10">
      								<input type="text" class="form-control" value="${stuone.phone }" disabled>
      							</div>
      						</div>
							
							<div class="form-group">
								<label class="control-label col-md-2">地址</label>
								<div class="col-md-10">
									<input type="text" class="form-control" value="${stuone.shengname}省-->${stuone.cityname}市-->${stuone.xianname}" disabled>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-2">学生图片</label>
								<div class="col-md-10">
									<img src="images/img.jpg" alt="" class="thumbnail">
								</div>
							</div>
							
							<div class="col-md-1 col-md-offset-2" style="margin-bottom: 80px;">
								<a href="${pageContext.request.contextPath}/student/studentlist" class="btn btn-success btn-block">返回</a>
							</div>
      						
      					</form>
      				</div>
      			</div>
      		</div>
      	</div>
      </div>
      <!-- /page content -->
	
<%@ include file="./commons/foot.jsp" %>
	</body>
</html>
