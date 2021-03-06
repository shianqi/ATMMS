package com.ATMMS.imudges.service;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.ATMMS.imudges.DAO.Major;
import com.ATMMS.imudges.DAO.MajorDAO;
import com.ATMMS.imudges.DAO.Subsystem;
import com.ATMMS.imudges.DAO.SubsystemDAO;

public class SubsystemService {
	public void getAllSubsystem(){
		SubsystemDAO subsystemDAO = new SubsystemDAO();
		List<Subsystem> list = subsystemDAO.findAll();
		ServletActionContext.getRequest().setAttribute("allSubsystem", list);
	}
	
	public int addSubsystem(String pId, String name){
		SubsystemDAO subsystemDAO = new SubsystemDAO();
		Subsystem subsystem = new Subsystem();
		subsystem.setName(name);
		subsystem.setParent(pId);
		subsystemDAO.save(subsystem);
		return subsystem.getId();
	}
	
	public void rename(int id, String name){
		SubsystemDAO subsystemDAO = new SubsystemDAO();
		Subsystem subsystem = subsystemDAO.findById(id);
		subsystem.setName(name);
		subsystemDAO.save(subsystem);
	}
}
