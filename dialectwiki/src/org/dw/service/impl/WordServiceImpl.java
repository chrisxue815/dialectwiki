package org.dw.service.impl;

import java.util.List;

import org.dw.dao.WordDAO;
import org.dw.model.Word;
import org.dw.service.WordService;

public class WordServiceImpl implements WordService
{
  private WordDAO wordDAO;
  public static final int LIST_SIZE = 15;

  public WordDAO getWordDAO()
  {
    return wordDAO;
  }

  public void setWordDAO(WordDAO wordDAO)
  {
    this.wordDAO = wordDAO;
  }

  public void addWord(Word word)
  {
    wordDAO.save(word);
  }
  
  public Word getById(int wordIdInt)
  {
    return wordDAO.findById(wordIdInt);
  }
  
  public List<Word> searchWords(String wordName, int page)
  {
    int index = WORDS_PER_PAGE * (page - 1);
    
    List<Word> words = wordDAO.searchSimilarWords(wordName, index, WORDS_PER_PAGE);
    
    Word word = findByWordName(wordName);
    
    if (word != null)
      words.add(0, word);
    
    return words;
  }
  
  public Word findByWordName(String wordName)
  {
    List<Word> words = wordDAO.findByWordName(wordName);
    
    if (words.size() == 1)
    {
      return words.get(0);
    }
    else
    {
      return null;
    }
  }
  
  public List<Word> getHotWords()
  {
	  return wordDAO.getHotWords(LIST_SIZE);
  }
  
  public List<Word> getWaitProns()
  {
	  return wordDAO.getWaitProns(LIST_SIZE);
  }
  
  public List<Word> getRecentWords()
  {
	  return wordDAO.getRecentWords(LIST_SIZE);
  }

  public long getWordNumber()
  {
    return wordDAO.getWordNumber();
  }
  
  public void enableWord(Word word)
  {
	 wordDAO.enableWord(word);
  }
  
  public void disableWord(Word word)
  {
	  wordDAO.disableWord(word);
  }
  
  public List<Word> getPageRecentWords(int pageNo,int pageSize)
  {
	  return wordDAO.getPageRecentWords(pageNo, pageSize);
  }
  
  public List<Word> getPageWaitProns(int pageNo,int pageSize)
  {
	  return wordDAO.getPageWaitProns(pageNo, pageSize);
  }
  
  public List<Word> getPageHotWords(int pageNo,int pageSize)
  {
	  return wordDAO.getPageHotWords(pageNo, pageSize);
  }
  
  public int getHotWordsSize()
  {
	  return wordDAO.getHotWordsSize();
  }
  
  public int getWaitPronsSize()
  {
	  return wordDAO.getWaitPronsSize();
  }
  
  public int getRecentWordsSize()
  {
	  return wordDAO.getRecentWordsSize();
  }
  
}
