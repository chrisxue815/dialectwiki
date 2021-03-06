package org.dw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.dw.dao.UserDAO;
import org.dw.hibernate.HibernateSessionFactory;
import org.dw.model.Authority;
import org.dw.model.User;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.dw.model.User
 * @author MyEclipse Persistence Tools
 */

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO
{
  private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
  protected void initDao()
  {
    // do nothing
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.UserDAO#save(org.dw.model.User)
   */
  public void save(User transientInstance)
  {
    log.debug("saving User instance");
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
   * @see org.dw.dao.impl.UserDAO#delete(org.dw.model.User)
   */
  public void delete(User persistentInstance)
  {
    log.debug("deleting User instance");
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
   * @see org.dw.dao.impl.UserDAO#findById(java.lang.Integer)
   */
  public User findById(java.lang.Integer id)
  {
    log.debug("getting User instance with id: " + id);
    try
    {
      User instance = (User) getHibernateTemplate()
          .get("org.dw.model.User", id);
      return instance;
    } catch (RuntimeException re)
    {
      log.error("get failed", re);
      throw re;
    }
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.UserDAO#findByExample(org.dw.model.User)
   */
  public List<User> findByExample(User instance)
  {
    log.debug("finding User instance by example");
    try
    {
      List<User> results = getHibernateTemplate().findByExample(instance);
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re)
    {
      log.error("find by example failed", re);
      throw re;
    }
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.UserDAO#findByProperty(java.lang.String, java.lang.Object)
   */
  public List<User> findByProperty(String propertyName, Object value)
  {
    log.debug("finding User instance with property: " + propertyName
        + ", value: " + value);
    try
    {
      String queryString = "from User as model where model." + propertyName
          + "= ?";
      return getHibernateTemplate().find(queryString, value);
    } catch (RuntimeException re)
    {
      log.error("find by property name failed", re);
      throw re;
    }
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.UserDAO#findByUsername(java.lang.Object)
   */
  public List<User> findByUsername(Object username)
  {
    return findByProperty(USERNAME, username);
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.UserDAO#findByPassword(java.lang.Object)
   */
  public List<User> findByPassword(Object password)
  {
    return findByProperty(PASSWORD, password);
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.UserDAO#findByEnabled(java.lang.Object)
   */
  public List<User> findByEnabled(Object enabled)
  {
    return findByProperty(ENABLED, enabled);
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.UserDAO#findByEmail(java.lang.Object)
   */
  public List<User> findByEmail(Object email)
  {
    return findByProperty(EMAIL, email);
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.UserDAO#findBySex(java.lang.Object)
   */
  public List<User> findBySex(Object sex)
  {
    return findByProperty(SEX, sex);
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.UserDAO#findAll()
   */
  public List<User> findAll()
  {
    log.debug("finding all User instances");
    try
    {
      String queryString = "from User";
      return getHibernateTemplate().find(queryString);
    } catch (RuntimeException re)
    {
      log.error("find all failed", re);
      throw re;
    }
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.UserDAO#merge(org.dw.model.User)
   */
  public User merge(User detachedInstance)
  {
    log.debug("merging User instance");
    try
    {
      User result = (User) getHibernateTemplate().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re)
    {
      log.error("merge failed", re);
      throw re;
    }
  }
  
  public void update(User user)
  {
    log.debug("updating User instance");
    try
    {
      getHibernateTemplate().update(user);
      log.debug("update successful");
    } catch (RuntimeException re)
    {
      log.error("update failed", re);
      throw re;
    }
  }

  /* (non-Javadoc)
   * @see org.dw.dao.impl.UserDAO#attachDirty(org.dw.model.User)
   */
  public void attachDirty(User instance)
  {
    log.debug("attaching dirty User instance");
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
   * @see org.dw.dao.impl.UserDAO#attachClean(org.dw.model.User)
   */
  public void attachClean(User instance)
  {
    log.debug("attaching clean User instance");
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

  public static UserDAO getFromApplicationContext(ApplicationContext ctx)
  {
    return (UserDAO) ctx.getBean("UserDAO");
  }
  
  public List<User> findNBUsers()
  {
	int listSize = 20;
	return findNBUsers(listSize);  
  }
  
  public List<User> findNBUsers(int listSize)
  {
	log.debug("get NB User list");
	try
	{
		List<User> NBUsers = new ArrayList<User>();
		String queryString = "from User model where model.userId in (select pron.user.userId from Pronunciation pron group by pron.user.userId order by count(*) desc)";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(queryString);
		query.setMaxResults(listSize);
		
		NBUsers = query.list();
		return NBUsers;
	}
	catch(RuntimeException re)
	{
		log.error("attach failed");
		throw re;
	}
  }
  
  
  public List<User> findGOODUsers()
  {
	int listSize = 20;  
	return findGOODUsers(listSize);
  }
  
  public List<User> findGOODUsers(int listSize)
  {
	  log.debug("get GOOD User list");
	  try
	  {
		  List<User> GOODUsers = new ArrayList<User>();
		  String queryString = "from User model where model.userId in (select pron.user.userId from Pronunciation pron group by pron.user.userId order by sum(goodVoteNum) desc , sum(badVoteNum) asc)";
		  Session session = HibernateSessionFactory.getSession();
		  Query query = session.createQuery(queryString);
		  query.setMaxResults(listSize);
		  
		  GOODUsers = query.list();
		  
		  return GOODUsers;
		  
	  }
	  catch (RuntimeException re)
	  {
		  log.error("attach failed");
		  throw re;
	  }
	  
  }
  
  
  public void enableUser(User user)
  {
	log.debug("enable User");
	try
	{
		user.setEnabled(true);
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		session.update(user);	
		trans.commit();
	}
	catch(RuntimeException re)
	{
		log.error("update failed");
		throw re;
	}
  }
  
  public void disableUser(User user)
  {
	  log.debug("enable User");
	  try
	  {
		  user.setEnabled(false);
		  Session session = HibernateSessionFactory.getSession();
		  Transaction trans = session.beginTransaction();
		  session.update(user);	
		  trans.commit();
	  }
	  catch(RuntimeException re)
	  {
		  log.error("update failed");
		  throw re;
	  }
	  
  }
  

}