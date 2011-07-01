package org.dw.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.dw.model.Pronunciation;
import org.dw.model.Word;

public interface PronunciationService {
	public Set<Pronunciation> getPronunciationByWordId(int wordId);
	
	public List<Pronunciation> searchPronunciation(int wordId);
	
	public long getPronunciationNumber();
	
	public void save(int word, int city, String prUrl, Date date);
	
	public Pronunciation getPronunciationById(int pronId);
	
	public List<Pronunciation> getRecentProns();
	
	public List<Pronunciation> getUserProns(int userId);
	
	public List<Pronunciation> getMapProns(int wordId);
	
	public void deleteWordProns(Word word);
	
	public void deletePron (Pronunciation pron);
	
	public List<Pronunciation> getPageRecentProns(int pageNo,int pageSize);
	
	public int getRecentPronsSize();
	
}
