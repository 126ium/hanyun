package com.hanyun.struts.action;

import org.apache.struts2.ServletActionContext;

import com.hanyun.model.impl.User;
import com.hanyun.service.IUserService;
import com.hanyun.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction implements ModelDriven<User>{
	private User user = new User();
	private UserServiceImpl userService = new UserServiceImpl();
	private String msg;	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String execute() {
		try {
			user.setLastLoginIP(ServletActionContext.getRequest().getRemoteAddr());
			user.setRegisterIP(ServletActionContext.getRequest().getRemoteAddr());
			if (!userService.validateEmail(user.getEmail())) {
				if (null == msg) {
					msg = "Email address illegal or it has been used!";
				} else {
					msg += "<br>Email address illegal or it has been used!";
				}
			}
				
			if (!userService.validateUsername(user.getUserName())) {
				if (null == msg) {
					msg = "Username illegal or it has been used!";
				} else {
					msg += "<br>Username illegal or it has been used!";
				}
			}
			
			if (null == msg)
				userService.add(user);
		} catch (Exception e) {
			msg += e.getMessage();
			e.printStackTrace();
		}
		
		return "json";
	}
	
	@Override
	public User getModel() {
		return user;
	}
	
	
}
