<!DOCTYPE html>
<%@ include file="menu.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑项目</title>
</head>
<body>
<section id="container">
    <section id="main-content">
        <section class="wrapper">
            <h3>
                <i class="fa fa-angle-right"></i> 编辑项目
            </h3>
            <!-- BASIC FORM ELELEMNTS -->
            <div class="row mt">
                <div class="col-lg-12">
                    <div class="form-panel">
                        <div class="form-horizontal style-form">
                            <div class="form-group col-sm-6">
                                <label class="col-sm-3 control-label">项目名称</label>
                                <div class="col-sm-6">
                                    <input id="projectName" type="text" class="form-control"
                                           name="projectName" onchange="onblurCheckIfNull(this, 'projectNameMsg')"/>
                                </div>
                                <div id="projectNameMsg" class="control-label"></div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-3 control-label">所属部门</label>
                                <div class="col-sm-6">
                                    <select id="deptId" class="form-control" name="deptId"
                                            onchange="onblurCheckIfNull(this, 'deptIdMsg')">
                                        <option value="">请选择</option>
                                    </select>
                                    <input type="hidden" id="deptFlg" value="0"/>
                                </div>
                                <div id="deptIdMsg" class="control-label"></div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-3 control-label">项目负责人</label>
                                <div class="col-sm-6">
                                    <select id="managerId" class="form-control" name="managerId"
                                            onchange="onblurCheckIfNull(this, 'managerIdMsg')">
                                        <option value="">请选择</option>
                                    </select>
                                </div>
                                <div id="managerIdMsg" class="control-label"></div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-3 control-label">项目开始时间</label>
                                <div class="col-sm-6 input-append date">
                                    <input id="beginTime" type="text" value="" name="beginTime"
                                           class="form-control form_datetime"
                                           onchange="onblurCheckIfNull(this, 'beginTimeMsg')"/>
                                </div>
                                <div id="beginTimeMsg" class="control-label"></div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-3 control-label">预计结束时间</label>
                                <div class="col-sm-6 input-append date">
                                    <input id="expectEndTime" type="text" value=""
                                           name="expectEndTime" class="form-control form_datetime"
                                           onchange="onblurCheckIfNull(this, 'expectEndTimeMsg')"/>
                                </div>
                                <div id="expectEndTimeMsg" class="control-label"></div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="col-sm-3 control-label">项目预算（元）</label>
                                <div class="col-sm-6">
                                    <input id="budget" class="form-control" type="text"
                                           name="budget" onchange="onblurCheckIfNull(this, 'budgetMsg')"/>
                                </div>
                                <div id="budgetMsg" class="control-label"></div>
                            </div>
                            <form id="uploadForm" action="project/fileUpload" method="post"
                                  enctype="multipart/form-data">
                                <div class="form-group col-sm-6">
                                    <label class="col-sm-3 control-label">上传项目策划案</label>
                                    <div class="col-sm-6">
                                        <input id="file" type="file" class="form-control" name="file"
                                               onchange="onblurCheckIfNull(this, 'schemeFileMsg')"/>
                                    </div>
                                    <div class="col-sm-2">
                                    </div>
                                    <div id="schemeFileMsg" class="control-label"></div>
                                </div>
                            </form>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-1 control-label">项目简介</label>
                                <div class="col-sm-7">
										<textarea id="projectDescribe" cols="4" class="form-control"
                                                  name="projectDescribe" style="margin-left: 40px;"
                                                  onchange="onblurCheckIfNull(this, 'projectDescribeMsg')"></textarea>
                                </div>
                                <div id="projectDescribeMsg" class="control-label"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-3 col-sm-offset-4">
                                    <div class="col-sm-6">
                                        <button id="btn_submit" type="submit" class="btn btn-success">提交</button>
                                    </div>
                                    <div class="col-sm-6">
                                        <button id="btn_reset" type="button" class="btn btn-warning">重置</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- col-lg-12-->
            </div>
            <div id="view" class="row mt">
                <div class="col-md-12">
                    <section class="task-panel tasks-widget">
                        <div class="panel-heading">
                            <div class="pull-left">
                                <h5>
                                    <i class="fa fa-tasks"></i> 未完成任务
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
                    <section class="task-panel tasks-widget">
                        <div class="panel-heading">
                            <div class="pull-left">
                                <h5>
                                    <i class="fa fa-tasks"></i> 正在审核任务
                                </h5>
                            </div>
                            <br>
                        </div>
                        <div class="panel-body">
                            <div class="task-content">
                                <ul id="shenhe-task-list" class="task-list">

                                </ul>
                            </div>
                        </div>
                    </section>
                    <section class="task-panel tasks-widget" style="margin-top: 30px;">
                        <div class="panel-heading">
                            <div class="pull-left">
                                <h5>
                                    <i class="fa fa-tasks"></i> 已完成任务
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
        </section>
        <!--/wrapper -->
    </section>

    <div id="add-form" class="row" hidden>
        <div class="col-md-12">
            <section class="task-panel tasks-widget">
                <div class="panel-body">
                    <div class="form-group col-sm-12" style="margin-top: 15px;">
                        <label class="col-sm-3 control-label" style="text-align:right">开始时间</label>
                        <div class="col-sm-6 input-append date" style="z-index: 10000">
                            <input id="taskBeginTime" type="text" value=""
                                   class="form-control form_datetime"
                                   onchange="onblurCheckIfNull(this, 'taskBeginTimeMsg')"/>
                        </div>
                        <div id="taskBeginTimeMsg" class="control-label"></div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-3 control-label" style="text-align:right">预计完成</label>
                        <div class="col-sm-6 input-append date">
                            <input id="taskEstimatedTime" type="text" value=""
                                   class="form-control form_datetime"
                                   onchange="onblurCheckIfNull(this, 'taskEstimatedTimeMsg')"/>
                        </div>
                        <div id="taskEstimatedTimeMsg" class="control-label"></div>
                    </div>
                    <div class="form-group col-sm-6">
                        <label class="col-sm-3 control-label">指派给</label>
                        <div class="col-sm-6">
                            <select id="empId" class="form-control" name="empId"
                                    onchange="onblurCheckIfNull(this, 'empIdMsg')">
                                <option value="">请选择</option>
                            </select>
                        </div>
                        <div id="empIdMsg" class="control-label"></div>
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

</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
<script>
    $(function () {

        $.ajax({
            url: '/project/getProjectById',
            type: 'get',
            data: {
                "id": window.location.href.split('=')[1],
                "time": new Date()
            },
            success: function (data) {
                if (data.status == '1') {// 数据获取成功！
                    var project = data.data.project;
                    var tasks = data.data.tasks;
                    for (var i = 0; i < tasks.length; i++) {
                        appendTaskToList(tasks[i]);
                    }
                    appendProjectToList(project);
                } else {// 数据不存在
                    alert(data.body);
                }
            },
            error: function (data) {
                alert("系统错误！请稍后重试！");
            }
        });

        $("#btn-cancel").click(function () {
            $('#add-form').dialog("close");
        });
        $("#btn-reset").click(function () {

        });
        $("#btn-submit").click(function () {
            $('#add-form').dialog("close");
        });
    })

    // 把任务信息显示到对应区域
    function appendTaskToList(data) {
        var status;
        if (data.status == '1') {
            status = "<span class='badge bg-success'>已完成</span>"; // bg-info, bg-important, bg-warning, bg-success
        } else if (data.status == '2') {
            status = "<span class='badge bg-theme'>审核中...</span>"; // bg-info, bg-important, bg-warning, bg-success
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
            "<div class='task-title'>" +
            "<input type='checkbox' class='list-child' value='' style='margin-right:10px;'/>" +
            "<span class='task-title-sp'>" + data.taskInfo + "</span> " +
            status +
            "<div class='pull-right hidden-phone' style='float:right'>" +
            "<button onclick='return finishTask(" + data.id + ")' class='btn btn-success btn-xs'>" +
            "<i class=' fa fa-check'></i>" +
            "</button>" +
            "<button onclick='return editTask(" + data.id + ")' class='btn btn-primary btn-xs'>" +
            "<i class='fa fa-pencil'></i>" +
            "</button>" +
            "<button onclick='return removeTask(" + data.id + ")' class='btn btn-danger btn-xs'>" +
            "<i class='fa fa-trash-o '></i>" +
            "</button>" +
            "</div>" +
            "</div>" +
            "</li>";

        if (data.status == '0') {
            $("#unfinished-task-list").append(node);
        } else if (data.status == '1') {
            $("#finished-task-list").append(node);
        } else {
            $("#shenhe-task-list").append(node);
        }

        return node;
    }

    // 把项目信息显示到对应的区域
    function appendProjectToList(project) {
        $("#projectName").val(project.projectName);// 项目名
        // 获取部门信息拼到下拉框
        $.get("/dept/getAll", {"time": new Date()}, function (data) {
            for (var i = 0; i < data.length; i++) {
                var optionNode;
                if (data[i].id == project.deptId) {
                    optionNode = "<option value='" + data[i].id + "' selected>" + data[i].deptName + "</option>";
                } else {
                    optionNode = "<option value='" + data[i].id + "'>" + data[i].deptName + "</option>";
                }
                $("#deptId").append(optionNode);
            }
        })

        // 获取部门员工信息拼到下拉框
        $.get("/emp/getByDeptId", {"deptId": project.deptId, "time": new Date()}, function (data) {
            for (var i = 0; i < data.length; i++) {
                var optionNode;
                if (data[i].id == project.managerId) {
                    optionNode = "<option value='" + data[i].id + "' selected>" + data[i].name + "</option>";
                } else {
                    optionNode = "<option value='" + data[i].id + "'>" + data[i].name + "</option>";
                }
                $("#managerId").append(optionNode);
            }
        });

        $("#beginTime").val(toDateString(new Date(project.beginTime)));
        $("#expectEndTime").val(toDateString(new Date(project.expectEndTime)));
        $("#budget").val(project.budget);
        $("#projectDescribe").val(project.projectDescribe);
        $("#file").val(project.schemeFile);
    }

    function toDateString(d) {
        var year = d.getFullYear();
        var month = buLing(d.getMonth() + 1);
        var date = buLing(d.getDate());
        var hours = buLing(d.getHours())
        var minutes = buLing(d.getMinutes());
        var seconds = buLing(d.getSeconds());
        return year + "-" + month + "-" + date + " " + hours + ":" + minutes + ":" + seconds;
    }

    function buLing(args) {
        if (args < 10) {
            args = "0" + args;
        }
        return args;
    }

    // 清除任务新增表单
    function clearForm() {

    }

    function showForm() {
        $('#add-form').dialog({
            title: '新增任务',
            width: 1000,
            // height: 300,
            closed: false,
            cache: false,
            modal: true,
        });
        $("#")
    }
</script>
