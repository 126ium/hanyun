package com.hanyun.service;

import java.sql.SQLException;
import java.util.List;

import com.hanyun.model.impl.User;

public interface IUserService {
	public List<User> getAll() throws SQLException;
	
	public void add(User...users) throws SQLException;
	
	public User login(String userName, String password);
	
	public void updateUserInfo(User...users) throws SQLException;
}
