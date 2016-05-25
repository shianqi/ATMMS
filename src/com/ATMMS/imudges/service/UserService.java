package com.ATMMS.imudges.service;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.ATMMS.imudges.DAO.User;
import com.ATMMS.imudges.DAO.UserDAO;
import com.ATMMS.imudges.util.MD5;
import com.opensymphony.xwork2.ActionContext;

public class UserService {
	public boolean login(String username, String password){
		UserDAO userDAO = new UserDAO();
		List<User> users = userDAO.findByUsername(username);
		User user = users.get(0);
		if(user.getPassword().equals(password)){
			Map<String , Object> session = ActionContext.getContext().getSession();
			session.put("username", username);
			session.put("state","1");
			session.put("userType", user.getUserType());
			return true;
		}
		return false;
	}
	
	public boolean fixPassword(String username,String password_old,String password_new1){
		UserDAO usersDAO = new UserDAO();
		try {
			User user = (User)usersDAO.findByUsername(username).get(0);
			if(password_old.equals(user.getPassword())){
				user.setPassword(password_new1);
				usersDAO.save(user);
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean haveUserPurview(){
		Map<String , Object> session = ActionContext.getContext().getSession();
		if(session.get("state")!=null&&session.get("state").equals("1")&&(session.get("userType").equals("2")||session.get("userType").equals("1"))){
			return true;
		}
		return false;
	}
	
	public static boolean haveAdminPurview(){
		Map<String , Object> session = ActionContext.getContext().getSession();
		if(session.get("state")!=null&&session.get("userType")!=null&&session.get("state").equals("1")&&session.get("userType").equals("1")){
			return true;
		}
		return false;
	}
	
	public boolean logout(){
		Map<String , Object> session = ActionContext.getContext().getSession();
		session.clear();
		return true;
	}
	
	public static boolean chechPurview(){
		if(haveUserPurview()){
			return true;
		}
		if(haveAdminPurview()){
			return true;
		}
		return false;
	}
	
	public boolean showUserList(){
		if(haveAdminPurview()){
			UserDAO userDAO = new UserDAO();
			List<User> userList = userDAO.findAll();
			ServletActionContext.getRequest().setAttribute("userList", userList);
			return true;
		}
		return false;
	}
	
	public boolean adminFixPassword(int id, String password){
		if(haveAdminPurview()){
			UserDAO userDAO = new UserDAO();
			User user = userDAO.findById(id);
			user.setPassword(new MD5().encryptPassword(password));
			userDAO.save(user);
			return true;
		}
		return false;
	}
	
	public boolean adminAddUser(String username, String password){
		if(haveAdminPurview()){
			UserDAO userDAO = new UserDAO();
			User user = new User();
			user.setUsername(username);
			user.setPassword(new MD5().encryptPassword(password));
			user.setUserType("2");
			userDAO.save(user);
			return true;
		}
		return false;
	}
}
