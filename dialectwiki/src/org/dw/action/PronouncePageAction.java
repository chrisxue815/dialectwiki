package org.dw.action;

import org.dw.model.Word;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class PronouncePageAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;
  private String wordId;
  private Word word;
  private WordService wordService;
  
  public String getWordId() {
    return wordId;
  }

  public void setWordId(String wordId) {
    this.wordId = wordId;
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
    if (wordId == null)
      return INPUT;
    
    try
    {
      int wordIdInt = Integer.parseInt(wordId);
      word = wordService.getById(wordIdInt);
      
      if (word == null)
        return ERROR;
      else
        return SUCCESS;
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
      return SUCCESS;
    }
  }
}
