package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.ItemService;
import com.ATMMS.imudges.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class FixItemDown extends ActionSupport{
	private int id;
	private String name;
	private String ascription;
	private String principal;
	private String medium;
	private String remark;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAscription() {
		return ascription;
	}

	public void setAscription(String ascription) {
		this.ascription = ascription;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String execute() throws Exception {
		if(UserService.chechPurview()){
			ItemService itemService = new ItemService();
			if(itemService.fixItemInformation(id, name, ascription, principal, medium, remark)){
				return SUCCESS;
			}
		}
		return ERROR;
	}
}
