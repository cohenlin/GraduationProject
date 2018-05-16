<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/css/style-responsive.css" rel="stylesheet">
</head>
<body>

<!-- **********************************************************************************************************************************************************
  MAIN CONTENT
  *********************************************************************************************************************************************************** -->

<div id="login-page">
    <div class="container">

        <form class="form-login">
            <h2 class="form-login-heading">登录</h2>
            <div class="login-wrap">
                <input type="text" id="userName" class="form-control"
                       placeholder="用户名" autofocus> <br> <input
                    id="password" type="password" class="form-control"
                    placeholder="密码"> <label class="checkbox"> <span
                    class="pull-right"> <a data-toggle="modal"
                                           href="login.html#myModal"> 忘记密码?</a>
					</span>
            </label>
                <button id="btn-login" class="btn btn-theme btn-block"
                        type="button">
                    <i class="fa fa-lock"></i> 登录
                </button>
            </div>
        </form>
        <form action="">
            <!-- 密码找回 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
                 tabindex="-1" id="myModal" class="modal fade">
                <div class="modal-dialog" style="width: 450px;">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"
                                    aria-hidden="true">&times;
                            </button>
                            <h4 class="modal-title">忘记密码？</h4>
                        </div>
                        <div class="modal-body">
                            <input id="userNameFindpass" type="text" placeholder="用户名"
                                   autocomplete="off" class="form-control placeholder-no-fix"/>
                            <input id="email" type="text" placeholder="邮箱"
                                   autocomplete="off" class="form-control placeholder-no-fix"/>
                        </div>
                        <div class="modal-footer">
                            <button data-dismiss="modal" class="btn btn-default"
                                    type="button">关闭
                            </button>
                            <button id="btn-submit" class="btn btn-theme" type="button">提交</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- modal -->
        </form>
    </div>
</div>

<!-- js placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>

<!--BACKSTRETCH-->
<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/js/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("assets/img/login-bg.jpg", {
        speed: 500
    });

    $(function () {
        // 找回密码
        $("#btn-submit").on("click", function () {
            var email = $("#email").val();
            var userName = $("#userNameFindpass").val();
            $.ajax({
                url: "findPassword",
                type: "POST",
                data: {
                    "time": new Date(),
                    "email": email,
                    "userName": userName
                },
                success: function (data) {
                    switch (data.status) {
                        case "1":// 发送成功
                            break;
                        case "0":// 发送失败
                            break;
                        case "-1":// 已经发送过
                            break;
                    }
                },
                error: function (data) {
                }
            });
        });

        // 登录
        $("#btn-login").on("click", function () {
            var userName = $("#userName").val();
            var password = $("#password").val();
            $.post("login", {
                "userName": userName,
                "password": password,
                "time": new Date()
            }, function (data) {
                if (data.status == "-1") {// 用户名为空或用户名不存在
                    alert(data.body);
                    return;
                } else if (data.status == "-2") {// 密码为空或密码错误
                    alert(data.body);
                    return;
                } else if (data.status == "-3") {// 账户不可用
                    alert(data.body);
                    return;
                }
//                 window.location.pathname = "/index";
                if (data.status == "1") {// 登陆成功！转发至首页面!
                    window.location.pathname = "/index";
                }
            });
        })
    })
</script>
</body>
</html>