package com.hanyun.model.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.hanyun.model.IRowMaper;
import com.hanyun.util.HanyunUtil;

public class Resource implements IRowMaper<Resource> {
	// 资源文件ID
	private int fileId;
	// 上传用户ID
	private int userId;
	// 资源类别ID
	private int resourceId;
	// 缩略图ID
	private int imageId;
	private String fileName;
	private String fileMD5;
	private String fileUrl;
	private Date uploadTime;
	private int downloadTimes;
	private int browseTimes;
	private int reviewStatusId;
	private int fileSize;
	private int userRoleId;

	public Resource(int fileId, int userId, int resourceId, int imageId,
			String fileName, String fileMD5, String fileUrl, Date uploadTime,
			int downloadTimes, int browseTimes, int reviewStatusId,
			int fileSize, int userRoleId) {
		super();
		this.fileId = fileId;
		this.userId = userId;
		this.resourceId = resourceId;
		this.imageId = imageId;
		this.fileName = fileName;
		this.fileMD5 = fileMD5;
		this.fileUrl = fileUrl;
		this.uploadTime = uploadTime;
		this.downloadTimes = downloadTimes;
		this.browseTimes = browseTimes;
		this.reviewStatusId = reviewStatusId;
		this.fileSize = fileSize;
		this.userRoleId = userRoleId;
	}

	public Resource() {
		
	}
	
	public Resource mapRow(ResultSet rs, int index) throws SQLException {
		Resource res = new Resource();
		res.setFileId(rs.getInt("fileId"));
		res.setUserId(rs.getInt("userId"));
		res.setResourceId(rs.getInt("resourceId"));
		res.setImageId(rs.getInt("imageId"));
		res.setFileName(rs.getString("fileName"));
		res.setFileMD5(rs.getString("fileMD5"));
		res.setFileUrl(rs.getString("fileUrl"));
		res.setUploadTime(rs.getTimestamp("uploadTime"));
		res.setDownloadTimes(rs.getInt("downloadTimes"));
		res.setBrowseTimes(rs.getInt("browseTimes"));
		res.setReviewStatusId(rs.getInt("reviewStatusId"));
		res.setFileSize(rs.getInt("fileSize"));
		res.setUserRoleId(rs.getInt("userRoleId"));
				
		return res;
	}
		
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileMD5() {
		return fileMD5;
	}
	public void setFileMD5(String fileMD5) {
		this.fileMD5 = fileMD5;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public int getDownloadTimes() {
		return downloadTimes;
	}
	public void setDownloadTimes(int downloadTimes) {
		this.downloadTimes = downloadTimes;
	}
	public int getBrowseTimes() {
		return browseTimes;
	}
	public void setBrowseTimes(int browseTimes) {
		this.browseTimes = browseTimes;
	}

	public int getReviewStatusId() {
		return reviewStatusId;
	}

	public void setReviewStatusId(int reviewStatusId) {
		this.reviewStatusId = reviewStatusId;
	}
	
	public int getFileSize() {
		return fileSize;
	}
	public String getFileSizeDescription() {
		HanyunUtil u = HanyunUtil.getInstance();
		return u.byteCountToDisplaySize(fileSize);
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	

}
