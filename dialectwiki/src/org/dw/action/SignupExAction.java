package org.dw.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.dw.service.UserService;
import org.dw.utils.MD5;
import org.dw.model.User;

public class SignupExAction extends ActionSupport
{

  private static final long serialVersionUID = 1L;
  private String username;
  private String password;
  private String password2;
  private String email;
  private String sex;
  private String validatecode;

  private UserService userService;

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

  public String getSex()
  {
    return sex;
  }

  public void setSex(String sex)
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

    try
    {
      User user = new User();
      user.setEnabled(true);
      user.setUsername(username);
      user.setPassword(MD5.toMD5(password));
      user.setEmail(email);
      user.setSex(sex);
      
      userService.signup(user);
      return SUCCESS;
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
      this.addFieldError("username", "用户名已存在");
      return ERROR;
    }
  }
  
  public void validate()
  {
    if (username == null)
      this.addFieldError("username", "用户名不能为空");
    else if (username.length() < 6)
      this.addFieldError("username", "用户名长度至少为6位");
    
    if (email == null)
      this.addFieldError("email", "Email不能为空");
    
    if (password == null)
      this.addFieldError("password", "密码不能为空");
    else if (password.length() < 6)
      this.addFieldError("password", "密码长度至少为6位");
    else if (!password.equals(password2))
      this.addFieldError("password", "两次输入的密码不一致");
    
    if (validatecode == null)
      this.addFieldError("validatecode", "验证码不能为空");
    else
    {
      Map<String, Object> session = ServletActionContext.getContext().getSession();
      String vcode = (String)session.get("vcode");
      
      if (vcode == null || !validatecode.equalsIgnoreCase(vcode))
        this.addFieldError("validatecode", "验证码错误");
    }
    
   /* try
    {
      new EmailValidator().validate(email);
    } catch (ValidationException e)
    {
      e.printStackTrace();
      this.addFieldError("email", "邮箱格式不正确");
    }*/
  }
}