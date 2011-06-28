package org.dw.action;

import org.dw.model.User;
import org.dw.service.AuthorityService;
import org.dw.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class ForbiddenUserAction extends ActionSupport {
	private static final long serialVersionUID = 5726928196552538953L;
	
	private static final String INVALID_ID = "invalidid";
	private static final String ID_NOT_EXIST = "idNotExist";
	private static final String USER_NOT_EXIST = "userNotExist";
	private static final String USERS = "users";
	
	private String id;
	private String name;
	private User user;
	private AuthorityService authorityService ;
	private UserService userService;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public AuthorityService getAuthorityService() {
		return authorityService;
	}
	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String execute()
	{
		try
		{
			if(id != null && id != "")
			{
				int userId = Integer.parseInt(id);
				user = userService.getUserById(userId);
				if(user == null)
					return ID_NOT_EXIST;
				
				authorityService.disableUserAuthority(user);
			}
			else if(name != null && name != "")
			{
				user = userService.getUserByUserName(name);
				if(user == null)
					return USER_NOT_EXIST;
				
				authorityService.disableUserAuthority(user);
			}
			else
			{
				return USERS;
			}
			return SUCCESS;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return INVALID_ID;
		}
	}

}
