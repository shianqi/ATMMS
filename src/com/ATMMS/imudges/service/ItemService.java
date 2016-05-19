package com.ATMMS.imudges.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.ATMMS.imudges.DAO.Factory;
import com.ATMMS.imudges.DAO.FactoryDAO;
import com.ATMMS.imudges.DAO.Item;
import com.ATMMS.imudges.DAO.ItemDAO;

public class ItemService {
	public void getAllItem(){
		ItemDAO itemDao= new ItemDAO();
		List<Item> list = itemDao.findAll();
		ServletActionContext.getRequest().setAttribute("allItem", list);
	}
	
	public boolean showItemById(int id){
		try {
			ItemDAO itemDAO = new ItemDAO();
			Item item = itemDAO.findById(id);
			ServletActionContext.getRequest().setAttribute("item", item);
			return true;
		} catch (Exception e) {
			System.out.println("ERROR:ItemService/showItemById()");
		}
		return false;
	}
	
	public int addItem(String pId,String name,String ascription,String principal,String medium,String remark){
		ItemDAO itemDAO = new ItemDAO();
		Item item = new Item();
		item.setNewTime(new Timestamp(System.currentTimeMillis()));
		item.setProject(pId.substring(0, 1));
		item.setParent(pId.substring(2));
		item.setName(name);
		item.setAscription(ascription);
		item.setPrincipal(principal);
		item.setMedium(medium);
		item.setRemark(remark);
		itemDAO.save(item);
		return item.getId();
	}
}
