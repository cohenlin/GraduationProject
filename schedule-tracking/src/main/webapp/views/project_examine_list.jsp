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
            <i class="fa fa-angle-right"></i> 项目审核列表
        </h3>
        <div class="row mt">
            <div class="col-lg-12">
                <div class="content-panel">
                    <!--<h4>-->
                    <!--<i class="fa fa-angle-right"></i> 项目信息表-->
                    <!--</h4>-->
                    <section id="unseen">
                        <table class="table table-bordered table-striped table-condensed">
                            <thead>
                            <tr>
                                <th>项目编号</th>
                                <th>项目名称</th>
                                <th class="numeric">开始日期</th>
                                <th class="numeric">持续日期</th>
                                <th class="numeric">项目负责人</th>
                                <th class="numeric">参与人数</th>
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
        init();
    })

    function init() {
        $.ajax({
            url: '/project/listExamine',
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
    }

    // 将项目信息拼接成表格行节点
    function appendNode(project) {
        var node = "<tr>" +
            "<td>" + project.id + "</td>" +
            "<td>" + project.projectName + "</td>" +
            "<td class='numeric'>" + new Date(project.beginTime).toLocaleString() + "</td>" +
            "<td class='numeric'>" + getTimes(project.expectEndTime - new Date().getTime()) + "</td>" +
            "<td class='numeric'>" + project.managerId + "</td>" +
            "<td class='numeric'>" + project.peopleNum + "</td>" +// 参与人数要算
            "<td class='numeric'>" +
            "<button onclick='return finishProject(" + project.id + ")' class='btn btn-success btn-xs'>" +
            "<i class='fa fa-thumbs-up'></i>" +
            "</button>" +
            "<button onclick='return rollBackProject(" + project.id + ")' class='btn btn-danger btn-xs'>" +
            "<i class='fa fa-thumbs-down'></i>" +
            "</button>" +
            "</td>" +
            "</tr>";
        $("#tbody").append(node);
    }

    // 设置项目为完成状态
    function finishProject(id) {
        $.ajax({
            url: '/project/finish',
            type: 'post',
            data: {
                "id": id,
                "time": new Date(),
                _method: "PUT"
            },
            success: function (data) {
                init();
            }
        });
    }

    // 回滚项目到未完成状态
    function rollBackProject(id) {
        $.ajax({
            url: '/project/rollBack',
            type: 'post',
            data: {
                "id": id,
                "time": new Date(),
                _method: "PUT"
            },
            success: function (data) {
                init();
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