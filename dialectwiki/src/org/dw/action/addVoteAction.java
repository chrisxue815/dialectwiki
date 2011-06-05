package org.dw.action;

import org.dw.model.Pronunciation;
import org.dw.model.User;
import org.dw.model.Vote;
import org.dw.model.VoteId;
import org.dw.service.PronunciationService;
import org.dw.service.UserService;
import org.dw.service.VoteService;
import org.springframework.security.core.context.SecurityContextHolder;

import com.opensymphony.xwork2.ActionSupport;

public class AddVoteAction extends ActionSupport {
	
	private static final long serialVersionUID = -5342628595007045780L;
	
	private Vote vote;
	private User user;
	private int voteMark;
	private int pronId;
	
	private UserService userService;
	private PronunciationService pronunciationService;
	private VoteService voteService;
	
	public int getPronId() {
		return pronId;
	}

	public void setPronId(int pronId) {
		this.pronId = pronId;
	}

	public Vote getVote() {
		return vote;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PronunciationService getPronunciationService() {
		return pronunciationService;
	}

	public void setPronunciationService(PronunciationService pronunciationService) {
		this.pronunciationService = pronunciationService;
	}

	public int getVoteMark() {
		return voteMark;
	}

	public void setVoteMark(int voteMark) {
		this.voteMark = voteMark;
	}

	public String execute(){
		Vote vote = new Vote();
		VoteId id = new VoteId();
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		user = userService.getUserByUserName(username);
		id.setUser(user);
		Pronunciation pron = pronunciationService.getPronunciationById(pronId);
		id.setPronunciation(pron);
		
		vote.setMark(voteMark);
		vote.setId(id);
		
		if(voteMark == 1)
		{
			int voteNum = pron.getGoodVoteNum();
			voteNum += 1;
			voteService.saveVote(vote,voteNum);
		}
		
		if(voteMark == -1)
		{
			int voteNum = pron.getBadVoteNum();
			voteNum += 1;
			voteService.saveVote(vote, voteNum);
		}
		return SUCCESS;
	}

}
