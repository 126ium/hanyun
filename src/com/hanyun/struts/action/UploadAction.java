package com.hanyun.struts.action;

import java.io.*;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.hanyun.model.impl.User;
import com.hanyun.service.IResourceService;
import com.hanyun.service.IUserService;
import com.hanyun.service.impl.ResourceServiceImpl;
import com.hanyun.service.impl.UserServiceImpl;
import com.hanyun.util.LogUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private String permission;
	private String filenameInput;
	private IResourceService resourceService = new ResourceServiceImpl();	

	public File getFileUpload() {
		return fileUpload;
	}


	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}


	public String getFileUploadContentType() {
		return fileUploadContentType;
	}


	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}


	public String getFileUploadFileName() {
		return fileUploadFileName;
	}


	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}
	

	public String getPermission() {
		return permission;
	}


	public void setPermission(String permission) {
		this.permission = permission;
	}


	public String getFilenameInput() {
		return filenameInput;
	}


	public void setFilenameInput(String filenameInput) {
		this.filenameInput = filenameInput;
	}
	
	public String execute() {
		LogUtil.log("INFO", "action exe");
		User user = null;
		
		user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		
		LogUtil.log("INFO", getFileUpload().getName());
		LogUtil.log("INFO", getFilenameInput());
		LogUtil.log("INFO", getPermission());
		
		try {

			if (!resourceService.saveFile(getFileUpload()))
				return INPUT;
		} catch (SecurityException e) {
			LogUtil.log("WARNING", e.toString());
			e.printStackTrace();
		} catch (Exception e) {
			LogUtil.log("WARNING", e.toString());
			e.printStackTrace();
		}
		
		try {
			resourceService.saveToDb(getFileUpload(), getFilenameInput(), user.getUserId(), getPermission());
//				return INPUT;
		} catch (Exception e) {
			LogUtil.log("WARNING", e.toString());
			e.printStackTrace();
		}
		
		return SUCCESS;
	}


}
