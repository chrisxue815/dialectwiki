package org.dw.service;

import org.dw.model.Authorities;
import org.dw.model.User;

public interface SignupService {
	public boolean signup(User user);
	public boolean giveAuthority(Authorities authorities);
}
