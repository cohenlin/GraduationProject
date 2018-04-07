<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<html>
<body>
<script type="text/javascript">
    $(function(){
    	$.get("dept/getAll", {"time" : new Date()}, function(data) {
            for(var i = 0; i < data.length; i++) {
                var optionNode = "<option value='" + data[i].id + "'>" + data[i].deptName + "</option>";
                $("#deptId").append(optionNode);
            }
        })
    })
</script>
	<!--main content start-->
	<section id="container">
		<section id="main-content">
			<section class="wrapper">
				<h3>
					<i class="fa fa-angle-right"></i> 新增项目
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
										<select id="deptId" class="form-control" name="deptId" onchange="onblurCheckIfNull(this, 'deptIdMsg')">
										    <option value="">请选择</option>
										</select>
										<input type="hidden" id="deptFlg" value="0" />
									</div>
									<div id="deptIdMsg" class="control-label"></div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-3 control-label">项目负责人</label>
									<div class="col-sm-6">
										<select id="managerId" class="form-control" name="managerId" onchange="onblurCheckIfNull(this, 'managerIdMsg')">
										    <option value="">请选择</option>
										</select>
									</div>
									<div id="managerIdMsg" class="control-label"></div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-3 control-label">项目开始时间</label>
									<div class="col-sm-6 input-append date">
										<input id="beginTime" type="text" value="" name="beginTime"
											class="form-control form_datetime" onchange="onblurCheckIfNull(this, 'beginTimeMsg')" />
									</div>
									<div id="beginTimeMsg" class="control-label"></div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-3 control-label">预计结束时间</label>
									<div class="col-sm-6 input-append date">
										<input id="expectEndTime" type="text" value=""
											name="expectEndTime" class="form-control form_datetime" onchange="onblurCheckIfNull(this, 'expectEndTimeMsg')" />
									</div>
									<div id="expectEndTimeMsg" class="control-label"></div>
								</div>
								<div class="form-group col-sm-6">
									<label class="col-sm-3 control-label">项目预算（元）</label>
									<div class="col-sm-6">
										<input id="budget" class="form-control" type="text"
											name="budget" onchange="onblurCheckIfNull(this, 'budgetMsg')" />
									</div>
									<div id="budgetMsg" class="control-label"></div>
								</div>
								<form id="uploadForm" action="project/fileUpload" method="post"
									enctype="multipart/form-data">
									<div class="form-group col-sm-6">
										<label class="col-sm-3 control-label">上传项目策划案</label>
										<div class="col-sm-6">
											<input id="file" type="file" class="form-control" name="file" onchange="onblurCheckIfNull(this, 'schemeFileMsg')" />
										</div>
										<div class="col-sm-2">
											<!-- 
                                            <span><button id="btn_upload" type="button" onclick="">上传</button></span>
                                        -->
										</div>
										<div id="schemeFileMsg" class="control-label"></div>
									</div>
								</form>
								<div class="form-group col-sm-12">
									<label class="col-sm-1 control-label">项目简介</label>
									<div class="col-sm-7">
										<textarea id="projectDescribe" cols="4" class="form-control"
											name="projectDescribe" style="margin-left: 40px;" onchange="onblurCheckIfNull(this, 'projectDescribeMsg')"></textarea>
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
					<!-- col-lg-12-->
				</div>
			</section>
			<!--/wrapper -->
		</section>
	</section>
	<!-- /MAIN CONTENT -->
	<!--main content end-->
	<jsp:include page="footer.jsp" />
	<script>
		$(function() {
			$("#deptId").on("change", function(){
				$("#managerId").empty();
				$("#managerId").append("<option value=''>请选择</option>");
				var deptId = $("#deptId").val();
				if(deptId == ""){
					return;
				}
				$.get("emp/getByDeptId", {"deptId" : deptId,"time": new Date()}, function(data){
					for(var i = 0; i < data.length; i++) {
		                var optionNode = "<option value='" + data[i].id + "'>" + data[i].name + "</option>";
		                $("#managerId").append(optionNode);
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
				$.post("project/addProject", args, function(data) {
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
	</script>
	<script type="text/javascript">
		$(".form_datetime").datetimepicker({
			format : "yyyy-mm-dd hh:ii:ss"
		});
	</script>
</body>
</html>