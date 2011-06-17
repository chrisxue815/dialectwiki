package org.dw.dao;

import java.util.List;

import org.dw.model.Province;

public interface ProvinceDAO
{

  // property constants
  public static final String PROVINCE_NAME = "provinceName";

  public void save(Province transientInstance);

  public void delete(Province persistentInstance);

  public Province findById(java.lang.Integer id);

  public List<Province> findByExample(Province instance);

  public List<Province> findByProperty(String propertyName, Object value);

  public List<Province> findByProvinceName(Object provinceName);

  public List<Province> findAll();

  public Province merge(Province detachedInstance);

  public void attachDirty(Province instance);

  public void attachClean(Province instance);
  
  

}