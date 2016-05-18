package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.MajorService;
import com.ATMMS.imudges.service.SubsystemService;
import com.ATTMS.imudges.Model.AddItemModel;
import com.opensymphony.xwork2.ActionSupport;

public class AddItem extends ActionSupport{
	private String pId;
	private String pType;
	private String isParent;
	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

	private AddItemModel addItemModel;

	public AddItemModel getAddItemModel() {
		return addItemModel;
	}

	public void setAddItemModel(AddItemModel addItemModel) {
		this.addItemModel = addItemModel;
	}

	public String getPId() {
		return pId;
	}

	public void setPId(String pId) {
		this.pId = pId;
	}

	public String getPType() {
		return pType;
	}

	public void setPType(String pType) {
		this.pType = pType;
	}

	

	@Override
	public String execute() throws Exception {
		addItemModel = new AddItemModel();
		addItemModel.setCode("false");
		addItemModel.setId("");
		if(chechPurview()){
			if(isParent.equals("true")){
				if(pType.equals("root")){
					MajorService majorService = new MajorService();
					addItemModel.setId(majorService.addMajor(pId)+"");
					addItemModel.setCode("true");
				}else if(pType.equals("major")){
					SubsystemService subsystemService = new SubsystemService();
					addItemModel.setId(subsystemService.addSubsystem(pId)+"");
					addItemModel.setCode("true");
				}else if(pType.equals("subsystem")){
					
				}else if(pType.equals("factory")){
					
				}
			}else{
				if(pType.equals("option")){
					
				}
			}
		}
		return SUCCESS;
	}
	
	//判断是否有删除权限
	public boolean chechPurview(){
		return true;
	}
}
