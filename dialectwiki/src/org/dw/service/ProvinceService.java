package org.dw.service;

import java.util.List;

import org.dw.model.Pronunciation;
import org.dw.model.Province;

public interface ProvinceService {
	public List<Pronunciation> getProvinceProns(int provinceId);
	public Province getProvinceByID(int provinceId);

}
