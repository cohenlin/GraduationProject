<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="menu.jsp" %>
<html>
<body>
<!-- **********************************************************************************************************************************************************
  MAIN CONTENT
  *********************************************************************************************************************************************************** -->
<!--main content start-->
<section id="main-content">
    <section class="wrapper">
        <h3>
            <i class="fa fa-angle-right"></i> 任务审核列表
        </h3>
        <!-- COMPLEX TO DO LIST -->
        <div id="view" class="row mt">
            <div class="col-md-12">
                <section class="task-panel tasks-widget">
                    <div class="panel-heading">
                        <div class="pull-left">
                            <!--<h5>-->
                            <!--<i class="fa fa-tasks"></i> 未完成任务-->
                            <!--</h5>-->
                        </div>
                        <br>
                    </div>
                    <div class="panel-body">
                        <div class="task-content">
                            <ul id="examine-task-list" class="task-list">

                            </ul>
                        </div>
                    </div>
                </section>
            </div>
            <!-- /col-md-12-->
        </div>
        <!-- /row -->
    </section>
    <!--/wrapper -->
</section>
<!-- /MAIN CONTENT -->
<!--main content end-->
</section>
<script>
    jQuery(document).ready(function () {
        TaskList.initTaskWidget();
        // 查询当前用户的所有任务，按完成与否显示在对应区域
        initTask();
    });

    // 查询当前用户的所有任务，按完成与否显示在对应区域
    function initTask() {
        $.ajax({
            url: '/task/listExamine',
            type: 'get',
            data: {
                "time": new Date()
            },
            success: function (data) {
                var tasks = data.data;
                if (tasks.length > 0) {
                    $("#examine-task-list").empty();
                    if(tasks.length == 0){
                        $("#examine-task-list").append("<h4>待审核任务列表为空！</h4>");
                        return;
                    }
                    for (var i = 0; i < tasks.length; i++) {
                        var node = getNodeOfTask(tasks[i]);
                        $("#examine-task-list").append(node);
                    }
                }
            },
            error: function (data) {
                alert("加载任务信息失败！请刷新重试！");
            }
        });
    }

    // 将任务设置为已完成
    function finishTask(id) {
        if (confirm("确认设置任务为完成？")) {
            $.ajax({
                type: 'post',
                url: '/task/examine',
                data: {
                    "id": id,
                    _method: "PUT"
                },
                success: function (data) {
                    initTask();// 修改成功，重新加载任务列表
                },
                error: function (data) {
                    alert("提交失败！请重试！");
                }
            });
        }
    }

    // 将任务回滚
    function rollBackTask(id) {
        if (confirm("确认回滚任务至未完成？")) {
            $.ajax({
                type: 'post',
                url: '/task/rollBack',
                data: {
                    "id": id,
                    _method: "PUT"
                },
                success: function (data) {
                    initTask();// 修改成功，重新加载任务列表
                },
                error: function (data) {
                    alert("失败！请重试！");
                }
            });
        }
    }

    // 根据查询到的任务信息，拼成列表的子节点返回
    function getNodeOfTask(data) {
        var node = "<li>" +
            "<div class='task-title'>" +
            "<input type='checkbox' class='list-child' value='' style='margin-right:10px;'/>" +
            "<span class='task-title-sp'>" + data.taskInfo + "</span> " +
            "<div class='pull-right hidden-phone' style='float:right'>" +
            "<button onclick='return finishTask(" + data.id + ")' class='btn btn-success btn-xs'>" +
            "<i class=' fa fa-thumbs-up'></i>" +
            "</button>" +
            "<button onclick='return rollBackTask(" + data.id + ")' class='btn btn-danger btn-xs'>" +
            "<i class='fa fa-thumbs-down'></i>" +
            "</button>" +
            "</div>" +
            "</div>" +
            "</li>";
        return node;
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