package org.dw.action;

import java.util.List;

import org.dw.model.Word;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class WordIndexAction extends ActionSupport
{

  private static final long serialVersionUID = -1524961208097493937L;

  private WordService wordService;

  // 最近的词条
  private List<Word> recentWords;

  // 热门词条
  private List<Word> hotWords;
  
  //待发音的词条
  private List<Word> waitProns;
  

  private Word word;

  
  public List<Word> getWaitProns() {
	return waitProns;
  }

  public void setWaitProns(List<Word> waitProns) 
  {
	this.waitProns = waitProns;
  }

  public Word getWord()
  {
	 return word;
  }

  public void setWord(Word word)
  {
    this.word = word;
  }

  public WordService getWordService()
  {
    return wordService;
  }

  public void setWordService(WordService wordService)
  {
    this.wordService = wordService;
  }

  public List<Word> getRecentWords()
  {
    return recentWords;
  }

  public void setRecentWords(List<Word> recentWords)
  {
    this.recentWords = recentWords;
  }

  public List<Word> getHotWords()
  {
    return hotWords;
  }

  public void setHotWords(List<Word> hotWords)
  {
    this.hotWords = hotWords;
  }

  public String execute()
  {
	hotWords = wordService.getHotWords(); 
	recentWords = wordService.getRecentWords(); 
	waitProns = wordService.getWaitProns();

	
    return SUCCESS;
  }

}
