package com.ATMMS.imudges.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.ATMMS.imudges.DAO.Factory;
import com.ATMMS.imudges.DAO.FactoryDAO;
import com.ATMMS.imudges.DAO.Item;
import com.ATMMS.imudges.DAO.ItemDAO;
import com.ATMMS.imudges.DAO.Major;
import com.ATMMS.imudges.DAO.MajorDAO;
import com.ATMMS.imudges.DAO.Subsystem;
import com.ATMMS.imudges.DAO.SubsystemDAO;

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
			item.setNum(getNumber(id));
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
	
	public boolean delItem(int id){
		if(UserService.haveAdminPurview()){
			ItemDAO itemDAO = new ItemDAO();
			Item item = itemDAO.findById(id);
			itemDAO.delete(item);
			return true;
		}
		return false;
	}
	
	public boolean fixItemInformation(int id,String name,String ascription,String principal,String medium,String remark){
		try {
			ItemDAO itemDAO = new ItemDAO();
			Item item = itemDAO.findById(id);
			item.setName(name);
			item.setAscription(ascription);
			item.setPrincipal(principal);
			item.setMedium(medium);
			item.setRemark(remark);
			item.setFixTime(new Timestamp(System.currentTimeMillis()));
			itemDAO.save(item);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public String getNumber(int id){
		String str = "";
		int num = 0;
		String itemString = "";
		String factoryString = "";
		String subsystemString = "";
		String majorString = "";
		
		MajorDAO majorDAO = new MajorDAO();
		SubsystemDAO subsystemDAO = new SubsystemDAO();
		FactoryDAO factoryDAO = new FactoryDAO();
		ItemDAO itemDAO = new ItemDAO();
		
		Item item = itemDAO.findById(id);
		Item item2 = new Item();
		item2.setProject(item.getProject());
		item2.setParent(item.getParent());
		List<Item> items = itemDAO.findByExample(item2);
		
		for(int i=0;i<items.size();i++){
			if(items.get(i).getId()==id){
				itemString = items.get(i).getProject()+"-"+(i+1);
				num = Integer.valueOf(items.get(i).getParent());
				break;
			}
		}
		
		Factory factory = factoryDAO.findById(num);
		factoryString = factory.getNum();
		num = Integer.valueOf(factory.getParent());
		
		Subsystem subsystem = subsystemDAO.findById(num);
		List<Subsystem> listSubsystems = subsystemDAO.findByParent(subsystem.getParent());
		//System.out.println(listSubsystems.size());
		for(int i=0;i<listSubsystems.size();i++){
			if(listSubsystems.get(i).getId()==num){
				subsystemString = (i+1)+"";
				num = Integer.valueOf(listSubsystems.get(i).getParent()); 
				break;
			}
		}
		
		String[] majorNum = {"¢ñ","¢ò","¢ó","¢ô","¢õ","¢ö","¢÷","¢ø","¢ù","¢ú"};
		majorString = majorNum[num-1];
		
		str = majorString+"-"+subsystemString+"-"+factoryString+"-"+itemString;
		return str;
	}
}
