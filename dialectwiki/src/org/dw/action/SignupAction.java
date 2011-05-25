package org.dw.action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.components.FieldError;
import org.dw.service.SignupService;
import org.dw.utils.MD5;
import org.dw.model.Authorities;
import org.dw.model.User;


public class SignupAction extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
    private String username;
    private	String password;
    private	String password2;
    private	String email;
    private	char sex;
    private	String validatecode;
    
    private SignupService signupService;
    
	public SignupService getSignupService() {
		return signupService;
	}

	public void setSignupService(SignupService signupService) {
		this.signupService = signupService;
	}

	public static int times = 0;
	
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getValidatecode() {
		return validatecode;
	}

	public void setValidatecode(String validatecode) {
		this.validatecode = validatecode;
	}

	
	@Override
	public String execute() throws Exception {
		//System.out.println("execute invoked");
		
		/*
		 * 注册账户的用户对象实体
		 */
		User user = new User();
		user.setEnabled(true);
		user.setUsername(username);
		user.setPassword(MD5.toMD5(password));
		user.setEmail(email);
		user.setSex(sex);
		
		Authorities authorities = new Authorities(username, "ROLE_USER");
		
		if(signupService.signup(user))
			return SUCCESS;
		else
			return INPUT;
	}

	public void validate() {
		this.getFieldErrors().clear();	
		/*
		 *用户名验证 
		 */
		if(null == username)
			this.addFieldError(username, "username blank!");
		if(username.length() < 5 || username.length() > 20)
			this.addFieldError(username, "username length should between 6 and 20!");
		
		/*
		 *密码验证 
		 */
		if(null == password)
			this.addFieldError(password, "password blank!");
		if(password.length() < 4 || password.length() > 20)
			this.addFieldError(password, "password lenght should between 6 and 20!");
		
		/*
		 *确认密码验证 
		 */
		if(null == password2)
			this.addFieldError(password2, "confirm password blank!");
		if(password.equals(password2) ==  false)
			this.addFieldError(password2, "两次输入密码不一致！");
		
		/*
		 * 邮箱验证
		 */
		if(null == email)
			this.addFieldError(email, "邮箱不能为空！");
		
		/*
		 * 验证码验证
		 */
		if(null == validatecode)
			this.addFieldError(validatecode, "validatecode blank!");
		
	}
	
}
