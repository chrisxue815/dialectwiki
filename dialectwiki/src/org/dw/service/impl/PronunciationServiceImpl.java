package org.dw.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.dw.dao.CityDAO;
import org.dw.dao.PronunciationDAO;
import org.dw.dao.UserDAO;
import org.dw.dao.WordDAO;
import org.dw.model.Pronunciation;
import org.dw.model.Word;
import org.dw.service.PronunciationService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class PronunciationServiceImpl implements PronunciationService {
  public static final int LIST_SIZE = 15;
  private PronunciationDAO pronunciationDAO;
  private WordDAO wordDAO;
  private UserDAO userDAO;
  private CityDAO cityDAO;
  
  public PronunciationDAO getPronunciationDAO() {
    return pronunciationDAO;
  }
  public void setPronunciationDAO(PronunciationDAO pronunciationDAO) {
    this.pronunciationDAO = pronunciationDAO;
  }
  
  public WordDAO getWordDAO()
  {
    return wordDAO;
  }
  public void setWordDAO(WordDAO wordDAO)
  {
    this.wordDAO = wordDAO;
  }
  public void setUserDAO(UserDAO userDAO) {
    this.userDAO = userDAO;
  }
  public UserDAO getUserDAO() {
    return userDAO;
  }
  public CityDAO getCityDAO() {
    return cityDAO;
  }
  public void setCityDAO(CityDAO cityDAO) {
    this.cityDAO = cityDAO;
  }

  public Set<Pronunciation> getPronunciationByWordId(int wordId) {
    return wordDAO.getPronunciations(wordId);
  }
  
  public List<Pronunciation> searchPronunciation(int wordId)
  {
    return pronunciationDAO.getPronsSearchResult(wordId);
  }
  
  public long getPronunciationNumber()
  {
    return pronunciationDAO.getPronunciationNumber();
  }
  
  public void save(int word, int city, String prUrl, Date date) {
    Pronunciation pron = new Pronunciation();

    
    pron.setWord(wordDAO.findById(word));
    pron.setUser(userDAO.findById(getUserId()));
    pron.setCity(cityDAO.findById(city));
    pron.setPrUrl(prUrl);
    pron.setUploadDate(date);
    

    pronunciationDAO.save(pron);
  }
  
  private int getUserId()
  {
    UserDetails ud = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String userName = ud.getUsername();
    
    return userDAO.findByUsername(userName).get(0).getUserId();
  }
  
  public Pronunciation getPronunciationById(int pronId)
  {
	  return pronunciationDAO.findById(pronId);
  }
  
  public List<Pronunciation> getRecentProns()
  {
	  return pronunciationDAO.getRecentProns(LIST_SIZE);
	  
  }
  
  public List<Pronunciation> getUserProns(int userId)
  {
	  return pronunciationDAO.getUserProns(userId);
  }
  
  public List<Pronunciation> getMapProns(int wordId)
  {
	  return pronunciationDAO.getMapProns(wordId);
  }
  
  public void deleteWordProns(Word word)
  {
	  pronunciationDAO.deleteAllWordPron(word);
  }
  
  public void deletePron(Pronunciation pron)
  {
	  pronunciationDAO.delete(pron);
  }
  
  public List<Pronunciation> getPageRecentProns(int pageNo,int pageSize)
  {
	  return pronunciationDAO.getPageRecentProns(pageNo, pageSize);
  }
  
}
