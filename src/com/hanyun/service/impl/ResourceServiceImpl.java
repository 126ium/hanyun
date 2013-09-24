package com.hanyun.service.impl;

import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.hanyun.service.IResourceService;
import com.hanyun.util.HanyunUtil;
import com.hanyun.util.LogUtil;
import com.hanyun.util.dbfactory.ConnectionBroker;
import com.hanyun.dao.ResourceDAOImpl;
import com.hanyun.model.Resource;

public class ResourceServiceImpl implements IResourceService {
	private ResourceDAOImpl resourceDAO = new ResourceDAOImpl();
	
	public boolean saveFile(File src) throws Exception {
		String basePath = null;
		String subPath = null;
		String fileMD5 = null;
		
		Properties prop = new Properties();
		try {
			prop.load(ConnectionBroker.class.getClassLoader().getResourceAsStream("hanyun.property"));
		} catch (IOException e) {
			LogUtil.log("WARN", "ERROR to read properties file");
			e.printStackTrace();
		}	
		basePath = prop.getProperty("baseDir");
		
		subPath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		fileMD5 = HanyunUtil.MD5(src);
		
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
			
			if (dst.exists())
				return false;
			else 
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
		
		if (permission == "public")
			userRoleId = 3;
		else if (permission == "protected")
			userRoleId = 2;
		else
			userRoleId = 1;
		
		resource.setFileName(filename);
		resource.setUserId(userId);
		resource.setFileMD5(HanyunUtil.MD5(src));
		resource.setUploadTime(new Date());
		resource.setDownloadTimes(0);
		resource.setBrowseTimes(0);
		resource.setReviewStatusId(1);
		resource.setFileSize(fileSize);
		resource.setUserRoleId(userRoleId);
		resource.setImageId(10000);
		resource.setResourceId(1);
		resource.setFileUrl("\\home\\ezio");
		
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
}
