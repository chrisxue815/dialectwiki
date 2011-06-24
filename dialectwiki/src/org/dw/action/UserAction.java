package org.dw.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.dw.model.City;
import org.dw.model.Pronunciation;
import org.dw.model.User;
import org.dw.service.PronunciationService;
import org.dw.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

//user Details的action
public class UserAction extends ActionSupport {
	
	private static final String USER_NOT_EXIST = ERROR;
	private static final long serialVersionUID = -5955231542987946679L;
	private String id;
	private String name;
	private User user;

	private UserService userService;
	private PronunciationService pronunciationService;
	List<Pronunciation> userProns;
	List<City> mapCity;
	List<List<Pronunciation>> pronList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Pronunciation> getUserProns() {
		return userProns;
	}

	public void setUserProns(List<Pronunciation> userProns) {
		this.userProns = userProns;
	}

	public PronunciationService getPronunciationService() {
		return pronunciationService;
	}

	public void setPronunciationService(
			PronunciationService pronunciationService) {
		this.pronunciationService = pronunciationService;
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

	public String execute() {
		if (id != null) {
			int idInt = Integer.parseInt(id);
			try {
				user = userService.getUserById(idInt);
				if(user == null)
					return USER_NOT_EXIST;
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
		} else if (name != null) {
			try {
				user = userService.getUserByUserName(name);
				userProns = pronunciationService.getUserProns(user.getUserId());

				if (userProns != null)
					getMapList();

				ServletActionContext.getRequest().setAttribute("userProns",
						userProns);

			} catch (Exception ex) {
				ex.printStackTrace();
				return ERROR;// 您所查找的用户不存在
			}
		}

		return SUCCESS;
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

}
