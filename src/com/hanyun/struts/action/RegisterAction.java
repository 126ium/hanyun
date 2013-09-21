package com.hanyun.struts.action;

import com.hanyun.model.User;
import com.hanyun.service.IUserService;
import com.hanyun.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction implements ModelDriven<User>{
	private User user = new User();
	private IUserService  userService = new UserServiceImpl();
	
	public String execute() {
		try {
			userService.add(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "json";
	}
	
	@Override
	public User getModel() {
		return user;
	}
	
	
}
