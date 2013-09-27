package com.hanyun.struts.action;

import org.apache.struts2.ServletActionContext;

public class LogoutAction {
	public String execute() {
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		try {
//			ServletActionContext.getResponse().getWriter().print("<script type=\"text/javascript\">window.location=\"tmp_usr.jsp\"</script>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
