package com.hanyun.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import com.hanyun.model.impl.Resource;
import com.hanyun.util.dbfactory.ConnectionPoolFactory;

public class ResourceDAOImpl extends AbstractHanyunDAO<Resource> {
	ConnectionPoolFactory factory = ConnectionPoolFactory.getInstatnce();

	@Override
	public void add(Resource... models) throws SQLException {
		for (Resource r : models) {
			factory.execute(
					"INSERT INTO t_Resource (userId, resourceId, imageId, fileName, fileMD5, fileUrl, uploadTime, downloadTimes, browseTimes, reviewStatusId, fileSize, userRoleId)"
							+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)",
					r.getUserId(),
					r.getResourceId(), 
					r.getImageId(),
					r.getFileName(),
					r.getFileMD5(), 
					r.getFileUrl(),
					r.getUploadTime(), 
					r.getDownloadTimes(),
					r.getBrowseTimes(),
					r.getReviewStatusId(),
					r.getFileSize(),
					r.getUserRoleId());
		}
	}

	@Override
	public void delete(Resource... models) throws SQLException {
		for (Resource r : models) {
			factory.execute("DELETE FROM t_Resource WHERE fileId = ?", r.getFileId());
		}
	}

	@Override
	public List<Resource> getAll() throws SQLException {
		return factory.getAll("SELECT * FROM t_Resource", new Resource());
	}
	
	/**
	 * 最热资源
	 * @param num
	 * @return
	 */
	public List<Resource> getHotRes(int num) {
		String sql = "SELECT * FROM t_Resource ORDER BY browseTimes DESC";
		if (num > 0)
			sql += " LIMIT 0," + String.valueOf(num);
		return factory.getAll(sql, new Resource());
	}
	
	/**
	 * 获取某用户上传的所有资源
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public List<Resource> getResourcesByUserid(int userId) throws SQLException {
		return factory.getAll("SELECT * FROM t_Resource WHERE userId = ?", new Resource(), userId);
	}
	
	/**
	 * 按类别获得所有资源
	 * @param categoryId
	 * @return
	 */
	public List<Resource> getResourcesByCategory(int categoryId, String sort, int num) {
		List<Resource> list;
		String sql = "SELECT * FROM t_Resource WHERE resourceId = ?";
		if (sort.equalsIgnoreCase("random")) {
			list = factory.getAll(sql, new Resource(), categoryId);
			if (list.size() - num > 0) {
				Random random = new Random();
				int sizeToTrim = list.size() - num;
				for (int i = 0; i < sizeToTrim; i ++) {
//					System.out.println("Current list size: " + list.size());
					list.remove(random.nextInt(list.size()));
				}
				for (int i = list.size(); i > 1; i --)
	                swap(list, i - 1, random.nextInt(i));
			}
			
			return list;
		}
		
		if (sort.equalsIgnoreCase("hot")) {
			sql += " ORDER BY browseTimes DESC";
		} else if (sort.equalsIgnoreCase("new")) {
			sql += " ORDER BY uploadTime DESC";
		}
		
		if (num > 0)
			sql += " LIMIT 0," + String.valueOf(num);
		list = factory.getAll(sql, new Resource(), categoryId);
		
		
		return list;
	}
	
	/**
	 * 交换List中的数据
	 * @param list
	 * @param j
	 * @param k
	 */
	public <T> void swap(List<T> list, int j, int k) {
		T t;
		t = list.get(j);
		list.set(j, list.get(k));
		list.set(k, t);		
	}

	@Override
	public void update(Resource r) throws SQLException {
			factory.execute(
					"UPDATE t_Resource SET userId=?, resourceId=?, imageId=?, fileName=?, fileMD5=?, fileUrl=?," +
					" uploadTime=?, downloadTimes=?, browseTimes=?, reviewStatusId=?, fileSize=?, userRoleId=? WHERE fileId=?",
					r.getUserId(),
					r.getResourceId(), 
					r.getImageId(),
					r.getFileName(),
					r.getFileMD5(), 
					r.getFileUrl(),
					r.getUploadTime(), 
					r.getDownloadTimes(),
					r.getBrowseTimes(),
					r.getReviewStatusId(),
					r.getFileSize(),
					r.getUserRoleId(),
					r.getFileId());
	}
	
	@Override
	public Resource get(int id) throws SQLException {
		return factory.get("SELECT * FROM t_Resource WHERE fileId = ?", new Resource(), id);
	}

	@Override
	public Resource get(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getPersonalResCount(int userId, int resourceId) throws SQLException {
		return (factory.getInt("SELECT COUNT(*) FROM t_Resource WHERE userId = ? AND resourceId = ?", userId, resourceId));
	}
	
	public int getAllResCount(int resourceId) throws SQLException {
		return (factory.getInt("SELECT COUNT(*) FROM t_Resource WHERE resourceId = ?", resourceId));
	}
	
	public static void main(String...args) {
		try {
			ResourceDAOImpl resDAasdfadfO = new ResourceDAOImpl();
			List listr = resDAasdfadfO.getResourcesByUserid(1000);
			System.out.println();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
