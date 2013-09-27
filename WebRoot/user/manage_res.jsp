<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@page import="com.hanyun.dao.ResourceDAOImpl"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hanyun.dao.UserDAOImpl,com.hanyun.model.impl.*,java.util.*"%>

<% 
	User user = (User) request.getSession().getAttribute("user");
	String id = request.getParameter("id");
	String reviewStatus = request.getParameter("review");
	String deleteConfirm = request.getParameter("delete");
	
	if (null == user) {
%>
	please login in first!
<%	
	}
	
	ResourceDAOImpl resDao = new ResourceDAOImpl();
	Resource res = resDao.get(Integer.parseInt(id));
	
	if (res.getUserId() != user.getUserId()) {
%>
	Illeagal request! Do NOT do something bad....
	
<%
	}
	
	if (deleteConfirm != null)
	if (deleteConfirm.equalsIgnoreCase("delete")) {
		resDao.delete(res);
%>

	delete successfully.
	<script type="text/javascript">
		window.location="tmp_res.jsp"
	</script>
	
<%
	}
	
	if (reviewStatus != null)
	if (reviewStatus.equals("2") || reviewStatus.equals("3") ) {
		if (user.getRole() != 1) {
 %>
	Illegal request. You are NOT admin.
	<script type="text/javascript">
		window.location="../index.jsp"
	</script>
<%
		} else {
			res.setReviewStatusId(Integer.parseInt(reviewStatus));
			resDao.update(res);
%>
	Update successfully! jump..
	<script type="text/javascript">
		window.location="tmp_res.jsp"
	</script>
<%
		}
	}
 %>

