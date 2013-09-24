package com.hanyun.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.struts2.components.Password;

import com.hanyun.model.impl.User;
import com.hanyun.util.dbfactory.ConnectionPoolFactory;

public class UserDAOImpl extends AbstractHanyunDAO<User> {
	ConnectionPoolFactory factory = ConnectionPoolFactory.getInstatnce();
	
	/**
	 * 添加用户
	 */
	@Override
	public void add(User... models) throws SQLException {
		for (User u : models) {
			factory.execute("INSERT INTO t_User (userName, userPassword, salt, userRoleId, userEmail, lastLoginIP, lastLoginTime, avatarUrl, registerIP, registerTime)" +
					" VALUES(?,?,?,?,?,?,?,?,?,?)", 
					u.getUserName(),
					u.getPassword(),
					u.getSalt(),
					u.getRole(),
					u.getEmail(),
					u.getLastLoginIP(),
					u.getLastLoginTime(),
					u.getAvatarUrl(),
					u.getRegisterIP(),
					u.getRegisterTime());
		}		
	}

	/**
	 * 删除用户
	 */
	@Override
	public void delete(User... models) throws SQLException {
		for (User u : models) {
			factory.execute("DELETE FROM t_User WHERE userId = ?", u.getUserId());
		}
		
	}
	
	/**
	 * 获取所有用户
	 */
	@Override
	public List<User> getAll() throws SQLException {
		return factory.getAll("SELECT * FROM t_User", new User());
	}
	
	/**
	 * 按ID查找用户
	 */
	@Override
	public User get(int id) throws SQLException {
		
		return factory.get("SELECT * FROM t_User WHERE userId = ?", new User(), id);
	}
	
	/**
	 * 按用户名查找用户
	 */
	@Override
	public User get(String name) {
		
		return factory.get("SELECT * FROM t_User WHERE userName = ?", new User(), name);
	}
	
	/**
	 * 按email查找用户
	 */
	public User getByEmail(String email) {
		return factory.get("SELECT * FROM t_User WHERE userEmail = ?", new User(), email);
	}
	
	@Override
	public void update() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	@Deprecated
	public User login(String userName, String password) throws SQLException {
		return factory.get("SELECT * FROM t_User WHERE userName = ? and userPassword = ?", new User(), userName, password);
	}
	
	public String getSalt(String userName) throws SQLException{
		User user = factory.get("SELECT * FROM t_User WHERE userName = ?", new User(), userName);
		return user.getSalt();
	}
	
	public int getRoleId(String role) throws SQLException {
		return factory.getInt("SELECT * FROM t_UserRole WHERE userRoleName = ?", role);
	}
	
	public static void main(String[] args) {
		UserDAOImpl u = new UserDAOImpl();
		Connection conn = null;
		try {
//			conn = u.db.getConnection();
//			int ret = u.getRoleId("管理员");
			System.out.println(u.getByEmail("me@intsilence.com"));
			

			System.out.println(u.db.getNumbersConnection());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


}
