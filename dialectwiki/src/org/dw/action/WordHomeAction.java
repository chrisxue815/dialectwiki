package org.dw.action;

import java.util.List;

import org.dw.model.Pronunciation;
import org.dw.model.Word;
import org.dw.service.PronunciationService;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class WordHomeAction extends ActionSupport{

	private static final long serialVersionUID = 2409752678054918663L;
	private String wordId;
	private String wordName;
	private WordService wordService;
	private PronunciationService pronunciationService;
	
	private Word word;
	private List<Pronunciation> prons;

	
	public String getWordId() {
		return wordId;
	}
	public void setWordId(String wordId) {
		this.wordId = wordId;
	}
	public String getWordName() {
	  return wordName;
	}
	public void setWordName(String wordName) {
	  this.wordName = wordName;
	}
	public WordService getWordService() {
		return wordService;
	}
	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}
	public Word getWord() {
		return word;
	}
	public void setWord(Word word) {
		this.word = word;
	}
	
	public PronunciationService getPronunciationService() {
		return pronunciationService;
	}
	public void setPronunciationService(PronunciationService pronunciationService) {
		this.pronunciationService = pronunciationService;
	}

	
	public String execute() {
	  if (wordId != null) {
	    int wordIdInt = Integer.parseInt(wordId);
	    
	    word = wordService.getById(wordIdInt);
	    prons = pronunciationService.searchPronunciation(wordIdInt);
	    
	    for (Pronunciation pron : prons) {
	      System.out.println("pron :" + pron.getCity().getCityName());
	    }
	    
	    return SUCCESS;
	  }
	  else if (wordName != null) {
	    word = wordService.findByWordName(wordName);
	    prons = pronunciationService.searchPronunciation(word.getWordId());
	    
	    return SUCCESS;
	  }
	  else {
	    return ERROR;
	  }
	}
	
}
