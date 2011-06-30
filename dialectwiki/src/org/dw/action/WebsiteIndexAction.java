package org.dw.action;

import java.util.List;

import org.dw.model.Pronunciation;
import org.dw.model.Word;
import org.dw.service.PronunciationService;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class WebsiteIndexAction extends ActionSupport {
	
	private static final long serialVersionUID = 136611988951934124L;

	private WordService wordService;
	private PronunciationService pronunciationService;
	
	  // 最近的词条
	private List<Word> recentWords;

	  // 热门词条
	private List<Word> hotWords;
	  
	  // 待发音的词条
	private List<Word> waitProns;
	
	  // 最近发音
	private List<Pronunciation> recentProns;
		

	public WordService getWordService() {
		return wordService;
	}

	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}
	
	public List<Word> getRecentWords() {
		return recentWords;
	}

	public void setRecentWords(List<Word> recentWords) {
		this.recentWords = recentWords;
	}

	public List<Word> getHotWords() {
		return hotWords;
	}

	public void setHotWords(List<Word> hotWords) {
		this.hotWords = hotWords;
	}

	public List<Word> getWaitProns() {
		return waitProns;
	}
	
	public void setWaitProns(List<Word> waitProns) {
		this.waitProns = waitProns;
	}
	
	public List<Pronunciation> getRecentProns() {
		return recentProns;
	}

	public void setRecentProns(List<Pronunciation> recentProns) {
		this.recentProns = recentProns;
	}
	
	public PronunciationService getPronunciationService() {
		return pronunciationService;
	}

	public void setPronunciationService(PronunciationService pronunciationService) {
		this.pronunciationService = pronunciationService;
	}

	public String execute()
	{
	    hotWords = wordService.getHotWords();
	    recentWords = wordService.getRecentWords();
	    waitProns = wordService.getWaitProns();
	    recentProns = pronunciationService.getRecentProns();
		
		return SUCCESS;
	}

}
