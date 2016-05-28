package com.ATMMS.imudges.service;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.ATMMS.imudges.DAO.Factory;
import com.ATMMS.imudges.DAO.FactoryDAO;
import com.ATMMS.imudges.DAO.ItemDAO;
import com.ATMMS.imudges.DAO.Subsystem;
import com.ATMMS.imudges.DAO.SubsystemDAO;

public class FactoryService {
	public void getAllFactory(){
		FactoryDAO factoryDAO = new FactoryDAO();
		List<Factory> list = factoryDAO.findAll();
		ServletActionContext.getRequest().setAttribute("allFactory", list);
	}
	
	public int addFactory(String pId, String name, String num){
		FactoryDAO factoryDAO = new FactoryDAO();
		Factory factory = new Factory();
		factory.setName(name);
		factory.setNum(num);
		factory.setParent(pId);
		factoryDAO.save(factory);
		return factory.getId();
	}
	
	public boolean delFactory(int id){
		FactoryDAO factoryDAO = new FactoryDAO();
		Factory factory = factoryDAO.findById(id);
		
		ItemDAO itemDAO = new ItemDAO();
		if(itemDAO.findByParent(id+"").size()>0){
			return false;
		}else{
			factoryDAO.delete(factory);
			return true;
		}
	}
	
	public void rename(int id, String name){
		FactoryDAO factoryDAO = new FactoryDAO();
		Factory factory = factoryDAO.findById(id);
		factory.setName(name);
		factoryDAO.save(factory);
	}
}
