package org.dw.dao;

import java.util.List;

import org.dw.model.Pronunciation;

public interface PronunciationDAO
{

  // property constants
  public static final String USER_ID = "userId";
  public static final String WORD_ID = "wordId";
  public static final String PR_URL = "prUrl";
  public static final String GOOD_VOTE_NUM = "goodVoteNum";
  public static final String BAD_VOTE_NUM = "badVoteNum";

  public void save(Pronunciation transientInstance);

  public void delete(Pronunciation persistentInstance);

  public Pronunciation findById(java.lang.Integer id);

  public List findByExample(Pronunciation instance);

  public List findByProperty(String propertyName, Object value);

  public List findByUserId(Object userId);

  public List findByWordId(Object wordId);

  public List findByPrUrl(Object prUrl);

  public List findByGoodVoteNum(Object goodVoteNum);

  public List findByBadVoteNum(Object badVoteNum);

  public List findAll();

  public Pronunciation merge(Pronunciation detachedInstance);

  public void attachDirty(Pronunciation instance);

  public void attachClean(Pronunciation instance);

}