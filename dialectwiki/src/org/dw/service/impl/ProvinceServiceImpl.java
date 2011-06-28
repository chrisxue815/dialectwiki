package org.dw.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.dw.dao.ProvinceDAO;
import org.dw.model.City;
import org.dw.model.Pronunciation;
import org.dw.model.Province;
import org.dw.model.Word;
import org.dw.service.ProvinceService;

public class ProvinceServiceImpl implements ProvinceService {
	private ProvinceDAO provinceDAO;

	public ProvinceDAO getProvinceDAO() {
		return provinceDAO;
	}


	public void setProvinceDAO(ProvinceDAO provinceDAO) {
		this.provinceDAO = provinceDAO;
	}


	public Province getProvinceByID(int provinceId) {
		return provinceDAO.findById(provinceId);
	}


	public List<Pronunciation> getProvinceProns(int provinceId) {
		List<Pronunciation> provinceProns = new ArrayList<Pronunciation>();
		Province province = getProvinceByID(provinceId);
		Set<City> proviceCitys = province.getCities();
		for(City city : proviceCitys)
		{
			Set<Pronunciation> cityProns = city.getPronunciations();
			for(Pronunciation pron : cityProns)
			{
				provinceProns.add(pron);
			}
		}
		return provinceProns;
	}
	


}
