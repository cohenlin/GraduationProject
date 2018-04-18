<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<html>
<body>
<script>
	$(function(){
	    $.ajax({
			url: '/project/list',
			type: 'get',
			data: {
			    "time" : new Date()
			},
			success: function(data){
			    var list = data.data;
                $("#tbody").empty();
                for (var i = 0; i < list.length; i++){
                    appendNode(list[i]);
				}
			},
			error: function(data){
				alert("error");
			}
		});
	})
	// 将项目信息拼接成表格行节点
	function appendNode(project){
	    $.ajax({
			url: '/project/getEmpByProId',
			type: 'get',
			data: {
				"pid": project.id,
				"time": new Date()
			},
			success: function(data){
			    var flg;
			    if(project.finished == '0'){
			        flg = "未完成";
				}else{
			        flg = "已完成";
				}
                var node = "<tr>" +
                    "<td>" + project.id + "</td>" +
                    "<td>" + project.projectName + "</td>" +
                    "<td class='numeric'>" + new Date(project.beginTime).toLocaleString() + "</td>" +
                    "<td class='numeric'>" + getTimes(project.expectEndTime - new Date().getTime()) + "</td>" +
                    "<td class='numeric'>" + new Date(project.expectEndTime).toLocaleString() + "</td>" +
                    "<td class='numeric'>" + project.managerId + "</td>" +
                    "<td class='numeric'>" + data.data.total + "</td>" +// 参与人数要算
                    "<td class='numeric'>" + project.schedule + "</td>" +
                    "<td class='numeric'>" + flg + "</td>" +
					"<td class='numeric'>" +
						"<button onclick='' class='btn btn-success btn-xs'>" +
						"<i class='fa fa-check'></i>" +
						"</button>" +
						"<button onclick='' class='btn btn-primary btn-xs'>" +
						"<i class='fa fa-pencil'></i>" +
						"</button>" +
						"<button onclick='' class='btn btn-danger btn-xs'>" +
						"<i class='fa fa-trash-o'></i>" +
						"</button>" +
					"</td>"+
                    "</tr>";
                $("#tbody").append(node);
			},
			error: function(data){

			}
		});
	}

	// 传入毫秒值，计算出几天几小时
	function getTimes(sec){
	    var hours = (sec / (1000 * 60 * 60)).toFixed(0);
	    var d = Math.floor(hours / 24);
	    var h = hours - d * 24;
	    return d.toString() + "天 " + h.toString() + "小时";
	}
</script>
	<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">
			<h3>
				<i class="fa fa-angle-right"></i> 项目信息一览
			</h3>
			<div class="row mt">
				<div class="col-lg-12">
					<div class="content-panel">
						<h4>
							<i class="fa fa-angle-right"></i> 项目信息表
						</h4>
						<section id="unseen">
							<table class="table table-bordered table-striped table-condensed">
								<thead>
									<tr>
										<th>项目编号</th>
										<th>项目名称</th>
										<th class="numeric">开始日期</th>
										<th class="numeric">持续日期</th>
										<th class="numeric">预计完成</th>
										<th class="numeric">项目负责人</th>
										<th class="numeric">参与人数</th>
										<th class="numeric">目前进度</th>
										<th class="numeric">是否完成</th>
										<th class="numeric">维护操作</th>
									</tr>
								</thead>
								<tbody id="tbody">

								</tbody>
							</table>
						</section>
					</div>
					<!-- /content-panel -->
				</div>
				<!-- /col-lg-4 -->
			</div>
			<!-- /row -->

		</section>
		<!--/wrapper -->
	</section>
	<!-- /MAIN CONTENT -->
	<!--main content end-->
	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/assets/js/jquery.js"></script>
	<script src="/assets/js/jquery-1.8.3.min.js"></script>
	<script src="/assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="/assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/assets/js/jquery.scrollTo.min.js"></script>
	<script src="/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="/assets/js/jquery.sparkline.js"></script>


	<!--common script for all pages-->
	<script src="/assets/js/common-scripts.js"></script>

	<script type="text/javascript"
		src="/assets/js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="/assets/js/gritter-conf.js"></script>

	<!--script for this page-->
	<script src="/assets/js/sparkline-chart.js"></script>
	<script src="/assets/js/zabuto_calendar.js"></script>
</body>
</html>