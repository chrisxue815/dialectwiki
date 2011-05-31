package org.dw.service;

import java.util.List;

import org.dw.model.Word;

public interface WordService
{
  public void addWord(Word word);

  public Word getById(int wordIdInt);
}
