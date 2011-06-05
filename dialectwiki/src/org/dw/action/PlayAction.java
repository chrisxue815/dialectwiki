package org.dw.action;

import org.dw.model.Pronunciation;

import com.opensymphony.xwork2.ActionSupport;

public class PlayAction extends ActionSupport {

	private Pronunciation pronunciation;
	
	
	
	
	public Pronunciation getPronunciation() {
		return pronunciation;
	}

	public void setPronunciation(Pronunciation pronunciation) {
		this.pronunciation = pronunciation;
	}




	public String execute()
	{
		return SUCCESS;
		
	}

}
