$(function () {
    // 初始化数据
    $.ajax({
        url: '/project/getProjectById',
        type: 'get',
        data: {
            "id": window.location.href.split('=')[1].split('&')[0],
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
})

// 把任务信息显示到对应区域
function appendTaskToList(data) {
    var status;
    if (data.status == '1') {
        status = "<span class='badge bg-success'>已完成</span>"; // bg-info, bg-important, bg-warning, bg-success
    } else if (data.status == '2') {
        status = "<span class='badge bg-theme'>审核中</span>"; // bg-info, bg-important, bg-warning, bg-success
    } else {
        status = "<span class='badge bg-info '>未完成</span>";
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
        "<button pid='"+data.id+"' onclick='return deleteTask(this)' class='btn btn-danger btn-xs'>" +
        "<i class='fa fa-trash-o '></i>" +
        "</button>" +
        "</div>" +
        "</div>" +
        "</li>";

    $("#unfinished-task-list").append(node);
    // if (data.status == '0') {
    // }
    // else if (data.status == '1') {
    //     $("#finished-task-list").append(node);
    // } else {
    //     $("#shenhe-task-list").append(node);
    // }

    return node;
}

// 把项目信息显示到对应的区域
function appendProjectToList(project) {
    $("#pid").val(project.id);
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
    });
    if (window.location.href.split('=')[2] == '1') {
        $("#deptId").prop("disabled", "disabled");
    }

    // 获取部门员工信息拼到下拉框
    $.get("/emp/getByDeptId", {"deptId": project.deptId, "time": new Date()}, function (data) {
        var optionNode = "<option value=''>请选择</option>";
        $("#managerId").empty();
        $("#empId").empty();
        $("#managerId").append(optionNode);
        $("#empId").append(optionNode);
        for (var i = 0; i < data.length; i++) {
            if (data[i].id == project.managerId) {
                optionNode = "<option value='" + data[i].id + "' selected>" + data[i].name + "</option>";
            } else {
                optionNode = "<option value='" + data[i].id + "'>" + data[i].name + "</option>";
            }
            $("#managerId").append(optionNode);
            $("#empId").append(optionNode);
        }
    });

    $("#beginTime").val(toDateString(new Date(project.beginTime)));
    $("#expectEndTime").val(toDateString(new Date(project.expectEndTime)));
    $("#budget").val(project.budget);
    $("#projectDescribe").val(project.projectDescribe);
}

// -------------------------------文件相关-begin--------------------------------------------------------//

// 查询当前项目所有的文件
function listFiles() {
    var pid = $("#pid").val();
    $.ajax({
        type: "GET",
        url: "/project/listFiles",
        data: {
            "pid": pid,
            "time": new Date()
        },
        success: function (data) {
            var files = data.data;
            if (files.length == 0) {
                return;
            }
            $("#file").empty();
            for (var i = 0; i < files.length; i++) {
                $("#file").append(getFileNode(files[i].filePath, files[i].fileName));
            }
        },
        error: function (data) {
            alert("error:" + data.responseText);
        }
    });
}

function getFileNode(filePath, fileName) {
    var n = "<div>" + fileName + "   " +
        "<a filePath='" + filePath + "' fileName='" + fileName + "' action='/project/download'  href='javascript:void(0)' onclick='downloadFile(this)'>下载</a>   " +
        "<a filePath='" + filePath + "' fileName='" + fileName + "' action='/project/deleteFile'  href='javascript:void(0)' onclick='deleteFile(this)'>删除</a></div>";
    return n;
}

// 下载文件
function downloadFile(node) {
    var filePath = $(node).attr("filePath");
    var fileName = $(node).attr("fileName");
    var action = $(node).attr("action");
    var form = $("<form id='temp-form'></form>");
    form.attr('action', action);
    form.attr('method', 'post');
    var input1 = $("<input type='hidden' name='filePath' />");
    input1.attr('value', filePath);
    var input2 = $("<input type='hidden' name='fileName' />");
    input2.attr('value', fileName);
    form.append(input1);
    form.append(input2);
    form.appendTo("body");
    form.css('display', 'none');
    form.submit();
    $("#temp-form").remove();
}

// 删除文件
function deleteFile(node) {
    alert($(node).html());
    var filePath = $(node).attr("filePath");
    var fileName = $(node).attr("fileName");
    var pid = $("#pid").val();
    var url = $(node).attr("action");
    $.ajax({
        type: 'POST',
        url: url,
        data: {
            "filePath": filePath,
            "fileName": fileName,
            "pid": pid,
            "time": new Date()
        },
        success: function (data) {
            $(node).parent().remove();
            alert(data.body);
        },
        error: function (data) {
            alert("error:" + data.responseText);
        }
    });
}

// -------------------------------文件相关-end--------------------------------------------------------//

function toDateString(d) {
    var year = d.getFullYear();
    var month = buLing(d.getMonth() + 1);
    var date = buLing(d.getDate());
    var hours = buLing(d.getHours())
    var minutes = buLing(d.getMinutes());
    var seconds = buLing(d.getSeconds());
    return year + "-" + month + "-" + date + " " + hours + ":" + minutes + ":" + seconds;
}

// 日期补零
function buLing(args) {
    if (args < 10) {
        args = "0" + args;
    }
    return args;
}

function showForm() {
    $('#add-form').dialog({
        title: '新增任务',
        width: 800,
        // height: 300,
        closed: false,
        cache: false,
        modal: true,
    });
}

// 显示文件列表
function showFileList() {
    listFiles();
    $('#file-list').dialog({
        title: '文件列表',
        width: 500,
        height: 500,
        closed: false,
        cache: false,
        modal: true,
        buttons: [{
            text: '关闭',
            iconCls: 'icon-cancel',
            handler: function () {
                $('#file-list').dialog('close');
            }
        }],
    });
}

// 文件上传
function uploadFile() {
    // FormData 对象
    var form = new FormData($("#file-form")[0]);
    form.append("flg", "1");                        // 标志, 1为项目文件, 2为任务文件
    form.append("id", $("#pid").val());                        // id: 项目id, 或任务id
    $.ajax({
        type: "POST",
        //dataType: "text",
        url: "/project/fileUpload",
        data: form,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {
            alert(data.body);
            var fileName = data.data.fileName;
            var filePath = data.data.filePath;
            $("#file").append(getFileNode(filePath, fileName));
        },
        error: function (data) {
            alert("error:" + data.responseText);
        }
    });
}

// ------------------------------------------项目任务维护-begin---------------------------------------------------//

$(function(){
// 新增任务取消按钮
    $("#btn-task-cancel").click(function () {
        $('#add-form').dialog("close");
    });
// 新增任务提交按钮
    $("#btn-task-submit").click(function () {
        submitTaskForm();
        $('#add-form').dialog("close");
    });
// 清除任务表单点击事件
    $("#btn-task-reset").on("click", function(){
        clearForm();
    });
})

// 清除任务新增表单
function clearForm() {
    $("#taskBeginTime").val('');
    $("#estimatedTime").val('');
    $("#taskInfo").val('');
}

function submitTaskForm(){
    var taskBeginTime = $("#taskBeginTime").val();
    var estimatedTime = $("#estimatedTime").val();
    var taskInfo = $("#taskInfo").val();
    var empId = $("#empId").val();
    var pid = $("#pid").val();
    var managerId = $("#managerId").val();
    $.ajax({
        type: "POST",
        url: "/task/insert",
        data: {
            "beginTime":taskBeginTime,
            "estimatedTime":estimatedTime,
            "taskInfo":taskInfo,
            "empId":empId,
            "projectId": pid,
            "managerId": managerId,
            "time": new Date()
        },
        success: function(data){
            alert("添加成功！")
            var node = "<li>" +
                "<div class='task-title'>" +
                "<input type='checkbox' class='list-child' value='' style='margin-right:10px;'/>" +
                "<span class='task-title-sp'>" + taskInfo + "</span> " +
                "<span class='badge bg-info '>未完成</span>" +
                "<div class='pull-right hidden-phone' style='float:right'>" +
                "<button onclick='return finishTask(" + data + ")' class='btn btn-success btn-xs'>" +
                "<i class=' fa fa-check'></i>" +
                "</button>" +
                "<button onclick='return editTask(" + data + ")' class='btn btn-primary btn-xs'>" +
                "<i class='fa fa-pencil'></i>" +
                "</button>" +
                "<button pid='"+data.data+"' onclick='return deleteTask(this)' class='btn btn-danger btn-xs'>" +
                "<i class='fa fa-trash-o '></i>" +
                "</button>" +
                "</div>" +
                "</div>" +
                "</li>";

            $("#unfinished-task-list").append(node);
        },
        error: function(data){
            alert("error:" + data.responseText);
        }
    });
}

// 删除任务
function deleteTask(node) {
    if (confirm("确认删除此任务？")) {
        $.ajax({
            url: "/task/delete",
            type: "POST",
            data: {
                _method: "DELETE",
                "id": $(node).attr("pid"),
                "time": new Date()
            },
            success: function (data) {
                if (data.status == "1") {
                    $(node).parent().parent().parent().remove();// 删除成功后删除页面上的任务
                } else {
                    alert("删除失败！请重试！");
                }
            },
            error: function (data) {
                alert("删除失败！请重试！");
            }
        });
    }
}