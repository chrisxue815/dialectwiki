package org.dw.model;

/**
 * Authority entity. @author MyEclipse Persistence Tools
 */

public class Authority implements java.io.Serializable
{

  // Fields

  /**
	 * 
	 */
  private static final long serialVersionUID = 8758261508711036055L;
  
  private String username;
  private String authority;

  // Constructors

  /** default constructor */
  public Authority()
  {
  }

  /** full constructor */
  public Authority(String username, String authority)
  {
    this.username = username;
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

  public String getAuthority()
  {
    return this.authority;
  }

  public void setAuthority(String authority)
  {
    this.authority = authority;
  }

}