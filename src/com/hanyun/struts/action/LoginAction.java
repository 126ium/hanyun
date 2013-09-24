package com.hanyun.struts.action;

import org.apache.struts2.ServletActionContext;

import com.hanyun.model.impl.User;
import com.hanyun.service.IUserService;
import com.hanyun.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction  implements ModelDriven<User> {
	private User user = new User();
	private String msg;	
	private IUserService userService = new UserServiceImpl();
	
	public String getMsg() {
		return msg;
	}
	
	public String execute() {
		user = userService.login(user.getUserName(), user.getPassword());
		if (null != user)
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
		else
			msg = "Invalid username or password";
		
		return "json";
	}
	@Override
	public User getModel() {
		return user;
	}

}
