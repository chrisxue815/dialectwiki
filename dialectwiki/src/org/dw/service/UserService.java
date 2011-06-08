package org.dw.service;

import java.util.Set;

import org.dw.model.Pronunciation;
import org.dw.model.User;

public interface UserService
{
  public void signup(User user);
  public User getUserByUserName(String userName);
  public Set<Pronunciation> getUserProns(String userName);
}
