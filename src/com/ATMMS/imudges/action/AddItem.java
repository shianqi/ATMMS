package com.ATMMS.imudges.action;

import com.ATMMS.imudges.service.FactoryService;
import com.ATMMS.imudges.service.ItemService;
import com.ATMMS.imudges.service.MajorService;
import com.ATMMS.imudges.service.SubsystemService;
import com.ATMMS.imudges.service.UserService;
import com.ATTMS.imudges.Model.AddItemModel;
import com.opensymphony.xwork2.ActionSupport;

public class AddItem extends ActionSupport{
	private String pId;
	private String pType;
	private String isParent;
	
	private String name;
	private String num;
	private String ascription;
	private String principal;
	private String medium;
	private String remark;
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAscription() {
		return ascription;
	}

	public void setAscription(String ascription) {
		this.ascription = ascription;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

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
		if(UserService.chechPurview()){
			if(isParent.equals("true")){
				if(pType.equals("root")){
					MajorService majorService = new MajorService();
					addItemModel.setId(majorService.addMajor(pId,name)+"");
					addItemModel.setCode("true");
				}else if(pType.equals("major")){
					SubsystemService subsystemService = new SubsystemService();
					addItemModel.setId(subsystemService.addSubsystem(pId,name)+"");
					addItemModel.setCode("true");
				}else if(pType.equals("subsystem")){
					FactoryService factoryService = new FactoryService();
					addItemModel.setId(factoryService.addFactory(pId,name,num)+"");
					addItemModel.setCode("true");
				}else if(pType.equals("factory")){
					
				}
			}else{
				if(pType.equals("option")){
					ItemService itemService = new ItemService();
					addItemModel.setId(itemService.addItem(pId,name,ascription,principal,medium,remark)+"");
					addItemModel.setCode("true");
				}
			}
		}
		return SUCCESS;
	}
	
	//判断是否有删除权限
	
}
