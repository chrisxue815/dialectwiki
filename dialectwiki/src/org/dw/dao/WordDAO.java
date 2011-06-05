package org.dw.dao;

import java.util.List;
import java.util.Set;

import org.dw.model.Pronunciation;
import org.dw.model.Word;

public interface WordDAO
{

  // property constants
  public static final String WORD_NAME = "wordName";

  public void save(Word transientInstance);

  public void delete(Word persistentInstance);

  public Word findById(java.lang.Integer id);

  public List<Word> findByExample(Word instance);

  public List<Word> findByProperty(String propertyName, Object value);

  public List<Word> findByWordName(Object wordName);

  public List<Word> findAll();

  public Word merge(Word detachedInstance);

  public void attachDirty(Word instance);

  public void attachClean(Word instance);
  
  public Set<Pronunciation> getPronunciations(int wordId);
  
  public List<Word> searchSimilarWords(String wordName, int index, int limit);
  
  public List<Word> getRecentWords();
  
  public List<Word> getHotWords();
  
  public List<Word> getWaitProns();
  
  public long getWordNumber();

}