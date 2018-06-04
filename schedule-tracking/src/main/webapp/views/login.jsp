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
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/css/style-responsive.css" rel="stylesheet">
</head>
<body>

<!-- **********************************************************************************************************************************************************
  MAIN CONTENT
  *********************************************************************************************************************************************************** -->

<div id="login-page">
    <div class="container">

        <form class="form-login" method="post">
            <h2 class="form-login-heading">登录</h2>
            <div class="login-wrap">
                <input type="text" id="username" class="form-control"
                       placeholder="用户名" name="username" autofocus> <br> <input
                    id="password" name="password" type="password" class="form-control"
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
                            <button data-dismiss="modal" id="btn-cancel" class="btn btn-default"
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
            var b = false;
            if (!checkEmail(email)) {
                $("#email").css("border-color", "red");
                b = true;
            }
            if (!checkUsername(userName)) {
                $("#userNameFindpass").css("border-color", "red");
                b = true;
            }
            if(b){
                return;
            }else{
                $("#userNameFindpass").css("border-color", "#ccc");
                $("#email").css("border-color", "#ccc");
            }
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
                            var emailLoginUrl = data.data;
                            alert("发送成功！即将跳转至邮箱登录页面！");
                            window.location.href = emailLoginUrl;
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
            var username = $("#username").val();
            var password = $("#password").val();
            var b = false;
            if (!checkUsername(username)) {
                $("#username").css("border-color", "red");
                b = true;
            }
            if (!checkPassword(password)) {
                $("#password").css("border-color", "red");
                b = true;
            }
            if(b){
                return;
            }else{
                $("#username").css("border-color", "#ccc");
                $("#password").css("border-color", "#ccc");
            }
            $(".form-login").submit();
            return;
        })

        // $("#username").on("blur", function () {
        //     var username = $("#username").val();
        //     if (checkUsername(username)) {
        //         $("#username").css("border-color", "#ccc");
        //         return;
        //     } else {
        //         $("#username").css("border-color", "red");
        //         return;
        //     }
        // });
        //
        // $("#password").on("blur", function () {
        //     var password = $("#password").val();
        //     if (checkPassword(password)) {
        //         $("#password").css("border-color", "#ccc");
        //         return;
        //     } else {
        //         $("#password").css("border-color", "red");
        //         return;
        //     }
        // });
        //
        // $("#email").on("blur", function () {
        //     var email = $("#email").val();
        //     if (checkEmail(email)) {
        //         $("#email").css("border-color", "#ccc");
        //         return;
        //     } else {
        //         $("#email").css("border-color", "red");
        //         return;
        //     }
        // });
        //
        // $("#userNameFindpass").on("blur", function () {
        //     var username = $("#userNameFindpass").val();
        //     if (checkUsername(username)) {
        //         $("#userNameFindpass").css("border-color", "#ccc");
        //         return;
        //     } else {
        //         $("#userNameFindpass").css("border-color", "red");
        //         return;
        //     }
        // });
    })

    function checkUsername(username) {
        var reg = "^[a-zA-Z0-9_]{4,16}$";// 4 - 16 位任意大小写字母数字
        if (username == null || username.trim() == "") {
            alert("用户名不能为空！");
            return false;
        }
        if (!username.match(reg)) {
            alert("用户名格式不合法！");
            return false;
        }
        return true;
    }

    function checkPassword(password) {
        // var reg="(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{3,12}";// 数字、字符、特殊字符三种中的两种组成, 且长度必须为3-12位
        var reg = "^.*(?=.{3,})";// 至少为三位
        if (password == null || password.trim() == "") {
            alert("密码不能为空！")
            return false;
        }
        if (!password.match(reg)) {
            alert("密码必须由数字、字符、特殊字符三种中的两种组成, 且长度必须为3-12位！")
            return false;
        }
        return true;
    }

    function checkEmail(email) {
        var reg = "^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$";
        if (email == null || email.trim() == "") {
            alert("邮箱不能为空！");
            return false;
        }
        if (!email.match(reg)) {
            alert("邮箱格式不正确！");
            return false;
        }
        return true;
    }
</script>
</body>
</html>