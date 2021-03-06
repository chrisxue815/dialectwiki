package org.dw.service;

import java.util.List;
import java.util.Set;

import org.dw.model.Authority;
import org.dw.model.Pronunciation;
import org.dw.model.User;

public interface UserService
{
  public void signup(User user);
  public void update(User user);
  public User getUserByUserName(String userName);
  public Set<Pronunciation> getUserProns(String userName);
  public List<User> getNBUsers(int listSize);
  public List<User> getNBUsers();
  public User getUserById(int userId);
  public List<User> getGOODUsers(int listSize);
  public List<User> getGOODUsers();
  
  public void enableUser(User user);
  public void disableUser(User user);
  
  public Authority getUserAuthority(User user);
}
