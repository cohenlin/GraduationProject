<!DOCTYPE html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/css/style-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.backstretch.min.js"></script>
<body>
<div id="login-page">
    <div class="container">
        <form class="form-login">
            <h2 class="form-login-heading">修改密码</h2>
            <div class="login-wrap row">
                <input id="password-1" type="password" class="form-control" placeholder="密码" autofocus>
                <input id="username" type="hidden" value="${userName}"/>
                <input id="code" type="hidden" value="${code}"/>
                <br>
                <input id="password-2" type="password" class="form-control" placeholder="重复密码">
                <br>
                <button id="btn-submit" class="btn btn-theme btn-block" type="button">
                    <i class="fa fa-lock"></i>提交
                </button>
            </div>
        </form>
    </div>
</div>
<script>
    $(function () {
        $("#password-1").on("change", function () {
            var password = $("#password-1").val();
            var reg = "(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{3,12}";
            if (password == null || password.trim() == '') {
                alert("密码不能为空！");
                return;
            }
            if (!password.exec(reg)) {
                alert("密码必须由数字、字符、特殊字符三种中的两种组成, 且长度必须为3-12位!");
                return;
            }
        });

        $("#password-2").on("change", function () {
            var password_1 = $("#password-1").val();
            if (password_1 == null || password_1.trim() == '') {
                alert("请先输入第一栏的密码!");
                return;
            }
            var password_2 = $("#password-2").val();
            if (password_1 != password_2) {
                alert("两次密码输入不一致，请确认！");
                return;
            }
        });

        $("#btn-submit").on("click", function () {
            var username = $("#username").val();
            var code = $("#code").val();
            var password = $("#password-2").val();
            if (password == null || password.trim() == '') {
                alert("密码不能为空！");
                return;
            }
            $.ajax({
                type: 'POST',
                url: '/emp/changePassword',
                data: {
                    "userName": username,
                    "code": code,
                    "passWord": password,
                    "time": new Date(),
                    _method: "PUT"
                },
                success: function (data) {
                    if(data.status == "1"){
                        alert("即将跳转至登录页面！");
                    }else{
                        alert("修改失败！");
                    }
                    window.location.pathname = "/index";
                },
                error: function (data) {
                    alert("修改失败！");
                    window.location.pathname = "/index";
                }
            });
        })
    })
</script>
</body>
</html>