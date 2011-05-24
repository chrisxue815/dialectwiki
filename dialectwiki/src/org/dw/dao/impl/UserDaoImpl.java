package org.dw.dao.impl;



import org.dw.dao.UserDAO;
import org.dw.hibernate.HibernateSessionFactory;
import org.dw.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOImpl implements UserDAO {

	public boolean signup(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		session.save(user);
		trans.commit();
		
		return true;
	}

}
