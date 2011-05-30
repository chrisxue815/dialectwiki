package org.dw.action;

import java.util.Set;

import org.dw.model.Pronunciation;
import org.dw.model.Word;
import org.dw.service.PronunciationService;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class WordHomeAction extends ActionSupport{

	private static final long serialVersionUID = 2409752678054918663L;
	private int wordId;
	private WordService wordService;
	private PronunciationService pronunciationService;
	
	private Word word;
	private Set<Pronunciation> prons;
	
	public int getWordId() {
		return wordId;
	}
	public void setWordId(int wordId) {
		this.wordId = wordId;
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
	public Set<Pronunciation> getProns() {
		return prons;
	}
	public void setProns(Set<Pronunciation> prons) {
		this.prons = prons;
	}
	
	public String execute(){
		word = wordService.getById(wordId);
		prons = pronunciationService.getPronunciationByWordId(wordId);

		return SUCCESS;
	}
	
	
	
}
