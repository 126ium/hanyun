<%@page import="com.hanyun.model.impl.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	User user = (User) request.getSession().getAttribute("user");
 %>    
 <%String resPageNum = request.getParameter("page"); %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title> Han Yun | Account - <%=user.getUserName() %></title>
		<link href="../css/bootstrap.css" rel="stylesheet">
		<link href="../css/jquery.Jcrop.min.css" rel="stylesheet">
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
						
							<h1><img alt="<%=user.getUserName() + "'s avatar" %>" class="avatar img-rounded" src="<%=user.getAvatarUrl() %>"><%=user.getUserName() %></h1>
						</section>
						<h2 id="uploaded"></h2>
					</aside>
					<ul id="personalTab" class="nav nav-pills nav-stacked">
						<li class="active" id="statis"><a href="#statistics" data-toggle="tab">Resource statistics</a></li>
						<li><a href="#profile" data-toggle="tab">Profile</a></li>
						<li><a href="#settings" data-toggle="tab">Account settings</a></li>
						<li><a href="#resource" data-toggle="tab">Resource management</a></li>
						<%if (user.getRole() == 1) { %>						
						<li><a href="tmp_res.jsp" target="_blank" >Advance Resource review</a></li>
                        <li><a href="tmp_usr.jsp" target="_blank" >User Management</a></li>
                        <%} %>
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
					<div class="tab-pane fade" id="review">
						<div class="panel panel-default">
							<div class="panel-heading">
						    	<h3 class="panel-title">Resource Review</h3>
							</div>
							<div class="panel-body">
								<%@ include file="resreview.jsp" %>
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
		<script type="text/javascript">
			function uploadTemp() {
	var fd = new FormData(document.getElementById("setForm"));
	fd.append("CustomField", "This is some extra data");
	$.ajax({
	  url: "avatarUpload",
	  type: "POST",
	  data: fd,
	  processData: false,  // tell jQuery not to process the data
	  contentType: false   // tell jQuery not to set contentType
	}).done(cutImage);
	
};

function cutImage() {
	$("#target").attr("src", "avatar/" + $.md5('<%=user.getUserId() %>').toUpperCase() + ".png.tmp");
	$("#preview").attr("src", "avatar/" + $.md5('<%=user.getUserId() %>').toUpperCase() + ".png.tmp");
	
	var aWidth = $("#target").css("width");
	var aHeight = $("#target").css("height");
	
	function showPreview(coords)
	{
		var rx = 100 / coords.w;
		var ry = 100 / coords.h;

		$('#preview').css({
			width: Math.round(rx * aWidth) + 'px',
			height: Math.round(ry * aHeight) + 'px',
			marginLeft: '-' + Math.round(rx * coords.x) + 'px',
			marginTop: '-' + Math.round(ry * coords.y) + 'px'
		});
		
		$('#x').val(coords.x);
		$('#y').val(coords.y);
		$('#w').val(coords.w);
		$('#h').val(coords.h);
	};
	
	$(function(){
		$('#target').Jcrop({
			onChange: showPreview,
			onSelect: showPreview,
			aspectRatio: 1
		});
	});
};

function saveFile() {
	var x = $('#x').val();
	var y = $('#y').val();
	var w = $('#w').val();
	var h = $('#h').val();
	$.post("saveAvatar", 
			{
				imagex: x,
				imagey: y,
				imagew: w,
				imageh: h,
			},
			fuck);
	
	function fuck() {
		//alert("fuck");
		window.location.reload(true);
	}
	
}

$("#avatarFile").change(uploadTemp);
$("#save").click(saveFile);		
		</script>
		<script src="../js/jquery.color.js"></script>
		<script src="../js/jquery.Jcrop.min.js"></script>
		<script src="../js/jquery.md5.js"></script>
		<script src="../js/setpasswd.js"></script>
	</body>
</html>
