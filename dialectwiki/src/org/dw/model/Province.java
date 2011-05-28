package org.dw.model;

import java.util.HashSet;
import java.util.Set;

public class Province {
	
	private int province_id;
	private String province_name;
	private Set<City> cities = new HashSet<City>();
	
	public Province() {
		
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	public int getProvince_id() {
		return province_id;
	}

	public void setProvince_id(int provinceId) {
		province_id = provinceId;
	}

	public String getProvince_name() {
		return province_name;
	}

	public void setProvince_name(String provinceName) {
		province_name = provinceName;
	}

}
