package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport{
	@Override
	public String execute() throws Exception {
		UserService userService = new UserService();
		if(userService.logout()){
			return SUCCESS;
		}
		return ERROR;
	}
}
