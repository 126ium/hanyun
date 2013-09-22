package com.hanyun.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.struts2.components.Password;

import com.hanyun.model.User;
import com.hanyun.util.dbfactory.ConnectionPoolFactory;

public class UserDAOImpl extends AbstractHanyunDAO<User> {
	ConnectionPoolFactory factory = ConnectionPoolFactory.getInstatnce();
	
	@Override
	public void add(User... models) throws SQLException {
		for (User u : models) {
			factory.execute("INSERT INTO t_User ( userName, userPassword, salt, userRole, userEmail, lastLoginIP, lastLoginTime, userStatus, avatarUrl, registerIP, registerTime)" +
					" VALUES(?,?,?,?,?,?,?,?,?,?,?)", 
					u.getUserName(),
					u.getPassword(),
					u.getSalt(),
					u.getRole(),
					u.getEmail(),
					u.getLastLoginIP(),
					u.getLastLoginTime(),
					u.getUserStatus(),
					u.getAvatarUrl(),
					u.getRegisterIP(),
					u.getRegisterTime());
		}		
	}

	@Override
	public void delete(User... models) throws SQLException {
		for (User u : models) {
			factory.execute("DELETE FROM t_User WHERE userId = ?", u.getUserId());
		}
		
	}

	@Override
	public List<User> getAll() throws SQLException {
		return factory.getAll("SELECT * FROM t_User", new User());
	}

	@Override
	public User get(User model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	public User login(String userName, String password) throws SQLException {
		return factory.get("SELECT * FROM t_User WHERE userName = ? and userPassword = ?", new User(), userName, password);
	}
	
	public String getSalt(String userName) throws SQLException{
		User user = factory.get("SELECT * FROM t_User WHERE userName = ?", new User(), userName);
		return user.getSalt();
	}
	
	public static void main(String[] args) {
		UserDAOImpl u = new UserDAOImpl();
		Connection conn = null;
		try {
			conn = u.db.getConnection();
			boolean ret = u.db.execute(
					"INSERT INTO t_User VALUES(?,?,?,?,?,?,?,?,?,?)", 
					"name", "pwd", "salt", 1, "haode@baidu.com", "xxx",
					new Date(), 1, "3.jpg");
			System.out.println(ret);

			System.out.println(u.db.getNumbersConnection());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
