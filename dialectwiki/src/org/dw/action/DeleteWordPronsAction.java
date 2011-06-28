package org.dw.action;

import org.dw.model.Word;
import org.dw.service.PronunciationService;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteWordPronsAction extends ActionSupport {

	private static final long serialVersionUID = -4020474392065216003L;
	private static final String INVALID_ID = "invalidid";
	private static final String ID_NOT_EXIST = "idNotExist";
	private static final String WORD_NOT_EXIST = "wordNotExist";
	private static final String WORDS = "words";
	
	
	private String id;
	private String name;
	private Word word;
	
	private WordService wordService;
	private PronunciationService pronunciationService;
	private int wordId;
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
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



	public PronunciationService getPronunciationService() {
		return pronunciationService;
	}



	public void setPronunciationService(PronunciationService pronunciationService) {
		this.pronunciationService = pronunciationService;
	}



	public int getWordId() {
		return wordId;
	}



	public void setWordId(int wordId) {
		this.wordId = wordId;
	}



	public String execute()
	{
		try
		{
			if( id !=null && id != "")
			{
				wordId = Integer.parseInt(id);
				word = wordService.getById(wordId);
				if(word == null)
					return ID_NOT_EXIST;
				
				pronunciationService.deleteWordProns(word);
			}
			else if( name != null && name != "")
			{
				word = wordService.findByWordName(name);
				
				if(word == null)
					return WORD_NOT_EXIST;
				
				wordId = word.getWordId();
				pronunciationService.deleteWordProns(word);
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
