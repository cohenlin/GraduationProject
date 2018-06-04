<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="menu.jsp" %>
<html>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/add_project.js"></script>
<script type="text/javascript">
    $(function () {
        $.get("/dept/getAll", {"time": new Date()}, function (data) {
            for (var i = 0; i < data.length; i++) {
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
                            <!--<form id="uploadForm" action="/project/fileUpload" method="POST" enctype="multipart/form-data">-->
                                <!--<div class="form-group col-sm-6">-->
                                    <!--<label class="col-sm-3 control-label">上传项目策划案</label>-->
                                    <!--<div class="col-sm-6">-->
                                        <!--<input id="file" type="file" class="form-control" name="file"-->
                                               <!--onchange="onblurCheckIfNull(this, 'schemeFileMsg')"/>-->
                                    <!--</div>-->
                                    <!--<div class="col-sm-2">-->
                                    <!--</div>-->
                                    <!--<div id="schemeFileMsg" class="control-label"></div>-->
                                <!--</div>-->
                            <!--</form>-->
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
            <%--<section class="form-panel" style="margin-top: 30px;">--%>
                <%--<div style="float: right">--%>
                    <%--<a onclick="showForm()" class="btn btn-success btn-sm pull-left" href="javascript:void(0)">新建任务</a>--%>
                <%--</div>--%>
                <%--<div class="panel-heading">--%>
                    <%--<div class="pull-left">--%>
                        <%--<h5>--%>
                            <%--<i class="fa fa-tasks"></i> 项目附属任务--%>
                        <%--</h5>--%>
                    <%--</div>--%>
                    <%--<br>--%>
                <%--</div>--%>
                    <%--<div class="task-content">--%>
                        <%--<ul id="finished-task-list" class="task-list">--%>
                            <%--<li>--%>
                                <%--<div class='task-title'>--%>
                                    <%--<input type='checkbox' class='list-child' value='' style='margin-right:10px;'/>--%>
                                    <%--<span class=\"task-title-sp\">任务内容</span>--%>
                                    <%--<span class='badge bg-success'>已完成</span>--%>
                                    <%--<div class='pull-right hidden-phone' style='float:right'>--%>
                                    <%--<button onclick='return finishTask()' class='btn btn-success btn-xs'>--%>
                                    <%--<i class='fa fa-check'></i>--%>
                                    <%--</button>--%>
                                    <%--<button onclick='return editTask()' class='btn btn-primary btn-xs'>--%>
                                    <%--<i class='fa fa-pencil'></i>--%>
                                    <%--</button>--%>
                                    <%--<button onclick='return removeTask()' class='btn btn-danger btn-xs'>--%>
                                    <%--<i class='fa fa-trash-o'></i>--%>
                                    <%--</button>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<div class='task-title'>--%>
                                    <%--<input type='checkbox' class='list-child' value='' style='margin-right:10px;'/>--%>
                                    <%--<span class=\"task-title-sp\">任务内容</span>--%>
                                    <%--<span class='badge bg-success'>已完成</span>--%>
                                    <%--<div class='pull-right hidden-phone' style='float:right'>--%>
                                    <%--<button onclick='return finishTask()' class='btn btn-success btn-xs'>--%>
                                    <%--<i class='fa fa-check'></i>--%>
                                    <%--</button>--%>
                                    <%--<button onclick='return editTask()' class='btn btn-primary btn-xs'>--%>
                                    <%--<i class='fa fa-pencil'></i>--%>
                                    <%--</button>--%>
                                    <%--<button onclick='return removeTask()' class='btn btn-danger btn-xs'>--%>
                                    <%--<i class='fa fa-trash-o'></i>--%>
                                    <%--</button>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</div>--%>
            <%--</section>--%>
        </section>
        <!--/wrapper -->
    </section>
</section>
<!-- /MAIN CONTENT -->
<!--main content end-->
<jsp:include page="footer.jsp"/>