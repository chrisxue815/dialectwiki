package org.dw.model;

/**
 * Word entity. @author MyEclipse Persistence Tools
 */

public class Word implements java.io.Serializable
{

  // Fields

  private static final long serialVersionUID = 1L;
  private Integer wordId;
  private String wordName;

  // Constructors

  /** default constructor */
  public Word()
  {
  }

  /** full constructor */
  public Word(String wordName)
  {
    this.wordName = wordName;
  }

  // Property accessors

  public Integer getWordId()
  {
    return this.wordId;
  }

  public void setWordId(Integer wordId)
  {
    this.wordId = wordId;
  }

  public String getWordName()
  {
    return this.wordName;
  }

  public void setWordName(String wordName)
  {
    this.wordName = wordName;
  }

}