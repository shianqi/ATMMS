package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.ItemChangeService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowItemList extends ActionSupport{
	@Override
	public String execute() throws Exception {
		ItemChangeService itemChangeService = new ItemChangeService();
		if(itemChangeService.showItemChangeList()){
			return SUCCESS;
		}
		return ERROR;
	}
}
