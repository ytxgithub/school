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
       		<div class="col-md-10 col-md-offset-1">
       			<div class="panel panel-warning">
       				<div class="panel-heading">
       					<h4>预约课时</h4>
       				</div>
       				<div class="panel-body">
       					<form action="${pageContext.request.contextPath}/classhours/addhours" class="form-horizontal">
       						<input type="hidden" id="majorid" value="${param.majorid }"/>
       						<div class="form-group">
       							<label class="control-label col-md-2">科目名称</label>
       							<div class="col-md-10">
       								<select id="subjectnames" name="subjectid" class="form-control">
       									<option value="0">请选择</option>
       								</select>
       							</div>
       						</div>
       						
       						<div class="form-group">
       							<label class="control-label col-md-2">上课老师</label>
       							<div class="col-md-10">
       								<select id="teachernames" name="teacherid" class="form-control">
       									<option value="0">请选择</option>
       								</select>
       							</div>
       						</div>
       						
       						<div class="form-group">
       							<label class="control-label col-md-2">预约时间</label>
       							<div class="col-md-10">
       								<input type="date" name="coursedate" class="form-control">
       							</div>
       						</div>
       						
       						<div class="form-group">
       							<div class="col-md-10 col-md-offset-2">
       								<button type="submit" class="btn btn-success">提交审核</button>
       								<a href="${pageContext.request.contextPath}/classhours/hourslist" class="btn btn-danger">返回</a>
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
		var id=$("#majorid").val();
		$.ajax({
			url:"/myschool/subject/subjectnames",
			data:{"majorid":id},
			dataType:"json",
			success:function(data){
				$.each(data,function(i){
					$("#subjectnames").append("<option value="+data[i].id+">"+data[i].subjectname+"</option>");
				});
			}
		});
		/* 老师名字 */
		$.ajax({
			url:"/myschool/teacher/teachernames",
			dataType:"json",
			success:function(data){
				$.each(data,function(i){
					$("#teachernames").append("<option value="+data[i].id+">"+data[i].name+"</option>");
				});
			}
		});
	</script>
	</body>
</html>