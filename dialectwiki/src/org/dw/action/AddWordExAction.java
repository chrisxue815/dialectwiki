package org.dw.action;

import org.dw.model.Word;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class AddWordExAction extends ActionSupport
{
  public static final String WORDNAME_REQUIRED = "wordnameRequired";

  private static final long serialVersionUID = 1L;

  private String wordname;
  private Word word;
  private WordService wordService;

  public String getWordname() {
    return wordname;
  }
  public void setWordname(String wordname) {
    this.wordname = wordname;
  }
  public Word getWord() {
    return word;
  }
  public void setWord(Word word) {
    this.word = word;
  }
  public WordService getWordService() {
    return wordService;
  }
  public void setWordService(WordService wordService) {
    this.wordService = wordService;
  }

  public String execute()
  {
    if (wordname == null)
      return WORDNAME_REQUIRED;
    
    word = new Word();
    word.setWordName(wordname);
    word.setEnabled(true);

    try
    {
      wordService.addWord(word);
      
      return SUCCESS;
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
      
      return ERROR;
    }
  }

  public void validate()
  {

  }
}
