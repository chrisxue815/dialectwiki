package org.dw.action;

import java.util.List;
import org.dw.model.User;
import org.dw.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

//user首页的action
public class UserIndexAction extends ActionSupport {

	private static final long serialVersionUID = 4300539552214668482L;
	
	private List<User> NBUsers;
    private UserService userService;
    
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getNBUsers() {
		return NBUsers;
	}

	public void setNBUsers(List<User> nBUsers) {
		NBUsers = nBUsers;
	}

	public String execute()
	{
		NBUsers = userService.getNBUsers();
		return SUCCESS;
	}
}
