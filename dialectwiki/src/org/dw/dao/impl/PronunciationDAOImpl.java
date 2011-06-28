package org.dw.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dw.dao.PronunciationDAO;
import org.dw.hibernate.HibernateSessionFactory;
import org.dw.model.Pronunciation;
import org.dw.model.Word;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class PronunciationDAOImpl extends HibernateDaoSupport implements PronunciationDAO
{
  private static final Logger log = LoggerFactory
    .getLogger(PronunciationDAOImpl.class);
  protected void initDao()
  {
    // do nothing
  }

  public void save(Pronunciation transientInstance)
  {
    log.debug("saving Pronunciation instance");
    try
    {
      getHibernateTemplate().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re)
    {
      log.error("save failed", re);
      throw re;
    }
  }

  public void delete(Pronunciation persistentInstance)
  {
    log.debug("deleting Pronunciation instance");
    try
    {
      getHibernateTemplate().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re)
    {
      log.error("delete failed", re);
      throw re;
    }
  }

  public Pronunciation findById(java.lang.Integer id)
  {
    log.debug("getting Pronunciation instance with id: " + id);
    try
    {
      Pronunciation instance = (Pronunciation) getHibernateTemplate().get(
          "org.dw.model.Pronunciation", id);
      return instance;
    } catch (RuntimeException re)
    {
      log.error("get failed", re);
      throw re;
    }
  }

  public List<Pronunciation> findByExample(Pronunciation instance)
  {
    log.debug("finding Pronunciation instance by example");
    try
    {
      List<Pronunciation> results = getHibernateTemplate().findByExample(instance);
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re)
    {
      log.error("find by example failed", re);
      throw re;
    }
  }

  public List<Pronunciation> findByProperty(String propertyName, Object value)
  {
    log.debug("finding Pronunciation instance with property: " + propertyName
        + ", value: " + value);
    try
    {
      String queryString = "from Pronunciation as model where model."
          + propertyName + "= ?";
      return getHibernateTemplate().find(queryString, value);
    } catch (RuntimeException re)
    {
      log.error("find by property name failed", re);
      throw re;
    }
  }

  public List<Pronunciation> findByPrUrl(Object prUrl)
  {
    return findByProperty(PR_URL, prUrl);
  }

  public List<Pronunciation> findByGoodVoteNum(Object goodVoteNum)
  {
    return findByProperty(GOOD_VOTE_NUM, goodVoteNum);
  }

  public List<Pronunciation> findByBadVoteNum(Object badVoteNum)
  {
    return findByProperty(BAD_VOTE_NUM, badVoteNum);
  }

  public List<Pronunciation> findAll()
  {
    log.debug("finding all Pronunciation instances");
    try
    {
      String queryString = "from Pronunciation";
      return getHibernateTemplate().find(queryString);
    } catch (RuntimeException re)
    {
      log.error("find all failed", re);
      throw re;
    }
  }

  public Pronunciation merge(Pronunciation detachedInstance)
  {
    log.debug("merging Pronunciation instance");
    try
    {
      Pronunciation result = (Pronunciation) getHibernateTemplate().merge(
          detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re)
    {
      log.error("merge failed", re);
      throw re;
    }
  }

  public void attachDirty(Pronunciation instance)
  {
    log.debug("attaching dirty Pronunciation instance");
    try
    {
      getHibernateTemplate().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re)
    {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(Pronunciation instance)
  {
    log.debug("attaching clean Pronunciation instance");
    try
    {
      getHibernateTemplate().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re)
    {
      log.error("attach failed", re);
      throw re;
    }
  }

  public static PronunciationDAO getFromApplicationContext(
      ApplicationContext ctx)
  {
    return (PronunciationDAO) ctx.getBean("PronunciationDAO");
  }
  
  public List<Pronunciation> getPronsSearchResult(int wordId)
  {
	  log.debug("get a PronounciateionList order by city");
	  try
	  {
		  String queryString = "from Pronunciation model where model.word.id = :wordid order by model.city.id asc";
		  Session session = HibernateSessionFactory.getSession();
		  Query query = session.createQuery(queryString);
		  query.setParameter("wordid", wordId );
		  List<Pronunciation> prons = query.list();
		  return prons;
	  } catch(RuntimeException re)
	  {
		  log.error("attach failed");
		  throw re;
	  }
  }
  
  public long getPronunciationNumber()
  {
    String queryString = "select count(*) from Pronunciation";
    return (Long)getHibernateTemplate().find(queryString).listIterator().next();
  }
  
  
  public void updateVoteNumber(int voteMark,int voteNum,int pronId)
  {
	  log.debug("vote a Pronunciation");
	  if(voteMark == 1)
	  {
		  try
		  {
			  String queryString = "update Pronunciation pron set pron.goodVoteNum = :goodVoteNum where pron.id = :pronId";
			  Session session = HibernateSessionFactory.getSession();
			  Transaction trans = session.beginTransaction();
			  Query query = session.createQuery(queryString);
			  query.setParameter("goodVoteNum", voteNum);
			  query.setParameter("pronId", pronId);
			  int ret = query.executeUpdate();
			  trans.commit();
			  
		  }
		  catch(RuntimeException re)
		  {
			  log.error("update failed");
			  throw re;
		  }
	  }
	  else if(voteMark == -1)
	  {
		  try
		  {
			  String queryString = "update Pronunciation pron set pron.badVoteNum = :badVoteNum where pron.id = :pronId";
			  Session session = HibernateSessionFactory.getSession();
			  Transaction trans = session.beginTransaction();
			  Query query = session.createQuery(queryString);
			  query.setParameter("badVoteNum", voteNum);
			  query.setParameter("pronId", pronId);
			  int ret = query.executeUpdate();
			  trans.commit();
		  }
		  catch(RuntimeException re)
		  {
			  log.error("update failed");
			  throw re;
		  }
	  }
  }
  
  public List<Pronunciation> getRecentProns()
  {
	  log.debug("get recent Pronunciation");
	  try
	  {
		  String queryString = "from Pronunciation pron order by pron.uploadDate desc";
		  Session session = HibernateSessionFactory.getSession();
		  Query query = session.createQuery(queryString);
		  query.setMaxResults(20);
		  List<Pronunciation> prons = query.list();
		  return prons;
	  }
	  catch(RuntimeException re)
	  {
		  log.error("attach failed");
		  throw re;
	  }
  }
  
  public List<Pronunciation> getRecentProns(int listSize)
  {
	  log.debug("get recent Pronunciation");
	  try
	  {
		  String queryString = "from Pronunciation pron order by pron.uploadDate desc";
		  Session session = HibernateSessionFactory.getSession();
		  Query query = session.createQuery(queryString);
		  query.setMaxResults(listSize);
		  List<Pronunciation> prons = query.list();
		  return prons;
	  }
	  catch(RuntimeException re)
	  {
		  log.error("attach failed");
		  throw re;
	  }
  }
  
  public List<Pronunciation> getUserProns(int userId)
  {
	  log.debug("get user pronunciations");
	  try
	  {
		  String queryString = "from Pronunciation pron where pron.user.userId = :userId order by pron.city.id asc ,  pron.word.wordId asc";
		  Session session = HibernateSessionFactory.getSession();
		  Query query = session.createQuery(queryString);
		  query.setParameter("userId", userId);
		  return query.list();
		  
	  }
	  catch(RuntimeException re)
	  {
		  log.error("attach failed");
		  throw re;
	  }
  }
  
  public List<Pronunciation> getUserMapProns(int userId)
  {
	  log.debug("get user map pronunciation");
	  try
	  {
		  String queryString = "from Pronunciation pron where pron.user.userId = :userId order by pron.city.id asc ,pron.word.wordId desc";
		  Session session = HibernateSessionFactory.getSession();
		  Query query = session.createQuery(queryString);
		  query.setParameter("serId", userId);
		  return query.list();	  
		  
	  }
	  catch (RuntimeException re)
	  {
		  log.error("attach failed");
		  throw re;
	  }
  }
  
  
  
  public List<Pronunciation> getMapProns(int wordId)
  {
	  log.debug("get map pronunciations");
	  try
	  {
		  //String queryString = "select new map(pron.pronId as id,pron.goodVoteNum as goodVoteNum) from Pronunciation pron where pron.word.wordId = :wordId order by pron.goodVoteNum desc pron.city.cityId asc";
		  String queryString = "from Pronunciation pron where pron.word.wordId = :wordId order by pron.goodVoteNum asc,pron.city.id asc";
		  Session session = HibernateSessionFactory.getSession();
		  Query query= session.createQuery(queryString);
		  query.setParameter("wordId", wordId);
		  
		 
		  List<Pronunciation> mapProns = query.list();		  
          System.out.println("query invoked");
		  return mapProns;
	  }
	  catch(RuntimeException re)
	  {
		  log.error("attach failed");
		  throw re;
	  }
  }
  
  
  public void deleteAllWordPron (Word word)
  {
	  log.debug("delete all prons by word");
	  try
	  {
		  String queryString = "delete Pronunciation pron where pron.word = :word";
		  Session session = HibernateSessionFactory.getSession();
		  Transaction trans = session.beginTransaction();
		  Query query = session.createQuery(queryString);
		  query.setParameter("word", word);
		  query.executeUpdate();
		  trans.commit();
		  session.close();
		  
	  }
	  catch(RuntimeException re)
	  {
		  log.error("delete failed!");
		  throw re;
	  }
  }
  
  public void deletePron (Pronunciation pron)
  {
	  delete(pron);
  }
  
}