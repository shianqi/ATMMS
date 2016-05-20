package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.FactoryService;
import com.ATMMS.imudges.service.MajorService;
import com.ATMMS.imudges.service.SubsystemService;
import com.ATMMS.imudges.service.UserService;
import com.ATTMS.imudges.Model.RenameModel;
import com.opensymphony.xwork2.ActionSupport;

public class Rename extends ActionSupport{
	private String name;
	private String type;
	private int id;
	private RenameModel renameModel;
	public RenameModel getRenameModel() {
		return renameModel;
	}

	public void setRenameModel(RenameModel renameModel) {
		this.renameModel = renameModel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String execute() throws Exception {
		renameModel = new RenameModel();
		if(UserService.chechPurview()){
			if(type.equals("major")){
				MajorService majorService = new MajorService();
				majorService.rename(id, name);
			}else if(type.equals("subsystem")){
				SubsystemService subsystemService = new SubsystemService();
				subsystemService.rename(id, name);
			}else if(type.equals("factory")){
				FactoryService factoryService = new FactoryService();
				factoryService.rename(id, name);
			}
			renameModel.setState("true");
		}else{
			renameModel.setState("false");
		}
		return SUCCESS;
	}
}
