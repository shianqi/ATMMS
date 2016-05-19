package com.ATMMS.imudges.service;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.ATMMS.imudges.DAO.Major;
import com.ATMMS.imudges.DAO.MajorDAO;

public class MajorService {
	public void getAllMajor(){
		MajorDAO majorDAO = new MajorDAO();
		List<Major> list = majorDAO.findAll();
		ServletActionContext.getRequest().setAttribute("allMajor", list);
	}
	
	public int addMajor(String pId,String name){
		MajorDAO majorDAO = new MajorDAO();
		int number = majorDAO.findAll().size();
		
		Major major = new Major();
		major.setName(name);
		majorDAO.save(major);
		return major.getId();
	}
}
