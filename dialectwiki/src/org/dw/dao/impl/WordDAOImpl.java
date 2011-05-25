package org.dw.dao.impl;

import java.util.List;

import org.dw.dao.WordDAO;
import org.dw.model.Word;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Word
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.dw.model.Word
 * @author MyEclipse Persistence Tools
 */

public class WordDAOImpl extends HibernateDaoSupport implements WordDAO
{  
  public static final String WORD_NAME = "wordName";
  private static final Logger log = LoggerFactory.getLogger(WordDAOImpl.class);
  
  protected void initDao()
  {
    // do nothing
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.WordDao#save(org.dw.hibernate.Word)
   */
  public void save(Word transientInstance)
  {
    log.debug("saving Word instance");
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

  /* (non-Javadoc)
   * @see org.dw.dao.impl.WordDao#delete(org.dw.hibernate.Word)
   */
  public void delete(Word persistentInstance)
  {
    log.debug("deleting Word instance");
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

  /* (non-Javadoc)
   * @see org.dw.dao.impl.WordDao#findById(java.lang.Integer)
   */
  public Word findById(java.lang.Integer id)
  {
    log.debug("getting Word instance with id: " + id);
    try
    {
      Word instance = (Word) getHibernateTemplate().get(
          "org.dw.hibernate.Word", id);
      return instance;
    } catch (RuntimeException re)
    {
      log.error("get failed", re);
      throw re;
    }
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.WordDao#findByExample(org.dw.hibernate.Word)
   */
  public List<Word> findByExample(Word instance)
  {
    log.debug("finding Word instance by example");
    try
    {
      List<Word> results = getHibernateTemplate().findByExample(instance);
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re)
    {
      log.error("find by example failed", re);
      throw re;
    }
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.WordDao#findByProperty(java.lang.String, java.lang.Object)
   */
  public List<Word> findByProperty(String propertyName, Object value)
  {
    log.debug("finding Word instance with property: " + propertyName
        + ", value: " + value);
    try
    {
      String queryString = "from Word as model where model." + propertyName
          + "= ?";
      return getHibernateTemplate().find(queryString, value);
    } catch (RuntimeException re)
    {
      log.error("find by property name failed", re);
      throw re;
    }
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.WordDao#findByWordName(java.lang.Object)
   */
  public List<Word> findByWordName(Object wordName)
  {
    return findByProperty(WORD_NAME, wordName);
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.WordDao#findAll()
   */
  public List<Word> findAll()
  {
    log.debug("finding all Word instances");
    try
    {
      String queryString = "from Word";
      return getHibernateTemplate().find(queryString);
    } catch (RuntimeException re)
    {
      log.error("find all failed", re);
      throw re;
    }
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.WordDao#merge(org.dw.hibernate.Word)
   */
  public Word merge(Word detachedInstance)
  {
    log.debug("merging Word instance");
    try
    {
      Word result = (Word) getHibernateTemplate().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re)
    {
      log.error("merge failed", re);
      throw re;
    }
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.WordDao#attachDirty(org.dw.hibernate.Word)
   */
  public void attachDirty(Word instance)
  {
    log.debug("attaching dirty Word instance");
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

  /* (non-Javadoc)
   * @see org.dw.dao.impl.WordDao#attachClean(org.dw.hibernate.Word)
   */
  public void attachClean(Word instance)
  {
    log.debug("attaching clean Word instance");
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

  public static WordDAO getFromApplicationContext(ApplicationContext ctx)
  {
    return (WordDAO) ctx.getBean("WordDAO");
  }
}