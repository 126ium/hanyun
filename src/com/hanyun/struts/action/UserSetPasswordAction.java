package com.hanyun.struts.action;


import java.io.IOException;

import javax.jms.Session;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import com.hanyun.model.impl.User;
import com.hanyun.service.impl.UserServiceImpl;
import com.hanyun.util.LogUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UserSetPasswordAction extends ActionSupport {
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

	public String execute() throws IOException, JSONException {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
//		System.out.println("setpassword action:" + user);
//		Session session = (Session) ServletActionContext.getRequest().getSession();
		if (null == user) {
			msg = "Illegal request, please login first! <br>UserSetPasswordAction";
		} else if (!userServiceImpl.confirmPassword(user, oldPassword)) {
			msg = "WRONG old password, please try again!";
			LogUtil.log("INFO", "oldpassword:" + oldPassword);
			LogUtil.log("INFO","newpassword" + user.getPassword());
		} else {
			userServiceImpl.setNewPassword(user, newPassword);
		}
		
		ServletActionContext.getResponse().getWriter().print(JSONUtil.serialize(msg));
		
		return null;
	}
}
