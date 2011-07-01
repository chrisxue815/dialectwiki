package org.dw.service;

import org.dw.model.User;

public interface AuthorityService {
	public void enableUserAuthority (User user);
	public void disableUserAuthority (User user);
    
}
