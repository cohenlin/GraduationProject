<!DOCTYPE html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/assets/css/to-do.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/demo.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/icon.css" rel="stylesheet">
    <!--external css-->
    <link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/css/style-responsive.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/easyui.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/jquery-ui.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.8.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript"
            src="${pageContext.request.contextPath}/assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.scrollTo.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.sparkline.js"></script>
    <!--common script for all pages-->
    <script src="${pageContext.request.contextPath}/assets/js/common-scripts.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/gritter-conf.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/tasks.js" type="text/javascript"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
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
            <li>
                <button id="btn-logout" class="logout">退出登录</button>
            </li>
        </ul>
    </div>
</header>
<!--header end-->
<!-- **********************************************************************************************************************************************************
MAIN SIDEBAR MENU ： 边缘菜单
*********************************************************************************************************************************************************** -->
<!--边缘菜单栏 start-->
<aside>
    <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">

            <p class="centered"><a href="profile.html"><img src="/assets/img/ui-sam.jpg" class="img-circle" width="60"></a>
            </p>

            <li style="margin-left: 50px;" class="sub-menu">
                <a href="/menu/project/add">新增项目</a>
            </li>
            <li style="margin-left: 50px;" class="sub-menu">
                <a href="/menu/project/list">浏览项目</a>
            </li>
            <li style="margin-left: 50px;" class="sub-menu">
                <a id="todo-list" href="/menu/task/list">任务列表</a>
            </li>
            <li style="margin-left: 50px;" class="sub-menu">
                <a id="task-examine-list" href="/menu/task/listExamine">任务审核</a>
            </li>
            <li style="margin-left: 50px;" class="sub-menu">
                <a id="project-examine-list" href="/menu/project/listExamine">项目审核</a>
            </li>
        </ul>
        <!-- 边缘菜单 end-->
    </div>
</aside>
<script>
    $(function () {
        $("#btn-logout").on("click", function () {
            window.location.pathname = "/logout";
        })
    })
</script>
<!--sidebar end-->
</body>
</html>