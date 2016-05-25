package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminFixPasswordDown extends ActionSupport{
	private int id;
	private String password;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		UserService userService = new UserService();
		if(userService.adminFixPassword(id, password)){
			return SUCCESS;
		}
		return ERROR;
	}
}
