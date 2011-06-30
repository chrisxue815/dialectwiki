package org.dw.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.dw.dao.WordDAO;
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
import org.springframework.orm.hibernate3.HibernateTemplate;
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

public class WordDAOImpl extends HibernateDaoSupport implements WordDAO {
	private static final Logger log = LoggerFactory
			.getLogger(WordDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dw.dao.impl.WordDAO#save(org.dw.model.Word)
	 */
	public void save(Word transientInstance) {
		log.debug("saving Word instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dw.dao.impl.WordDAO#delete(org.dw.model.Word)
	 */
	public void delete(Word persistentInstance) {
		log.debug("deleting Word instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dw.dao.impl.WordDAO#findById(java.lang.Integer)
	 */
	public Word findById(java.lang.Integer id) {
		log.debug("getting Word instance with id: " + id);
		try {
			Word instance = (Word) getHibernateTemplate().get(
					"org.dw.model.Word", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dw.dao.impl.WordDAO#findByExample(org.dw.model.Word)
	 */
	public List<Word> findByExample(Word instance) {
		log.debug("finding Word instance by example");
		try {
			List<Word> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dw.dao.impl.WordDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List<Word> findByProperty(String propertyName, Object value) {
		log.debug("finding Word instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Word as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dw.dao.impl.WordDAO#findByWordName(java.lang.Object)
	 */
	public List<Word> findByWordName(Object wordName) {
		return findByProperty(WORD_NAME, wordName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dw.dao.impl.WordDAO#findAll()
	 */
	public List<Word> findAll() {
		log.debug("finding all Word instances");
		try {
			String queryString = "from Word";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dw.dao.impl.WordDAO#merge(org.dw.model.Word)
	 */
	public Word merge(Word detachedInstance) {
		log.debug("merging Word instance");
		try {
			Word result = (Word) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dw.dao.impl.WordDAO#attachDirty(org.dw.model.Word)
	 */
	public void attachDirty(Word instance) {
		log.debug("attaching dirty Word instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dw.dao.impl.WordDAO#attachClean(org.dw.model.Word)
	 */
	public void attachClean(Word instance) {
		log.debug("attaching clean Word instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static WordDAO getFromApplicationContext(ApplicationContext ctx) {
		return (WordDAO) ctx.getBean("WordDAO");
	}

	public Set<Pronunciation> getPronunciations(int wordId) {
		Word word = this.findById(wordId);
		Set<Pronunciation> prons = word.getPronunciations();
		return prons;
	}

	public List<Word> searchSimilarWords(String wordName, int index, int limit) {
		log.debug("searching similar words with wordName" + wordName);
		try {
			String queryString = "from Word as model where model.? like '%?%' and model.? != ? limit ?, ?";
			return getHibernateTemplate().find(queryString, WORD_NAME,
					wordName, WORD_NAME, wordName, index, limit);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List<Word> getRecentWords() {
		return getRecentWords(LIST_SIZE);
	}

	public List<Word> getRecentWords(int listSize) {
		log.debug("get recent Words with limited size 20");
		try {
			String queryString = "from Word model where model.enabled = true order by model.wordId desc limit 0,20";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List<Word> getPageRecentWords(int pageNo, int pageSize) {
		log.debug("get recent words in a page");
		try {
			int index = (pageNo - 1) * pageSize;
			String queryString = "from Word model where model.enabled = true order by model.wordId desc limit " + index + "," + pageSize;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List<Word> getHotWords() {
		return getHotWords(LIST_SIZE);
	}

	public List<Word> getHotWords(int listSize) {
		try {
			Word word = null;
			List<Word> hotWords = new ArrayList<Word>();
			String queryString = "from Word model where model.enabled = true order by model.wordId desc";
			List<Word> queryResult = getHibernateTemplate().find(queryString);

			int resultSize = queryResult.size();

			if (resultSize == 0) {
				return null;
			} else {
				for (int i = 0; i < resultSize && hotWords.size() < listSize; i++) {
					word = queryResult.get(i);
					boolean isEmpty = word.getPronunciations().isEmpty();

					if (isEmpty == false)
						hotWords.add(word);
				}
				return hotWords;
			}
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}

	}

	//////////////////////////////////////////
	public List<Word> getPageHotWords(int pageNo,int pageSize)
	{
		log.debug("attach a page of Words");
		try
		{
			int index = (pageNo -1) * pageSize;
			String queryString = "from Word model where model.wordId in (select pron.word.wordId from Pronunciation pron) and model.enabled = true order by model.wordId desc limit "+ index + "," + pageSize;
			return getHibernateTemplate().find(queryString);
		}
		catch(RuntimeException re)
		{
			log.error("attach failed",re);
			throw re;
		}
	}
	
	public List<Word> igetHotWords(int listSize) {
		try{
			List<Word> hotWords = new ArrayList<Word>();
			String queryString = "from Word model where model.wordId in (select pron.word.wordId from Pronunciation pron) and model.enabled = true order by model.wordId desc limit 0 , ?";
			hotWords = getHibernateTemplate().find(queryString,listSize);
			return hotWords;
		}catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	//////////////////////////////////////////

	public List<Word> getWaitProns() {
		return getWaitProns(LIST_SIZE);
	}

	public List<Word> getWaitProns(int listSize) {
		try {
			Word word = null;
			List<Word> waitProns = new ArrayList<Word>();
			String queryString = "from Word word where word.enabled = true order by word.wordId asc ";
			List<Word> queryResult = getHibernateTemplate().find(queryString);

			int resultSize = queryResult.size();

			if (resultSize == 0) {
				return null;
			} else {
				for (int i = 0; i < resultSize && waitProns.size() < listSize; i++) {
					word = queryResult.get(i);
					boolean isEmpty = word.getPronunciations().isEmpty();

					if (isEmpty == true)
						waitProns.add(word);
				}
				return waitProns;
			}
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	//////////////////////////////////////////////////////////
	public List<Word> igetWaitProns(int listSize)
	{
		try{
			String queryString = "from Word model where model.wordId  not in (select pron.word.wordId from Pronunciation pron) and model.enabled = true order by model.wordId desc limit 0 , ?";
			return getHibernateTemplate().find(queryString,listSize);
		}
		catch(RuntimeException re)
		{
			log.error("attach failed" ,re);
			throw re;
		}
	}
	
	public List<Word> getPageWaitProns(int pageNo,int pageSize)
	{
		try
		{
			int index = (pageNo - 1) * pageSize;
			String queryString = "from Word model where model.wordId in (select pron.word.wordId from Pronunciation pron) and model.enabled = true order by model.wordId desc limit "+ index + "," + pageSize;
			return getHibernateTemplate().find(queryString);
		}
		catch(RuntimeException re)
		{
			log.error("attach failed" ,re);
			throw re;
		}
	}
	
	////////////////////////////////////////////////////////////

	public long getWordNumber() {
		String queryString = "select count(*) from Word";
		return (Long) getHibernateTemplate().find(queryString).listIterator()
				.next();
	}

	public void enableWord(Word word) {
		log.debug("enable word");
		try {
			word.setEnabled(true);
			Session session = HibernateSessionFactory.getSession();
			Transaction trans = session.beginTransaction();
			session.update(word);
			trans.commit();
			session.close();
		} catch (RuntimeException re) {
			log.error("update failed");
			throw re;
		}
	}

	public void disableWord(Word word) {
		log.debug("disable word");
		try {
			word.setEnabled(false);
			Session session = HibernateSessionFactory.getSession();
			Transaction trans = session.beginTransaction();
			session.update(word);
			trans.commit();
			session.close();
		} catch (RuntimeException re) {
			log.error("update failed");
			throw re;
		}

	}
}