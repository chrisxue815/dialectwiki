package org.dw.model;

import java.util.HashSet;
import java.util.Set;

/**
 * City entity. @author MyEclipse Persistence Tools
 */

public class City implements java.io.Serializable
{
  private static final long serialVersionUID = -3575605849678714826L;
  
  private Integer cityId;
  private String cityName;
  
  private Province province;
  private Set<Pronunciation> pronunciations = new HashSet<Pronunciation>();

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
  public City(Province province, String cityName, Set<Pronunciation> pronunciations)
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

  public Set<Pronunciation> getPronunciations()
  {
    return this.pronunciations;
  }

  public void setPronunciations(Set<Pronunciation> pronunciations)
  {
    this.pronunciations = pronunciations;
  }

}