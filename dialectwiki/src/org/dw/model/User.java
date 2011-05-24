package org.dw.model;

public class User {
	String username;
	String password;
	boolean enable;
	String email;
	char Sex;
	
	public User(){}
	
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
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getSex() {
		return Sex;
	}
	public void setSex(char sex) {
		Sex = sex;
	}
	
	
}
