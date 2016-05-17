package com.ATMMS.imudges.service;

import java.util.List;

import org.apache.struts2.ServletActionContext;

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
}
