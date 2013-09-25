<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title> Han Yun | Resource Statistics </title>
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/navbar-fixed-top.css" rel="stylesheet">
		<link href="css/custom.css" rel="stylesheet">
		<style type="text/css"></style>	
		<script>window["_GOOG_TRANS_EXT_VER"] = "1";</script>
	</head>
	<body>
	<%@ include file="layouts/_header.jsp" %>
		<div class="container">
			<div class="center hero-unit">
				<h1>Resource Statistics</h1>
				<h3>Bar Charts</h3>
				<div>
					<canvas id="allBarChart" width="800" height="400"></canvas>
				</div>
				<h3>Doughnut Charts</h3>
				<div>
					<canvas id="allDouChart" width="400" height="400"></canvas>
				</div>
				<span class="label label-pic">Pictures</span>
				<span class="label label-doc">Documents</span>
				<span class="label label-music">Musics</span>
				<span class="label label-video">Videos</span>
			</div>
			<%@ include file="layouts/_footer.jsp" %>
		</div>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/drawallchart.js"></script>
		<script src="js/chart.js"></script>
	</body>
</html>