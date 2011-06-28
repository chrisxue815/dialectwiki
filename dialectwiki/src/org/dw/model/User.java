package org.dw.model;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable
{

  // Fields

  private static final long serialVersionUID = 1L;
  
  private Integer userId;
  private String username;
  private String password;
  private Boolean enabled;
  private String email;
  private String sex;
  private String question;
  private String answer;
  private Set pronunciations = new HashSet(0);
  private Set votes = new HashSet(0);
  private Set authorities = new HashSet(0);

  // Constructors

  /** default constructor */
  public User()
  {
  }

  /** minimal constructor */
  public User(String username)
  {
    this.username = username;
  }

  /** full constructor */
  public User(String username, String password, Boolean enabled, String email,
      String sex, Set pronunciations, Set votes, Set authorities)
  {
    this.username = username;
    this.password = password;
    this.enabled = enabled;
    this.email = email;
    this.sex = sex;
    this.pronunciations = pronunciations;
    this.votes = votes;
    this.authorities = authorities;
  }

  // Property accessors

  public Integer getUserId()
  {
    return this.userId;
  }

  public void setUserId(Integer userId)
  {
    this.userId = userId;
  }

  public String getUsername()
  {
    return this.username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getPassword()
  {
    return this.password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public Boolean getEnabled()
  {
    return this.enabled;
  }

  public void setEnabled(Boolean enabled)
  {
    this.enabled = enabled;
  }

  public String getEmail()
  {
    return this.email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getSex()
  {
    return this.sex;
  }

  public void setSex(String sex)
  {
    this.sex = sex;
  }
  
  public String getQuestion()
  {
    return this.question;
  }
  
  public void setQuestion(String question)
  {
    this.question = question;
  }
  
  public String getAnswer()
  {
    return this.answer;
  }
  
  public void setAnswer(String answer)
  {
    this.answer = answer;
  }

  public Set getPronunciations()
  {
    return this.pronunciations;
  }

  public void setPronunciations(Set pronunciations)
  {
    this.pronunciations = pronunciations;
  }

  public Set getVotes()
  {
    return this.votes;
  }

  public void setVotes(Set votes)
  {
    this.votes = votes;
  }

  public Set getAuthorities()
  {
    return this.authorities;
  }

  public void setAuthorities(Set authorities)
  {
    this.authorities = authorities;
  }

}