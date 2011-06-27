package org.dw.dao.impl;

import java.util.List;
import java.util.Set;

import org.dw.dao.AuthorityDAO;
import org.dw.hibernate.HibernateSessionFactory;
import org.dw.model.Authority;
import org.dw.model.User;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Authority entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.dw.model.Authority
 * @author MyEclipse Persistence Tools
 */

public class AuthorityDAOImpl extends HibernateDaoSupport implements AuthorityDAO
{
  private static final Logger log = LoggerFactory.getLogger(AuthorityDAOImpl.class);
  private static final String ROLE_USER = "ROLE_USER";
  private static final String ROLE_FORBIDDEN = "ROLE_FORBIDDEN";
  protected void initDao()
  {
    // do nothing
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.AuthorityDAO#save(org.dw.model.Authority)
   */
  public void save(Authority transientInstance)
  {
    log.debug("saving Authority instance");
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
   * @see org.dw.dao.impl.AuthorityDAO#delete(org.dw.model.Authority)
   */
  public void delete(Authority persistentInstance)
  {
    log.debug("deleting Authority instance");
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
   * @see org.dw.dao.impl.AuthorityDAO#findById(java.lang.String)
   */
  public Authority findById(java.lang.String id)
  {
    log.debug("getting Authority instance with id: " + id);
    try
    {
      Authority instance = (Authority) getHibernateTemplate().get(
          "org.dw.model.Authority", id);
      return instance;
    } catch (RuntimeException re)
    {
      log.error("get failed", re);
      throw re;
    }
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.AuthorityDAO#findByExample(org.dw.model.Authority)
   */
  public List<Authority> findByExample(Authority instance)
  {
    log.debug("finding Authority instance by example");
    try
    {
      List<Authority> results = getHibernateTemplate().findByExample(instance);
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re)
    {
      log.error("find by example failed", re);
      throw re;
    }
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.AuthorityDAO#findByProperty(java.lang.String, java.lang.Object)
   */
  public List<Authority> findByProperty(String propertyName, Object value)
  {
    log.debug("finding Authority instance with property: " + propertyName
        + ", value: " + value);
    try
    {
      String queryString = "from Authority as model where model."
          + propertyName + "= ?";
      return getHibernateTemplate().find(queryString, value);
    } catch (RuntimeException re)
    {
      log.error("find by property name failed", re);
      throw re;
    }
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.AuthorityDAO#findByAuthority(java.lang.Object)
   */
  public List<Authority> findByAuthority(Object authority)
  {
    return findByProperty(AUTHORITY, authority);
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.AuthorityDAO#findAll()
   */
  public List<Authority> findAll()
  {
    log.debug("finding all Authority instances");
    try
    {
      String queryString = "from Authority";
      return getHibernateTemplate().find(queryString);
    } catch (RuntimeException re)
    {
      log.error("find all failed", re);
      throw re;
    }
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.AuthorityDAO#merge(org.dw.model.Authority)
   */
  public Authority merge(Authority detachedInstance)
  {
    log.debug("merging Authority instance");
    try
    {
      Authority result = (Authority) getHibernateTemplate().merge(
          detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re)
    {
      log.error("merge failed", re);
      throw re;
    }
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.AuthorityDAO#attachDirty(org.dw.model.Authority)
   */
  public void attachDirty(Authority instance)
  {
    log.debug("attaching dirty Authority instance");
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
   * @see org.dw.dao.impl.AuthorityDAO#attachClean(org.dw.model.Authority)
   */
  public void attachClean(Authority instance)
  {
    log.debug("attaching clean Authority instance");
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

  public static AuthorityDAO getFromApplicationContext(ApplicationContext ctx)
  {
    return (AuthorityDAO) ctx.getBean("AuthorityDAO");
  }
  
  
  public void enableUserRole(User user)
  {
	  log.debug("set user authority ROLE_USER");
	  try
	  {
		Set<Authority> userAuthorities = user.getAuthorities();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		for(Authority authority:userAuthorities)
		{
			if(authority.getAuthority().equals(ROLE_FORBIDDEN))
			{
				authority.setAuthority(ROLE_USER);
				session.update(authority);
				trans.commit();
			}
		}
		session.close();
	  }
	  catch(RuntimeException re)
	  {
		  log.error("update failed");
		  throw re;
	  }
  }
  
  public void disableUserRole(User user)
  {
	  log.debug("set user authority ROLE_FORBIDDEN");
	  try
	  {
		Set<Authority> userAuthorities = user.getAuthorities();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		for(Authority authority:userAuthorities)
		{
			if(authority.getAuthority().equals(ROLE_USER))
			{
				authority.setAuthority(ROLE_FORBIDDEN);
				session.update(authority);
				trans.commit();
			}
		}
		session.close();
	  }
	  catch(RuntimeException re)
	  {
		  log.error("update failed");
		  throw re;
	  }
  }
}