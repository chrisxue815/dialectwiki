package org.dw.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.dw.model.User;
import org.dw.service.UserService;
import org.dw.utils.MD5;

import com.opensymphony.xwork2.ActionSupport;

public class RecoverStep3Action extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String username;
	private String answer;
	private UserService userService;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() {
		try {
			User user = userService.getUserByUserName(username);
			String trueAnswer = user.getAnswer();
			String inputAnswer = MD5.toMD5(answer);

			if (trueAnswer.equalsIgnoreCase(inputAnswer)) {
				HttpSession session = ServletActionContext.getRequest()
						.getSession();
				session.setAttribute("recoverUser", username);
				session.setAttribute("recover", "1");

				return SUCCESS;
			} else {
				return INPUT;
			}
		} catch (Exception ex) {
			return ERROR;
		}
	}

	public void validate() {
		if (answer == null)
			this.addFieldError("answer", "密保答案问题不能为空！");
		else {
			User user = userService.getUserByUserName(username);
			String trueAnswer = user.getAnswer();
			String inputAnswer = MD5.toMD5(answer);
			
			if(trueAnswer.equalsIgnoreCase(inputAnswer) == false)
				this.addFieldError("answer", "密保答案错误！为了您的账户安全请重新验证！");
		}
	}
}
