package com.hanyun.model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Thumbnail implements IRowMaper<Thumbnail> {
	private int imageId;
	private String imageUrl;
	private String imageName;
	
	
	public Thumbnail(int imageId, String imageUrl, String imageName) {
		super();
		this.imageId = imageId;
		this.imageUrl = imageUrl;
		this.imageName = imageName;
	}
	
	public Thumbnail() {
		
	}

	public Thumbnail mapRow(ResultSet rs, int index) throws SQLException {
		Thumbnail thumb = new Thumbnail();
		thumb.setImageId(rs.getInt("imageId"));
		thumb.setImageUrl(rs.getString("imageUrl"));
		thumb.setImageName(rs.getString("imageName"));
		
		return thumb;
	}
	
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	

}
