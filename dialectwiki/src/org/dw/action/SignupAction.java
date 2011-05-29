package org.dw.action;

import com.opensymphony.xwork2.ActionSupport;

import org.dw.service.UserService;
import org.dw.utils.MD5;
import org.dw.model.User;

public class SignupAction extends ActionSupport
{

  private static final long serialVersionUID = 1L;
  private String username;
  private String password;
  private String password2;
  private String email;
  private char sex;
  private String validatecode;

  private UserService userService;

  public static int times = 0;

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getPassword2()
  {
    return password2;
  }

  public void setPassword2(String password2)
  {
    this.password2 = password2;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public char getSex()
  {
    return sex;
  }

  public void setSex(char sex)
  {
    this.sex = sex;
  }

  public String getValidatecode()
  {
    return validatecode;
  }

  public void setValidatecode(String validatecode)
  {
    this.validatecode = validatecode;
  }

  public UserService getUserService()
  {
    return userService;
  }

  public void setUserService(UserService userService)
  {
    this.userService = userService;
  }

  @Override
  public String execute() throws Exception
  {
    /*
     * 注册账户的用户对象实体
     */
    User user = new User();
    user.setEnabled(true);
    user.setUsername(username);
    user.setPassword(MD5.toMD5(password));
    user.setEmail(email);
    user.setSex(sex);

    if (userService.signup(user))
      return SUCCESS;
    else
      return INPUT;
  }
}