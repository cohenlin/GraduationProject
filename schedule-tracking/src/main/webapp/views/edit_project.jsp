<!DOCTYPE html>
<%@ include file="menu.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑项目</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/edit_project.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/add_project.js"></script>
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
                            <input type="hidden" id="pid" value="">
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
                            <div class="form-group col-sm-6">
                                <label class="col-sm-3 control-label">项目资料</label>
                                <div class="col-sm-6">
                                    <a onclick="showFileList()" class="btn btn-success btn-sm"
                                       href="javascript:void(0)">文件列表</a>
                                </div>
                                <!--<div class="col-sm-2">-->
                                <!--</div>-->
                                <!--</div>-->
                                <!--<div class="form-group col-sm-6">-->
                                <!--<label class="col-sm-3 control-label">上传文件</label>-->
                                <!--<div class="col-sm-6">-->
                                <!--<input id="fileUpload" type="file" class="form-control" name="file" />-->
                                <!--<input id="upload" type="button" value="上传" />-->
                                <!--<br />-->
                                <!--<progress id="progressBar" value="0" max="100"/>-->
                                <!--<span id="percentage"></span>-->
                                <!--</div>-->
                                <!--<div class="col-sm-2"></div>-->
                            </div>
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
                                    <i class="fa fa-tasks"></i> 项目附属任务
                                </h5>
                            </div>
                            <div class="pull-right add-task-row" style="margin-right: 12px; margin-bottom: 5px;">
                                <div>
                                    <a onclick="showForm()" class="btn btn-success btn-sm pull-left"
                                       href="javascript:void(0)">新建任务</a>
                                </div>
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
                </div>
                <!-- /col-md-12-->
            </div>
            <div id="add-form" class="row" hidden>
                <div class="col-md-12">
                    <section class="task-panel tasks-widget">
                        <div class="panel-body">
                            <div class="form-group col-sm-12">
                                <label class="col-sm-3 control-label" style="text-align:right">开始时间</label>
                                <div class="col-sm-6 input-append date" style="z-index: 10000;">
                                    <input id="taskBeginTime" type="text" value=""
                                           class="form-control form_datetime"
                                           onchange="onblurCheckIfNull(this, 'taskBeginTimeMsg')"/>
                                </div>
                                <div id="taskBeginTimeMsg" class="control-label"></div>
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
                                <label class="col-sm-3 control-label" style="text-align:right">指派给谁</label>

                                <div class="col-sm-6 input-append">
                                    <select id="empId" class="form-control" name="managerId"
                                            onchange="onblurCheckIfNull(this, 'empIdMsg')">
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
                                <div class="col-sm-12 col-sm-offset-4">
                                    <div class="col-sm-1">
                                        <button id="btn-task-submit" type="submit" class="btn btn-success btn-sm">提交
                                        </button>
                                    </div>
                                    <div class="col-sm-1">
                                        <button id="btn-task-reset" type="button" class="btn btn-warning btn-sm">重置
                                        </button>
                                    </div>
                                    <div class="col-sm-1">
                                        <button id="btn-task-cancel" type="button" class="btn btn-sm">取消</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
                <!-- /col-md-12-->
            </div>
            <div id="file-list" class="row" hidden>
                <div class="col-md-12">
                    <!-- 文件上传 -->
                    <label class="col-sm-3">上传文件</label>
                    <div class="col-sm-11 col-md-offset-1">
                        <div class="col-sm-9">
                            <form id="file-form" enctype="multipart/form-data">
                                <input id="fileUpload" type="file" class="form-control" name="file"/>
                            </form>
                        </div>
                        <input id="upload" type="button" class="col-sm-3 btn btn-warning btn-sm" value="上传"
                               onclick="return uploadFile()"/>
                    </div>
                    <!-- 文件列表 -->
                    <br/>
                    <label class="col-sm-3">文件列表</label>
                    <div id="file" class="col-sm-10 col-md-offset-2">

                    </div>
                </div>
            </div>
        </section>
    </section>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
<script>

</script>