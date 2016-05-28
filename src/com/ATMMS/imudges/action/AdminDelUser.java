package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminDelUser extends ActionSupport{
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		UserService userService = new UserService();
		if(userService.adminDelUser(id)){
			return SUCCESS;
		}
		return ERROR;
	}
}
