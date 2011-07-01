package org.dw.action;

import java.util.List;

import org.dw.model.Word;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class MoreHotWordsAction extends ActionSupport {

	private static final long serialVersionUID = 6586021096304675837L;
	private String pageNum = "1";
	private String front;
	private String back;
	private String end;
	private static int pageSize = 60;
	private int pageNumInt;
	private int frontInt;
	private int backInt;
	private int endInt;
	
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
	
	
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getPageNum() {
		return pageNum;
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
		hotWords = wordService.getPageHotWords(pageNumInt, pageSize);
		return SUCCESS;
	}
	private void SetNums(){
		pageNumInt = Integer.parseInt(pageNum);
		endInt = (wordService.getWaitPronsSize()-1)/pageSize+1;
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
