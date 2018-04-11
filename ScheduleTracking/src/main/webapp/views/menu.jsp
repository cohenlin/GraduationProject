<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style-responsive.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.css" rel="stylesheet">

<script src="js/jquery.min.js"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="菜单"></div>
              </div>
            <!--logo start-->
            <a href="index" class="logo"><b>任务跟踪系统</b></a>
            <!--logo end-->

            <div class="top-menu">
                <ul class="nav pull-right top-menu">
                    <li><button id="btn-logout" class="logout">退出登录</button></li>
                </ul>
            </div>
        </header>
      <!--header end-->
	      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU ： 边缘菜单
      *********************************************************************************************************************************************************** -->
      <!--边缘菜单栏 start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
                  <p class="centered"><a href="profile.html"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>项目管理</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="add_project_form">新增项目</a></li>
                          <li><a  href="buttons.html">浏览项目</a></li>
                          <li><a  href="panels.html">修改项目</a></li>
                      </ul>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-cogs"></i>
                          <span>任务管理</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="gallery.html">新增任务</a></li>
                          <li><a  href="todo_list">任务列表</a></li>
                          <li><a  href="todo_list.html">修改任务</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-book"></i>
                          <span>待开发</span>
                      </a>
                      <!-- <ul class="sub">
                          <li><a  href="blank.html">Blank Page</a></li>
                          <li><a  href="login.html">Login</a></li>
                          <li><a  href="lock_screen.html">Lock Screen</a></li>
                      </ul> -->
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-tasks"></i>
                          <span>待开发</span>
                      </a>
                      <!-- <ul class="sub">
                          <li><a  href="form_component.html">Form Components</a></li>
                      </ul> -->
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-th"></i>
                          <span>待开发</span>
                      </a>
                      <!-- <ul class="sub">
                          <li><a  href="basic_table.html">Basic Table</a></li>
                          <li><a  href="responsive_table.html">Responsive Table</a></li>
                      </ul> -->
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class=" fa fa-bar-chart-o"></i>
                          <span>待开发</span>
                      </a>
                      <!-- <ul class="sub">
                          <li><a  href="morris.html">Morris</a></li>
                          <li><a  href="chartjs.html">Chartjs</a></li>
                      </ul> -->
                  </li>

              </ul>
              <!-- 边缘菜单 end-->
          </div>
      </aside>
      <script>
          $(function () {
              $("#btn-logout").on("click", function () {
                  $.post("logout", {"time" : new Date()}, function (data) {
                      if(data.status == "1"){
                          window.location.href = "http://localhost:8080/st/login.jsp";
                      }
                  });
              })
          })
      </script>
      <!--sidebar end-->
</body>
</html>