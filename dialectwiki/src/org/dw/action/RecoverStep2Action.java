package org.dw.action;

import com.opensymphony.xwork2.ActionSupport;

import org.dw.model.User;
import org.dw.service.UserService;
import org.dw.utils.MyStringUtils;

public class RecoverStep2Action extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String username;
	private UserService userService;
	private String question;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String execute() {
		try {
			User user = userService.getUserByUserName(username);
			question = user.getQuestion();

			return SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
	}

	public void validate() 
	{
		if (username == null) {
			username = username.toLowerCase();
			this.addFieldError("username", "用户名不能为空");
		} else if (username.length() < 6)
			this.addFieldError("username", "用户名长度至少为6位");
		else if (username.length() > 14)
			this.addFieldError("username", "用户名长度至多为14位");
		else if (MyStringUtils.checkUserName(username))
			this.addFieldError("username", "无效的用户名");
		else if(userService.getUserByUserName(username) == null)
			this.addFieldError("username", "不存在此用户");
	}
}
