package org.dw.action;

import org.dw.model.Pronunciation;
import org.dw.service.PronunciationService;

import com.opensymphony.xwork2.ActionSupport;

public class DeletePronAction extends ActionSupport {

	private static final long serialVersionUID = -7156956207442932280L;
	private static final String INVALID_ID = "invalidid";
	private static final String PRON_NOT_EXIST = "pronNotExist";
	private static final String WORDS = "words";
	
	private String id;
	private Pronunciation pron;
	private PronunciationService pronunciationService;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Pronunciation getPron() {
		return pron;
	}

	public void setPron(Pronunciation pron) {
		this.pron = pron;
	}

	public PronunciationService getPronunciationService() {
		return pronunciationService;
	}

	public void setPronunciationService(PronunciationService pronunciationService) {
		this.pronunciationService = pronunciationService;
	}


	public String execute()
	{
		try
		{
			if( id != null && id !="")
			{
				int pronId = Integer.parseInt(id);
				Pronunciation pron = pronunciationService.getPronunciationById(pronId);
				
				if(pron == null)
					return PRON_NOT_EXIST;
				
				pronunciationService.deletePron(pron);
				
			}
			else
			{
				return WORDS;
			}
			return SUCCESS;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return INVALID_ID;
		}
	}
}
