package org.dw.service.impl;

import org.dw.dao.UserDAO;
import org.dw.model.User;
import org.dw.service.SignupService;

public class SignupServiceImpl implements SignupService {
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	public boolean signup(User user) {
		// TODO Auto-generated method stub
		
		return userDAO.signup(user);
	}

}
