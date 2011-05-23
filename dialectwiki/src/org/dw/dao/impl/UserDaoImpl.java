package org.dw.dao.impl;

import org.dw.dao.UserDao;
import org.dw.hibernate.HibernateSessionFactory;
import org.dw.model.User;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserDaoImpl implements UserDao {

	public boolean signup(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(null);  //null 替换成对应的sql语句
		return false;
	}

}
