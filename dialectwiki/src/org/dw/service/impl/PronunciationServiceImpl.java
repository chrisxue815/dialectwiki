package org.dw.service.impl;

import java.util.List;

import org.dw.dao.PronunciationDAO;
import org.dw.model.Pronunciation;
import org.dw.service.PronunciationService;

public class PronunciationServiceImpl implements PronunciationService {

	private PronunciationDAO pronunciationDAO;
	
	public PronunciationDAO getPronunciationDAO() {
		return pronunciationDAO;
	}
	public void setPronunciationDAO(PronunciationDAO pronunciationDAO) {
		this.pronunciationDAO = pronunciationDAO;
	}

	public List<Pronunciation> getPronunciationByWordId(int wordId) {
		System.out.println("PronsSevice:" + wordId);
		return pronunciationDAO.findByWordId(wordId);
	}
	
	//public List<String> getPronunciationBy
}
