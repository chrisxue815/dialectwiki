package org.dw.dao.impl;

import java.util.List;

import org.dw.dao.VoteDAO;
import org.dw.model.Vote;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Vote
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.dw.model.Vote
 * @author MyEclipse Persistence Tools
 */

public class VoteDAOImpl extends HibernateDaoSupport implements VoteDAO
{
  private static final Logger log = LoggerFactory.getLogger(VoteDAOImpl.class);

  protected void initDao()
  {
    // do nothing
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.dw.dao.impl.VoteDAO#save(org.dw.model.Vote)
   */
  public void save(Vote transientInstance)
  {
    log.debug("saving Vote instance");
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
   * @see org.dw.dao.impl.VoteDAO#delete(org.dw.model.Vote)
   */
  public void delete(Vote persistentInstance)
  {
    log.debug("deleting Vote instance");
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
   * @see org.dw.dao.impl.VoteDAO#findById(org.dw.model.VoteId)
   */
  public Vote findById(org.dw.model.VoteId id)
  {
    log.debug("getting Vote instance with id: " + id);
    try
    {
      Vote instance = (Vote) getHibernateTemplate()
          .get("org.dw.model.Vote", id);
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
   * @see org.dw.dao.impl.VoteDAO#findByExample(org.dw.model.Vote)
   */
  public List<Vote> findByExample(Vote instance)
  {
    log.debug("finding Vote instance by example");
    try
    {
      List<Vote> results = getHibernateTemplate().findByExample(instance);
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
   * @see org.dw.dao.impl.VoteDAO#findByProperty(java.lang.String,
   * java.lang.Object)
   */
  public List<Vote> findByProperty(String propertyName, Object value)
  {
    log.debug("finding Vote instance with property: " + propertyName
        + ", value: " + value);
    try
    {
      String queryString = "from Vote as model where model." + propertyName
          + "= ?";
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
   * @see org.dw.dao.impl.VoteDAO#findByMark(java.lang.Object)
   */
  public List<Vote> findByMark(Object mark)
  {
    return findByProperty(MARK, mark);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.dw.dao.impl.VoteDAO#findAll()
   */
  public List<Vote> findAll()
  {
    log.debug("finding all Vote instances");
    try
    {
      String queryString = "from Vote";
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
   * @see org.dw.dao.impl.VoteDAO#merge(org.dw.model.Vote)
   */
  public Vote merge(Vote detachedInstance)
  {
    log.debug("merging Vote instance");
    try
    {
      Vote result = (Vote) getHibernateTemplate().merge(detachedInstance);
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
   * @see org.dw.dao.impl.VoteDAO#attachDirty(org.dw.model.Vote)
   */
  public void attachDirty(Vote instance)
  {
    log.debug("attaching dirty Vote instance");
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
   * @see org.dw.dao.impl.VoteDAO#attachClean(org.dw.model.Vote)
   */
  public void attachClean(Vote instance)
  {
    log.debug("attaching clean Vote instance");
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

  public static VoteDAO getFromApplicationContext(ApplicationContext ctx)
  {
    return (VoteDAO) ctx.getBean("VoteDAO");
  }
}