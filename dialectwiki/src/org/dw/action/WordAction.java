package org.dw.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.dw.model.City;
import org.dw.model.Pronunciation;
import org.dw.model.Province;
import org.dw.model.Word;
import org.dw.service.PronunciationService;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class WordAction extends ActionSupport{

	private static final long serialVersionUID = 2409752678054918663L;
	private String id;
	private String name;
	private WordService wordService;
	private PronunciationService pronunciationService;
	
	private Word word;
	private List<Pronunciation> prons;

	
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
	public WordService getWordService() {
		return wordService;
	}
	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}
	public Word getWord() {
		return word;
	}
	public void setWord(Word word) {
		this.word = word;
	}
	
	public PronunciationService getPronunciationService() {
		return pronunciationService;
	}
	public void setPronunciationService(PronunciationService pronunciationService) {
		this.pronunciationService = pronunciationService;
	}

	
	public String execute() {
	  if (id != null) {
		int wordId = Integer.parseInt(id);
		dataInit(wordId);

	   
	    return SUCCESS;
	  }
	  else if (name != null) {
	    word = wordService.findByWordName(name);
	    int wordId = word.getWordId();
	    dataInit(wordId);
	    
	    return SUCCESS;
	  }
	  else {
	    return ERROR;
	  }
	}
	
	public void dataInit(int wordId)
	{
	    int wordIdInt = Integer.parseInt(id);
	    word = wordService.getById(wordIdInt);
	    prons = pronunciationService.searchPronunciation(wordIdInt);
	    
	    List<Province> provinceList = new ArrayList<Province>();
	    List<City> cityList = new ArrayList<City>();
	    
	    List<Integer> pronsIndexs = new ArrayList<Integer>();
	    List<Integer> cityIndexs = new ArrayList<Integer>();
	    
	    City lastCity = null;
	    City nextCity = null;

	    
	    Province lastProvince = null;
	    Province nextProvince = null;
	    int provinceIndex = 0; //?
	    
	    int pronIndex = 0;
	    lastCity = prons.get(pronIndex).getCity();
	    cityList.add(lastCity);

	    for(Pronunciation pron : prons)
	    {
	    	nextCity = pron.getCity();
	    	if(false == nextCity.equals(lastCity))
	    	{
	    		lastCity = nextCity;
	    		pronsIndexs.add(pronIndex);
	    		cityList.add(lastCity);
	    	}
	    	
	    	pronIndex++;
	    	
	    }
	    pronsIndexs.add(pronIndex);
	    
	    int cityIndex = 0;
	    lastProvince = prons.get(cityIndex).getCity().getProvince();
	    provinceList.add(lastProvince);
	    
	    for(City city: cityList)
	    {
	    	nextProvince = city.getProvince();
	    	if(false == nextProvince.equals(lastProvince))
	    	{
	    		lastProvince = nextProvince;
	    		cityIndexs.add(cityIndex);
	    		provinceList.add(lastProvince);
	    	}
	    	cityIndex++;
	    }
	    cityIndexs.add(cityIndex);
	    
        ServletActionContext.getRequest().setAttribute("provinceList", provinceList);
        ServletActionContext.getRequest().setAttribute("cityList",cityList);
        ServletActionContext.getRequest().setAttribute("pronsIndexs",pronsIndexs );
        ServletActionContext.getRequest().setAttribute("cityIndexs", cityIndexs);
        ServletActionContext.getRequest().setAttribute("prons", prons);
	    
		
	}
}
