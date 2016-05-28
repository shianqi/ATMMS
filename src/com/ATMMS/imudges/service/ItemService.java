package com.ATMMS.imudges.service;

import java.sql.Timestamp;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.ATMMS.imudges.DAO.Factory;
import com.ATMMS.imudges.DAO.FactoryDAO;
import com.ATMMS.imudges.DAO.Item;
import com.ATMMS.imudges.DAO.ItemDAO;
import com.ATMMS.imudges.DAO.Itemchange;
import com.ATMMS.imudges.DAO.ItemchangeDAO;
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
		}else if(UserService.haveUserPurview()){
			ItemDAO itemDAO = new ItemDAO();
			Item item = itemDAO.findById(id);
			ItemchangeDAO changeDAO = new ItemchangeDAO();
			Itemchange change = new Itemchange();
			change.setPid(item.getId()+"");
			change.setType("2");
			changeDAO.save(change);
			return true;
		}
		return false;
	}
	
	/**
	 * 修改文档信息
	 * @param id
	 * @param name
	 * @param ascription
	 * @param principal
	 * @param medium
	 * @param remark
	 * @return
	 */
	public boolean fixItemInformation(int id,String name,String ascription,String principal,String medium,String remark){
		try {
			if(UserService.haveAdminPurview()){
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
			}else if(UserService.haveUserPurview()){
				ItemDAO itemDAO = new ItemDAO();
				Item item = itemDAO.findById(id);
				ItemchangeDAO changeDAO = new ItemchangeDAO();
				Itemchange change = new Itemchange();
				change.setPid(item.getId()+"");
				change.setName(name);
				change.setAscription(ascription);
				change.setPrinclpal(principal);
				change.setMedium(medium);
				change.setRemark(remark);
				change.setType("1");
				changeDAO.save(change);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	/**
	 * 得到文档编号
	 * @param id id
	 * @return 编号
	 */
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
		
		String[] majorNum = {"Ⅰ","Ⅱ","Ⅲ","Ⅳ","Ⅴ","Ⅵ","Ⅶ","Ⅷ","Ⅸ","Ⅹ"};
		majorString = majorNum[num-1];
		
		str = majorString+"-"+subsystemString+"-"+factoryString+"-"+itemString;
		return str;
	}
}
