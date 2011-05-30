package org.dw.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Pronunciation entity. @author MyEclipse Persistence Tools
 */

public class Pronunciation implements java.io.Serializable
{
	private static final long serialVersionUID = 5914756326088583626L;
// Fields

  private Integer pronId;
  private City city;
  private Integer userId;
  private Integer wordId;
  private String prUrl;
  private Date uploadDate;
  private Integer goodVoteNum;
  private Integer badVoteNum;


  private Set<Vote> votes = new HashSet<Vote>();

  // Constructors

  /** default constructor */
  public Pronunciation()
  {
  }

  /** minimal constructor */
  public Pronunciation(City city, Integer userId, Integer wordId,
      Integer goodVoteNum, Integer badVoteNum)
  {
    this.city = city;
    this.userId = userId;
    this.wordId = wordId;
    this.goodVoteNum = goodVoteNum;
    this.badVoteNum = badVoteNum;
  }

  /** full constructor */
  public Pronunciation(City city, Integer userId, Integer wordId, String prUrl,
      Date uploadDate, Integer goodVoteNum, Integer badVoteNum, Set<Vote> votes)
  {
    this.city = city;
    this.userId = userId;
    this.wordId = wordId;
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

  public City getCity()
  {
    return this.city;
  }

  public void setCity(City city)
  {
    this.city = city;
  }

  public Integer getUserId()
  {
    return this.userId;
  }

  public void setUserId(Integer userId)
  {
    this.userId = userId;
  }

  public Integer getWordId()
  {
    return this.wordId;
  }

  public void setWordId(Integer wordId)
  {
    this.wordId = wordId;
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

  public Set<Vote> getVotes()
  {
    return this.votes;
  }

  public void setVotes(Set<Vote> votes)
  {
    this.votes = votes;
  }

}