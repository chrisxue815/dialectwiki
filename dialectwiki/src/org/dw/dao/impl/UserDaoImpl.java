package org.dw.dao.impl;

import org.dw.dao.UserDAO;
import org.dw.hibernate.HibernateSessionFactory;
import org.dw.model.User;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserDAOImpl implements UserDAO {

	public boolean signup(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(null);  
		return false;
	}

}
