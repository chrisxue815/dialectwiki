package org.dw.action;

import org.dw.model.Word;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class PronouncePageAction extends ActionSupport
{
  public static final String NAME_NOT_EXIST = "nameNotExist";
  
  private static final long serialVersionUID = 1L;
  private String id;
  private String name;
  private Word word;
  private WordService wordService;
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public WordService getWordService() {
    return wordService;
  }

  public void setWordService(WordService wordService) {
    this.wordService = wordService;
  }
  
  public Word getWord() {
    return word;
  }

  public void setWord(Word word) {
    this.word = word;
  }
  
  public String execute()
  {
    try
    {
      if (id != null)
      {
        int wordIdInt = Integer.parseInt(id);
        word = wordService.getById(wordIdInt);
        if (word == null)
          return ERROR;
      }
      else if (name != null)
      {
        word = wordService.findByWordName(name);
        if (word == null)
          return NAME_NOT_EXIST;
        id = word.getWordId().toString();
      }
      else
        return SUCCESS;
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
      return ERROR;
    }
    return SUCCESS;
  }
}
