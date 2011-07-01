package org.dw.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.dw.model.User;
import org.dw.service.UserService;
import org.dw.utils.MD5;
import org.dw.utils.MyStringUtils;

import com.opensymphony.xwork2.ActionSupport;

public class RecoverStep4Action extends ActionSupport
{
  private static final long serialVersionUID = 1L;

  private String password;
  private String password2;
  private UserService userService;

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

  public UserService getUserService()
  {
    return userService;
  }

  public void setUserService(UserService userService)
  {
    this.userService = userService;
  }
  

  public String execute()
  {
    try
    {
      HttpSession session = ServletActionContext.getRequest().getSession();
      String userName = (String) session.getAttribute("recoverUser");
      User user = userService.getUserByUserName(userName);
      
      if (session.getAttribute("recover").equals("1"))
      {
        session.setAttribute("recover", "0");
        
        user.setPassword(MD5.toMD5(password));
        userService.update(user);
        
        return SUCCESS;
      }
    }
    catch (Exception ex)
    {
      return ERROR;
    }
    
    return ERROR;
  }
  
  public void validate()
  {
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
  }
}
