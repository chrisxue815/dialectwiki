package org.dw.dao;

import java.util.List;

import org.dw.model.Word;

public interface WordDAO
{

  //property constants
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
  
  //查找新添加的词条
  public List<Word> findRecentWord(int listSize);
  public List<Word> findAllRecentWord();
  //查找较热门的词条
  public List<Word> findHotWord(int listSize);
  public List<Word> findAllHotWord();
   
  //查找待发音的词条
  public List<Word> findWaitPronWord(int listSize);
  public List<Word> findAllWaitPronWord();
  
  //搜索词条
  public List<Word> searchWord(String value);

}