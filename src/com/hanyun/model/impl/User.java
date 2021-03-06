package com.hanyun.model.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.hanyun.model.IRowMaper;

/**
 * User model
 * 
 * @author IntSilence
 * 
 */
public class User implements IRowMaper<User> {
	private int userId;
	private String userName;
	private String password;
	private String salt;
	private int role;
	private String email;
	private String lastLoginIP;
	private Date lastLoginTime;
	private String avatarUrl;
	private String registerIP;
	private Date registerTime;

	public User(int userId, String userName, String password, String salt,
			int role, String email, String lastLoginIP, Date lastLoginTime,
			String avatarUrl, String registerIP, Date registerTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.salt = salt;
		this.role = role;
		this.email = email;
		this.lastLoginIP = lastLoginIP;
		this.lastLoginTime = lastLoginTime;
		this.avatarUrl = avatarUrl;
		this.registerIP = registerIP;
		this.registerTime = registerTime;
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
		user.setRole(rs.getInt("userRoleId"));
		user.setEmail(rs.getString("userEmail"));
		user.setLastLoginIP(rs.getString("lastLoginIP"));
		user.setLastLoginTime(rs.getTime("lastLoginTime"));
		user.setAvatarUrl(rs.getString("avatarUrl"));
		user.setRegisterIP(rs.getString("registerIP"));
		user.setRegisterTime(rs.getTimestamp("registerTime"));

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

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getRegisterIP() {
		return registerIP;
	}

	public void setRegisterIP(String registerIP) {
		this.registerIP = registerIP;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
}
