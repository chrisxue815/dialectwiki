package org.dw.action;

import java.util.List;

import org.dw.model.Word;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class MoreWaitPronsAction extends ActionSupport {

	private static final long serialVersionUID = -8133777444171476800L;
	
	private List<Word> waitProns;
	private WordService wordService;
	public List<Word> getWaitProns() {
		return waitProns;
	}
	public void setWaitProns(List<Word> waitProns) {
		this.waitProns = waitProns;
	}
	public WordService getWordService() {
		return wordService;
	}
	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}
	
	public String execute()
	{
		waitProns = wordService.getPageWaitProns(0, 50);
		
		return SUCCESS;
	}
}
