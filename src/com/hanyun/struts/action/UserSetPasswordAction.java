package com.hanyun.struts.action;

import javax.security.auth.message.ServerAuth;

import org.apache.struts2.ServletActionContext;

import com.hanyun.model.impl.User;
import com.hanyun.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserSetPasswordAction extends ActionSupport {
	private User user;
	private String msg;
	private String newPassword;
	private String oldPassword;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String execute() {
		user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (null == user) {
			msg = "Illegal request, please login first! <br>UserSetPasswordAction";
		} else if (!userServiceImpl.confirmPassword(user, oldPassword)) {
			msg = "WRONG old password, please try again!";
		} else {
			userServiceImpl.setNewPassword(user, newPassword);
		}
		
		return "json";
	}
}
