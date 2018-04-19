<!DOCTYPE html>
<%@ include file="menu.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<html>
<body>
<!-- **********************************************************************************************************************************************************
  MAIN CONTENT
  *********************************************************************************************************************************************************** -->
<!--main content start-->
<section id="main-content">
    <section class="wrapper">
        <h3>
            <i class="fa fa-angle-right"></i> 项目信息一览
        </h3>
        <div class="row mt">
            <div class="col-lg-12">
                <div class="content-panel">
                    <h4>
                        <i class="fa fa-angle-right"></i> 项目信息表
                    </h4>
                    <section id="unseen">
                        <table class="table table-bordered table-striped table-condensed">
                            <thead>
                            <tr>
                                <th>项目编号</th>
                                <th>项目名称</th>
                                <th class="numeric">开始日期</th>
                                <th class="numeric">持续日期</th>
                                <th class="numeric">预计完成</th>
                                <th class="numeric">项目负责人</th>
                                <th class="numeric">参与人数</th>
                                <th class="numeric">目前进度</th>
                                <th class="numeric">是否完成</th>
                                <th class="numeric">维护操作</th>
                            </tr>
                            </thead>
                            <tbody id="tbody">

                            </tbody>
                        </table>
                    </section>
                </div>
                <!-- /content-panel -->
            </div>
            <!-- /col-lg-4 -->
        </div>
        <!-- /row -->

    </section>
    <!--/wrapper -->
</section>
<!-- /MAIN CONTENT -->
<!--main content end-->
</section>
<jsp:include page="footer.jsp"/>
<script>
    $(function () {
        $.ajax({
            url: '/project/list',
            type: 'get',
            data: {
                "time": new Date()
            },
            success: function (data) {
                var list = data.data;
                $("#tbody").empty();
                for (var i = 0; i < list.length; i++) {
                    appendNode(list[i]);
                }
            },
            error: function (data) {
                alert("error");
            }
        });
    })

    // 将项目信息拼接成表格行节点
    function appendNode(project) {
        $.ajax({
            url: '/project/getEmpByProId',
            type: 'get',
            data: {
                "pid": project.id,
                "time": new Date()
            },
            success: function (data) {
                var flg;
                if (project.finished == '0') {
                    flg = "未完成";
                } else {
                    flg = "已完成";
                }
                var node = "<tr>" +
                    "<td>" + project.id + "</td>" +
                    "<td>" + project.projectName + "</td>" +
                    "<td class='numeric'>" + new Date(project.beginTime).toLocaleString() + "</td>" +
                    "<td class='numeric'>" + getTimes(project.expectEndTime - new Date().getTime()) + "</td>" +
                    "<td class='numeric'>" + new Date(project.expectEndTime).toLocaleString() + "</td>" +
                    "<td class='numeric'>" + project.managerId + "</td>" +
                    "<td class='numeric'>" + data.data.total + "</td>" +// 参与人数要算
                    "<td class='numeric'>" + project.schedule + "</td>" +
                    "<td class='numeric'>" + flg + "</td>" +
                    "<td class='numeric'>" +
                    "<button onclick='' class='btn btn-success btn-xs'>" +
                    "<i class='fa fa-check'></i>" +
                    "</button>" +
                    "<button onclick='return editProject(" + project.id + ")' class='btn btn-primary btn-xs'>" +
                    "<i class='fa fa-pencil'></i>" +
                    "</button>" +
                    "<button onclick='' class='btn btn-danger btn-xs'>" +
                    "<i class='fa fa-trash-o'></i>" +
                    "</button>" +
                    "</td>" +
                    "</tr>";
                $("#tbody").append(node);
            },
            error: function (data) {

            }
        });
    }

    function editProject(pid) {
        $.ajax({
            url: '/project/checkLevel',
            type: 'get',
            data: {
                "pid": pid,
                "time": new Date()
            },
            success: function (data) {
                if (data.status == '1' || data.status == '2') {// 权限足够
                    window.location.href = "/views/edit_project.jsp?id=" + pid + "&status=" + data.status;
                } else if (data.status == '-1') {// 权限不足
                    alert(data.body);
                } else {// 未登录
                    window.location.href = "/login.jsp";
                }
            },
            error: function (data) {
                alert("系统错误！请稍后重试！");
            }
        });
    }

    // 传入毫秒值，计算出几天几小时
    function getTimes(sec) {
        var hours = (sec / (1000 * 60 * 60)).toFixed(0);
        var d = Math.floor(hours / 24);
        var h = hours - d * 24;
        return d.toString() + "天 " + h.toString() + "小时";
    }
</script>
</body>
</html>