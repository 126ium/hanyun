<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.hanyun.model.impl.*,com.hanyun.dao.*,java.util.*"%>
    
<div class="container">
	<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#uploadModal">
		Upload
	</button>
	<div class="divider"></div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>File Name</th>
				<th>Size</th>
				<th>Upload Time</th>
				<th>Review Status</th>
				<th>Permission</th>
				<th>Download Times</th>
				<th>Browse Times</th>
				<th>Operation</th>
			</tr>
		</thead>
		<tbody>
		<%
			User resManageUser = (User) session.getAttribute("user");
			ResourceDAOImpl resDao = new ResourceDAOImpl();
			List<Resource> resManageList = resDao.getResourcesByUserid(resManageUser.getUserId()); 
			String[] reviewStatus = {"fuck??", "Check pending", "Passed", "Not approved"};
			String[] authorisation = {"fuck??", "Private", "Register User", "Public"};
 			
			for (int i = 0; i < resManageList.size(); i ++ ) {			
		 %>
			<tr id="<%=i %>">
			
				<td><a href=<%= path + "download.jsp?id=" + resManageList.get(i).getFileId() %>> <%=resManageList.get(i).getFileName() %> </a></td>
				<td><%=resManageList.get(i).getFileSizeDescription() %></td>
				<td><%=resManageList.get(i).getUploadTime() %></td>
				<td><%=reviewStatus[ resManageList.get(i).getReviewStatusId() ] %></td>
				<td><%=authorisation[ resManageList.get(i).getUserRoleId() ] %></td>
				<td><%=resManageList.get(i).getDownloadTimes() %></td>
				<td><%=resManageList.get(i).getBrowseTimes() %></td>
				<td>
					<button id="deleteButton" class="btn btn-danger btn-lg" data-toggle="modal" data-target="#deleteModal">
						Delete
					</button>
				</td>
			</tr>
		<%
			}
		 %>
		</tbody>
	</table>
</div>
