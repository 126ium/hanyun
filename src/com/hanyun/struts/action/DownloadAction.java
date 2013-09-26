package com.hanyun.struts.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.hanyun.dao.ResourceDAOImpl;
import com.hanyun.model.impl.Resource;
import com.hanyun.model.impl.User;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	private ResourceDAOImpl resourceDAOImpl = new ResourceDAOImpl();
	private String fileId;
	private Resource resource;
	private InputStream downloadStream;

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	
	public String getDownloadFileName() throws UnsupportedEncodingException {  
        return new String(resource.getFileName().getBytes(), "ISO8859-1");  
    }  
	
	//从下载文件原始存放路径读取得到文件输出流
	public InputStream getDownloadStream() throws Exception {
//		downloadStream =HanyunUtil.class.getClassLoader().getResourceAsStream("c:\\a.txt");
//		downloadStream = new FileInputStream("C:\\a.txt");
//		System.out.println(resource.getFileUrl());
//		downloadStream = ServletActionContext.getServletContext().getResourceAsStream("/" + resource.getFileUrl());
		URL url;
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (null == user  && resource.getUserRoleId() < 3) {
			url = new URL("file:///C:/TEMPFILE/warning.txt");
		} else if (user.getRole() > resource.getUserRoleId()) {
			url = new URL("file:///C:/TEMPFILE/loginWarning.txt");
		} else {
			url = new URL("file:///" + resource.getFileUrl());
			resource.setDownloadTimes(resource.getDownloadTimes() + 1);
			resourceDAOImpl.update(resource);
		}
		downloadStream = url.openStream();
		
//		System.out.println(downloadStream);

		return downloadStream;
	}
	
	public void setDownloadStream(InputStream inputStream) {
		this.downloadStream = inputStream;
	}

	public String execute() {
		try {
			resource = (Resource) resourceDAOImpl.get(Integer.parseInt(fileId));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
//		try {
//			getDownloadStream();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return SUCCESS;
	}
}