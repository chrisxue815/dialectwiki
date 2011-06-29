package org.dw.action;

import org.dw.model.Word;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class DisableWordAction extends ActionSupport {
	private static final long serialVersionUID = 3321781545847712700L;
	
	private static final String INVALID_ID = "invalidid";
	private static final String ID_NOT_EXIST = "idNotExist";
	private static final String WORD_NOT_EXIST = "wordNotExist";
	private static final String WORDS = "words";
	
	private String id;
	private Word word;
	private WordService wordService;
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Word getWord() {
		return word;
	}



	public void setWord(Word word) {
		this.word = word;
	}



	public WordService getWordService() {
		return wordService;
	}



	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}



	public String execute()
	{
		try
		{
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		return null;
	
	}

}
