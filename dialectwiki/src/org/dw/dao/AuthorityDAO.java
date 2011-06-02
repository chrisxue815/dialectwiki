package org.dw.dao;

import java.util.List;

import org.dw.model.Authority;

public interface AuthorityDAO
{

  // property constants
  public static final String AUTHORITY = "authority";

  public void save(Authority transientInstance);

  public void delete(Authority persistentInstance);

  public Authority findById(java.lang.String id);

  public List findByExample(Authority instance);

  public List findByProperty(String propertyName, Object value);

  public List findByAuthority(Object authority);

  public List findAll();

  public Authority merge(Authority detachedInstance);

  public void attachDirty(Authority instance);

  public void attachClean(Authority instance);

}