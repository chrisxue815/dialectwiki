package org.dw.dao;

import java.util.List;

import org.dw.model.City;

public interface CityDAO
{

  // property constants
  public static final String CITY_NAME = "cityName";

  public void save(City transientInstance);

  public void delete(City persistentInstance);

  public City findById(java.lang.Integer id);

  public List<City> findByExample(City instance);

  public List<City> findByProperty(String propertyName, Object value);

  public List<City> findByCityName(Object cityName);

  public List<City> findAll();

  public City merge(City detachedInstance);

  public void attachDirty(City instance);

  public void attachClean(City instance);

}