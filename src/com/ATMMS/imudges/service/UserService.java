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
}
