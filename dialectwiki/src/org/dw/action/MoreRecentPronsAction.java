package org.dw.action;

import java.util.List;

import org.dw.model.Pronunciation;
import org.dw.service.PronunciationService;


import com.opensymphony.xwork2.ActionSupport;

public class MoreRecentPronsAction extends ActionSupport {

	private static final long serialVersionUID = -3841034060658998427L;
	
	private List<Pronunciation> recentProns; 
	private PronunciationService pronunciationService;
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
		recentProns = pronunciationService.getPageRecentProns(0, 50);
		
		return SUCCESS;
	}

}
