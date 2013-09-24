package com.hanyun.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.hanyun.dao.UserDAOImpl;
import com.hanyun.model.impl.User;
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
			user.setRole(userDAO.getRoleId("普通用户"));
			user.setAvatarUrl("not set");
			user.setLastLoginTime(new Date());
			user.setRegisterTime(new Date());
			userDAO.add(user);
		}		
	}
	
	/**
	 * 验证用户名是否重复
	 * @param username
	 * @return
	 */
	public boolean validateUsername(String username) {
		try {
			if (null != userDAO.get(username)) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (username.length() < 4)
			return false;
	
		return true;
	}
	
	/**
	 * 验证Email是否重复
	 * @param email
	 * @return
	 */
	public boolean validateEmail(String email) {
		try {
			if (null != userDAO.getByEmail(email)) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (!isEmail(email))
			return false;
		
		return true;
	}
	
	/**
	 * 判断string是否为一个合法的email地址
	 * @param email
	 * @return
	 */
	public boolean isEmail (String email) {
		if (email.isEmpty() || email.trim().isEmpty())
			return false;
		email = email.toLowerCase();
		if(email.endsWith(".con"))
			return false;
		if(email.endsWith(".cm"))
			return false;
		if(email.endsWith("@gmial.com"))
			return false;
		if(email.endsWith("@gamil.com"))
			return false;
		if(email.endsWith("@gmai.com"))
			return false;
		return email.matches("\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b");
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
