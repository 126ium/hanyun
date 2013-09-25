<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title> Han Yun | Download </title>
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/navbar-fixed-top.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/navbar.css"/>
		<link rel="stylesheet" type="text/css" href="css/resources.css"/>
		<link rel="stylesheet" type="text/css" href="css/SaveDowm.css"/>
		<link href="css/custom.css" rel="stylesheet">
		<style type="text/css"></style>
		<script>window["_GOOG_TRANS_EXT_VER"] = "1";</script>
	</head>
	<body>
		<%@ include file="layouts/_header.jsp" %>
		<div class="container">
			<div class="row marketing">
				<div class="col-lg-8">
					<div class="panel panel-default">
						<div class="panel-body">
    						<div class="container">
    							<h1>File Name</h1>
    							<div class="center">				
									<a href="#" class="thumbnail">
      									<img data-src="holder.js/100%x180" alt="file" src="images/0001.jpg" style="max-width: 100%; height: auto; display: block;">
      								</a>
      								<h5>Size: 1KB</h5>
      								<h5>Upload Date: 2020-2-20</h5>
    							</div>
    							<footer>
    								<button class="btn btn-primary btn-lg" type="submit">
										Download
									</button>
									<p style="float: right; margin-left: 10px">Download Times:3</p>
									<p style="float: right;">Browse Times:4</p>
    							</footer>
    						</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="panel panel-default">
						<div class="panel-body">
    						<div class="container">
    							<h1>Sharer</h1>
    							<aside>
									<section>
										<h3><img alt="username" class="avatar img-rounded" src="images/default_avatar.jpg">User</h3>
									</section>
								</aside>
								<footer>
									<h2>Recommend:</h2>
									<table class="table table-hover">
										<tbody>
											<tr><td>file1</td></tr>
											<tr><td>file2</td></tr>
										</tbody>
									</table>
								</footer>
    						</div>
						</div>
					</div>
				</div>
			</div>
		<%@ include file="layouts/_footer.jsp" %>
		</div>
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	</body>
</html>