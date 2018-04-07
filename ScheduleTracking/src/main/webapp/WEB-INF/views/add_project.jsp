<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="assets/js/bootstrap-datepicker/css/datepicker.css" />
<link rel="stylesheet" type="text/css"
	href="assets/js/bootstrap-daterangepicker/daterangepicker.css" />
<!-- Custom styles for this template -->
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style-responsive.css" rel="stylesheet">

<link href="css/bootstrap-datetimepicker.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style type="text/css">
.form-group {
	margin: 5px 1px;
}

.form-panel {
	padding: 30px;
}
</style>
</head>

<body>

	<section id="container"> <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
	<!--header start--> <header class="header black-bg">
	<div class="sidebar-toggle-box">
		<div class="fa fa-bars tooltips" data-placement="right"
			data-original-title="菜单"></div>
	</div>
	<!--logo start--> <a href="index" class="logo"><b>任务跟踪系统</b></a> <!--logo end-->

	<div class="top-menu">
		<ul class="nav pull-right top-menu">
			<li><a class="logout" href="login.html">退出登录</a></li>
		</ul>
	</div>
	</header> <!--header end--> <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU ： 边缘菜单
      *********************************************************************************************************************************************************** -->
	<!--边缘菜单栏 start--><!--边缘菜单栏 start--> <aside>
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">

			<p class="centered">
				<a href="profile.html"><img src="assets/img/ui-sam.jpg"
					class="img-circle" width="60"></a>
			</p>

			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-desktop"></i> <span>项目管理</span>
			</a>
				<ul class="sub">
					<li><a href="add_project_form">新增项目</a></li>
					<li><a href="buttons.html">浏览项目</a></li>
					<li><a href="panels.html">修改项目</a></li>
				</ul></li>

			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-cogs"></i> <span>任务管理</span>
			</a>
				<ul class="sub">
					<li><a href="gallery.html">新增任务</a></li>
					<li><a href="calendar.html">浏览任务</a></li>
					<li><a href="todo_list.html">修改任务</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-book"></i> <span>待开发</span>
			</a> <!-- <ul class="sub">
                          <li><a  href="blank.html">Blank Page</a></li>
                          <li><a  href="login.html">Login</a></li>
                          <li><a  href="lock_screen.html">Lock Screen</a></li>
                      </ul> --></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-tasks"></i> <span>待开发</span>
			</a> <!-- <ul class="sub">
                          <li><a  href="form_component.html">Form Components</a></li>
                      </ul> --></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-th"></i> <span>待开发</span>
			</a> <!-- <ul class="sub">
                          <li><a  href="basic_table.html">Basic Table</a></li>
                          <li><a  href="responsive_table.html">Responsive Table</a></li>
                      </ul> --></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class=" fa fa-bar-chart-o"></i> <span>待开发</span>
			</a> <!-- <ul class="sub">
                          <li><a  href="morris.html">Morris</a></li>
                          <li><a  href="chartjs.html">Chartjs</a></li>
                      </ul> --></li>

		</ul>
		<!-- 边缘菜单 end-->
	</div>
	</aside><!--sidebar end--> <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	<!--main content start--> <section id="main-content"> <section
		class="wrapper">
	<h3>
		<i class="fa fa-angle-right"></i> 新增项目
	</h3>

	<!-- BASIC FORM ELELEMNTS -->
	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">
				<form action="project/addProject" class="form-horizontal style-form"
					method="post" role="form">
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label">项目名称</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" name="projectName" />
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label">所属部门</label>
						<div class="col-sm-6">
							<select class="form-control" name="deptId">
								<option value="1">技术部</option>
								<option value="2">人事部</option>
								<option value="3">财务部</option>
								<option value="4">市场部</option>
							</select>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label">项目负责人</label>
						<div class="col-sm-6">
							<select class="form-control" name="managerId">
								<option value="1">张三</option>
								<option value="2">李四</option>
								<option value="3">王五</option>
							</select>
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label">项目开始时间</label>
						<div class="col-sm-6 input-append date">
							<input type="text" value="" name="beginTime"
								class="form-control form_datetime">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label">预计结束时间</label>
						<div class="col-sm-6 input-append date">
							<input type="text" value="" name="expectEndTime"
								class="form-control form_datetime">
						</div>
					</div>
					<div class="form-group col-sm-6">
						<label class="col-sm-4 control-label">项目预算（元）</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" name="budget" />
						</div>
					</div>
					<div class="form-group col-sm-12">
						<label class="col-sm-2 control-label">上传项目策划案</label>
						<div class="col-sm-3">
							<input id="file" type="file" class="form-control" name="file" />
						</div>
						<div class="col-sm-2">
							<span><button type="button" onclick="return upload()">上传</button></span>
						</div>
					</div>
					<div class="form-group col-sm-12">
						<label class="col-sm-2 control-label">项目简介</label>
						<div class="col-sm-6">
							<textarea type="text" cols="3" class="form-control"
								name="projectDescribe"></textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-success">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- col-lg-12-->
	</div>
	</section> <!--/wrapper --> </section> <!-- /MAIN CONTENT --> <!--main content end--> </section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/jquery-1.8.3.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="assets/js/jquery.scrollTo.min.js"></script>
	<script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="assets/js/jquery.sparkline.js"></script>


	<!--common script for all pages-->
	<script src="assets/js/common-scripts.js"></script>
	<script src="js/bootstrap-datetimepicker.js"></script>

	<script type="text/javascript"
		src="assets/js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="assets/js/gritter-conf.js"></script>
	<script type="text/javascript" src="js/ajaxFileUpload.js"></script>
	<script type="text/javascript">
		function upload() {
			/* var path = $("#file").value;
			alert(path);
			if ($.trim(path) == "") {
				alert("请选择要上传的文件"); 
				return;
			} */

			$.ajaxFileUpload({
				url : 'project/fileUpload', //这里是服务器处理的代码
				type : 'post',
				secureuri : false, //一般设置为false
				fileElementId : 'file', // 上传文件的id、name属性名
				dataType : 'json', //返回值类型，一般设置为json、application/json
				data : {}, //传递参数到服务器
				success : function(data, status) {
					if (data == "1" || data.equals("1")) {
						alert("文件成功处理完成!");
					} else {
						alert("文件成功处理出错！");
					}
				},
				error : function(data, status, e) {
					alert("错误：上传组件错误，请检察网络!");
				}
			});
		}
	</script>
	<script type="text/javascript">
		$(".form_datetime").datetimepicker({
			format : "dd MM yyyy - hh:ii"
		});
	</script>
</body>
</html>