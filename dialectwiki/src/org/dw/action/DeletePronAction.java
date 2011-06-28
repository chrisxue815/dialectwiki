package org.dw.action;

import org.dw.model.Pronunciation;
import org.dw.service.PronunciationService;

import com.opensymphony.xwork2.ActionSupport;

public class DeletePronAction extends ActionSupport {

	private static final long serialVersionUID = -7156956207442932280L;
	private static final String INVALID_ID = "invalidid";
	private static final String ID_NOT_EXIST = "idNotExist";
	private static final String WORD_NOT_EXIST = "wordNotExist";
	private static final String WORDS = "words";
	
	private String id;
	private Pronunciation pron;
	private PronunciationService pronunciationService;
	
	
	public String execute()
	{
		try
		{
			return null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return INVALID_ID;
		}
	}

}
