package org.dw.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.dw.service.UserService;
import org.dw.utils.MD5;
import org.dw.utils.MyStringUtils;
import org.dw.model.User;

public class SignupExAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String password2;
	private String question;
	private String answer;
	private String email;
	private String sex;
	private String validatecode;

	private UserService userService;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getValidatecode() {
		return validatecode;
	}

	public void setValidatecode(String validatecode) {
		this.validatecode = validatecode;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		/*
		 * 注册账户的用户对象实体
		 */

		try {
			User user = new User();
			user.setEnabled(true);
			user.setUsername(username);
			user.setPassword(MD5.toMD5(password));
			user.setQuestion(question);
			user.setAnswer(MD5.toMD5(answer));
			user.setEmail(email);
			user.setSex(sex);

			userService.signup(user);
			return SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
			this.addFieldError("username", "用户名已存在");
			return ERROR;
		}
	}

	public void validate() {
		if (username == null) {
			username = username.toLowerCase();
			this.addFieldError("username", "用户名不能为空");
		} else if (username.length() < 6)
			this.addFieldError("username", "用户名长度至少为6位");
		else if (username.length() > 14)
			this.addFieldError("username", "用户名长度至多为14位");
		else if (MyStringUtils.checkUserName(username))
			this.addFieldError("username", "无效的用户名");

		if (email == null)
			this.addFieldError("email", "Email不能为空");
		else if (email.length() > 30)
			this.addFieldError("email", "Email至多为30位");

		if (password == null)
			this.addFieldError("password", "密码不能为空");
		else if (password.length() < 6)
			this.addFieldError("password", "密码长度至少为6位");
		else if (password.length() > 20)
			this.addFieldError("password", "密码长度至多为20位");
		else if (!password.equals(password2))
			this.addFieldError("password", "两次输入的密码不一致");
		else if (MyStringUtils.checkUserPass(password))
			this.addFieldError("password", "无效的密码");

		if (question == null)
			this.addFieldError("question", "密保问题不能为空");
		else if (question.length() < 4)
			this.addFieldError("question", "密保问题至少为4位");
		else if (question.length() > 20)
			this.addFieldError("question", "密保问题至多为20位");

		if (answer == null)
			this.addFieldError("answer", "密保答案不能为空");
		else if (answer.length() < 4)
			this.addFieldError("answer", "密保答案至少为4位");
		else if (answer.length() > 20)
			this.addFieldError("answer", "密保答案至多为20位");

		if (validatecode == null)
			this.addFieldError("validatecode", "验证码不能为空");
		else {
			Map<String, Object> session = ServletActionContext.getContext()
					.getSession();
			String vcode = (String) session.get("vcode");

			if (vcode == null || !validatecode.equalsIgnoreCase(vcode))
				this.addFieldError("validatecode", "验证码错误");
		}
	}
}