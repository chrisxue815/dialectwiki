package org.dw.action;

import org.dw.model.Word;
import org.dw.service.WordService;
import com.opensymphony.xwork2.ActionSupport;

public class WordHomeAction extends ActionSupport{

	private static final long serialVersionUID = 2409752678054918663L;
	private int wordId;
	private WordService wordService;
	private Word word;
	
	
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
	
	public String execute(){
		word = wordService.getById(wordId);
		return SUCCESS;
	}
	
	
	
}
