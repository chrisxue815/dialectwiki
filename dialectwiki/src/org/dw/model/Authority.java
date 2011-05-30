package org.dw.model;

/**
 * Authority entity. @author MyEclipse Persistence Tools
 */

public class Authority implements java.io.Serializable
{

  // Fields

  private String username;
  private User user;
  private String authority;

  // Constructors

  /** default constructor */
  public Authority()
  {
  }

  /** full constructor */
  public Authority(User user, String authority)
  {
    this.user = user;
    this.authority = authority;
  }

  // Property accessors

  public String getUsername()
  {
    return this.username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public User getUser()
  {
    return this.user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

  public String getAuthority()
  {
    return this.authority;
  }

  public void setAuthority(String authority)
  {
    this.authority = authority;
  }

}