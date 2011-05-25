package org.dw.dao;

import org.dw.model.Authorities;
import org.dw.model.User;

public interface UserDAO {
	
	public boolean signup(User user);
	public boolean giveAuthority(Authorities authorities);
}
