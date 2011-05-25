package org.dw.service.impl;

import org.dw.dao.AuthorityDAO;
import org.dw.dao.UserDAO;
import org.dw.model.Authorities;
import org.dw.model.User;
import org.dw.service.SignupService;

public class SignupServiceImpl implements SignupService {
	private static final String ROLE_USER = "ROLE_USER";
	private UserDAO userDAO;
	private AuthorityDAO authorityDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public AuthorityDAO getAuthorityDAO() {
		return authorityDAO;
	}

	public void setAuthorityDAO(AuthorityDAO authorityDAO) {
		this.authorityDAO = authorityDAO;
	}

	public boolean signup(User user) {
		Authorities authorities = new Authorities(user.getUsername(), ROLE_USER);
		return (userDAO.signup(user)&& authorityDAO.setAuthority(authorities));
	}	
}
