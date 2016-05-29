package com.ATMMS.imudges.service;

import java.sql.Timestamp;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.ATMMS.imudges.DAO.Item;
import com.ATMMS.imudges.DAO.ItemDAO;
import com.ATMMS.imudges.DAO.Itemchange;
import com.ATMMS.imudges.DAO.ItemchangeDAO;

public class ItemChangeService {
	public boolean showItemChangeList(){
		if(UserService.haveAdminPurview()){
			ItemchangeDAO itemchangeDAO = new ItemchangeDAO();
			List<Itemchange> list = itemchangeDAO.findAll();
			ServletActionContext.getRequest().setAttribute("itemChangeList", list);
			
			return true;
		}else if(UserService.haveUserPurview()){
			ItemchangeDAO itemchangeDAO = new ItemchangeDAO();
			List<Itemchange> list = itemchangeDAO.findByUsername(UserService.getUsername());
			System.out.println(UserService.getUsername());
			ServletActionContext.getRequest().setAttribute("itemChangeList", list);
			return true;
		}
		return false;
	}
	
	public boolean showDelInformation(int changeId){
		if(UserService.chechPurview()){
			ItemchangeDAO itemchangeDAO = new ItemchangeDAO();
			Itemchange itemchange = itemchangeDAO.findById(changeId);
			ItemDAO itemDAO = new ItemDAO();
			Item item = itemDAO.findById(Integer.parseInt(itemchange.getPid()));
			ServletActionContext.getRequest().setAttribute("DelInformation", item);
			return true;
		}
		return false;
	}
	
	public boolean showChangeInformation(int changeId){
		if(UserService.chechPurview()){
			ItemchangeDAO itemchangeDAO = new ItemchangeDAO();
			Itemchange itemchange = itemchangeDAO.findById(changeId);
			ItemDAO itemDAO = new ItemDAO();
			Item item = itemDAO.findById(Integer.parseInt(itemchange.getPid()));
			ServletActionContext.getRequest().setAttribute("item", item);
			ServletActionContext.getRequest().setAttribute("itemChange", itemchange);
			return true;
		}
		return false;
	}
	
	public int getMessageNumber(){
		if(UserService.haveAdminPurview()){
			ItemchangeDAO itemchangeDAO = new ItemchangeDAO();
			List<Itemchange> list = itemchangeDAO.findAll();
			return list.size();
		}else if(UserService.haveUserPurview()){
			ItemchangeDAO itemchangeDAO = new ItemchangeDAO();
			List<Itemchange> list = itemchangeDAO.findByUsername(UserService.getUsername());
			return list.size();
		}
		return 0;
	}
	
	public boolean itemDelDown(int id,String state){
		if(UserService.haveAdminPurview()){
			if(state.equals("true")){
				ItemchangeDAO itemchangeDAO = new ItemchangeDAO();
				ItemDAO itemDAO = new ItemDAO();
				Itemchange itemchange = itemchangeDAO.findById(id);
				Item item = itemDAO.findById(Integer.parseInt(itemchange.getPid()));
				itemDAO.delete(item);
				itemchangeDAO.delete(itemchange);
				return true;
			}else if(state.equals("false")){
				ItemchangeDAO itemchangeDAO = new ItemchangeDAO();
				Itemchange itemchange = itemchangeDAO.findById(id);
				itemchangeDAO.delete(itemchange);
				return true;
			}
			return true;
		}
		return false;
	}
	
	public boolean itemChangeDown(int id,String state){
		if(UserService.haveAdminPurview()){
			if(state.equals("true")){
				ItemchangeDAO itemchangeDAO = new ItemchangeDAO();
				ItemDAO itemDAO = new ItemDAO();
				Itemchange itemchange = itemchangeDAO.findById(id);
				Item item = itemDAO.findById(Integer.parseInt(itemchange.getPid()));
				item.setName(itemchange.getName());
				item.setAscription(itemchange.getAscription());
				item.setPrincipal(itemchange.getPrinclpal());
				item.setMedium(itemchange.getMedium());
				item.setRemark(itemchange.getRemark());
				item.setFixTime(new Timestamp(System.currentTimeMillis()));
				itemDAO.save(item);
				itemchangeDAO.delete(itemchange);
				return true;
			}else if(state.equals("false")){
				ItemchangeDAO itemchangeDAO = new ItemchangeDAO();
				Itemchange itemchange = itemchangeDAO.findById(id);
				itemchangeDAO.delete(itemchange);
				return true;
			}
		}
		return false;
	}
}
