package org.dw.dao.impl;

import org.dw.dao.AuthorityDAO;
import org.dw.hibernate.HibernateSessionFactory;
import org.dw.model.Authorities;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthorityDAOImpl implements AuthorityDAO {

	public boolean setAuthority(Authorities authorities) {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		session.save(authorities);
		trans.commit();
		session.close();
		return true;
	}

}
