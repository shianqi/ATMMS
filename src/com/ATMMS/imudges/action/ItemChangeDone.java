package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.ItemChangeService;
import com.opensymphony.xwork2.ActionSupport;

public class ItemChangeDone extends ActionSupport{
	private int id;
	private String state;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String execute() throws Exception {
		ItemChangeService itemChangeService = new ItemChangeService();
		if(itemChangeService.itemChangeDown(id, state)){
			return SUCCESS;
		}
		return ERROR;
	}
}
