<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="menu.jsp" %>
<html>
<link href="/assets/css/to-do.css" rel="stylesheet">
<body>
<!-- **********************************************************************************************************************************************************
  MAIN CONTENT
  *********************************************************************************************************************************************************** -->
<!--main content start-->
<section id="main-content">
    <section class="wrapper">
        <h3>
            <i class="fa fa-angle-right"></i> 任务列表
        </h3>
        <div class="pull-right add-task-row" style="margin-right: 4px; margin-bottom: 5px;">
            <div>
                <a onclick="showForm()" class="btn btn-success btn-sm pull-left" href="javascript:void(0)">新建任务</a>
            </div>
            <!--<div>-->
                <!--<a class="btn btn-default btn-sm pull-right"-->
                   <!--href="javascript:void(0)">See All Tasks</a>-->
            <!--</div>-->
        </div>
        <!-- COMPLEX TO DO LIST -->
        <div id="view" class="row mt">
            <div class="col-md-12">
                <section class="task-panel tasks-widget">
                    <div class="panel-heading">
                        <div class="pull-left">
                            <h5>
                                <i class="fa fa-tasks"></i> 未完成任务列表
                            </h5>
                        </div>
                        <br>
                    </div>
                    <div class="panel-body">
                        <div class="task-content">
                            <ul id="unfinished-task-list" class="task-list">

                            </ul>
                        </div>
                    </div>
                </section>
                <section class="task-panel tasks-widget" style="margin-top: 30px;">
                    <div class="panel-heading">
                        <div class="pull-left">
                            <h5>
                                <i class="fa fa-tasks"></i> 已完成任务列表
                            </h5>
                        </div>
                        <br>
                    </div>
                    <div class="panel-body">
                        <div class="task-content">
                            <ul id="finished-task-list" class="task-list">

                            </ul>
                        </div>
                    </div>
                </section>
            </div>
            <!-- /col-md-12-->
        </div>
        <!-- -&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;-->
        <div id="add-form" class="row" hidden>
            <div class="col-md-12">
                <section class="task-panel tasks-widget">

                    <div class="panel-body">
                        <div class="form-group col-sm-12">
                            <label class="col-sm-3 control-label" style="text-align:right">开始时间</label>
                            <div class="col-sm-6 input-append date">
                                <input id="beginTime" type="text" value=""
                                       class="form-control form_datetime"
                                       onchange="onblurCheckIfNull(this, 'beginTimeMsg')"/>
                            </div>
                            <div id="beginTimeMsg" class="control-label"></div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-3 control-label" style="text-align:right">预计完成</label>
                            <div class="col-sm-6 input-append date">
                                <input id="estimatedTime" type="text" value=""
                                       class="form-control form_datetime"
                                       onchange="onblurCheckIfNull(this, 'estimatedTimeMsg')"/>
                            </div>
                            <div id="estimatedTimeMsg" class="control-label"></div>
                        </div>
                        <div class="form-group col-sm-12">
                            <label class="col-sm-3 control-label" style="text-align:right">任务信息</label>
                            <div class="col-sm-6">
                                <textarea id="taskInfo" cols="4" class="form-control"
                                          onchange="onblurCheckIfNull(this, 'taskInfoMsg')"></textarea>
                            </div>
                            <div id="taskInfoMsg" class="control-label"></div>
                        </div>
                        <div class="form-group col-sm-12">
                            <div class="col-sm-3 col-sm-offset-4">
                                <div class="col-sm-4">
                                    <button id="btn-submit" type="submit" class="btn btn-success">提交</button>
                                </div>
                                <div class="col-sm-4">
                                    <button id="btn-reset" type="button" class="btn btn-warning">重置</button>
                                </div>
                                <div class="col-sm-4">
                                    <button id="btn-cancel" type="button" class="btn">取消</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
            <!-- /col-md-12-->
        </div>

        <!--============================================-->
        <!-- /row -->
    </section>
    <!--/wrapper -->
</section>
<!-- /MAIN CONTENT -->
<!--main content end-->
</section>
<script src="/assets/js/tasks.js" type="text/javascript"></script>

<script>
    jQuery(document).ready(function () {
        TaskList.initTaskWidget();
        // 查询当前用户的所有任务，按完成与否显示在对应区域
        initTask();
        // 设置定时器定时更新任务列表时间
        // 一分钟更新一次任务列表时间
        // window.setInterval(function(){
        //     initTask();
        // }, 60000);

        // 给新增任务的提交按钮绑定点击事件，点击后将表单数据获取并发到后台保存为新任务
        $("#btn-submit").on("click", function () {
            var beginTime = $("#beginTime").val();
            var estimatedTime = $("#estimatedTime").val();
            var taskInfo = $("#taskInfo").val();
            var args = {
                "beginTime": beginTime,
                "estimatedTime": estimatedTime,
                "taskInfo": taskInfo,
                "time": new Date()
            };
            $.post("/task/insert", args, function (data) {
                if (data.status == 1) {
                    initTask();
                    $("#view").show();
                    $("#add-form").hide();
                    // 设置定时器定时更新任务列表时间
                    // 一分钟更新一次任务列表时间
                    // window.setInterval(function(){
                    //     initTask();
                    // }, 60000);
                }
            });
        });

        // 给重置按钮绑定点击事件，点击后清空表单数据
        $("#btn-reset").on("click", function () {
            clearForm();
        });

        // 取消新增任务
        $("#btn-cancel").on("click", function(){
            $("#view").show();
            clearForm();
            $("#add-form").hide();
            // 设置定时器定时更新任务列表时间
            // 一分钟更新一次任务列表时间
            // window.setInterval(function(){
            //     initTask();
            // }, 60000);
        });
    });

    function setInterval() {
        // 一分钟更新一次任务列表时间
        window.setInterval(function(){
            initTask();
        }, 60000);
    }

    // 查询当前用户的所有任务，按完成与否显示在对应区域
    function initTask() {
        $("#view").show();// 显示任务列表
        $("#add-form").hide();// 隐藏新增表单
        $.ajax({
            async: false,
            url: '/task/list',
            type: 'get',
            data: {
                "time": new Date()
            },
            success: function (data) {
                if (data.length > 0) {
                    $("#finished-task-list").empty();
                    $("#unfinished-task-list").empty();
                    for (var i = 0; i < data.length; i++) {
                        var node = getNodeOfTask(data[i]);
                        if(data[i].finish == '0'){
                            $("#unfinished-task-list").append(node);
                        } else {
                            $("#finished-task-list").append(node);
                        }
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
        if(confirm("确认设置任务为完成？")){
            $.ajax({
                type: 'post',
                url: '/task/finish',
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

    // 编辑任务
    function editTask(id) {
        if(confirm("确定编辑任务？")){
            $.ajax({
                url: "/task/edit",
                type: "POST",
                data:{
                    _method: "PUT",
                    "id": id
                },
                success: function(data){

                },
                error: function(data){

                }
            });
        }
    }

    // 删除任务
    function removeTask(id) {
        if(confirm("确认删除此任务？")){
            $.ajax({
                url: "/task/delete",
                type: "POST",
                data:{
                    _method: "DELETE",
                    "id": id,
                    "time": new Date()
                },
                success: function(data) {
                    if(data.status == "1"){
                        initTask();// 删除成功后重新加载任务列表！
                    }else{
                        alert("删除失败！请重试！");
                    }
                },
                error: function(data){
                    alert("删除失败！请重试！");
                }
            });
        }
    }

    // 点击新增任务按钮，隐藏任务列表，显示新增表单
    function showForm() {
        // window.clearInterval();
        $("#view").hide();
        clearForm();
        $("#add-form").show();
    }

    // 清空当前新增表单的数据
    function clearForm() {
        $("#beginTime").val("");
        $("#estimatedTime").val("");
        $("#taskInfo").val("");
    }

    // 根据查询到的任务信息，拼成列表的子节点返回
    function getNodeOfTask(data) {
        var status;
        if (data.finish == true) {
            status = "<span class=\"badge bg-theme\">已完成</span>"; // bg-info, bg-important, bg-warning, bg-success
        } else {
            var now = new Date();
            var h = ((data.estimatedTime - now.getTime()) / (1000 * 60 * 60)).toFixed(0);
            var days = Math.floor(h / 24);
            var hours = h - days * 24;// 小时数
            var color;
            if (days < 3) {
                color = "bg-info";
            }
            if (days < 1) {
                color = "bg-important";
            }
            if (days >= 3) {
                color = "bg-warning";
            }
            if (days >= 7) {
                color = "bg-success";
            }
            status = "<span class=\"badge " + color + "\">" + days + " 天 " + hours + " 小时</span>";
        }
        var node = "<li>" +
            "<div class=\"task-title\">" +
            "<input type=\"checkbox\" class=\"list-child\" value=\"\" style=\"margin-right:10px;\"/>" +
            "<span class=\"task-title-sp\">" + data.taskInfo + "</span> " +
            status +
            "<div class=\"pull-right hidden-phone\" style=\"float:right\">" +
            "<button onclick=\"return finishTask(" + data.id + ")\" class=\"btn btn-success btn-xs\">" +
            "<i class=\" fa fa-check\"></i>" +
            "</button>" +
            "<button onclick=\"return editTask(" + data.id + ")\" class=\"btn btn-primary btn-xs\">" +
            "<i class=\"fa fa-pencil\"></i>" +
            "</button>" +
            "<button onclick=\"return removeTask(" + data.id + ")\" class=\"btn btn-danger btn-xs\">" +
            "<i class=\"fa fa-trash-o \"></i>" +
            "</button>" +
            "</div>" +
            "</div>" +
            "</li>";
        return node;
    }

    // 传入毫秒值，计算出几天几小时
    function getTimes(sec){
        var hours = (sec / (1000 * 60 * 60)).toFixed(0);
        var d = Math.floor(hours / 24);
        var h = hours - d * 24;
        return d.toString() + "天 " + h.toString() + "小时";
    }
</script>
<jsp:include page="footer.jsp"/>
</body>
</html>