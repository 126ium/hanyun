package com.hanyun.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.hanyun.dao.UserDAOImpl;
import com.hanyun.model.User;
import com.hanyun.service.IUserService;
import com.hanyun.util.HanyunUtil;

public class UserServiceImpl implements IUserService{
	
	UserDAOImpl userDAO = new UserDAOImpl();
	HanyunUtil u = HanyunUtil.getInstance();

	@Override
	public List<User> getAll() throws SQLException {		
		return userDAO.getAll();
	}

	@Override
	public void add(User... users) throws SQLException {
		for (User user : users) {
			String salt = u.getSalt();
			String password = user.getPassword();
			user.setSalt(salt);
			user.setPassword(u.MD5(u.MD5(password) + salt));
			user.setRole(99);
			user.setUserStatus(99);
			user.setUserId(99);
			user.setAvatarUrl("not set");
			user.setLastLoginIP("not set");
			user.setLastLoginTime(new Date());
			userDAO.add(user);
		}
		
	}

	@Override
	public User login(String userName, String password) throws Exception {
		String salt = userDAO.getSalt(userName);
		password = u.MD5(u.MD5(password) + salt);
		return userDAO.login(userName, password);
	}

	@Override
	public void updateUserInfo(User... users) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
}
