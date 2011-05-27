package org.dw.service.impl;

import org.dw.dao.WordDAO;
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


}
