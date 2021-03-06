package org.dw.dao;

import java.util.List;

import org.dw.model.User;

public interface UserDAO
{

  // property constants
  public static final String USERNAME = "username";
  public static final String PASSWORD = "password";
  public static final String ENABLED = "enabled";
  public static final String EMAIL = "email";
  public static final String SEX = "sex";
  public static final String QUESTION = "question";
  public static final String ANSWER = "answer";

  public void save(User transientInstance);

  public void delete(User persistentInstance);

  public User findById(java.lang.Integer id);

  public List<User> findByExample(User instance);

  public List<User> findByProperty(String propertyName, Object value);

  public List<User> findByUsername(Object username);

  public List<User> findByPassword(Object password);

  public List<User> findByEnabled(Object enabled);

  public List<User> findByEmail(Object email);

  public List<User> findBySex(Object sex);

  public List<User> findAll();

  public User merge(User detachedInstance);
  
  public void update(User user);

  public void attachDirty(User instance);

  public void attachClean(User instance);
  
  public List<User> findNBUsers();
  
  public List<User> findNBUsers(int listSize);
  
  public List<User> findGOODUsers();
  
  public List<User> findGOODUsers(int listSize);
  
  public void enableUser(User user);
  public void disableUser(User user);
  

  
  

}