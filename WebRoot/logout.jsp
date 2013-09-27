<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@page import="com.hanyun.dao.ResourceDAOImpl"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hanyun.dao.UserDAOImpl,com.hanyun.model.impl.*,java.util.*"%>

<% 
	request.getSession().removeAttribute("user");
%>
	Logou successfully!
	<script type="text/javascript">
		window.location="index.jsp"
	</script>