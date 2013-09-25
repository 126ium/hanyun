package com.hanyun.util.dbfactory;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Date;

import javax.swing.tree.RowMapper;
import javax.ws.rs.GET;

import com.hanyun.model.IRowMaper;
import com.hanyun.util.LogUtil;


/**
 * 数据库连接池单态模式实现
 * 
 * @author RESPIRE 2013-9-16 14:33:10
 * @version 1.0
 * 
 */
public class ConnectionPoolFactory {
	private BuildConnection build = null;
	private Connection conn = null;
	private static ConnectionPoolFactory instance = new ConnectionPoolFactory();

	/**
	 * 单态模式，保证只有一个连接池实例
	 * 
	 * @return ConnectionPoolFactory 当前的的连接池对象
	 */
	public static ConnectionPoolFactory getInstatnce() {
		return instance;
	}

	private void setValues(PreparedStatement pstmt, Object... objects)
			throws SQLException {
		for (int i = 0; i < objects.length; i++) {
			// Data型转为Timestamp
			if (objects[i] instanceof java.util.Date) {
				pstmt.setTimestamp(i + 1, new java.sql.Timestamp(
						((java.util.Date) objects[i]).getTime()));
				// Integer参数对应的方法不是setInteger，特殊处理
			} else if (objects[i] instanceof Integer) {
				pstmt.setInt(i + 1, (Integer) objects[i]);
				// 其它的setString, setLong, setDouble之类
			} else {
				try {
					pstmt.getClass()
							// 获取PreparedStatement对应的方法
							.getMethod(
							// 方法名
									"set"
											+ objects[i].getClass()
													.getSimpleName(),
									// 第一个参数
									int.class,
									// 第二个参数
									objects[i].getClass())
							// 执行这个方法
							.invoke(pstmt, i + 1, objects[i]);
				} catch (Exception e) {
					// 失败就当做Object处理
					pstmt.setObject(i + 1, objects[i]);
					System.err.println("HANYUN ATTENTION: There is an object value in SQL?");
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * insert? update?
	 * @param sql
	 * @param objects
	 * @return
	 */
	public boolean execute(String sql, Object... objects) {
		boolean result = false;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			// 作为一个事物手动控制提交
			conn.setAutoCommit(false);
			// 预编译SQL
			pstmt = conn.prepareStatement(sql);
			// 设置提交SQL的参数
			setValues(pstmt, objects);
			// 尝试提交
			result = pstmt.execute();
			// 没有出错，commit
			conn.commit();
		} catch (SQLException e) {
			// 出错则撤销本次事物
			System.err.println("HANYUN ERROR: SQL COMMIT FAILURE!");
			try {
				conn.rollback();
			} catch (SQLException e2) {
				System.err.println("HANYUN ERROR: SQL ROLLBACK FAILURE!");
				e2.printStackTrace();
			}			
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				System.err.println("HANYUN ERROR: pstmt OR conn CLOSE FAILURE!");
				e2.printStackTrace();
			}
		}

		return result;
	}
	
	/**
	 * 查所有的model
	 * @param sql
	 * @param rowMapper
	 * @return
	 */
	public <T> List<T> getAll(String sql, IRowMaper<T> rowMapper) {		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		int index = 0;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rowMapper.mapRow(rs, index));
				index++;
			}			
		} catch (SQLException e) {
			// 出错则撤销本次事物
			System.err.println("HANYUN ERROR: SQL COMMIT FAILURE!");
			try {
				conn.rollback();
			} catch (SQLException e2) {
				System.err.println("HANYUN ERROR: SQL ROLLBACK FAILURE!");
				e2.printStackTrace();
			}			
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				System.err.println("HANYUN ERROR: pstmt OR conn CLOSE FAILURE!");
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	
	/**
	 * 按条件查多个model
	 * @param sql
	 * @param rowMapper
	 * @param objects
	 * @return
	 */
	// TODO 代码有重复，怎么优化
	public <T> List<T> getAll(String sql, IRowMaper<T> rowMapper, Object...objects) {		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		int index = 0;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			setValues(pstmt, objects);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rowMapper.mapRow(rs, index));
				index++;
			}			
		} catch (SQLException e) {
			// 出错则撤销本次事物
			System.err.println("HANYUN ERROR: SQL COMMIT FAILURE!");
			try {
				conn.rollback();
			} catch (SQLException e2) {
				System.err.println("HANYUN ERROR: SQL ROLLBACK FAILURE!");
				e2.printStackTrace();
			}			
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				System.err.println("HANYUN ERROR: pstmt OR conn CLOSE FAILURE!");
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	
	/**
	 * 查一个model
	 * @param sql
	 * @param iRowMaper
	 * @param objects
	 * @return
	 */
	public <T> T get(String sql, IRowMaper<T> iRowMaper, Object...objects) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		T t = null;
		try {
			conn = getConnection();
			// 没有事物处理
			conn.setAutoCommit(true);
			pstmt = conn.prepareStatement(sql);
			setValues(pstmt, objects);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				t = iRowMaper.mapRow(rs, 0);
			} else {
				LogUtil.log("HANYUN ATENTION","NO DATARECORD FOND IN RESULTSET!!");
			}
			if (rs.next()) {
				LogUtil.log("HANYUN ATENTION", "MORE THAN ONE DATARECORD FOND IN RESULTSET!!");
			}
			
		} catch (SQLException e) {
			System.err.println("HANYUN ERROR : QUERY FAILURE!!");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				System.err.println("HANYUN ERROR : rs OR pstmt CLOSE FAILURE!!");
				e.printStackTrace();
			}			
		}
		return t;
	}	
	
	/**
	 * 查整形数据
	 * @param sql
	 * @param objects
	 * @return
	 * @throws Exception
	 */
	public int getInt(String sql,Object...objects) throws SQLException {
		conn = getConnection();	
		conn.setAutoCommit(true);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);  
			setValues(pstmt,objects);  
			rs = pstmt.executeQuery();
			int t = 0;
			if(rs.next()){
				t = rs.getInt(1);
			}else{
				throw new SQLException("没有数据");
			}
			if(rs.next()){
				throw new SQLException("数据不止一条");
			}
			return t;
		} catch (SQLException e) {
			throw e;
		}finally{
			try{
				rs.close();
			}catch (Exception e) {}
			try{
				pstmt.close();
			}catch (Exception e) {}
			conn.close();
			
		}
	}
	
	/**
	 * 私有的构造函数，外部无法访问
	 */
	private ConnectionPoolFactory() {
		this.build = new ConnectionBroker();
	}

	/**
	 * @see com.hanyun.util.dbfactory.ConnectionBroker
	 */
	public Connection getConnection() throws SQLException {
		return build.getConnection();
	}

	/**
	 * @see com.hanyun.util.dbfactory.ConnectionBroker
	 */
	public void freeConnection(Connection conn) throws SQLException {
		build.freeConnection(conn);
	}

	/**
	 * @see com.hanyun.util.dbfactory.ConnectionBroker
	 */
	public int getNumbersConnection() throws SQLException {
		return build.getNumberConnections();
	}

	/**
	 * 测试连接池是否正常工作
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ConnectionPoolFactory factory = ConnectionPoolFactory.getInstatnce();
		Connection conn = null;
		try {
			conn = factory.getConnection();
			boolean ret = factory.execute(
					"INSERT INTO t_user VALUES(?,?,?,?,?,?,?,?,?,?)", 5,
					"name", "pwd", "salt", 1, "haode@baidu.com", "xxx",
					new Date(), 1, "3.jpg");
			System.out.println(ret);

			System.out.println(factory.getNumbersConnection());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}