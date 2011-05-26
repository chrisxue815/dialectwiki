package org.dw.dao.impl;

import java.util.List;
import org.dw.dao.WordDAO;
import org.dw.hibernate.HibernateSessionFactory;
import org.dw.model.Word;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class WordDAOImpl implements WordDAO
{
	public boolean addWord(Word word){
		String wordName = word.getWordName();
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from dw_word where word_name = :wordname");
		query.setString("wordname", wordName);
		List wordNames = query.list();
		if(wordNames.size() < 0){
			Transaction trans = session.beginTransaction();
			session.save(word);
			trans.commit();
			session.close();
			
			return true;
		}
		else{
			session.close();
			return false;
		}
	}
}