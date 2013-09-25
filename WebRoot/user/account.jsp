<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title> Han Yun | Account </title>
		<link href="../css/bootstrap.css" rel="stylesheet">
		<link href="../css/navbar-fixed-top.css" rel="stylesheet">
		<link href="../css/custom.css" rel="stylesheet">
		<style type="text/css"></style>
		<script>window["_GOOG_TRANS_EXT_VER"] = "1";</script>
</head>
	<body>
		<%@ include file="../layouts/_header.jsp"%>
		<div class="container">
			<div class="row marketing">
				<div class="col-lg-3">
					<aside>
						<section>
							<h1><img alt="username" class="avatar img-rounded" src="avatar/default_avatar.jpg">User</h1>
						</section>
						<h2>Uploaded: 9</h2>
					</aside>
					<ul id="personalTab" class="nav nav-pills nav-stacked">
						<li class="active" id="statis"><a href="#statistics" data-toggle="tab">Resource statistics</a></li>
						<li><a href="#profile" data-toggle="tab">Profile</a></li>
						<li><a href="#settings" data-toggle="tab">Account settings</a></li>
						<li><a href="#resource" data-toggle="tab">Resource management</a></li>
					</ul>
				</div>
				<div id="personalTabContent" class="col-lg-9 tab-content">
					<div class="tab-pane fade active in" id="statistics">
						<div class="panel panel-default">
							<div class="panel-heading">
						    	<h3 class="panel-title">Resource Statistics</h3>
							</div>
							<div class="panel-body">
								<%@ include file="restatistics.jsp" %>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="profile">
						<div class="panel panel-default">
							<div class="panel-heading">
						    	<h3 class="panel-title">Profile</h3>
							</div>
							<div class="panel-body">
								<%@ include file="profile.jsp" %>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="settings">
						<div class="panel panel-default">
							<div class="panel-heading">
						    	<h3 class="panel-title">Account Settings</h3>
							</div>
							<div class="panel-body">
								<%@ include file="settings.jsp" %>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="resource">
						<div class="panel panel-default">
							<div class="panel-heading">
						    	<h3 class="panel-title">Resource Management</h3>
							</div>
							<div class="panel-body">
								<%@ include file="resmanage.jsp" %>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%@ include file="upload.jsp" %>
			<%@ include file="../layouts/_footer.jsp" %>
		</div>
		<script src="../js/jquery.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$("#fileupload").change(function() {
				var result = $("#fileupload").val();
				var reg = /[^\\\/]*[\\\/]+/g; 
				result = result.replace(reg, ''); 
				$("#filenameInput").val(result);
			});
		</script>
		<script src="../js/chart.js"></script>
		<script src="../js/drawchart.js"></script>
	</body>
</html>