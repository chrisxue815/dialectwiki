package org.dw.service.impl;

import java.util.List;

import org.dw.dao.WordDAO;
import org.dw.macro.MACRO_WORD;
import org.dw.model.Word;
import org.dw.service.WordService;

public class WordServiceImpl implements WordService {
	private WordDAO wordDAO;

	public WordDAO getWordDAO() {
		return wordDAO;
	}

	public void setWordDAO(WordDAO wordDAO) {
		this.wordDAO = wordDAO;
	}
	
	public void addWord(Word word) {
		wordDAO.save(word);
	}
	
	public List<Word> getRecentWords() {
		return wordDAO.findRecentWord(MACRO_WORD.LIST_SIZE);
	}
	
	public List<Word> getHotWords(){
		return wordDAO.findHotWord(MACRO_WORD.LIST_SIZE);
	}

	public List<Word> getAllHotWords() {
		return wordDAO.findWaitPronWord(MACRO_WORD.LIST_SIZE);
	}

	public List<Word> getAllRecentWords() {
		return wordDAO.findAllRecentWord();
	}

	public List<Word> getAllWaitPronWords() {
		return wordDAO.findAllWaitPronWord();
	}

	public List<Word> getWaitPronWords() {
		return wordDAO.findAllWaitPronWord();
	}
	
	public List<Word> searchWord(String value) {
	  return wordDAO.searchWord(value);
	}


}
