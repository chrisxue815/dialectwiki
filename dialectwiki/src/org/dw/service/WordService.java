package org.dw.service;

import java.util.List;

import org.dw.model.Word;

public interface WordService
{
  public static final int WORDS_PER_PAGE = 10; 
  
  public void addWord(Word word);

  public Word getById(int wordIdInt);
  
  public List<Word> searchWords(String wordName, int page);
  
  public Word findByWordName(String wordName);
  
  public List<Word> getHotWords();
  
  public List<Word> getWaitProns();
  
  public List<Word> getRecentWords();
  
  public long getWordNumber();
  
  public void enableWord(Word word);
  
  public void disableWord(Word word);
  
  public List<Word> getPageRecentWords(int pageNo,int pageSize);
  public List<Word> getPageWaitProns(int pageNo,int pageSize);
  public List<Word> getPageHotWords(int pageNo,int pageSize);
  
  public int getHotWordsSize();
  public int getWaitPronsSize();
  public int getRecentWordsSize();

}
