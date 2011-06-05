package org.chris;

import java.util.ArrayList;
import java.util.List;

public class Province
{
  int id;
  String name;
  List<City> cities;
  
  public int getId()
  {
    return id;
  }
  public void setId(int id)
  {
    this.id = id;
  }
  public String getName()
  {
    return name;
  }
  public void setProvinceName(String name)
  {
    this.name = name;
  }
  public List<City> getCities()
  {
    return cities;
  }
  public void setCities(List<City> cities)
  {
    this.cities = cities;
  }
  public void addCity(City city)
  {
    city.setProvince(this);
    cities.add(city);
  }
  
  Province(int id, String name)
  {
    this.id = id;
    this.name = name;
    cities = new ArrayList<City>();
  }
}
