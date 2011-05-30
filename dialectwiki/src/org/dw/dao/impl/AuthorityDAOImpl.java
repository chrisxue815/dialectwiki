package org.dw.dao.impl;

import org.dw.dao.AuthorityDAO;
import org.dw.hibernate.HibernateSessionFactory;
import org.dw.model.Authority;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthorityDAOImpl implements AuthorityDAO
{

  public boolean setAuthority(Authority authorities)
  {
    try
    {
      Session session = HibernateSessionFactory.getSession();
      Transaction trans = session.beginTransaction();
      session.save(authorities);
      trans.commit();
      session.close();
    }
    catch (RuntimeException ex)
    {
      ex.printStackTrace();
    }
    return true;
  }

}
