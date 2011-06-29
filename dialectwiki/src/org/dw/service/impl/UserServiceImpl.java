package org.dw.service.impl;

import java.util.List;
import java.util.Set;

import org.dw.dao.AuthorityDAO;
import org.dw.dao.PronunciationDAO;
import org.dw.dao.UserDAO;
import org.dw.macro.MACRO_USER;
import org.dw.model.Authority;
import org.dw.model.Pronunciation;
import org.dw.model.User;
import org.dw.service.UserService;

public class UserServiceImpl implements UserService
{
  private UserDAO userDAO;
  private AuthorityDAO authorityDAO;
  private PronunciationDAO pronunciationDAO;
  
  

  public PronunciationDAO getPronunciationDAO() {
	return pronunciationDAO;
  }

  public void setPronunciationDAO(PronunciationDAO pronunciationDAO) {
	this.pronunciationDAO = pronunciationDAO;
  }

  public UserDAO getUserDAO()
  {
    return userDAO;
  }

  public void setUserDAO(UserDAO userDAO)
  {
    this.userDAO = userDAO;
  }

  public AuthorityDAO getAuthorityDAO()
  {
    return authorityDAO;
  }

  public void setAuthorityDAO(AuthorityDAO authorityDAO)
  {
    this.authorityDAO = authorityDAO;
  }

  public void signup(User user)
  {
    Authority authorities = new Authority(user.getUsername(),
        MACRO_USER.ROLE_USER);
    
    userDAO.save(user);
    authorityDAO.save(authorities);
  }

	public User getUserByUserName(String userName) {
		return (User) userDAO.findByUsername(userName).get(0);
	}
	
	public Set<Pronunciation> getUserProns(String userName)
	{
		User user = this.getUserByUserName(userName);
		return user.getPronunciations();
	}
	
	public List<User> getNBUsers(int listSize)
	{
		return userDAO.findNBUsers(listSize);
	}
    public List<User> getNBUsers()
    {
    	return userDAO.findNBUsers();
    }
    
    public User getUserById(int userId)
    {
    	return userDAO.findById(userId);
    }
    public List<User> getGOODUsers(int listSize)
    {
    	return userDAO.findGOODUsers(listSize);
    }
    public List<User> getGOODUsers()
    {
    	return userDAO.findGOODUsers();
    	
    }
    
    public void enableUser(User user)
    {
    	userDAO.enableUser(user);
    }
    
    public void disableUser(User user)
    {
    	userDAO.disableUser(user);
    }
    
    public Authority getUserAuthority(User user)
    {
    	return authorityDAO.findUserAuthority(user);
    }
}
