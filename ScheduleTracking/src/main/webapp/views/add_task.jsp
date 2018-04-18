<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="add-form" class="row">
    <div class="col-md-12">
        <section class="task-panel tasks-widget">
            <div class="panel-body">
                <div class="form-group col-sm-12">
                    <label class="col-sm-3 control-label" style="text-align:right">开始时间</label>
                    <div class="col-sm-6 input-append date">
                        <input id="1" type="text" value=""
                               class="form-control form_datetime"
                               onchange="onblurCheckIfNull(this, 'beginTimeMsg')"/>
                    </div>
                    <div id="2" class="control-label"></div>
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
</body>
</html>
