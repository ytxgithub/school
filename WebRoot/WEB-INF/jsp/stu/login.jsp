<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>APP信息管理系统-开发者平台</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath }/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath }/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath }/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="${pageContext.request.contextPath }/vendors/animate.css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath }/build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form action="${pageContext.request.contextPath }/login/stulogin" method="get">
              <h1>学生管理系统</h1>
              <div>
                <input type="text" name="stucode" class="form-control" placeholder="Username" required="" />
              </div>
              <div>
                <input type="password" name="stupwd" class="form-control" value="123456" placeholder="Password" required="" />
              </div>
			  <div>
				  <label>
					  <input type="radio" name="shenfen" value="学生" checked="checked" />学生
				  </label>
				  <label  style="margin-left: 40px;margin-right: 40px;">
				  	  <input type="radio" value="老师" name="shenfen" />老师
				  </label>
				  <label>
				  	  <input type="radio" value="校长"  name="shenfen" />校长
				  </label>
			  </div>
              <div>
              	<button class="btn btn-success submit btn-block" type="submit">登录</button>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">
                  <a href="#signup" class="to_register"> 注册 </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i>学生管理系统</h1>
                  <p>©2020 北大青鸟北资第一学院BS3T272</p>
                </div>
              </div>
            </form>
          </section>
        </div>

        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form action="${pageContext.request.contextPath }/login/zhuce">
              <h1>注册</h1>
              <div>
                <input type="text" name="stucode" class="form-control" placeholder="Username" required="" />
              </div>
              <div>
                <input type="password" name="stupwd" class="form-control" value="123456" placeholder="Password" required="" />
              </div>
			  <div>
				  <label>
					  <input type="radio" name="shenfen" value="学生" checked="checked" />学生
				  </label>
				  <label  style="margin-left: 40px;margin-right: 40px;">
				  	  <input type="radio" value="老师" name="shenfen" />老师
				  </label>
				  <label>
				  	  <input type="radio" value="校长"  name="shenfen" />校长
				  </label>
			  </div>
			  
              <div>
                <a class="btn btn-danger submit btn-block" href="index.html">立即注册</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">
                  <a href="#signin" class="to_register"> 登录 </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i>学生管理系统</h1>
                  <p>©2020 北大青鸟北资第一学院BS3T272</p>
                </div>
              </div>
            </form>
          </section>
        </div>
      </div>
    </div>
  </body>
</html>