package org.dw.action;

import java.util.List;

import org.dw.model.Word;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class SearchWordAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;

  private String wordName;
  private WordService wordService;
  private List<Word> words;

  public String getWordName()
  {
    return wordName;
  }

  public void setWordName(String wordName)
  {
    this.wordName = wordName;
  }

  public WordService getWordService()
  {
    return wordService;
  }

  public void setWordService(WordService wordService)
  {
    this.wordService = wordService;
  }

  public List<Word> getWords()
  {
    return words;
  }

  public void setWords(List<Word> words)
  {
    this.words = words;
  }

  public String execute()
  {
    try
    {
      words = wordService.searchWord(wordName);
      return SUCCESS;
    } catch (Exception ex)
    {
      ex.printStackTrace();
      return ERROR;
    }
  }
}
