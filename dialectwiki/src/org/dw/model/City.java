package org.dw.model;

import java.util.HashSet;
import java.util.Set;

public class City {
	
	private int city_id;
	private String city_name;
	private Province province;
	private Set<Pronunciation> pronunciation = new HashSet<Pronunciation>();

	public City() {
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int cityId) {
		city_id = cityId;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String cityName) {
		city_name = cityName;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Set<Pronunciation> getPronunciation() {
		return pronunciation;
	}

	public void setPronunciation(Set<Pronunciation> pronunciation) {
		this.pronunciation = pronunciation;
	}
	
	

}
