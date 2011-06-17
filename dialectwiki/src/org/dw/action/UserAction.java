package org.dw.action;


import java.util.List;


import org.dw.model.Pronunciation;
import org.dw.model.User;
import org.dw.service.PronunciationService;
import org.dw.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

//user Details的action
public class UserAction extends ActionSupport{
	
	private static final long serialVersionUID = -5955231542987946679L;
	private String id;
	private String name;
	private User user;
	
	private UserService userService;
	private PronunciationService pronunciationService;
	List<Pronunciation> userProns;

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



	public UserService getUserService() {
		return userService;
	}



	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	

	public List<Pronunciation> getUserProns() {
		return userProns;
	}



	public void setUserProns(List<Pronunciation> userProns) {
		this.userProns = userProns;
	}


	
	public PronunciationService getPronunciationService() {
		return pronunciationService;
	}



	public void setPronunciationService(PronunciationService pronunciationService) {
		this.pronunciationService = pronunciationService;
	}



	public String execute()
	{
		if(id != null)
		{
			int idInt = Integer.parseInt(id);
			try
			{
				user =  userService.getUserById(idInt);
				userProns = pronunciationService.getUserProns(idInt);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				return ERROR;//您所查找的用户不存在
			}
		}
		else if(name != null)
		{
			try
			{
				user = userService.getUserByUserName(name);	
				userProns = pronunciationService.getUserProns(user.getUserId());
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return ERROR;//您所查找的用户不存在
			}
		}
		
		return SUCCESS;
	}
	
}
