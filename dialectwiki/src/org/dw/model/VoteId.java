package org.dw.model;

/**
 * VoteId entity. @author MyEclipse Persistence Tools
 */

public class VoteId implements java.io.Serializable
{

  private static final long serialVersionUID = -7866922824907181800L;
  
  private Integer userId;
  private Pronunciation pronunciation;

  // Constructors

  /** default constructor */
  public VoteId()
  {
  }

  /** full constructor */
  public VoteId(Integer userId, Pronunciation pronunciation)
  {
    this.userId = userId;
    this.pronunciation = pronunciation;
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

  public Pronunciation getPronunciation()
  {
    return this.pronunciation;
  }

  public void setPronunciation(Pronunciation pronunciation)
  {
    this.pronunciation = pronunciation;
  }

  public boolean equals(Object other)
  {
    if ((this == other))
      return true;
    if ((other == null))
      return false;
    if (!(other instanceof VoteId))
      return false;
    VoteId castOther = (VoteId) other;

    return ((this.getUserId() == castOther.getUserId()) || (this.getUserId() != null
        && castOther.getUserId() != null && this.getUserId().equals(
        castOther.getUserId())))
        && ((this.getPronunciation() == castOther.getPronunciation()) || (this
            .getPronunciation() != null
            && castOther.getPronunciation() != null && this.getPronunciation()
            .equals(castOther.getPronunciation())));
  }

  public int hashCode()
  {
    int result = 17;

    result = 37 * result
        + (getUserId() == null ? 0 : this.getUserId().hashCode());
    result = 37 * result
        + (getPronunciation() == null ? 0 : this.getPronunciation().hashCode());
    return result;
  }

}