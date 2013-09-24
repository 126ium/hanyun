package com.hanyun.model.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hanyun.model.IRowMaper;


public class ResourceCategory implements IRowMaper<ResourceCategory> { 
	private int resourceId;
	private int t_R_resourceId;
	private String resourceName;
	
	public ResourceCategory(int resourceId, int t_R_resourceId,
			String resourceName) {
		super();
		this.resourceId = resourceId;
		this.t_R_resourceId = t_R_resourceId;
		this.resourceName = resourceName;
	}
	
	public ResourceCategory() {
		
	}

	public ResourceCategory mapRow(ResultSet rs, int index) throws SQLException{
		ResourceCategory resc = new ResourceCategory();
		resc.setResourceId(rs.getInt("resourceId"));
		resc.setT_R_resourceId(rs.getInt("t_R_resourceId"));
		resc.setResourceName(rs.getString("resourceName"));
		
		return resc;
	}
	
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public int getT_R_resourceId() {
		return t_R_resourceId;
	}
	public void setT_R_resourceId(int t_R_resourceId) {
		this.t_R_resourceId = t_R_resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	

}
