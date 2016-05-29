package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.ItemChangeService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowDelInformation extends ActionSupport{
	private int changeId;
	
	public int getChangeId() {
		return changeId;
	}

	public void setChangeId(int changeId) {
		this.changeId = changeId;
	}

	@Override
	public String execute() throws Exception {
		ItemChangeService itemChangeService = new ItemChangeService();
		if(itemChangeService.showDelInformation(changeId)){
			return SUCCESS;
		}
		return ERROR;
	}
}
