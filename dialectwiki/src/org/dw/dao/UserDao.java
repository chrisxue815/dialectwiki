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

  public void save(User transientInstance);

  public void delete(User persistentInstance);

  public User findById(java.lang.Integer id);

  public List findByExample(User instance);

  public List findByProperty(String propertyName, Object value);

  public List findByUsername(Object username);

  public List findByPassword(Object password);

  public List findByEnabled(Object enabled);

  public List findByEmail(Object email);

  public List findBySex(Object sex);

  public List findAll();

  public User merge(User detachedInstance);

  public void attachDirty(User instance);

  public void attachClean(User instance);

}