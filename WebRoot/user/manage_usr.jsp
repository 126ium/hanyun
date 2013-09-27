<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@page import="com.hanyun.dao.ResourceDAOImpl"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hanyun.dao.UserDAOImpl,com.hanyun.model.impl.*,java.util.*"%>

<% 
	String uid = request.getParameter("id");
	String operation = request.getParameter("op");
	User currentUser = (User) request.getSession().getAttribute("user");
	
	// 不是管理员说个蛋
	if (currentUser.getRole() != 1) {
%>
	Ilegal request!
	
	<script type="text/javascript">
		window.location="../index.jsp"
	</script>
<%
	} else {
	UserDAOImpl userDao = new UserDAOImpl();
	User opUser = userDao.get(Integer.parseInt(uid));
	
	if (operation != null)
		if (operation.equalsIgnoreCase("setadmin")) {
			opUser.setRole(1);
			userDao.update(opUser);
%>
	update user as ADMIN successfully!!
	
<%
		} else if (operation.equalsIgnoreCase("setnormal")) {
			opUser.setRole(2);
			userDao.update(opUser);
 %>
 	update user as NOMALUSER successfully!
 <%
 		} else if (operation.equalsIgnoreCase("delete")) {
 			userDao.delete(opUser);
  %>
  
  	DELETE user successfully!
  	
  <%
  	}  
  }
   %>
   
   	<script type="text/javascript">
		window.location="tmp_usr.jsp"
	</script>

