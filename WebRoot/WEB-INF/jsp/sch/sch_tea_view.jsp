<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./commons/head.jsp" %>

	 <!-- page content -->
      		<div class="right_col" role="main">
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<div class="panel panel-warning">
							<div class="panel-heading">
								<h4>查看老师基本信息</h4>
							</div>
							<div class="panel-body">
								<form action="" class="form-horizontal">
										
									<div class="form-group">
										<label class="control-label col-md-2">老师姓名</label>
										<div class="col-md-10">
											<input type="text" class="form-control" value="${tea.name }" disabled>
										</div>
									</div>
										
										<div class="form-group">
											<label class="control-label col-md-2">性别</label>
											<div class="col-md-10">
												<input type="text" value="${tea.sex }" class="form-control" disabled>
											</div>
										</div>
										
			
									<div class="form-group">
										<label class="control-label col-md-2">手机号</label>
										<div class="col-md-10">
											<input type="text" value="${tea.phone }" class="form-control" disabled>
										</div>
									</div>
										
										<div class="form-group">
												<label class="control-label col-md-2">老师照片</label>
											<div class="col-md-10">
												<c:choose>
													<c:when test="${tea.photo==null }">
														<img src="${pageContext.request.contextPath}/uploads/wu/wu.jpg"  class="thumbnail"/>
													</c:when>
													<c:otherwise>
														<img src="${pageContext.request.contextPath}/uploads/tea/${tea.photo}"  class="thumbnail"/>
													</c:otherwise>
												</c:choose>
											</div>
										</div>
										
										<div class="col-md-1 col-md-offset-2" style="margin-bottom: 80px;">
											<a href="${pageContext.request.contextPath}/sch/schTealist" class="btn btn-success btn-block">返回</a>
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
