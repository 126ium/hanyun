package com.hanyun.service.impl;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.struts2.ServletActionContext;

import com.hanyun.service.IAvatarService;
import com.hanyun.util.HanyunUtil;
import com.hanyun.util.LogUtil;

public class AvatarSerivceImpl implements IAvatarService {
	private HanyunUtil util = HanyunUtil.getInstance();
	
	public boolean saveTmpFile(File src, int userId) throws Exception {
		String basePath = null;
		String userMD5 = null;
		
		Properties prop = new Properties();
		try {
			prop.load(ResourceServiceImpl.class.getClassLoader().getResourceAsStream("hanyun.property"));
		} catch (IOException e) {
			LogUtil.log("WARN", "ERROR to read properties file");
			e.printStackTrace();
		}	
		//basePath = "/home/ezio/code/temp/hanyun_file";
		basePath = ServletActionContext.getServletContext().getRealPath("/user/avatar");
		
		userMD5 = util.MD5(String.valueOf(userId));
		
		try {
			//InputStream in = null;
			//OutputStream out = null;
			
			File dir = new File(basePath);
			if (!dir.exists()) {
				dir.mkdirs();
				LogUtil.log("INFO", "Dir is invalid, created");
			}
			
			File dst = new File(basePath  + "/" + userMD5 + ".png.tmp");
			LogUtil.log("INFO", "Dst file is OK");
			

			if (!dst.exists()) {
				dst.createNewFile();
				LogUtil.log("INFO", "Dst file is invalid, created");
			}

			BufferedImage in = ImageIO.read(src);
			ImageIO.write(in, "PNG", dst);
			LogUtil.log("INFO", "Dst file saved");
		} catch (Exception e) {	
			LogUtil.log("WARNING", e.toString());
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean saveFile(int x, int y, int width, int height, int userId) throws Exception {
		String srcpath;
		String dstpath;
		String userMD5 = util.MD5(String.valueOf(userId));

		srcpath = ServletActionContext.getServletContext().getRealPath("/user/avatar");
		dstpath = srcpath;
		srcpath += "/" + userMD5 + ".png.tmp";
		dstpath += "/" + userMD5 + ".png";
		
	    FileInputStream is = null;
	    ImageInputStream iis = null;
	    try {
	    	is = new FileInputStream(srcpath);  
	    	Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName("png");  
	    	ImageReader reader = it.next();  
	    	iis = ImageIO.createImageInputStream(is);  
	    	reader.setInput(iis, true);  
	    	ImageReadParam param = reader.getDefaultReadParam();  
	    	Rectangle rect = new Rectangle(x, y, width, height);  
	    	param.setSourceRegion(rect);
	    	
	    	BufferedImage bi = reader.read(0, param);
	    	File dst = new File(dstpath);
	    	if (!dst.exists()) {
				dst.createNewFile();
				LogUtil.log("INFO", "Dst file is invalid, created");
			}
	    	
			LogUtil.log("INFO", "Dst file is OK");
	    	ImageIO.write(bi, "png", dst);
	    	LogUtil.log("INFO", "Avatar saved");
	    	LogUtil.log("INFO", dst.getPath());
	    } finally {  
	    	if (is != null)  
	    		is.close();
	    	if (iis != null)  
	    		iis.close();
	    }	    	
		return true;
	}
}
