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
	private String voteMark;
	private String pronId;
	
	private UserService userService;
	private PronunciationService pronunciationService;
	private VoteService voteService;
	
	


	public String getVoteMark() {
		return voteMark;
	}

	public void setVoteMark(String voteMark) {
		this.voteMark = voteMark;
	}

	public String getPronId() {
		return pronId;
	}

	public void setPronId(String pronId) {
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

	public VoteService getVoteService() {
		return voteService;
	}

	public void setVoteService(VoteService voteService) {
		this.voteService = voteService;
	}

	public String execute(){
		Vote vote = new Vote();
		VoteId id = new VoteId();
		System.out.println(pronId);
		System.out.println(voteMark);
		int pronIdInt = Integer.parseInt(pronId);
		int voteMarkInt = Integer.parseInt(voteMark);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		user = userService.getUserByUserName(username);
		id.setUser(user);
		Pronunciation pron = pronunciationService.getPronunciationById(pronIdInt);
		id.setPronunciation(pron);
		
		vote.setMark(voteMarkInt);
		vote.setId(id);
		
		if(voteMarkInt == 1)
		{
			int voteNum = pron.getGoodVoteNum();
			voteNum += 1;
			voteService.saveVote(vote,voteNum);
		}
		
		if(voteMarkInt == -1)
		{
			int voteNum = pron.getBadVoteNum();
			voteNum += 1;
			voteService.saveVote(vote, voteNum);
		}
		return SUCCESS;
	}

}
