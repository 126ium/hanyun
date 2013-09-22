package com.hanyun.dao;

import java.sql.SQLException;
import java.util.List;
import com.hanyun.model.Thumbnail;
import com.hanyun.util.dbfactory.ConnectionPoolFactory;

public class ThumbnailDAOImpl extends AbstractHanyunDAO<Thumbnail> {
	ConnectionPoolFactory factory = ConnectionPoolFactory.getInstatnce();

	@Override
	public void add(Thumbnail... models) throws SQLException {
		for (Thumbnail t : models) {
			factory.execute(
					"INSERT INTO t_Image (imageId, imageUrl, imageName)" +
					" VALUES(?,?,?)",
					t.getImageId(), t.getImageUrl(), t.getImageName());
		}
	}

	@Override
	public void delete(Thumbnail... models) throws SQLException {
		for (Thumbnail t : models) {
			factory.execute(
					"DELETE FROM t_Image where imageId = ?",
					t.getImageId());
		}
	}

	@Override
	public List<Thumbnail> getAll() throws SQLException {
		return factory.getAll("SELECT * FROM t_Image", new Thumbnail());
	}

	@Override
	public Thumbnail get(Thumbnail model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() throws SQLException {
		// TODO Auto-generated method stub

	}
	
	public static void main(String...args) {
		ThumbnailDAOImpl t = new ThumbnailDAOImpl();
		try {
			List list = t.getAll();
			System.out.println();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
