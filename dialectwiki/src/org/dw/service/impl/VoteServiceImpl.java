package org.dw.service.impl;

import org.dw.dao.PronunciationDAO;
import org.dw.dao.VoteDAO;
import org.dw.model.Vote;
import org.dw.service.VoteService;

public class VoteServiceImpl implements VoteService {
	
	private VoteDAO voteDAO;
	private PronunciationDAO pronunciationDAO;
	
	

	public VoteDAO getVoteDAO() {
		return voteDAO;
	}



	public void setVoteDAO(VoteDAO voteDAO) {
		this.voteDAO = voteDAO;
	}



	public PronunciationDAO getPronunciationDAO() {
		return pronunciationDAO;
	}



	public void setPronunciationDAO(PronunciationDAO pronunciationDAO) {
		this.pronunciationDAO = pronunciationDAO;
	}



	public void saveVote(Vote vote,int voteNum) {
		voteDAO.save(vote);
		int pronId = vote.getId().getPronunciation().getPronId();
		System.out.println(pronId);
		pronunciationDAO.updateVoteNumber(vote.getMark(),voteNum,pronId);
	}

}
