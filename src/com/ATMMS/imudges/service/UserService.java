package com.ATMMS.imudges.service;

import java.util.List;
import java.util.Map;

import com.ATMMS.imudges.DAO.User;
import com.ATMMS.imudges.DAO.UserDAO;
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
	
	public void logout(){
		Map<String , Object> session = ActionContext.getContext().getSession();
		session.clear();
	}
}
