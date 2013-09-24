package com.hanyun.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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
					r.getUserRoleId(),
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


	@Override
	public void update() throws SQLException {
		// TODO Auto-generated method stub

	}
	
	public static void main(String...args) {
		try {
			List listr = new ResourceDAOImpl().getAll();
			System.out.println();
//			Resource res = new Resource(2, 1, 1, 2, "filename", "fileMd5", "fileurl", new Date(), 2, 2, 2);
//			new ResourceDAOImpl().add(res);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public Resource get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource get(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
