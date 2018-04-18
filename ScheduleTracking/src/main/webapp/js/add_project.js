$(function() {

    $(".form_datetime").datetimepicker({
        format : "yyyy-mm-dd hh:ii:ss"
    });

    $("#deptId").on("change", function(){
        $("#managerId").empty();
        $("#managerId").append("<option value=''>请选择</option>");
        var deptId = $("#deptId").val();
        if(deptId == ""){
            return;
        }
        $.get("/emp/getByDeptId", {"deptId" : deptId,"time": new Date()}, function(data){
            for(var i = 0; i < data.length; i++) {
                var optionNode = "<option value='" + data[i].id + "'>" + data[i].name + "</option>";
                $("#managerId").append(optionNode);
                $("#empId").append(optionNode);
            }
        });
    });

    // 重置按钮点击事件，点击后将表单数据重置为空
    $("#btn_reset").click(function(){
        $("#projectName").val("");
        $("#deptId").val("");
        $("#managerId").val("");
        $("#beginTime").val("");
        $("#endTime").val("");
        $("#expectEndTime").val("");
        $("#budget").val("");
        $("#projectDescribe").val("");
        $("#file").val("");
    });

    // 点击按钮ajax提交项目信息，提交文件上传表单
    $("#btn_submit").click(function() {
        if(!filedCheck()){
            return;
        }
        var projectName = $("#projectName").val();// 项目名称
        var deptId = $("#deptId").val();// 部门ID
        var managerId = $("#managerId").val();// 负责人ID
        var beginTime = $("#beginTime").val();// 开始时间
        var expectEndTime = $("#expectEndTime").val();// 预计结束时间
        var budget = $("#budget").val();// 项目预算
        var projectDescribe = $("#projectDescribe").val();// 项目简介
        var strs = $("#file").val().split("\\");
        var schemeFile = strs[strs.length - 1];

        var args = {
            "projectName" : projectName,
            "deptId" : deptId,
            "managerId" : managerId,
            "beginTime" : beginTime,
            "expectEndTime" : expectEndTime,
            "budget" : budget,
            "projectDescribe" : projectDescribe,
            "schemeFile" : schemeFile,
            "time" : new Date()
        };
        $.post("/project/addProject", args, function(data) {
            if (data.status == "1") {
                $("#uploadForm").submit();
            } else {
                for (var key in data) {
                    if(key != "status") {
                        msg = data[key];
                        var msgNode = "<font color='red'>" + msg + "</font>";
                        $("#" + key + "Msg").empty().append(msgNode);
                    }
                }
            }
        });
    });
})

function checkFiledsIfNull(filedName, filedValue, ErrorMsgEare){
    if(filedValue == "" || filedValue == null){
        var msgNode = "<font color='red'>" + filedName + "不能为空！</font>";
        $(ErrorMsgEare).empty().append(msgNode);
        return false;
    }
    return true;
}

// 前台校验方法
function filedCheck() {
    var projectName = $("#projectName").val();// 项目名称
    if(!checkFiledsIfNull("项目名称", projectName, $("#projectNameMsg"))) {
        return false;
    }
    var deptId = $("#deptId").val();// 部门ID
    if(deptId == "") {
        var msgNode = "<font color='red'>请选择部门！</font>";
        $("#deptIdMsg").empty().append(msgNode);
        return false;
    }
    var managerId = $("#managerId").val();// 负责人ID
    if(managerId == "") {
        var msgNode = "<font color='red'>请选择负责人！</font>";
        $("#managerIdMsg").empty().append(msgNode);
        return false;
    }
    var beginTime = $("#beginTime").val();// 开始时间
    if(!checkFiledsIfNull("开始时间", beginTime, $("#beginTimeMsg"))) {
        return false;
    }
    var expectEndTime = $("#expectEndTime").val();// 预计结束时间
    if(!checkFiledsIfNull("预期时间", expectEndTime, $("#expectEndTimeMsg"))){
        return false;
    }
    var budget = $("#budget").val();// 项目预算
    if(!checkFiledsIfNull("项目预算", budget, $("#budgetMsg"))){
        return false;
    }
    var projectDescribe = $("#projectDescribe").val();// 项目简介
    if(!checkFiledsIfNull("项目简介", projectDescribe, $("#projectDescribeMsg"))){
        return false;
    }
    var strs = $("#file").val().split("\\");
    var schemeFile = strs[strs.length - 1];
    if(schemeFile == "" || schemeFile == null){
        var msgNode = "<font color='red'>请提交策划案！</font>";
        $("#schemeFileMsg").empty().html(msgNode);
        return false;
    }

    return true;
}

// 当某项信息校验失败后，若用户修改了值，则验证该项是否为空
function onblurCheckIfNull(inputNode, msgDivName){
    var value = $(inputNode).val();
    if(value != "") {
        $("#" + msgDivName).empty();
    }
}