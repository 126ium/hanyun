package com.hanyun.util.dbfactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库连接池接口
 * 
 * @author RESPIRE 2013-9-16 11:10:30
 * @version 1.00
 *
 */
public interface BuildConnection {
	/**
	 * 从数据库连接池中得到数据库连接
	 * 
	 * @return Connection 成功建立的连接
	 * @throws SQLException 
	 */
	public Connection getConnection() throws SQLException;
	
    /**
     * 释放数据库连接到数据库连接池中
     * 
     * @param conn 待释放的连接
     * @throws SQLException
     */
	public void freeConnection(Connection conn) throws SQLException;

	/**
	 * 得到数据库连接池中的连接数量
	 * 
	 * @return int 当前数据库连接数量
	 * @throws SQLException
	 */
	public int getNumberConnections() throws SQLException;

}