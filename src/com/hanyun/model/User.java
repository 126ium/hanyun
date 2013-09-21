package com.hanyun.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;


public class User implements IRowMaper<User> {
	private int userId;
	private String userName;
	private String password;
	private String salt;
	private int role;
	private String email;
	private String lastLoginIP;
	private Date lastLoginTime;
	private int userStatus;
	private String avatarUrl;
		
	
	public User(int userId, String username, String password, String salt,
			int role, String email, String lastLoginIP, Time lastLoginTime,
			int userStatus, String avatarUrl) {
		super();
		this.userId = userId;
		this.userName = username;
		this.password = password;
		this.salt = salt;
		this.role = role;
		this.email = email;
		this.lastLoginIP = lastLoginIP;
		this.lastLoginTime = lastLoginTime;
		this.userStatus = userStatus;
		this.avatarUrl = avatarUrl;
	}

	public User() {
		
	}
	
	@Override
	public User mapRow(ResultSet rs, int index) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt("userId"));
		user.setUserName(rs.getString("userName"));
		user.setPassword(rs.getString("userPassword"));
		user.setSalt(rs.getString("salt"));		
		user.setRole(rs.getInt("userRole"));
		user.setEmail(rs.getString("userEmail"));
		user.setLastLoginIP(rs.getString("lastLoginIP"));
		user.setLastLoginTime(rs.getTime("lastLoginTime"));
		user.setUserStatus(rs.getInt("userStatus"));
		user.setAvatarUrl(rs.getString("avatarUrl"));		
		
		return user;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String username) {
		this.userName = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getSalt() {
		return salt;
	}


	public void setSalt(String salt) {
		this.salt = salt;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getLastLoginIP() {
		return lastLoginIP;
	}


	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}


	public Date getLastLoginTime() {
		return lastLoginTime;
	}


	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}


	public int getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}


	public String getAvatarUrl() {
		return avatarUrl;
	}


	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
}
