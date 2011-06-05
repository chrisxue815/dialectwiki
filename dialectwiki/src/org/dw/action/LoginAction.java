package org.dw.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;
  
  private String signupSuccess;

  public String getSignupSuccess()
  {
    return signupSuccess;
  }

  public void setSignupSuccess(String signupSuccess)
  {
    this.signupSuccess = signupSuccess;
  }
  
  public String execute()
  {
    return SUCCESS;
  }
}
