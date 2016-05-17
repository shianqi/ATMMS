package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.ItemService;
import com.ATMMS.imudges.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowItem extends ActionSupport{
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
		if(UserService.haveUserPurview()){
			if(itemService.showItemById(id)){
				return SUCCESS;
			}
		}
		return ERROR;
	}
}
