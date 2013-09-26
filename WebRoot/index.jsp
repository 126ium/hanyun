<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hanyun.dao.ResourceDAOImpl,java.util.*,com.hanyun.model.impl.*"%>
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
				<p><a class="btn btn-lg btn-primary" href="login.jsp#toregister" role="button">Sign up Now!</a></p>
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
									<table class="table table-hover">
										<thead>
											<tr>
												<th>File Name</th>
												<th>Size</th>
												<th>Download Times</th>
												<th>Browse Times</th>
												<th>Upload Time</th>
											</tr>
										</thead>
										<tbody>
										<%
											ResourceDAOImpl resDAO = new ResourceDAOImpl();
											List<Resource> hotVideoList = resDAO.getResourcesByCategory(3, "hot", 3);	
											for (int i = 0; i < hotVideoList.size(); i ++) {									
										 %>
											<tr>
												<td><a href="download.jsp?id=<%=hotVideoList.get(i).getFileId() %>"><%=hotVideoList.get(i).getFileName() %></a></td>
												<td><%=hotVideoList.get(i).getFileSizeDescription() %></td>
												<td><%=hotVideoList.get(i).getDownloadTimes() %></td>
												<td><%=hotVideoList.get(i).getBrowseTimes() %></td>
												<td><%=new SimpleDateFormat("yyyy-MM-dd").format(hotVideoList.get(i).getUploadTime()) %></td>
											</tr>
										<%
											}
										 %>											
										</tbody>
									</table>
								</div>
								<div class="tab-pane fade" id="videoNew">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>File Name</th>
												<th>Size</th>
												<th>Download Times</th>
												<th>Browse Times</th>
												<th>Upload Time</th>
											</tr>
										</thead>
										<tbody>
										<%
											List<Resource> newVideoList = resDAO.getResourcesByCategory(3, "new", 3);	
											for (int i = 0; i < newVideoList.size(); i ++) {									
										 %>
											<tr>
												<td><a href="download.jsp?id=<%=newVideoList.get(i).getFileId() %>"><%=newVideoList.get(i).getFileName() %></a></td>
												<td><%=newVideoList.get(i).getFileSizeDescription() %></td>
												<td><%=newVideoList.get(i).getDownloadTimes() %></td>
												<td><%=newVideoList.get(i).getBrowseTimes() %></td>
												<td><%=new SimpleDateFormat("yyyy-MM-dd").format(newVideoList.get(i).getUploadTime()) %></td>
											</tr>
										<%
											}
										 %>											
										</tbody>
									</table>
								</div>
								<div class="tab-pane fade" id="videoRandom">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>File Name</th>
												<th>Size</th>
												<th>Download Times</th>
												<th>Browse Times</th>
												<th>Upload Time</th>
											</tr>
										</thead>
										<tbody>
										<%
											List<Resource> randomVideoList = resDAO.getResourcesByCategory(3, "random", 3);	
											for (int i = 0; i < randomVideoList.size(); i ++) {									
										 %>
											<tr>
												<td><a href="download.jsp?id=<%=randomVideoList.get(i).getFileId() %>"><%=randomVideoList.get(i).getFileName() %></a></td>
												<td><%=randomVideoList.get(i).getFileSizeDescription() %></td>
												<td><%=randomVideoList.get(i).getDownloadTimes() %></td>
												<td><%=randomVideoList.get(i).getBrowseTimes() %></td>
												<td><%=new SimpleDateFormat("yyyy-MM-dd").format(randomVideoList.get(i).getUploadTime()) %></td>
											</tr>
										<%
											}
										 %>											
										</tbody>
									</table>
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
									<table class="table table-hover">
										<thead>
											<tr>
												<th>File Name</th>
												<th>Size</th>
												<th>Download Times</th>
												<th>Browse Times</th>
												<th>Upload Time</th>
											</tr>
										</thead>
										<tbody>
										<%
											List<Resource> hotPicList = resDAO.getResourcesByCategory(2, "hot", 3);	
											for (int i = 0; i < hotPicList.size(); i ++) {									
										 %>
											<tr>
												<td><a href="download.jsp?id=<%=hotPicList.get(i).getFileId() %>"><%=hotPicList.get(i).getFileName() %></a></td>
												<td><%=hotPicList.get(i).getFileSizeDescription() %></td>
												<td><%=hotPicList.get(i).getDownloadTimes() %></td>
												<td><%=hotPicList.get(i).getBrowseTimes() %></td>
												<td><%=new SimpleDateFormat("yyyy-MM-dd").format(hotPicList.get(i).getUploadTime()) %></td>
											</tr>
										<%
											}
										 %>											
										</tbody>
									</table>
								</div>
								<div class="tab-pane fade" id="picNew">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>File Name</th>
												<th>Size</th>
												<th>Download Times</th>
												<th>Browse Times</th>
												<th>Upload Time</th>
											</tr>
										</thead>
										<tbody>
										<%
											List<Resource> newPicList = resDAO.getResourcesByCategory(2, "new", 3);	
											for (int i = 0; i < newPicList.size(); i ++) {									
										 %>
											<tr>
												<td><a href="download.jsp?id=<%=newPicList.get(i).getFileId() %>"><%=newPicList.get(i).getFileName() %></a></td>
												<td><%=newPicList.get(i).getFileSizeDescription() %></td>
												<td><%=newPicList.get(i).getDownloadTimes() %></td>
												<td><%=newPicList.get(i).getBrowseTimes() %></td>
												<td><%=new SimpleDateFormat("yyyy-MM-dd").format(newPicList.get(i).getUploadTime()) %></td>
											</tr>
										<%
											}
										 %>											
										</tbody>
									</table>
								</div>
								<div class="tab-pane fade" id="picRandom">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>File Name</th>
												<th>Size</th>
												<th>Download Times</th>
												<th>Browse Times</th>
												<th>Upload Time</th>
											</tr>
										</thead>
										<tbody>
										<%
											List<Resource> randomPicList = resDAO.getResourcesByCategory(2, "random", 3);	
											for (int i = 0; i < randomPicList.size(); i ++) {									
										 %>
											<tr>
												<td><a href="download.jsp?id=<%=randomPicList.get(i).getFileId() %>"><%=randomPicList.get(i).getFileName() %></a></td>
												<td><%=randomPicList.get(i).getFileSizeDescription() %></td>
												<td><%=randomPicList.get(i).getDownloadTimes() %></td>
												<td><%=randomPicList.get(i).getBrowseTimes() %></td>
												<td><%=new SimpleDateFormat("yyyy-MM-dd").format(randomPicList.get(i).getUploadTime()) %></td>
											</tr>
										<%
											}
										 %>											
										</tbody>
									</table>
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
									<table class="table table-hover">
										<thead>
											<tr>
												<th>File Name</th>
												<th>Size</th>
												<th>Download Times</th>
												<th>Browse Times</th>
												<th>Upload Time</th>
											</tr>
										</thead>
										<tbody>
										<%
											List<Resource> hotDocList = resDAO.getResourcesByCategory(1, "hot", 3);	
											for (int i = 0; i < hotDocList.size(); i ++) {									
										 %>
											<tr>
												<td><a href="download.jsp?id=<%=hotDocList.get(i).getFileId() %>"><%=hotDocList.get(i).getFileName() %></a></td>
												<td><%=hotDocList.get(i).getFileSizeDescription() %></td>
												<td><%=hotDocList.get(i).getDownloadTimes() %></td>
												<td><%=hotDocList.get(i).getBrowseTimes() %></td>
												<td><%=new SimpleDateFormat("yyyy-MM-dd").format(hotDocList.get(i).getUploadTime()) %></td>
											</tr>
										<%
											}
										 %>											
										</tbody>
									</table>
								</div>
								<div class="tab-pane fade" id="docNew">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>File Name</th>
												<th>Size</th>
												<th>Download Times</th>
												<th>Browse Times</th>
												<th>Upload Time</th>
											</tr>
										</thead>
										<tbody>
										<%
											List<Resource> newDocList = resDAO.getResourcesByCategory(1, "new", 3);	
											for (int i = 0; i < newDocList.size(); i ++) {									
										 %>
											<tr>
												<td><a href="download.jsp?id=<%=newDocList.get(i).getFileId() %>"><%=newDocList.get(i).getFileName() %></a></td>
												<td><%=newDocList.get(i).getFileSizeDescription() %></td>
												<td><%=newDocList.get(i).getDownloadTimes() %></td>
												<td><%=newDocList.get(i).getBrowseTimes() %></td>
												<td><%=new SimpleDateFormat("yyyy-MM-dd").format(newDocList.get(i).getUploadTime()) %></td>
											</tr>
										<%
											}
										 %>											
										</tbody>
									</table>
								</div>
								<div class="tab-pane fade" id="docRandom">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>File Name</th>
												<th>Size</th>
												<th>Download Times</th>
												<th>Browse Times</th>
												<th>Upload Time</th>
											</tr>
										</thead>
										<tbody>
										<%
											List<Resource> randomDocList = resDAO.getResourcesByCategory(1, "random", 3);	
											for (int i = 0; i < randomDocList.size(); i ++) {									
										 %>
											<tr>
												<td><a href="download.jsp?id=<%=randomDocList.get(i).getFileId() %>"><%=randomDocList.get(i).getFileName() %></a></td>
												<td><%=randomDocList.get(i).getFileSizeDescription() %></td>
												<td><%=randomDocList.get(i).getDownloadTimes() %></td>
												<td><%=randomDocList.get(i).getBrowseTimes() %></td>
												<td><%=new SimpleDateFormat("yyyy-MM-dd").format(randomDocList.get(i).getUploadTime()) %></td>
											</tr>
										<%
											}
										 %>											
										</tbody>
									</table>
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
									<table class="table table-hover">
										<thead>
											<tr>
												<th>File Name</th>
												<th>Size</th>
												<th>Download Times</th>
												<th>Browse Times</th>
												<th>Upload Time</th>
											</tr>
										</thead>
										<tbody>
										<%
											List<Resource> hotMusicList = resDAO.getResourcesByCategory(4, "hot", 3);	
											for (int i = 0; i < hotMusicList.size(); i ++) {									
										 %>
											<tr>
												<td><a href="download.jsp?id=<%=hotMusicList.get(i).getFileId() %>"><%=hotMusicList.get(i).getFileName() %></a></td>
												<td><%=hotMusicList.get(i).getFileSizeDescription() %></td>
												<td><%=hotMusicList.get(i).getDownloadTimes() %></td>
												<td><%=hotMusicList.get(i).getBrowseTimes() %></td>
												<td><%=new SimpleDateFormat("yyyy-MM-dd").format(hotMusicList.get(i).getUploadTime()) %></td>
											</tr>
										<%
											}
										 %>											
										</tbody>
									</table>
								</div>
								<div class="tab-pane fade" id="musicNew">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>File Name</th>
												<th>Size</th>
												<th>Download Times</th>
												<th>Browse Times</th>
												<th>Upload Time</th>
											</tr>
										</thead>
										<tbody>
										<%
											List<Resource> newMusicList = resDAO.getResourcesByCategory(4, "new", 3);	
											for (int i = 0; i < newMusicList.size(); i ++) {									
										 %>
											<tr>
												<td><a href="download.jsp?id=<%=newMusicList.get(i).getFileId() %>"><%=newMusicList.get(i).getFileName() %></a></td>
												<td><%=newMusicList.get(i).getFileSizeDescription() %></td>
												<td><%=newMusicList.get(i).getDownloadTimes() %></td>
												<td><%=newMusicList.get(i).getBrowseTimes() %></td>
												<td><%=new SimpleDateFormat("yyyy-MM-dd").format(newMusicList.get(i).getUploadTime()) %></td>
											</tr>
										<%
											}
										 %>											
										</tbody>
									</table>
								</div>
								<div class="tab-pane fade" id="musicRandom">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>File Name</th>
												<th>Size</th>
												<th>Download Times</th>
												<th>Browse Times</th>
												<th>Upload Time</th>
											</tr>
										</thead>
										<tbody>
										<%
											List<Resource> randomMusicList = resDAO.getResourcesByCategory(4, "random", 3);	
											for (int i = 0; i < randomMusicList.size(); i ++) {									
										 %>
											<tr>
												<td><a href="download.jsp?id=<%=randomMusicList.get(i).getFileId() %>"><%=randomMusicList.get(i).getFileName() %></a></td>
												<td><%=randomMusicList.get(i).getFileSizeDescription() %></td>
												<td><%=randomMusicList.get(i).getDownloadTimes() %></td>
												<td><%=randomMusicList.get(i).getBrowseTimes() %></td>
												<td><%=new SimpleDateFormat("yyyy-MM-dd").format(randomMusicList.get(i).getUploadTime()) %></td>
											</tr>
										<%
											}
										 %>											
										</tbody>
									</table>
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
							<table class="table table-hover">
										<thead>
											<tr>
												<th>File Name</th>
												<th>Size</th>
												<th>Download Times</th>
												<th>Browse Times</th>
												<th>Upload Time</th>
											</tr>
										</thead>
										<tbody>
										<%
											List<Resource> hotResList = resDAO.getHotRes(5);	
											for (int i = 0; i < hotResList.size(); i ++) {									
										 %>
											<tr>
												<td><a href="download.jsp?id=<%=hotResList.get(i).getFileId() %>"><%=hotResList.get(i).getFileName() %></a></td>
												<td><%=hotResList.get(i).getFileSizeDescription() %></td>
												<td><%=hotResList.get(i).getDownloadTimes() %></td>
												<td><%=hotResList.get(i).getBrowseTimes() %></td>
												<td><%=new SimpleDateFormat("yyyy-MM-dd").format(hotResList.get(i).getUploadTime()) %></td>
											</tr>
										<%
											}
										 %>											
										</tbody>
									</table>
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