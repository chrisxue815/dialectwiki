package org.dw.action;

import org.dw.model.Pronunciation;

import com.opensymphony.xwork2.ActionSupport;

public class PlayAction extends ActionSupport {

	private static final long serialVersionUID = 7194816618407396592L;
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
