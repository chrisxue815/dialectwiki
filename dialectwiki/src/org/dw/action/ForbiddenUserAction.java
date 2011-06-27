package org.dw.action;

import org.dw.model.User;
import org.dw.service.AuthorityService;
import com.opensymphony.xwork2.ActionSupport;

public class ForbiddenUserAction extends ActionSupport {
	private static final long serialVersionUID = 5726928196552538953L;
	
	private static final String INVALID_ID = "invalidid";
	
	private String id;
	private User user;
	private AuthorityService authorityService ;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String execute()
	{
		try{
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
