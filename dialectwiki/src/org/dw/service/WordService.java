package org.dw.service;

import java.util.List;

import org.dw.model.Word;

public interface WordService
{
  public void addWord(Word word);

  public List<Word> getRecentWords();

  public List<Word> getHotWords();

  public List<Word> getWaitPronWords();

  public List<Word> getAllRecentWords();

  public List<Word> getAllHotWords();

  public List<Word> getAllWaitPronWords();

  public List<Word> searchWord(String value);

  public Word getById(int wordIdInt);
}
