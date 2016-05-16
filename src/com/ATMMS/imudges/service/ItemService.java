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
}
