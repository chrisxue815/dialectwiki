package org.dw.dao;

import java.util.List;

import org.dw.model.Authority;
import org.dw.model.User;

public interface AuthorityDAO
{

  // property constants
  public static final String AUTHORITY = "authority";
  
  public void save(Authority transientInstance);

  public void delete(Authority persistentInstance);

  public Authority findById(java.lang.String id);

  public List<Authority> findByExample(Authority instance);

  public List<Authority> findByProperty(String propertyName, Object value);

  public List<Authority> findByAuthority(Object authority);

  public List<Authority> findAll();

  public Authority merge(Authority detachedInstance);

  public void attachDirty(Authority instance);

  public void attachClean(Authority instance);
  
  public void enableUserRole(User user);
  
  public void disableUserRole(User user);

}