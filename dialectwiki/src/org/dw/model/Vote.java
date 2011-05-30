package org.dw.model;

/**
 * Vote entity. @author MyEclipse Persistence Tools
 */

public class Vote implements java.io.Serializable
{

  // Fields

  private static final long serialVersionUID = 3170597088678928139L;

  
  private VoteId id;
  private Integer mark;

  // Constructors

  /** default constructor */
  public Vote()
  {
  }

  /** minimal constructor */
  public Vote(VoteId id)
  {
    this.id = id;
  }

  /** full constructor */
  public Vote(VoteId id, Integer mark)
  {
    this.id = id;
    this.mark = mark;
  }

  // Property accessors

  public VoteId getId()
  {
    return this.id;
  }

  public void setId(VoteId id)
  {
    this.id = id;
  }

  public Integer getMark()
  {
    return this.mark;
  }

  public void setMark(Integer mark)
  {
    this.mark = mark;
  }

}