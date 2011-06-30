package org.dw.service.impl;

import org.dw.dao.AuthorityDAO;
import org.dw.model.User;
import org.dw.service.AuthorityService;

public class AuthorityServiceImpl implements AuthorityService {

	private AuthorityDAO authorityDAO;
	
	
	
	public AuthorityDAO getAuthorityDAO() {
		return authorityDAO;
	}

	public void setAuthorityDAO(AuthorityDAO authorityDAO) {
		this.authorityDAO = authorityDAO;
	}

	public void disableUserAuthority(User user) {
		authorityDAO.disableUserRole(user);
		
	}

	public void enableUserAuthority(User user) {
		authorityDAO.enableUserRole(user);
	}

}
