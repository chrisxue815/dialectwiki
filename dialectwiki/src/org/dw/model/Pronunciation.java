package org.dw.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Pronunciation entity. @author MyEclipse Persistence Tools
 */

public class Pronunciation implements java.io.Serializable
{

  // Fields

  private Integer pronId;
  private Word word;
  private User user;
  private City city;
  private String prUrl;
  private Date uploadDate;
  private Integer goodVoteNum;
  private Integer badVoteNum;
  private Set votes = new HashSet(0);

  // Constructors

  /** default constructor */
  public Pronunciation()
  {
  }

  /** minimal constructor */
  public Pronunciation(Word word, User user, City city, Integer goodVoteNum,
      Integer badVoteNum)
  {
    this.word = word;
    this.user = user;
    this.city = city;
    this.goodVoteNum = goodVoteNum;
    this.badVoteNum = badVoteNum;
  }

  /** full constructor */
  public Pronunciation(Word word, User user, City city, String prUrl,
      Date uploadDate, Integer goodVoteNum, Integer badVoteNum, Set votes)
  {
    this.word = word;
    this.user = user;
    this.city = city;
    this.prUrl = prUrl;
    this.uploadDate = uploadDate;
    this.goodVoteNum = goodVoteNum;
    this.badVoteNum = badVoteNum;
    this.votes = votes;
  }

  // Property accessors

  public Integer getPronId()
  {
    return this.pronId;
  }

  public void setPronId(Integer pronId)
  {
    this.pronId = pronId;
  }

  public Word getWord()
  {
    return this.word;
  }

  public void setWord(Word word)
  {
    this.word = word;
  }

  public User getUser()
  {
    return this.user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

  public City getCity()
  {
    return this.city;
  }

  public void setCity(City city)
  {
    this.city = city;
  }

  public String getPrUrl()
  {
    return this.prUrl;
  }

  public void setPrUrl(String prUrl)
  {
    this.prUrl = prUrl;
  }

  public Date getUploadDate()
  {
    return this.uploadDate;
  }

  public void setUploadDate(Date uploadDate)
  {
    this.uploadDate = uploadDate;
  }

  public Integer getGoodVoteNum()
  {
    return this.goodVoteNum;
  }

  public void setGoodVoteNum(Integer goodVoteNum)
  {
    this.goodVoteNum = goodVoteNum;
  }

  public Integer getBadVoteNum()
  {
    return this.badVoteNum;
  }

  public void setBadVoteNum(Integer badVoteNum)
  {
    this.badVoteNum = badVoteNum;
  }

  public Set getVotes()
  {
    return this.votes;
  }

  public void setVotes(Set votes)
  {
    this.votes = votes;
  }

}