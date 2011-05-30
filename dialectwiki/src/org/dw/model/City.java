package org.dw.model;

import java.util.HashSet;
import java.util.Set;

/**
 * City entity. @author MyEclipse Persistence Tools
 */

public class City implements java.io.Serializable
{

  // Fields

  private Integer cityId;
  private Province province;
  private String cityName;
  private Set pronunciations = new HashSet(0);

  // Constructors

  /** default constructor */
  public City()
  {
  }

  /** minimal constructor */
  public City(Province province)
  {
    this.province = province;
  }

  /** full constructor */
  public City(Province province, String cityName, Set pronunciations)
  {
    this.province = province;
    this.cityName = cityName;
    this.pronunciations = pronunciations;
  }

  // Property accessors

  public Integer getCityId()
  {
    return this.cityId;
  }

  public void setCityId(Integer cityId)
  {
    this.cityId = cityId;
  }

  public Province getProvince()
  {
    return this.province;
  }

  public void setProvince(Province province)
  {
    this.province = province;
  }

  public String getCityName()
  {
    return this.cityName;
  }

  public void setCityName(String cityName)
  {
    this.cityName = cityName;
  }

  public Set getPronunciations()
  {
    return this.pronunciations;
  }

  public void setPronunciations(Set pronunciations)
  {
    this.pronunciations = pronunciations;
  }

}