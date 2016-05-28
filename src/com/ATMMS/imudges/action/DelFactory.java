package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.FactoryService;
import com.ATTMS.imudges.Model.RenameModel;
import com.opensymphony.xwork2.ActionSupport;

public class DelFactory extends ActionSupport{
	private int id;
	private RenameModel delFactoryModel;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RenameModel getDelFactoryModel() {
		return delFactoryModel;
	}
	public void setDelFactoryModel(RenameModel delFactoryModel) {
		this.delFactoryModel = delFactoryModel;
	}
	@Override
	public String execute() throws Exception {
		delFactoryModel = new RenameModel();
		FactoryService factoryService = new FactoryService();
		if(factoryService.delFactory(id)){
			delFactoryModel.setState("true");
		}else{
			delFactoryModel.setState("false");
		}
		return SUCCESS;
	}
}
