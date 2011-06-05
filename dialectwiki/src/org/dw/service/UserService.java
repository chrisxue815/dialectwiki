package org.dw.service;

import org.dw.model.User;

public interface UserService
{
  public void signup(User user);
  public User getUserByUserName(String userName);
}
