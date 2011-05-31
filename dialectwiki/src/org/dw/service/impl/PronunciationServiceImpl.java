package org.dw.service.impl;

import java.util.Set;

import org.dw.dao.PronunciationDAO;
import org.dw.dao.WordDAO;
import org.dw.model.Pronunciation;
import org.dw.model.Word;
import org.dw.service.PronunciationService;

public class PronunciationServiceImpl implements PronunciationService {

	private PronunciationDAO pronunciationDAO;
	private WordDAO wordDAO;
	
  public PronunciationDAO getPronunciationDAO() {
		return pronunciationDAO;
	}
	public void setPronunciationDAO(PronunciationDAO pronunciationDAO) {
		this.pronunciationDAO = pronunciationDAO;
	}
	
  public WordDAO getWordDAO()
  {
    return wordDAO;
  }
  public void setWordDAO(WordDAO wordDAO)
  {
    this.wordDAO = wordDAO;
  }

	public Set<Pronunciation> getPronunciationByWordId(int wordId) {
		return wordDAO.getPronunciations(wordId);
	}
	
	//public List<String> getPronunciationBy
}
