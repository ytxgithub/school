<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ include file="./commons/head.jsp" %>

	 <!-- page content -->
      	
      	 <div class="right_col" role="main">
        	<div class="row">
        		<div class="col-md-12">
					<!-- 搜索表单 -->
					<div class="panel panel-warning">
						<div class="panel-heading">
							<h4>搜索信息</h4>
						</div>
						<div class="panel-body">
							<form action="${pageContext.request.contextPath }/sch/schTealist" class="form-horizontal">
								
								<div class="form-group col-md-3">
									<label class="control-label col-md-4">老师姓名</label>
									<div class="col-md-8">
										<input type="text" name="name" class="form-control">
									</div>
								</div>
								
								
								<div class="form-group col-md-3">
									<label class="control-label col-md-4">性别</label>
									<div class="col-md-8">
										<select name="sex" class="form-control">
											<option value="0">请选择</option>
											<option value="1">男</option>
											<option value="2">女</option>
										</select>
									</div>
								</div>
								
								
								<div class="form-group col-md-3">
									<div class="col-md-8 col-md-offset-4">
										<button type="submit" class="btn btn-success btn-block">搜索老师</button>
									</div>
								</div>
							</form>
							</div>
						</div>
        			<div class="panel panel-success">
        				<div class="panel-heading">
        					<h4>全部信息</h4>
        				</div>
        				<div class="panel-body">
        					<div class="row">
        						<div class="col-md-12">
        							<table class="table table-bordered table-hover table-striped">
        								<thead>
        									<tr class="bg-blue-sky">
        										<th>老师姓名</th>
        										<th>性别</th>
        										<th>手机号</th>
												<th>操作</th>
        									</tr>
        								</thead>
        								<tbody>
        									
        									<c:forEach items="${teachertlist}" var="t">
        										<tr>
	        										<td>${t.name }</td>
	        										<td>${t.sex }</td>
	        										<td>${t.phone }</td>
													<td>
														<div class="btn-group dropdown">
															<button type="button" class="btn btn-danger">选择操作</button>
															<button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
																<span class="caret"></span>
															</button>
															<ul class="dropdown-menu">
																<li><a href="${pageContext.request.contextPath}/sch/schTeaone?id=${t.id}">查看老师信息</a></li>
																<li><a href="${pageContext.request.contextPath}/sch/schTeadel?id=${t.id}">删除老师</a></li>
																<li><a href="${pageContext.request.contextPath}/sch/teaModifyForm?id=${t.id}">修改老师</a></li>
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
												<a href="${pageContext.request.contextPath}/sch/schTealist?pageIndex=${param.pageIndex-1}${par}">
													<span>&laquo;</span>
												</a>
											</li>
										</c:otherwise>
									</c:choose>
      								
      								<c:forEach begin="1" step="1" var="i" end="${pageCount }">
      									<li><a href="${pageContext.request.contextPath}/sch/schTealist?pageIndex=${i}${par}">${i}</a></li>
      								</c:forEach>
      								
      								<c:choose>
										<c:when test="${param.pageIndex<pageCount}">
											<li>
												<a href="${pageContext.request.contextPath}/sch/schTealist?pageIndex=${param.pageIndex+1}${par}" aria-label="Next">
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
	</body>
</html>
