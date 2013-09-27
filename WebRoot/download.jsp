<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.hanyun.dao.*,com.hanyun.model.impl.*,java.text.SimpleDateFormat"%>
    
<%
	String fileId = request.getParameter("id");
	AbstractHanyunDAO resDao = new ResourceDAOImpl();
	AbstractHanyunDAO userDao = new UserDAOImpl();
	Resource res = (Resource) resDao.get(Integer.parseInt(fileId));
	
	if (res == null) {
	
%>
	sorry, we can not find the resource you requested.
<%
	} else {
	res.setBrowseTimes(res.getBrowseTimes() + 1);
	resDao.update(res);
	User uploadUser = (User) userDao.get(res.getUserId());
%>
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
    							<h1><%=res.getFileName() %></h1>
    							<div class="center">				
									<a href="#" class="thumbnail">
      									<img data-src="holder.js/100%x180" alt="file" src="images/<%=res.getResourceId() %>.jpg" style="max-width: 100%; height: auto; display: block;">
      								</a>
      								<h5>Size: <%=res.getFileSizeDescription() %></h5>
      								<h5>Upload Date: <%=new SimpleDateFormat("yyyy-MM-dd").format(res.getUploadTime()) %></h5>
    							</div>
    							<footer>
    								<button id="downButton" class="btn btn-primary btn-lg">
										Download
									</button>
									<p style="float: right; margin-left: 10px">Download Times:<%=res.getDownloadTimes() %></p>
									<p style="float: right;">Browse Times:<%=res.getBrowseTimes() %></p>
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
										<h3><img alt="<%=uploadUser.getUserName() %>" class="avatar img-rounded" src="<%="user/" + uploadUser.getAvatarUrl() %>"> <%=uploadUser.getUserName() %></h3>
									</section>
								</aside>
								<footer>
									<h2>Recommend:</h2>
									<table class="table table-hover">
										<tbody>
										<%
											Resource res1 = (Resource) resDao.get(Integer.parseInt(fileId) + 1);
											Resource res2 = (Resource) resDao.get(Integer.parseInt(fileId) + 2);										
										
										 %>
											<tr><td><%=res1.getFileName() %></td></tr>
											<tr><td><%=res2.getFileName() %></td></tr>
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
	<script type="text/javascript">
		$("#downButton").click(function() {
			window.location = "download.action?fileId=<%=res.getFileId() %>";			
			});
	</script>	

	</body>
</html>
<% }%>