package com.hanyun.struts.action;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.hanyun.model.impl.User;
import com.hanyun.service.IAvatarService;
import com.hanyun.service.impl.AvatarSerivceImpl;
import com.hanyun.util.LogUtil;
import com.opensymphony.xwork2.ActionSupport;

public class AvatarUploadAction extends ActionSupport {
	private File avatarFile;
	private String avatarFileContentType;
	private String avatarFileFileName;
	private IAvatarService avatarService = new AvatarSerivceImpl();
	
	public File getAvatarFile() {
		return avatarFile;
	}
	public void setAvatarFile(File avatarFile) {
		this.avatarFile = avatarFile;
	}
	public String getAvatarFileContentType() {
		return avatarFileContentType;
	}
	public void setAvatarFileContentType(String avatarFileContentType) {
		this.avatarFileContentType = avatarFileContentType;
	}
	public String getAvatarFileFileName() {
		return avatarFileFileName;
	}
	public void setAvatarFileFileName(String avatarFileFileName) {
		this.avatarFileFileName = avatarFileFileName;
	}
	
	public String execute() {
		User user = null;
		
		user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		
		try {
			avatarService.saveTmpFile(getAvatarFile(), user.getUserId());
		} catch (Exception e) {
			LogUtil.log("WARNING", e.toString());
			e.printStackTrace();
			return "Write temp file error";
		}
		
		return SUCCESS;
	}
	
	
}
