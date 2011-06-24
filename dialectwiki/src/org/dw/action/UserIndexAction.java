package org.dw.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.dw.model.City;
import org.dw.model.Pronunciation;
import org.dw.model.User;
import org.dw.service.PronunciationService;
import org.dw.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;

import com.opensymphony.xwork2.ActionSupport;

//user首页的action
public class UserIndexAction extends ActionSupport {

	private static final long serialVersionUID = 4300539552214668482L;
	
	private List<User> NBUsers;
	private List<User> GOODUsers;
    private UserService userService;
    private User user;
    
	private PronunciationService pronunciationService;
	private List<Pronunciation> userProns;
	private List<City> mapCity;
	private List<List<Pronunciation>> pronList;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getNBUsers() {
		return NBUsers;
	}

	public void setNBUsers(List<User> nBUsers) {
		NBUsers = nBUsers;
	}
	
	

	public List<User> getGOODUsers() {
		return GOODUsers;
	}

	public void setGOODUsers(List<User> gOODUsers) {
		GOODUsers = gOODUsers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String execute()
	{
		int listSize = 20;
		NBUsers = userService.getNBUsers(listSize);
		GOODUsers = userService.getGOODUsers(listSize);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if( ! username.equals("anonymousUser"))
		{
			user = userService.getUserByUserName(username);
		}
		if(user == null)
			return SUCCESS;
		int idInt = user.getUserId();
		try {
			userProns = pronunciationService.getUserProns(idInt);

			if (userProns != null && userProns.size() != 0)
				getMapList();

			ServletActionContext.getRequest().setAttribute("mapCity",
					mapCity);
			ServletActionContext.getRequest().setAttribute("pronList",
					pronList);

		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;// 您所查找的用户不存在
		}
		return SUCCESS;
	}

	public List<City> getMapCity() {
		return mapCity;
	}

	public void setMapCity(List<City> mapCity) {
		this.mapCity = mapCity;
	}

	public List<List<Pronunciation>> getPronList() {
		return pronList;
	}

	public void setPronList(List<List<Pronunciation>> pronList) {
		this.pronList = pronList;
	}
	public void getMapList() {
		if (userProns != null) {
			for (Pronunciation pron : userProns) {
				System.out.println("pron city:" + pron.getCity().getCityName()
						+ " ;word" + pron.getWord().getWordName());
			}
			Pronunciation lastPron, nextPron;
			lastPron = userProns.get(0);
			nextPron = lastPron;

			mapCity = new ArrayList<City>();
			pronList = new ArrayList<List<Pronunciation>>();

			mapCity.add(nextPron.getCity());
			pronList.add(new ArrayList<Pronunciation>());
			// System.out.println(nextPron.getCity());
			int index = 0;

			while (true) {
				if (!nextPron.getCity().equals(lastPron.getCity())) {
					mapCity.add(nextPron.getCity());
					pronList.add(new ArrayList<Pronunciation>());
					int cityIndex = mapCity.size() - 1;
					pronList.get(cityIndex).add(nextPron);

				} else {
					pronList.get(mapCity.size() - 1).add(nextPron);
				}

				index++;
				if (index == userProns.size())
					break;
				lastPron = nextPron;
				nextPron = userProns.get(index);
			}
			
			/*
			int i = 0;
			
			for (City city : mapCity) {
				System.out.println(city.getCityName());
				for (Pronunciation pron : pronList.get(i)) {
					System.out.println("   " + pron.getWord().getWordName());
				}
				i++;
			}
			*/

		}
	}

	public PronunciationService getPronunciationService() {
		return pronunciationService;
	}

	public void setPronunciationService(PronunciationService pronunciationService) {
		this.pronunciationService = pronunciationService;
	}

	public List<Pronunciation> getUserProns() {
		return userProns;
	}

	public void setUserProns(List<Pronunciation> userProns) {
		this.userProns = userProns;
	}

}
