<%@page import="com.hanyun.dao.ResourceDAOImpl,java.util.*, com.hanyun.model.impl.*"%>
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
		<title> Han Yun | Search </title>
	</head>
	<body>
		<%@ include file="layouts/_header.jsp" %>
		<div class="container">
			<div class="hero-unit">
				<h3>Search Result</h3>
				<%
					String searchKey = request.getParameter("s");
					ResourceDAOImpl resDao = new ResourceDAOImpl();
					List<Resource> resultList = resDao.getSearchResult(searchKey, 10);
					
					//System.out.println(resultList);
					for (int i = 0; i < resultList.size(); i ++) {
				 %>
				<div class="media">
  					<a class="pull-left" href="#">
    					<img style="width: 64px; height: 64px;" class="media-object" src="images/<%=resultList.get(i).getImageId() %>.jpg" alt="">
  					</a>
  					<div class="media-body">
    					<h4 class="media-heading"><%=resultList.get(i).getFileName() %></h4>
    					<p>Size:<%=resultList.get(i).getFileSizeDescription() %>  Upload Time: Upload By:</p>
  					</div>
				</div>
				<%
					}
				 %>
			</div>
			<%@ include file="layouts/_footer.jsp" %>
		</div>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>