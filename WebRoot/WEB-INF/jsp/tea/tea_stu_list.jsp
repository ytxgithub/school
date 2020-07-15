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
      		<div class="col-md-12">
				<!-- 搜索表单 -->
				<div class="panel panel-warning">
					<div class="panel-heading">
						<h4>搜索信息</h4>
					</div>
					<div class="panel-body">
						<form action="${pageContext.request.contextPath}/student/studentlist" class="form-horizontal">
							<div class="form-group col-md-3">
								<label class="control-label col-md-4">学生姓名</label>
								<div class="col-md-8">
									<input name="name" value="${student.name }" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group col-md-3">
								<label class="control-label col-md-4">性别</label>
								<div class="col-md-8">
									<select name="sex"  class="form-control">
										<option value="0">请选择</option>
										<option value="1">男</option>
										<option value="2">女</option>
									</select>
								</div>
							</div>
							
							<div class="form-group col-md-3">
								<label class="control-label col-md-4">省</label>
								<div class="col-md-8">
									<select id="sheng"   name="sheng" class="form-control">
										<option value="0">请选择</option>
									</select>
								</div>
							</div>
							
							<div class="form-group col-md-3">
								<label class="control-label col-md-4">市</label>
								<div class="col-md-8">
									<select id="city" name="city" class="form-control">
										<option value="0">请选择</option>
									</select>
								</div>
							</div>
							
							<div class="form-group col-md-3">
								<label class="control-label col-md-4">区/县</label>
								<div class="col-md-8">
									<select id="xian" name="xian" class="form-control">
										<option value="0">请选择</option>
									</select>
								</div>
							</div>
							
							<div class="form-group col-md-3">
								<div class="col-md-8 col-md-offset-4">
									<button type="submit" class="btn btn-success btn-block">搜索学生</button>
								</div>
							</div>
						</form>
						</div>
					</div>
      			<div class="panel panel-success">
      				<div class="panel-heading">
      					<h4>我的学生</h4>
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
											<th>操作</th>
      									</tr>
      								</thead>
      								<tbody>
      									<c:forEach items="${studentlist}" var="s">
      										<tr>
	      										<td>${s.name }</td>
	      										<td>${s.sex }</td>
	      										<td>${s.age }</td>
	      										<td>${s.classname }</td>
	      										<td>${s.majorname }</td>
	      										<td>${s.phone }</td>
	      										<td>${s.shengname}->${s.cityname}->${s.xianname}</td>
												<td>
													<div class="btn-group dropdown">
														<button type="button" class="btn btn-danger">选择操作</button>
														<button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
															<span class="caret"></span>
														</button>
														<ul class="dropdown-menu">
															<li><a href="${pageContext.request.contextPath}/student/stuinfo?id=${s.id}">查看信息</a></li>
															<li><a href="${pageContext.request.contextPath}/student/delstu?id=${s.id}">删除学生</a></li>
															<li><a href="${pageContext.request.contextPath}/student/stuinfo?id=${s.id}&mod=1">修改学生</a></li>
														</ul>
													</div>
												</td>
      										</tr>
      									</c:forEach>
      									
      									
      								</tbody>
      							</table>
      							<ul class="pagination pull-right">
      								
      								<c:choose>
										<c:when test="${param.pageIndex==1 or param.pageIndex<1}">
											<li class="disabled">
												<a href="#">
													<span>&laquo;</span>
												</a>
											</li>
										</c:when>
										<c:otherwise>
											
											<li>
												<a href="${pageContext.request.contextPath}/student/studentlist?pageIndex=${param.pageIndex-1}${par}">
													<span>&laquo;</span>
												</a>
											</li>
										</c:otherwise>
									</c:choose>
      								
      								<c:forEach begin="1" step="1" var="i" end="${pageCount }">
      									<li><a href="${pageContext.request.contextPath}/student/studentlist?pageIndex=${i}${par}">${i}</a></li>
      								</c:forEach>
      								
      								<c:choose>
										<c:when test="${param.pageIndex<pageCount}">
											<li>
												<a href="${pageContext.request.contextPath}/student/studentlist?pageIndex=${param.pageIndex+1}${par}" aria-label="Next">
													<span>&raquo;</span>
												</a>
											</li>
										</c:when>
										<c:otherwise>
											<li class="disabled">
												<a href="#" aria-label="Next">
													<span>&raquo;</span>
												</a>
											</li>
										</c:otherwise>
									</c:choose>
      								
      							</ul>
      						</div>
      					</div>
      				</div>
      			</div>
      		</div>
      	</div>
      </div>
      <!-- /page content -->
      <%@ include file="./commons/foot.jsp" %>
      
      <script type="text/javascript">
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
