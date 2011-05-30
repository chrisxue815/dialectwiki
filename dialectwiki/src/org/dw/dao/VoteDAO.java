package org.dw.dao;

import java.util.List;

import org.dw.model.Vote;

public interface VoteDAO
{

  // property constants
  public static final String MARK = "mark";

  public void save(Vote transientInstance);

  public void delete(Vote persistentInstance);

  public Vote findById(org.dw.model.VoteId id);

  public List<Vote> findByExample(Vote instance);

  public List<Vote> findByProperty(String propertyName, Object value);

  public List<Vote> findByMark(Object mark);

  public List<Vote> findAll();

  public Vote merge(Vote detachedInstance);

  public void attachDirty(Vote instance);

  public void attachClean(Vote instance);

}