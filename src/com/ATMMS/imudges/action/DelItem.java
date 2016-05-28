package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.ItemService;
import com.ATMMS.imudges.service.UserService;
import com.ATTMS.imudges.Model.RenameModel;
import com.opensymphony.xwork2.ActionSupport;

public class DelItem extends ActionSupport{
	private int id;
	private RenameModel delItemModel;
	
	public RenameModel getDelItemModel() {
		return delItemModel;
	}

	public void setDelItemModel(RenameModel delItemModel) {
		this.delItemModel = delItemModel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String execute() throws Exception {
		ItemService itemService = new ItemService();
		delItemModel = new RenameModel();
		if(itemService.delItem(id)){
			delItemModel.setState("true");
			return SUCCESS;
		}
		delItemModel.setState("false");
		return ERROR;
	}
}
