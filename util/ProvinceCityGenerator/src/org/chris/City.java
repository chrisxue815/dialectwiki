package org.chris;

public class City
{
  int id;
  String name;
  Province province;
  
  public int getId()
  {
    return id;
  }
  public void setCityId(int id)
  {
    this.id = id;
  }
  public String getName()
  {
    return name;
  }
  public void setCityName(String name)
  {
    this.name = name;
  }
  public Province getProvince()
  {
    return province;
  }
  public void setProvince(Province province)
  {
    this.province = province;
  }
  
  City(int id, String name, Province province)
  {
    this.id = id;
    this.name = name;
    this.province = province;
  }
}
