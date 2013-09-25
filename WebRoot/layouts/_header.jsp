<%@page import="java.util.Properties"%>
<%@ page language="java" import="com.hanyun.model.impl.User,java.io.IOException" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
		Properties prop = new Properties();
		try {
			prop.load(User.class.getClassLoader().getResourceAsStream("hanyun.property"));
		} catch (IOException e) {
			System.err.println("配置文件读取错误！");
			e.printStackTrace();
		}
		String path = prop.getProperty("webRoot");
     %>
<div class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href=<%=path + "index.jsp" %>>Han Yun</a>
		</div>
		<div class="navbar-collapse collapse">
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Search</button>
			</form>
			
			<%		
				User userHeader = (User) request.getSession().getAttribute("user");
				if (userHeader != null) { 						
			%>
			 
			<ul class="nav navbar-nav navbar-right">
				<li><a href=<%=path + "index.jsp" %>>Home</a></li>
				<li class="active"><a href="<%=path + "user/account.jsp"%>"><%=userHeader.getUserName()%></a></li>
			</ul>
			<%
				} else {
			 %>
			 
			<ul class="nav navbar-nav navbar-right">
				<li><a href=<%=path + "index.jsp" %>>Home</a></li>
				<li class="active"><a href=<%=path + "login.jsp" %>>Sign in/up</a></li>
			</ul>
			<%
				}
			 %>
			
		</div>
	</div>
</div>