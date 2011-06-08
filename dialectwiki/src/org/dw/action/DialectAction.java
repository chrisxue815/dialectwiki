package org.dw.action;

import java.util.List;

import org.dw.model.Pronunciation;
import org.dw.model.Province;
import org.dw.service.ProvinceService;

import com.opensymphony.xwork2.ActionSupport;

public class DialectAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9110988604739715665L;
	private static final String PROVINCE_NOT_EXIST = "PROVINCE_NOT_EXIST";
	
	
	
	
	private ProvinceService provinceService;
	private List<Pronunciation> prons;
	private Province province;
	private String id;

	
	public ProvinceService getProvinceService() {
		return provinceService;
	}
	public void setProvinceService(ProvinceService provinceService) {
		this.provinceService = provinceService;
	}
	public List<Pronunciation> getProns() {
		return prons;
	}
	public void setProns(List<Pronunciation> prons) {
		this.prons = prons;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String execute()
	{
	    if(id != null)
	    {
	    	try
	    	{
	    		int idInt = Integer.parseInt(id);
	    		province = provinceService.getProvinceByID(idInt);
	    		if(province != null)
	    		{
	    			prons = provinceService.getProvinceProns(idInt);
	    			return SUCCESS;
	    		}
	    		else
	    		{
	    			return PROVINCE_NOT_EXIST;
	    		}
	    		
	    	}
	    	catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    		return ERROR;
	    	}
	    }
	    else
	    {
	    	return ERROR;
	    }
		
		
	}
	
	

}
