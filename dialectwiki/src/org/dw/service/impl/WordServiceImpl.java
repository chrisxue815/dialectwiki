package org.dw.service.impl;

import java.util.List;

import org.dw.dao.WordDAO;
import org.dw.model.Word;
import org.dw.service.WordService;

public class WordServiceImpl implements WordService
{
  private WordDAO wordDAO;

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
	  return wordDAO.getHotWords();
  }
  
  public List<Word> getWaitProns()
  {
	  return wordDAO.getWaitProns();
  }
  
  public List<Word> getRecentWords()
  {
	  return wordDAO.getRecentWords();
  }

  public long getWordNumber()
  {
    return wordDAO.getWordNumber();
  }
}
