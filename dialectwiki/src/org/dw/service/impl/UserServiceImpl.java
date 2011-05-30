package org.dw.service.impl;

import org.dw.dao.AuthorityDAO;
import org.dw.dao.UserDAO;
import org.dw.model.Authority;
import org.dw.service.UserService;
import org.dw.macro.MACRO_USER;
import org.dw.model.User;

public class UserServiceImpl implements UserService
{
  private UserDAO userDAO;
  private AuthorityDAO authorityDAO;

  public UserDAO getUserDAO()
  {
    return userDAO;
  }

  public void setUserDAO(UserDAO userDAO)
  {
    this.userDAO = userDAO;
  }

  public AuthorityDAO getAuthorityDAO()
  {
    return authorityDAO;
  }

  public void setAuthorityDAO(AuthorityDAO authorityDAO)
  {
    this.authorityDAO = authorityDAO;
  }

  public boolean signup(User user)
  {
    Authority authorities = new Authority(user,
        MACRO_USER.ROLE_USER);
    return (userDAO.signup(user) && authorityDAO.setAuthority(authorities));
  }
}
