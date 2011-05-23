package org.dw.action;

import com.opensymphony.xwork2.ActionSupport;
import org.dw.utils.MD5;
import org.dw.model.User;
public class SignupAction extends ActionSupport {
	String username;
	String password;
	String password2;
	String email;
	char sex;
	String validatecode;
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

	public int getSex() {
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
		//System.out.println("excute invoked");
		
		/*
		 * ע���˻����û�����ʵ��
		 */
		User user = new User();
		user.setEnable(true);
		user.setUsername(username);
		user.setPassword(MD5.toMD5(password));
		user.setEmail(email);
		
		
		
		
		return SUCCESS;
	}

	public void validate() {
		
		times++;
		System.out.println("validate invoked!");
		System.out.println("���ύ" + times + "��");
		System.out.println("username :" + username);
		System.out.println("password :" + password);
		System.out.println("password2:" + password2);
		System.out.println("email    :" + email);
		System.out.println("valcode  :" + validatecode);
		
	
		/*
		 *�û�����֤ 
		 */
		if(null == username)
			this.addFieldError(username, "username blank!");
		if(username.length() < 5 || username.length() > 20)
			this.addFieldError(username, "username length should between 6 and 20!");
		
		
		/*
		 *������֤ 
		 */
		if(null == password)
			this.addFieldError(password, "password blank!");
		if(password.length() < 4 || password.length() > 20)
			this.addFieldError(password, "password lenght should between 6 and 20!");
		
		/*
		 *ȷ��������֤ 
		 */
		if(null == password2)
			this.addFieldError(password2, "confirm password blank!");
		if(password.equals(password2) ==  false)
			this.addFieldError(password2, "�����������벻һ�£�");
		
		/*
		 * ������֤
		 */
		if(null == email)
			this.addFieldError(email, "���䲻��Ϊ�գ�");
		
		/*
		 * ��֤����֤
		 */
		if(null == validatecode)
			this.addFieldError(validatecode, "validatecode blank!");
		
	}
	
	
	

}
