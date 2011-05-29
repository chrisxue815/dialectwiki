package org.dw.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Word entity. @author MyEclipse Persistence Tools
 */

public class Word implements java.io.Serializable
{

  private static final long serialVersionUID = 1L;
  private Integer wordId;
  private String wordName;

  public Word()
  {
	  
  }
  public Word(String wordName)
  {
    this.wordName = wordName;
  }


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