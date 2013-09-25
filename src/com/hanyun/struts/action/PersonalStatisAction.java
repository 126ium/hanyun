package com.hanyun.struts.action;

import org.apache.struts2.ServletActionContext;

import com.hanyun.model.impl.User;
import com.hanyun.service.IResourceService;
import com.hanyun.service.impl.ResourceServiceImpl;
import com.hanyun.util.LogUtil;
import com.opensymphony.xwork2.ActionSupport;

public class PersonalStatisAction extends ActionSupport {
	private final int DOCUMENT = 1;
	private final int PICTURE = 2;
	private final int VIDEO = 3;
	private final int MUSIC = 4;
	
	private int musicCount;
	private int videoCount;
	private int picCount;
	private int docCount;
	private IResourceService resourceService = new ResourceServiceImpl();
	
	public int getMusicCount() {
		return musicCount;
	}
	public void setMusicCount(int musicCount) {
		this.musicCount = musicCount;
	}
	public int getVideoCount() {
		return videoCount;
	}
	public void setVideoCount(int videoCount) {
		this.videoCount = videoCount;
	}
	public int getPicCount() {
		return picCount;
	}
	public void setPicCount(int picCount) {
		this.picCount = picCount;
	}
	public int getDocCount() {
		return docCount;
	}
	public void setDocCount(int docCount) {
		this.docCount = docCount;
	}
	
	public String execute() {
		User user = null;
		
		user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		
		try {
			setDocCount(resourceService.getPersonalResCount(user.getUserId(), DOCUMENT));
			setPicCount(resourceService.getPersonalResCount(user.getUserId(), PICTURE));
			setMusicCount(resourceService.getPersonalResCount(user.getUserId(), MUSIC));
			setVideoCount(resourceService.getPersonalResCount(user.getUserId(), VIDEO));
		} catch (Exception e) {
			LogUtil.log("WARNING", e.toString());
			e.printStackTrace();
		}
		
		return "json";
	}
}
