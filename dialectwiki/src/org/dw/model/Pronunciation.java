package org.dw.model;

import java.util.HashSet;
import java.util.Set;

import org.dw.hibernate.Word;

public class Pronunciation {
	
	private int pron_id;
	private String pr_url;
	private String upload_date;
	private User user;
	private Dialect dialect;
	private Word word;
	private City city;
	private Set votes = new HashSet();

	public Pronunciation() {
		
	}

	public int getPron_id() {
		return pron_id;
	}

	public void setPron_id(int pronId) {
		pron_id = pronId;
	}

	public String getPr_url() {
		return pr_url;
	}

	public void setPr_url(String prUrl) {
		pr_url = prUrl;
	}

	public String getUpload_date() {
		return upload_date;
	}

	public void setUpload_date(String uploadDate) {
		upload_date = uploadDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Dialect getDialect() {
		return dialect;
	}

	public void setDialect(Dialect dialect) {
		this.dialect = dialect;
	}

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Set getVotes() {
		return votes;
	}

	public void setVotes(Set votes) {
		this.votes = votes;
	}
	
	
	

}
