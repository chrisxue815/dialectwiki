package org.dw.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.dw.dao.PronunciationDAO;
import org.dw.model.Pronunciation;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Pronunciation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.dw.model.Pronunciation
 * @author MyEclipse Persistence Tools
 */

public class PronunciationDAOImpl extends HibernateDaoSupport implements
    PronunciationDAO
{
  private static final Logger log = LoggerFactory
      .getLogger(PronunciationDAOImpl.class);

  protected void initDao()
  {
    // do nothing
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.dw.dao.impl.PronunciationDAO#save(org.dw.model.Pronunciation)
   */
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

  /*
   * (non-Javadoc)
   * 
   * @see org.dw.dao.impl.PronunciationDAO#delete(org.dw.model.Pronunciation)
   */
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

  /*
   * (non-Javadoc)
   * 
   * @see org.dw.dao.impl.PronunciationDAO#findById(java.lang.Integer)
   */
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

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.dw.dao.impl.PronunciationDAO#findByExample(org.dw.model.Pronunciation)
   */
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

  /*
   * (non-Javadoc)
   * 
   * @see org.dw.dao.impl.PronunciationDAO#findByProperty(java.lang.String,
   * java.lang.Object)
   */
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

  /*
   * (non-Javadoc)
   * 
   * @see org.dw.dao.impl.PronunciationDAO#findByUserId(java.lang.Object)
   */
  public List<Pronunciation> findByUserId(Object userId)
  {
    return findByProperty(USER_ID, userId);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.dw.dao.impl.PronunciationDAO#findByWordId(java.lang.Object)
   */
  public List<Pronunciation> findByWordId(Object wordId)
  {
	System.out.println("PronsDAO:" + wordId);
    return findByProperty(WORD_ID, wordId);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.dw.dao.impl.PronunciationDAO#findByPrUrl(java.lang.Object)
   */
  public List<Pronunciation> findByPrUrl(Object prUrl)
  {
    return findByProperty(PR_URL, prUrl);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.dw.dao.impl.PronunciationDAO#findByGoodVoteNum(java.lang.Object)
   */
  public List<Pronunciation> findByGoodVoteNum(Object goodVoteNum)
  {
    return findByProperty(GOOD_VOTE_NUM, goodVoteNum);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.dw.dao.impl.PronunciationDAO#findByBadVoteNum(java.lang.Object)
   */
  public List<Pronunciation> findByBadVoteNum(Object badVoteNum)
  {
    return findByProperty(BAD_VOTE_NUM, badVoteNum);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.dw.dao.impl.PronunciationDAO#findAll()
   */
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

  /*
   * (non-Javadoc)
   * 
   * @see org.dw.dao.impl.PronunciationDAO#merge(org.dw.model.Pronunciation)
   */
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

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.dw.dao.impl.PronunciationDAO#attachDirty(org.dw.model.Pronunciation)
   */
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

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.dw.dao.impl.PronunciationDAO#attachClean(org.dw.model.Pronunciation)
   */
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
}