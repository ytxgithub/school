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
						<h4>课时列表</h4>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<table class="table table-bordered table-hover table-striped">
									<thead>
										<tr class="bg-blue-sky">
											<th>课目名称</th>
											<th>姓名</th>
											<th>上课老师</th>
											<th>上课时间</th>
											<th>预约状态</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${classhours}" var="ca">
											<tr>
												<td>${ca.subjectname }</td>
												<td>${ca.studentname }</td>
												<td>${ca.teachername }</td>
												<td>${ca.coursedate }</td>
												<c:choose>
													<c:when test="${ca.ident==0}">
														<td>预约失败</td>
													</c:when>
													<c:when test="${ca.ident==1}">
														<td>预约成功</td>
														<td><a href="${pageContext.request.contextPath}/classhours/delhours?id=${ca.id}">取消预约</a></td>
													</c:when>
													<c:when test="${ca.ident==2}">
														<td>待审核</td>
														<td><a href="${pageContext.request.contextPath}/classhours/delhours?id=${ca.id}">取消审核</a></td>
													</c:when>
												</c:choose>
												
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
												<a href="${pageContext.request.contextPath}/classhours/hourslist?pageIndex=${param.pageIndex-1}">
													<span>&laquo;</span>
												</a>
											</li>
										</c:otherwise>
									</c:choose>
									
									<c:forEach begin="1" step="1" end="${pageCount }" var="i">
										<li><a href="${pageContext.request.contextPath}/classhours/hourslist?pageIndex=${i}">${i}</a></li>
									</c:forEach>
									
									
									<c:choose>
										<c:when test="${param.pageIndex<pageCount}">
											<li>
												<a href="${pageContext.request.contextPath}/classhours/hourslist?pageIndex=${param.pageIndex+1}" aria-label="Next">
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