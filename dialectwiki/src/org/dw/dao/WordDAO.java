package org.dw.dao;

import java.util.List;

import org.dw.model.Word;

public interface WordDAO
{

  // property constants
  public static final String WORD_NAME = "wordName";

  public void save(Word transientInstance);

  public void delete(Word persistentInstance);

  public Word findById(java.lang.Integer id);

  public List findByExample(Word instance);

  public List findByProperty(String propertyName, Object value);

  public List findByWordName(Object wordName);

  public List findAll();

  public Word merge(Word detachedInstance);

  public void attachDirty(Word instance);

  public void attachClean(Word instance);

}