package com.hanyun.struts.action;

import org.apache.struts2.ServletActionContext;

import com.hanyun.model.impl.User;
import com.hanyun.service.IAvatarService;
import com.hanyun.service.impl.AvatarSerivceImpl;
import com.hanyun.util.LogUtil;
import com.opensymphony.xwork2.ActionSupport;

public class SaveAvatarAction extends ActionSupport{
	private int imagex;
	private int imagey;
	private int imagew;
	private int imageh;
	private IAvatarService avatarService = new AvatarSerivceImpl();
	
	public int getImagex() {
		return imagex;
	}
	public void setImagex(int imagex) {
		this.imagex = imagex;
	}
	public int getImagey() {
		return imagey;
	}
	public void setImagey(int imagey) {
		this.imagey = imagey;
	}
	public int getImagew() {
		return imagew;
	}
	public void setImagew(int imagew) {
		this.imagew = imagew;
	}
	public int getImageh() {
		return imageh;
	}
	public void setImageh(int imageh) {
		this.imageh = imageh;
	}
	
	public String execute() {
		User user = null;
		
		user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		
		try {
			avatarService.saveFile(getImagex(), getImagey(), getImagew(), getImageh(), user.getUserId());
		} catch (Exception e) {
			LogUtil.log("WARNING", e.toString());
			e.printStackTrace();
			return "Write file error";
		}
		
		return SUCCESS;
	}
}
