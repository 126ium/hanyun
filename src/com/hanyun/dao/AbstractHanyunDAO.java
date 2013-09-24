package com.hanyun.dao;

import java.sql.SQLException;
import java.util.List;
import com.hanyun.util.dbfactory.ConnectionPoolFactory;

public abstract class AbstractHanyunDAO<T> {
	ConnectionPoolFactory db = ConnectionPoolFactory.getInstatnce();
	
	/**
	 * 增
	 * @param model
	 * @throws Exception
	 */
	public abstract void add(T... models) throws SQLException;
	
	/**
	 * 删
	 * @param model
	 * @throws Exception
	 */
	public abstract void delete(T... models) throws SQLException;
	
	/**
	 * 查，所有
	 * @return
	 * @throws Exception
	 */
	public abstract List<T> getAll() throws SQLException;
	
	/**
	 * 查，按ID
	 * @return
	 * @throws Exception
	 */
	public abstract T get(int id) throws SQLException;
	
	/**
	 * 查，按名字
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public abstract T get(String name) throws SQLException;
	
	/**
	 * 改
	 * @throws Exception
	 */
	public abstract void update() throws SQLException; 
	
}
