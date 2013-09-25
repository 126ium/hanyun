<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title> Han Yun | A convenient multimedia share platform </title>
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
				<h1>Welcome to Han Yun</h1>
				<h2>A convenient multimedia share platform</h2>
				<p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up Now!</a></p>
			</div>
		</div>
		<div class="container">
			<div class="row marketing">
				<div class="col-lg-6">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h2 class="panel-title">Video</h2>
						</div>
						<div class="panel-body">
							<ul id="videoTab" class="nav nav-tabs nav-justified">
								<li class="active">
									<a href="#videoHot" data-toggle="tab">Hot</a>
								</li>
								<li>
									<a href="#videoNew" data-toggle="tab">New</a>
								</li>
								<li>
									<a href="#videoRandom" data-toggle="tab">Random</a>
								</li>
							</ul>
							<div id="videoTabContent" class="tab-content">
								<div class="tab-pane fade active in" id="videoHot">
									<p>TODO</p>
								</div>
								<div class="tab-pane fade" id="videoNew">
									<p>TODO</p>
								</div>
								<div class="tab-pane fade" id="videoRandom">
									<p>TODO</p>
								</div>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h2 class="panel-title">Picture</h2>
						</div>
						<div class="panel-body">
							<ul id="picTab" class="nav nav-tabs nav-justified">
								<li class="active">
									<a href="#picHot" data-toggle="tab">Hot</a>
								</li>
								<li>
									<a href="#picNew" data-toggle="tab">New</a>
								</li>
								<li>
									<a href="#picRandom" data-toggle="tab">Random</a>
								</li>
							</ul>
							<div id="picTabContent" class="tab-content">
								<div class="tab-pane fade active in" id="picHot">
									<p>TODO</p>
								</div>
								<div class="tab-pane fade" id="picNew">
									<p>TODO</p>
								</div>
								<div class="tab-pane fade" id="picRandom">
									<p>TODO</p>
								</div>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h2 class="panel-title">Document</h2>
						</div>
						<div class="panel-body">
							<ul id="docTab" class="nav nav-tabs nav-justified">
								<li class="active">
									<a href="#docHot" data-toggle="tab">Hot</a>
								</li>
								<li>
									<a href="#docNew" data-toggle="tab">New</a>
								</li>
								<li>
									<a href="#docRandom" data-toggle="tab">Random</a>
								</li>
							</ul>
							<div id="picTabContent" class="tab-content">
								<div class="tab-pane fade active in" id="docHot">
									<p>TODO</p>
								</div>
								<div class="tab-pane fade" id="docNew">
									<p>TODO</p>
								</div>
								<div class="tab-pane fade" id="docRandom">
									<p>TODO</p>
								</div>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h2 class="panel-title">Music</h2>
						</div>
						<div class="panel-body">
							<ul id="docTab" class="nav nav-tabs nav-justified">
								<li class="active">
									<a href="#musicHot" data-toggle="tab">Hot</a>
								</li>
								<li>
									<a href="#musicNew" data-toggle="tab">New</a>
								</li>
								<li>
									<a href="#musicRandom" data-toggle="tab">Random</a>
								</li>
							</ul>
							<div id="picTabContent" class="tab-content">
								<div class="tab-pane fade active in" id="musicHot">
									<p>TODO</p>
								</div>
								<div class="tab-pane fade" id="musicNew">
									<p>TODO</p>
								</div>
								<div class="tab-pane fade" id="musicRandom">
									<p>TODO</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h2 class="panel-title">What's Hot?</h2>
						</div>
						<div class="panel-body">
							content
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h2 class="panel-title">Who shares most?</h2>
						</div>
						<div class="panel-body">
							content
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