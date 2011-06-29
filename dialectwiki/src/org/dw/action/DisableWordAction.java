package org.dw.action;

import org.dw.model.Word;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class DisableWordAction extends ActionSupport {
	private static final long serialVersionUID = 3321781545847712700L;
	
	private static final String INVALID_ID = "invalidid";
	private static final String WORD_NOT_EXIST = "wordNotExist";
	private static final String WORDS = "words";
	
	private String id;
	private Word word;
	private WordService wordService;
	private int wordId;
	
	
	
	public int getWordId() {
		return wordId;
	}



	public void setWordId(int wordId) {
		this.wordId = wordId;
	}



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
			if( id != null && id != "")
			{
				wordId = Integer.parseInt(id);
				word = wordService.getById(wordId);
				
				if (word == null)
					return WORD_NOT_EXIST;
				
				wordService.disableWord(word);
				
			}
			else
			{
				return WORDS;
			}
			return SUCCESS;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return INVALID_ID;
		}
	}

}
