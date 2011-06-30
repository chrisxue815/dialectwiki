package org.dw.action;

import java.util.List;

import org.dw.model.Word;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class MoreRecentWordsAction extends ActionSupport {

	private static final long serialVersionUID = 6872058744240511303L;
	
	private List<Word> recentWords;
	private WordService wordService;
	
	public List<Word> getRecentWords() {
		return recentWords;
	}

	public void setRecentWords(List<Word> recentWords) {
		this.recentWords = recentWords;
	}
	
	public WordService getWordService() {
		return wordService;
	}

	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}

	public String execute()
	{
		
		recentWords = wordService.getPageRecentWords(0, 50);
		
		return SUCCESS;
	}

}
