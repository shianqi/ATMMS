package com.ATMMS.imudges.service;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.ATMMS.imudges.DAO.Option;
import com.ATMMS.imudges.DAO.OptionDAO;

public class OptionService {
	public void getAllOption(){
		OptionDAO optionDAO = new OptionDAO();
		List<Option> list = optionDAO.findAll();
		ServletActionContext.getRequest().setAttribute("allOption", list);
	}
}
