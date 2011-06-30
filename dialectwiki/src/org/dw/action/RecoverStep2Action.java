package org.dw.action;

import com.opensymphony.xwork2.ActionSupport;

import org.dw.model.User;
import org.dw.service.UserService;

public class RecoverStep2Action extends ActionSupport
{
  private static final long serialVersionUID = 1L;
  
  private String userName;
  private UserService userService;
  
  private String question;

  public String getUserName()
  {
    return userName;
  }

  public void setUsername(String userName)
  {
    this.userName = userName;
  }
  
  public UserService getUserService()
  {
    return userService;
  }

  public void setUserService(UserService userService)
  {
    this.userService = userService;
  }

  public String getQuestion()
  {
    return question;
  }

  public void setQuestion(String question)
  {
    this.question = question;
  }

  
  public String execute()
  {
    try
    {
      User user = userService.getUserByUserName(userName);
      question = user.getQuestion();
      
      return SUCCESS;
    }
    catch (Exception ex)
    {
      return ERROR;
    }
  }
}
