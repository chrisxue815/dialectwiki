package org.dw.service;

import java.util.List;

import org.dw.model.Word;

public interface WordService {
	public void addWord(Word word);
	public List<Word> getRecentWords();
	public List<Word> getHotWords();
}
