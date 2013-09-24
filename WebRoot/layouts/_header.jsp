<%@ page language="java" import="com.hanyun.model.impl.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">Han Yun</a>
		</div>
		<div class="navbar-collapse collapse">
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Search</button>
			</form>
			<%
		
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) { 		
			
			 %>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.jsp">Home</a></li>
				<li class="active"><a href="user/account.jsp">Account</a></li>
			</ul>
			<%
			} else {
			 %>
			 
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.jsp">Home</a></li>
				<li class="active"><a href="login.jsp">Sign in/up</a></li>
			</ul>
			<%
			}
			 %>
			
		</div>
	</div>
</div>