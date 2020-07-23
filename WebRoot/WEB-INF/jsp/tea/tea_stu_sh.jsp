<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./commons/head.jsp" %>
 <!-- page content -->
     <div class="right_col" role="main">
      	<div class="row">
      		<div class="col-md-12">
      			<div class="panel panel-success">
      				<div class="panel-heading">
      					<h4>审核课程</h4>
      				</div>
      				<div class="panel-body">
      					<div class="row">
      						<div class="col-md-12">
								
      							<table class="table table-bordered table-hover table-striped">
      								<thead>
      									<tr class="bg-blue-sky">
      										<th>学生姓名</th>
											<th>科目名称</th>
											<th>上课时间</th>
											<th>操作</th>
      									</tr>
      								</thead>
      								<tbody>
      									<c:forEach items="${classhours}" var="ca">
      										<tr>
	      										<td>${ca.studentname}</td>
	      										<td>${ca.subjectname}</td>
	      										<td>${ca.coursedate}</td>
												<td>
													<div class="btn-group dropdown">
														<button type="button" class="btn btn-danger">选择操作</button>
														<button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
															<span class="caret"></span>
														</button>
														<ul class="dropdown-menu">
															<li><a href="${pageContext.request.contextPath}/classhours/ident?status=1&classhoursid=${ca.id}">审核通过</a></li>
															<li><a href="${pageContext.request.contextPath}/classhours/ident?status=0&classhoursid=${ca.id}">审核不通过</a></li>
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
												<a href="${pageContext.request.contextPath}/classhours/shform?pageIndex=${param.pageIndex-1}">
													<span>&laquo;</span>
												</a>
											</li>
										</c:otherwise>
									</c:choose>
									
									<c:forEach begin="1" step="1" end="${pageCount }" var="i">
										<li><a href="${pageContext.request.contextPath}/classhours/shform?pageIndex=${i}">${i}</a></li>
									</c:forEach>
									
									
									<c:choose>
										<c:when test="${param.pageIndex<pageCount}">
											<li>
												<a href="${pageContext.request.contextPath}/classhours/shform?pageIndex=${param.pageIndex+1}" aria-label="Next">
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

