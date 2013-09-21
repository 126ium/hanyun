package com.hanyun.struts.action;

import org.apache.struts2.ServletActionContext;

import com.hanyun.model.User;
import com.hanyun.service.IUserService;
import com.hanyun.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction  implements ModelDriven<User> {
	private User user = new User();
	
	private IUserService userService = new UserServiceImpl();
	
	public String execute() {
		try {
			user = userService.login(user.getUserName(), user.getPassword());
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}
	@Override
	public User getModel() {
		return user;
	}

}
