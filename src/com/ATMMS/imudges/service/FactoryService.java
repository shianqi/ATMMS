package com.ATMMS.imudges.service;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.ATMMS.imudges.DAO.Factory;
import com.ATMMS.imudges.DAO.FactoryDAO;

public class FactoryService {
	public void getAllFactory(){
		FactoryDAO factoryDAO = new FactoryDAO();
		List<Factory> list = factoryDAO.findAll();
		ServletActionContext.getRequest().setAttribute("allFactory", list);
	}
}
