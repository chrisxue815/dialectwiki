package org.dw.dao;

import java.util.List;

import org.dw.model.Pronunciation;

public interface PronunciationDAO
{

  // property constants
  public static final String PR_URL = "prUrl";
  public static final String GOOD_VOTE_NUM = "goodVoteNum";
  public static final String BAD_VOTE_NUM = "badVoteNum";

  public void save(Pronunciation transientInstance);

  public void delete(Pronunciation persistentInstance);

  public Pronunciation findById(java.lang.Integer id);

  public List<Pronunciation> findByExample(Pronunciation instance);

  public List<Pronunciation> findByProperty(String propertyName, Object value);

  public List<Pronunciation> findByPrUrl(Object prUrl);

  public List<Pronunciation> findByGoodVoteNum(Object goodVoteNum);

  public List<Pronunciation> findByBadVoteNum(Object badVoteNum);

  public List<Pronunciation> findAll();

  public Pronunciation merge(Pronunciation detachedInstance);

  public void attachDirty(Pronunciation instance);

  public void attachClean(Pronunciation instance);
  
  public List<Pronunciation>  getPronsSearchResult(int wordId);

  public long getPronunciationNumber();
  
  public void updateVoteNumber(int voteMark,int voteNum,int pronId);
  
  public List<Pronunciation> getRecentProns();
}