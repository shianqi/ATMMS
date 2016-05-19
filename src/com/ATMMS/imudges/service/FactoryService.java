package com.ATMMS.imudges.service;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.ATMMS.imudges.DAO.Factory;
import com.ATMMS.imudges.DAO.FactoryDAO;
import com.ATMMS.imudges.DAO.Subsystem;
import com.ATMMS.imudges.DAO.SubsystemDAO;

public class FactoryService {
	public void getAllFactory(){
		FactoryDAO factoryDAO = new FactoryDAO();
		List<Factory> list = factoryDAO.findAll();
		ServletActionContext.getRequest().setAttribute("allFactory", list);
	}
	
	public int addFactory(String pId){
		FactoryDAO factoryDAO = new FactoryDAO();
		Factory factory = new Factory();
		factory.setName("new folder");
		factory.setParent(pId);
		factoryDAO.save(factory);
		return factory.getId();
	}
}
