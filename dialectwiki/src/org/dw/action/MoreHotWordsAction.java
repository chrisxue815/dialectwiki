package org.dw.action;

import java.util.List;

import org.dw.model.Word;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class MoreHotWordsAction extends ActionSupport {

	private static final long serialVersionUID = 6586021096304675837L;
	
	private List<Word> hotWords;
	private WordService wordService;
	public WordService getWordService() {
		return wordService;
	}
	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}
	public List<Word> getHotWords() {
		return hotWords;
	}
	public void setHotWords(List<Word> hotWords) {
		this.hotWords = hotWords;
	}
	
	
	public String execute()
	{
		hotWords = wordService.getPageHotWords(0, 50);
		return SUCCESS;
	}
	
}
