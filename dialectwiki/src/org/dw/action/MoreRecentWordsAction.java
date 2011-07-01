package org.dw.action;

import java.util.List;

import org.dw.model.Word;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class MoreRecentWordsAction extends ActionSupport {

	private static final long serialVersionUID = 6872058744240511303L;
	private String pageNum = "1";
	private String front;
	private String back;
	private String end;
	private static int pageSize = 60;
	private int pageNumInt;
	private int frontInt;
	private int backInt;
	private int endInt;
	
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

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getFront() {
		return front;
	}

	public void setFront(String front) {
		this.front = front;
	}

	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String execute()
	{
		SetNums();
		recentWords = wordService.getPageRecentWords(pageNumInt, pageSize);
		
		return SUCCESS;
	}

	private void SetNums(){
		pageNumInt = Integer.parseInt(pageNum);
		endInt = (wordService.getRecentWordsSize()-1)/pageSize+1;
		if(pageNumInt > 1)
			frontInt = pageNumInt-1;
		else frontInt = 1;
		if(pageNumInt < endInt)
			backInt = pageNumInt+1;
		else backInt = endInt;

		pageNum = String.valueOf(pageNumInt);
		end = String.valueOf(endInt);
		front = String.valueOf(frontInt);
		back = String.valueOf(backInt);
	}
}
