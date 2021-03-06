package com.ATMMS.imudges.action;

import java.util.Map;

import com.ATMMS.imudges.service.FactoryService;
import com.ATMMS.imudges.service.ItemChangeService;
import com.ATMMS.imudges.service.ItemService;
import com.ATMMS.imudges.service.MajorService;
import com.ATMMS.imudges.service.OptionService;
import com.ATMMS.imudges.service.SubsystemService;
import com.ATMMS.imudges.service.UserService;
import com.ATMMS.imudges.util.MD5;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport{
	private String messageNumber;
	private String username;
	private String password;
	
	public String getMessageNumber() {
		return messageNumber;
	}
	public void setMessageNumber(String messageNumber) {
		this.messageNumber = messageNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String execute() throws Exception {
		UserService userService = new UserService();
		if(password!=null&&userService.login(username, new MD5().encryptPassword(password))){
			init();
			return SUCCESS;
		}
		return ERROR;
	}
	
	public void init(){
		MajorService majorService = new MajorService();
		FactoryService factoryService = new FactoryService();
		SubsystemService subsystemService = new SubsystemService();
		ItemService itemService = new ItemService();
		OptionService optionService = new OptionService();
		ItemChangeService itemChangeService = new ItemChangeService();
		
		majorService.getAllMajor();
		factoryService.getAllFactory();
		subsystemService.getAllSubsystem();
		itemService.getAllItem();
		optionService.getAllOption();
		messageNumber = itemChangeService.getMessageNumber()+"";
	}
}
