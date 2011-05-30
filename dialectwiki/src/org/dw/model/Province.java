package org.dw.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Province entity. @author MyEclipse Persistence Tools
 */

public class Province implements java.io.Serializable
{

  // Fields
  private static final long serialVersionUID = -7014295089933073427L;
  
  private Integer provinceId;
  private String provinceName;
  private Set<City> cities = new HashSet<City>();

  // Constructors

  /** default constructor */
  public Province()
  {
  }

  /** full constructor */
  public Province(String provinceName, Set<City> cities)
  {
    this.provinceName = provinceName;
    this.cities = cities;
  }

  // Property accessors

  public Integer getProvinceId()
  {
    return this.provinceId;
  }

  public void setProvinceId(Integer provinceId)
  {
    this.provinceId = provinceId;
  }

  public String getProvinceName()
  {
    return this.provinceName;
  }

  public void setProvinceName(String provinceName)
  {
    this.provinceName = provinceName;
  }

  public Set<City> getCities()
  {
    return this.cities;
  }

  public void setCities(Set<City> cities)
  {
    this.cities = cities;
  }

}