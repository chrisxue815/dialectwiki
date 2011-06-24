package org.dw.action;

import java.util.List;
import org.dw.model.User;
import org.dw.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;

import com.opensymphony.xwork2.ActionSupport;

//user首页的action
public class UserIndexAction extends ActionSupport {

	private static final long serialVersionUID = 4300539552214668482L;
	
	private List<User> NBUsers;
	private List<User> GOODUsers;
    private UserService userService;
    private User user;
    
	
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
	
	

	public List<User> getGOODUsers() {
		return GOODUsers;
	}

	public void setGOODUsers(List<User> gOODUsers) {
		GOODUsers = gOODUsers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute()
	{
		int listSize = 20;
		NBUsers = userService.getNBUsers(listSize);
		GOODUsers = userService.getGOODUsers(listSize);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if( ! username.equals("anonymousUser"))
		{
			user = userService.getUserByUserName(username);
		}
		return SUCCESS;
	}
}
