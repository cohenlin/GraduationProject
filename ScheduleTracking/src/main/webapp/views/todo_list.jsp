<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="menu.jsp" %>
<html>
<link href="assets/css/to-do.css" rel="stylesheet">
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
        <!-- COMPLEX TO DO LIST -->
        <div class="row mt">
            <div class="col-md-12">
                <section class="task-panel tasks-widget">
                    <div class="panel-heading">
                        <div class="pull-left">
                            <h5>
                                <i class="fa fa-tasks"></i> Todo List - Complex Style
                            </h5>
                        </div>
                        <br>
                    </div>
                    <div class="panel-body">
                        <div class="task-content">
                            <ul class="task-list">
                                <li>
                                    <div class="task-checkbox">
                                        <input type="checkbox" class="list-child" value=""/>
                                    </div>
                                    <div class="task-title">
                                        <span class="task-title-sp">任务1</span> <span class="badge bg-theme">Done</span>
                                        <div class="pull-right hidden-phone">
                                            <button class="btn btn-success btn-xs">
                                                <i class=" fa fa-check"></i>
                                            </button>
                                            <button class="btn btn-primary btn-xs">
                                                <i class="fa fa-pencil"></i>
                                            </button>
                                            <button class="btn btn-danger btn-xs">
                                                <i class="fa fa-trash-o "></i>
                                            </button>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="task-checkbox">
                                        <input type="checkbox" class="list-child" value=""/>
                                    </div>
                                    <div class="task-title">
                                            <span class="task-title-sp">Extensive collection of
                                                plugins</span> <span class="badge bg-warning">Cool</span>
                                        <div class="pull-right hidden-phone">
                                            <button class="btn btn-success btn-xs">
                                                <i class=" fa fa-check"></i>
                                            </button>
                                            <button class="btn btn-primary btn-xs">
                                                <i class="fa fa-pencil"></i>
                                            </button>
                                            <button class="btn btn-danger btn-xs">
                                                <i class="fa fa-trash-o "></i>
                                            </button>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="task-checkbox">
                                        <input type="checkbox" class="list-child" value=""/>
                                    </div>
                                    <div class="task-title">
                                        <span class="task-title-sp">Free updates always, no extra fees.</span>
                                        <span class="badge bg-success">2 Days</span>
                                        <div class="pull-right hidden-phone">
                                            <button class="btn btn-success btn-xs">
                                                <i class=" fa fa-check"></i>
                                            </button>
                                            <button class="btn btn-primary btn-xs">
                                                <i class="fa fa-pencil"></i>
                                            </button>
                                            <button class="btn btn-danger btn-xs">
                                                <i class="fa fa-trash-o "></i>
                                            </button>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="task-checkbox">
                                        <input type="checkbox" class="list-child" value=""/>
                                    </div>
                                    <div class="task-title">
                                        <span class="task-title-sp">More features coming soon</span>
                                        <span class="badge bg-info">Tomorrow</span>
                                        <div class="pull-right hidden-phone">
                                            <button class="btn btn-success btn-xs">
                                                <i class=" fa fa-check"></i>
                                            </button>
                                            <button class="btn btn-primary btn-xs">
                                                <i class="fa fa-pencil"></i>
                                            </button>
                                            <button class="btn btn-danger btn-xs">
                                                <i class="fa fa-trash-o "></i>
                                            </button>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="task-checkbox">
                                        <input type="checkbox" class="list-child" value=""/>
                                    </div>
                                    <div class="task-title">
                                            <span class="task-title-sp">Hey, seriously, you should
                                                buy this </span> <span class="badge bg-important">Now</span>
                                        <div class="pull-right">
                                            <button class="btn btn-success btn-xs">
                                                <i class=" fa fa-check"></i>
                                            </button>
                                            <button class="btn btn-primary btn-xs">
                                                <i class="fa fa-pencil"></i>
                                            </button>
                                            <button class="btn btn-danger btn-xs">
                                                <i class="fa fa-trash-o "></i>
                                            </button>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>

                        <div class=" add-task-row">
                            <a class="btn btn-success btn-sm pull-left"
                               href="todo_list.html#">Add New Tasks</a> <a
                                class="btn btn-default btn-sm pull-right"
                                href="todo_list.html#">See All Tasks</a>
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

<!-- js placed at the end of the document so the pages load faster -->
<script src="assets/js/jquery.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript"
        src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="assets/js/jquery.scrollTo.min.js"></script>
<script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
<!--common script for all pages-->
<script src="assets/js/common-scripts.js"></script>
<!--script for this page-->
<script src="assets/js/tasks.js" type="text/javascript"></script>

<script>
    jQuery(document).ready(function () {
        TaskList.initTaskWidget();

        $.get("task/list", {"time": new Date()}, function (data) {
            // if (data.length > 0) {
            //     for (var i = 0; i < data.length(); i++) {
            //
            //     }
            // }
        });
    });
</script>
</body>
</html>