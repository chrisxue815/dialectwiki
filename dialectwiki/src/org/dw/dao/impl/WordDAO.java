package org.dw.dao.impl;

import java.util.List;

import org.dw.hibernate.Word;


public interface WordDAO
{

  public abstract void save(Word transientInstance);

  public abstract void delete(Word persistentInstance);

  public abstract Word findById(java.lang.Integer id);

  public abstract List<Word> findByExample(Word instance);

  public abstract List<Word> findByProperty(String propertyName, Object value);

  public abstract List<Word> findByWordName(Object wordName);

  public abstract List<Word> findAll();

  public abstract Word merge(Word detachedInstance);

  public abstract void attachDirty(Word instance);

  public abstract void attachClean(Word instance);

}