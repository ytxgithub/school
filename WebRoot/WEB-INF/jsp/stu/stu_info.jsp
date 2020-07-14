<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./commons/head.jsp" %>

	 <!-- page content -->
	 
      <div class="right_col" role="main">
        	<div class="row">
        		<div class="col-md-12">
        			<div class="alert alert-info">
        				欢迎${sessionScope.STUDENT.name },进入学生管理系统
        			</div>
        		</div>
        	</div>
			
      	<div class="row">
      		<div class="col-md-12">
      			<div class="panel panel-success">
      				<div class="panel-heading">
      					<h4>${sessionScope.STUDENT.name}的信息</h4>
      				</div>
      				<div class="panel-body">
      					<div class="row">
      						<div class="col-md-12">
      							<table class="table table-bordered table-hover table-striped">
      								<thead>
      									<tr class="bg-blue-sky">
      										<th>学生姓名</th>
											<th>性别</th>
											<th>年龄</th>
      										<th>班级名称</th>
											<th>专业名称</th>
      										<th>手机号</th>
      										<th>地址</th>
      									</tr>
      								</thead>
      								<tbody>
      										<tr>
	      										<td>${studentlist.name }</td>
	      										<td>${studentlist.sex }</td>
	      										<td>${studentlist.age }</td>
	      										<td>${studentlist.classname }</td>
	      										<td>${studentlist.majorname }</td>
	      										<td>${studentlist.phone }</td>
	      										<td>${studentlist.shengname}->${studentlist.cityname}->${studentlist.xianname}</td>
      										</tr>
      								</tbody>
      							</table>
      						</div>
      					</div>
      				</div>
      			</div>
      		</div>
      	</div>
      </div>
      <!-- /page content -->
	
<%@ include file="./commons/foot.jsp" %>
	</body>
</html>