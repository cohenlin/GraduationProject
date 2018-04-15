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
            <div style="margin-right:125px;">
                <a onclick="showForm()" class="btn btn-success btn-sm pull-left" href="javascript:void(0)">Add New
                    Tasks</a>
            </div>
            <div>
                <a class="btn btn-default btn-sm pull-right"
                   href="javascript:void(0)">See All Tasks</a>
            </div>
        </div>
        <!-- COMPLEX TO DO LIST -->
        <div id="view" class="row mt">
            <div class="col-md-12">
                <section class="task-panel tasks-widget">
                    <div class="panel-heading">
                        <div class="pull-left">
                            <h5>
                                <i class="fa fa-tasks"></i> Todo List - Complex Style
                            </h5>
                        </div>
                        <!--<div class="pull-right add-task-row">
                            <div style="margin-right:125px;">
                                <a onclick="showForm()" class="btn btn-success btn-sm pull-left"
                                   href="javascript:void(0)">Add New Tasks</a>
                            </div>
                            <div>
                                <a class="btn btn-default btn-sm pull-right"
                                   href="javascript:void(0)">See All Tasks</a>
                            </div>
                        </div>-->
                        <br>
                    </div>
                    <div class="panel-body">
                        <div id="unfinished-task-list" class="task-content">
                            <ul class="unfinished-task-list task-list">

                            </ul>
                        </div>
                        <!--<div class=" add-task-row">
                            <a onclick="showForm()" class="btn btn-success btn-sm pull-left"
                               href="javascript:void(0)">Add New Tasks</a> <a
                                class="btn btn-default btn-sm pull-right"
                                href="javascript:void(0)">See All Tasks</a>
                        </div>-->
                    </div>
                </section>


                <section class="task-panel tasks-widget" style="margin-top: 30px;">
                    <div class="panel-heading">
                        <div class="pull-left">
                            <h5>
                                <i class="fa fa-tasks"></i> Todo List - Complex Style
                            </h5>
                        </div>
                        <br>
                    </div>
                    <div class="panel-body">
                        <div id="finished-task-list" class="task-content" hidden>
                            <ul class="finished-task-list task-list">

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
                            <label class="col-sm-3 control-label" style="text-align:right">备用字段</label>
                            <div class="col-sm-6 input-append date">
                                <input id="ss" type="text" value=""
                                       class="form-control form_datetime"
                                       onchange=""/>
                            </div>
                            <div id="sss" class="control-label"></div>
                        </div>

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
                                <div class="col-sm-6">
                                    <button id="btn-submit" type="submit" class="btn btn-success">提交</button>
                                </div>
                                <div class="col-sm-6">
                                    <button id="btn-reset" type="button" class="btn btn-warning">重置</button>
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

        initTask();

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
            console.log(args);
            $.post("/task/insert", args, function (data) {
                if (data.status == 1) {
                    initTask();
                    $("#view").show();
                    $("#add-form").hide();
                }
            });
        });

        $("#btn-reset").on("click", function () {
            clearForm();
        });
    });

    function initTask() {
        initUnFinishedTask();
        initFinishedTask();
        $(".unfinished-task-list").show();
        $(".finished-task-list").hide();
    }

    function initUnFinishedTask() {
        $.ajax({
            async: false,
            url: '/task/listAllUnFinished',
            type: 'get',
            data: {
                "time": new Date()
            },
            success: function (data) {
                if (data.length > 0) {
                    $(".task-list").empty();
                    for (var i = 0; i < data.length; i++) {
                        var node = getNodeOfTask(data[i]);
                        $(".unfinished-task-list").append(node);
                    }
                }
            },
            error: function (data) {
                initUnFinishedTask();
            }
        });
    }

    function initFinishedTask() {
        $.ajax({
            async: false,
            url: '/task/listAllFinished',
            type: 'get',
            data: {
                "time": new Date()
            },
            success: function (data) {
                if (data.length > 0) {
                    $(".task-list").empty();
                    for (var i = 0; i < data.length; i++) {
                        var node = getNodeOfTask(data[i]);
                        $(".finished-task-list").append(node);
                    }
                }
            },
            error: function (data) {
                initFinishedTask();
            }
        });
    }

    function finishTask(id) {
        alert("id : " + id);
        $.ajax({
            type: 'post',
            url: '/task/finish',
            data: {
                "id": id,
                _method: "PUT"
            },
            success: function (data) {
                alert("put success");
            },
            error: function (data) {
                alert("put error");
            }
        });
    }

    function showForm() {
        $("#view").hide();
        clearForm();
        $("#add-form").show();
    }

    function clearForm() {
        $("#beginTime").val("");
        $("#estimatedTime").val("");
        $("#taskInfo").val("");
    }

    function getNodeOfTask(data) {
        var status;
        if (data.finish == true) {
            status = "<span class=\"badge bg-theme\">已完成</span>"; // bg-info, bg-important, bg-warning, bg-success
        } else {
            var now = new Date();
            var days = ((data.estimatedTime - now.getTime()) / (1000 * 60 * 60 * 24)).toFixed();// 天数
            var hours = ((((data.estimatedTime - now.getTime()) / (1000 * 60 * 60 * 24)) - days) * 24).toFixed();// 小时数
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

    function dateFormat(cellval) {
        var date = new Date(cellval);
        return date.toLocaleString();
    }

</script>
<jsp:include page="footer.jsp"/>
</body>
</html>