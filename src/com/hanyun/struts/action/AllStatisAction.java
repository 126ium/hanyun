package com.hanyun.struts.action;

import com.hanyun.service.IResourceService;
import com.hanyun.service.impl.ResourceServiceImpl;
import com.hanyun.util.LogUtil;
import com.opensymphony.xwork2.ActionSupport;

public class AllStatisAction extends ActionSupport {
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
		try {
			setDocCount(resourceService.getAllResCount(DOCUMENT));
			setPicCount(resourceService.getAllResCount(PICTURE));
			setMusicCount(resourceService.getAllResCount(MUSIC));
			setVideoCount(resourceService.getAllResCount(VIDEO));
		} catch (Exception e) {
			LogUtil.log("WARNING", e.toString());
			e.printStackTrace();
		}
		
		return "json";
	}
}
