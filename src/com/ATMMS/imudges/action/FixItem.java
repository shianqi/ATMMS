package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.ItemService;
import com.ATMMS.imudges.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class FixItem extends ActionSupport{
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		ItemService itemService = new ItemService();
		if(UserService.chechPurview()){
			if(itemService.showItemById(id)){
				return SUCCESS;
			}
		}
		return ERROR;
	}
}
