package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowAddItemPage extends ActionSupport{
	private String pId;
	
	public String getPId() {
		return pId;
	}
	
	public void setPId(String pId) {
		this.pId = pId;
	}
	
	@Override
	public String execute() throws Exception {
		if(UserService.chechPurview()){
			return SUCCESS;
		}
		return ERROR;
	}
}
