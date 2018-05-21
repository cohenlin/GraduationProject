<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<p><h4>操作成功!正在跳转至${target}...<span id="sec"></span></h4></p>
<input type="hidden" id="url" value="${url}"/>
</body>
<script>
    $(function () {
        var len = 10;
        jquery.setInterval(function () {
            $("#sec").innerHTML = len + 's'
            alert($("#sec").innerHTML);
            if ($("#sec").innerHTML == '0s') {
                var url = $("#url");
                window.location.pathname = url;
            }
            len--;
        }, 1000);
    })
</script>
</html>