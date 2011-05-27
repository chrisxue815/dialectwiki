package org.dw.action;

import org.dw.model.Word;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class AddWordAction extends ActionSupport {

  private static final long serialVersionUID = 1L;
  
  private String wordid;
  private String wordname;
  private WordService wordService;
  
  public String getWordid() {
	  return wordid;
  }
  public void setWordid(String wordid) {
	  this.wordid = wordid;
  }
  public String getWordname() {
	  return wordname;
  }
  public void setWordname(String wordname) {
	  this.wordname = wordname;
  }
  public WordService getWordService() {
	  return wordService;
  }
  public void setWordService(WordService wordService) {
	  this.wordService = wordService;
  }
  
  
  public String execute() {
	  Word word = new Word();
	  word.setWordName(wordname);
	  
	  if(wordService.addWord(word))
		  return SUCCESS;
	  else
		  return ERROR;
  }
  
  public void validate(){
	  
  }
}
