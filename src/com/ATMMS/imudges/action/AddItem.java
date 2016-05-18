package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.MajorService;
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

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
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
		addItemModel.setState("false");
		addItemModel.setId("");
		if(chechPurview()){
			if(isParent.equals("true")){
				if(pType.equals("major")){
					MajorService majorService = new MajorService();
					addItemModel.setId(majorService.addMajor(pId)+"");
					addItemModel.setState("true");
				}else if(pType=="subsystem"){
					
				}else if(pType=="factory"){
					
				}else if(pType=="option"){
					
				}
			}else{
				if(pType=="item"){
					
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
