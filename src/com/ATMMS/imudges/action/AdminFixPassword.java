package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminFixPassword extends ActionSupport{
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String execute() throws Exception {
		UserService userService = new UserService();
		if(userService.haveAdminPurview()){
			return SUCCESS;
		}
		return ERROR;
	}
}
