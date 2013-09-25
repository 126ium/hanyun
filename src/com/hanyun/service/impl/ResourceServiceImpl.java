package com.hanyun.service.impl;

import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.hanyun.service.IResourceService;
import com.hanyun.util.HanyunUtil;
import com.hanyun.util.LogUtil;
import com.hanyun.dao.ResourceDAOImpl;
import com.hanyun.model.impl.Resource;

public class ResourceServiceImpl implements IResourceService {
	private ResourceDAOImpl resourceDAO = new ResourceDAOImpl();
	private HanyunUtil util = HanyunUtil.getInstance();
	
	public String getBasePath() {

		return util.getHanyunConfig("baseDir");
	}
	
	
	public boolean saveFile(File src) throws Exception {
		String basePath = getBasePath();
		String subPath = null;
		String fileMD5 = null;
		
		subPath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		fileMD5 = util.MD5(src);
		
		try {
			InputStream in = null;
			OutputStream out = null;
			
			File dir = new File(basePath + "/" + subPath);
			if (!dir.exists()) {
				dir.mkdirs();
				LogUtil.log("INFO", "Dir is invalid, created");
			}
			
			File dst = new File(basePath + "/" + subPath + "/" + fileMD5);
			LogUtil.log("INFO", "Dst file is OK");
			
//			if (dst.exists())
//				return false;
//			else 
//				dst.createNewFile();
			if (!dst.exists())
				dst.createNewFile();
			
			try {
				in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
				byte [] buffer = new byte [BUFFER_SIZE];
				while (in.read(buffer) > 0 ) {
					out.write(buffer);
				}
				LogUtil.log("INFO", "File Saved");
			} finally {
				if (null != in) {
					in.close();
                } 
                if (null != out) {
                	out.close();
                }                
            } 	
		} catch (Exception e) {	
			LogUtil.log("WARNING", e.toString());
			e.printStackTrace();
			return false;
		} 
		
		return true;
	}
	
	public boolean deleteFile(String path) throws Exception {
		return true;
	}
	
	public boolean saveToDb(File src, String filename, int userId, String permission) throws Exception {
		int fileSize = 0;
		FileInputStream in = null;
		Resource resource = new Resource();
		int userRoleId = 1;
		
		LogUtil.log("INFO", "Try to save resource info to db");
		
		try {
			in = new FileInputStream(src);
			fileSize = in.available();
		} catch (FileNotFoundException e) {
			LogUtil.log("WARNING", e.toString());
			e.printStackTrace();
			return false;
		} catch (SecurityException e) {
				LogUtil.log("WARNING", e.toString());
				e.printStackTrace();
				return false;
		} finally {
			in.close();
		}
		
		if (permission.equalsIgnoreCase("public"))
			userRoleId = 3;
		else if (permission.equalsIgnoreCase("protected"))
			userRoleId = 2;
		else
			userRoleId = 1;
		
		
		String basePath = getBasePath();		
		String subPath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());		
		String fileMD5 = util.MD5(src);
		
		resource.setFileName(filename);
		resource.setUserId(userId);
		// TODO md5只用算一次
		resource.setFileMD5(fileMD5);
		resource.setUploadTime(new Date());
		resource.setDownloadTimes(0);
		resource.setBrowseTimes(0);
		resource.setReviewStatusId(1);
		resource.setFileSize(fileSize);
		resource.setUserRoleId(userRoleId);
		// TODO image id
		resource.setImageId(10000);
		
		// TODO 类别应该查数据库		
		String fileExt = filename.substring(filename.lastIndexOf('.'), filename.length());
		if (fileExt.equalsIgnoreCase(".doc") ||
				fileExt.equalsIgnoreCase(".docx") ||
				fileExt.equalsIgnoreCase(".pdf") ||
				fileExt.equalsIgnoreCase(".txt") ||
				fileExt.equalsIgnoreCase(".xls") ||
				fileExt.equalsIgnoreCase(".xlsx") ||
				fileExt.equalsIgnoreCase(".ppt") ||
				fileExt.equalsIgnoreCase(".pptx") ||
				fileExt.equalsIgnoreCase(".txt") ||
				fileExt.equalsIgnoreCase(".html") ||
				fileExt.equalsIgnoreCase(".zip") ||
				fileExt.equalsIgnoreCase(".rar") ||
				fileExt.equalsIgnoreCase(".7z") ||
				fileExt.equalsIgnoreCase(".iso") ||
				fileExt.equalsIgnoreCase(".img")) {
			resource.setResourceId(1);
		} else if (fileExt.equalsIgnoreCase(".jpg") ||
				fileExt.equalsIgnoreCase(".jpeg") ||
				fileExt.equalsIgnoreCase(".png") ||
				fileExt.equalsIgnoreCase(".tif") ||
				fileExt.equalsIgnoreCase(".bmp") ||
				fileExt.equalsIgnoreCase(".gif")) {
			resource.setResourceId(2);
		} else if (fileExt.equalsIgnoreCase(".rmvb") ||
				fileExt.equalsIgnoreCase(".mp4") ||
				fileExt.equalsIgnoreCase(".avi") ||
				fileExt.equalsIgnoreCase(".m4v") ||
				fileExt.equalsIgnoreCase(".flv") ||
				fileExt.equalsIgnoreCase(".mkv") ||
				fileExt.equalsIgnoreCase(".mov")) {
			resource.setResourceId(3);
		} else if (fileExt.equalsIgnoreCase(".mp3") ||
				fileExt.equalsIgnoreCase(".mp2") ||
				fileExt.equalsIgnoreCase(".ape") ||
				fileExt.equalsIgnoreCase(".cue") ||
				fileExt.equalsIgnoreCase(".flac") ||
				fileExt.equalsIgnoreCase(".wav") ||
				fileExt.equalsIgnoreCase(".wma") ||
				fileExt.equalsIgnoreCase(".rm")) {
			resource.setResourceId(4);
		}
		
		if (resource.getResourceId() == 0)
			resource.setResourceId(999);
		// TODO 名字只用算一次
		resource.setFileUrl(basePath + '/' + subPath + '/' + fileMD5);
		
		LogUtil.log("INFO", "Object Resource set currently");
		
		try {
			resourceDAO.add(resource);
		} catch (SQLException e) {
			LogUtil.log("WARNING", e.toString());
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public List<Resource> getResourcesByUserid(int id) throws SQLException {
		return resourceDAO.getResourcesByUserid(id);
	}
	
	public int getPersonalResCount(int userId, int resourceId) throws Exception {
		return resourceDAO.getPersonalResCount(userId, resourceId);
	}
	
	public int getAllResCount(int resourceId) throws Exception {
		return resourceDAO.getAllResCount(resourceId);
	}
	
	public static void main(String...args) throws SQLException {
		ResourceServiceImpl s = new ResourceServiceImpl();
		List<Resource> list = new ArrayList<Resource>();
		list = s.getResourcesByUserid(1004);
		
		System.out.println("");
	}
}
