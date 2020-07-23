<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./commons/head.jsp" %>

	 <!-- page content -->
      	<div class="right_col" role="main">
      	<div class="row">
        		<div class="col-md-12">
        			<div class="alert alert-info">
        				欢迎${sessionScope.SCH.xzname }校长,进入学生管理系统
        			</div>
        		</div>
        	</div>
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<div class="panel panel-warning">
							<div class="panel-heading">
								<h4>查看老师基本信息</h4>
							</div>
							<div class="panel-body">
								<form action="${pageContext.request.contextPath}/sch/teaModify"
								 class="form-horizontal" method="post" enctype="multipart/form-data">
									<input type="hidden" name="id" value="${tea.id }"/>
									<div class="form-group">
										<label class="control-label col-md-2">老师姓名</label>
										<div class="col-md-10">
											<input type="text" name="name" class="form-control" value="${tea.name }">
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
											<input type="text" name="phone"  value="${tea.phone}" class="form-control">
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
										
									<div class="form-group">
										<label class="control-label col-md-2">上传照片</label>
										<div class="col-md-10">
											<input type="file" name="file" class="form-control" />
										</div>
									</div>
										
										<div class="form-group">
											<div class="col-md-10 col-md-offset-2">
												<button type="submit" class="btn btn-success">保存修改</button>
												<a href="${pageContext.request.contextPath}/sch/schTealist" class="btn btn-danger">返回</a>
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
	</body>
</html>
