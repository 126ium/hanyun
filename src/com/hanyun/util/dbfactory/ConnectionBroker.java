package com.hanyun.util.dbfactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//TODO 待修正，可以自己实现
import com.devdaily.opensource.database.DDConnectionBroker;

/**
 * 数据库连接代理实现
 * 
 * @author RESPIRE 2013-9-16 11:42:14
 * @version 1.0
 * 
 */
public class ConnectionBroker implements BuildConnection {
	private String driver = null;
	private String url = null;
	private String username = null;
	private String password = null;
	private int minConnections = 0;
	private int maxConnections = 0;
	private long timeout = 0;
	private long leaseTime = 0;
	private String logFile = null;
	private DDConnectionBroker broker = null;

	public ConnectionBroker() {
		super();
		Properties prop = new Properties();
		try {
			prop.load(ConnectionBroker.class.getClassLoader().getResourceAsStream("hanyun.property"));
		} catch (IOException e) {
			System.err.println("配置文件读取错误！");
			e.printStackTrace();
		}

		// 加载配置项
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		minConnections = Integer.parseInt(prop.getProperty("minConnections"));
		maxConnections = Integer.parseInt(prop.getProperty("maxConnections"));
		timeout = Integer.parseInt(prop.getProperty("timeout"));
		leaseTime = Integer.parseInt(prop.getProperty("leaseTime"));
		logFile = prop.getProperty("logFile");
	}
	
	/**
	 * 建立数据库连接
	 * 
	 * @return Connection 成功建立的连接
	 * @throws SQLException 如果操作出错
	 */
	public Connection getConnection() throws SQLException {
		broker = new DDConnectionBroker(driver, url, username, password,
				minConnections, maxConnections, timeout, leaseTime, logFile);

		return broker.getConnection();
	}
	
	/**
	 * 释放数据库连接
	 * @param conn 待释放的连接
	 * @throws SQLException 如果释放失败
	 */
	public void freeConnection(Connection conn) throws SQLException {
		broker.freeConnection(conn);
	}

	/**
	 * 连接池中当前建立的连接数量
	 * 
	 * @return int 连接池中的数据库连接数量
	 * @throws SQLException 如果获取失败
	 */
	public int getNumberConnections() throws SQLException {
		if (broker != null) {
			return broker.getNumberConnections();
		} else {
			return -1;
		}
	}

	/**
	 * 测试连接代理是否正常工作
	 * @param args
	 */
	public static void main(String[] args) {

		ConnectionBroker connectionBroker = new ConnectionBroker();
		Connection conn = null;
		try {
			conn = connectionBroker.getConnection();
			System.out.println("the number of connection is:"
					+ connectionBroker.getNumberConnections());
			Statement st = conn.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT  username, userpassword, userEmail FROM t_user");
			while (rs.next()) {
				String theUsername = rs.getString("username");
				String thePassword = rs.getString("userpassword");
				String theEmail = rs.getString("userEmail");
				System.out.println("Database record: " + theUsername + ", "
						+ thePassword + ", " + theEmail);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connectionBroker.freeConnection(conn);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				System.out.println("the number of connection is:"
						+ connectionBroker.getNumberConnections());
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}

}
