package org.dw.action;

import java.util.ArrayList;
import java.util.List;

import org.dw.model.City;
import org.dw.model.Pronunciation;
import org.dw.model.Province;
import org.dw.model.Word;
import org.dw.service.PronunciationService;
import org.dw.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class WordHomeAction extends ActionSupport{

	private static final long serialVersionUID = 2409752678054918663L;
	private String wordId;
	private String wordName;
	private WordService wordService;
	private PronunciationService pronunciationService;
	
	private Word word;
	private List<Pronunciation> prons;

	
	public String getWordId() {
		return wordId;
	}
	public void setWordId(String wordId) {
		this.wordId = wordId;
	}
	public String getWordName() {
	  return wordName;
	}
	public void setWordName(String wordName) {
	  this.wordName = wordName;
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
	  if (wordId != null) {
	    int wordIdInt = Integer.parseInt(wordId);
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
	    pronsIndexs.add(pronIndex);
	    
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
	    
	    int cityIndex = 0;
	    lastProvince = prons.get(cityIndex).getCity().getProvince();
	    cityIndexs.add(cityIndex);
	    provinceList.add(lastProvince);
	    for(City city: cityList)
	    {
	    	System.out.println("cityName:" + city.getCityName());
	    	nextProvince = city.getProvince();
	    	if(false == nextProvince.equals(lastProvince))
	    	{
	    		lastProvince = nextProvince;
	    		cityIndexs.add(cityIndex);
	    		provinceList.add(lastProvince);
	    	}
	    	cityIndex++;
	    }
	    for(Integer num : cityIndexs)
	    {
	    	System.out.println(num);
	    }
	    
	    for(Integer num : pronsIndexs)
	    {
	    	System.out.println(num);
	    }
	    
	    int i = 0;
	    cityIndex = 0;
	    pronIndex = 0;
	    for(Province province : provinceList)
	    {
	    	System.out.println("province name:" + province.getProvinceName());
	    	while(i <= cityIndexs.get(cityIndex))
	    	{
	    		System.out.println("    city name:" + cityList.get(i).getCityName());
	    		i++;
	    	}
	    	cityIndex++;
	    }
	    
	    
	    
	    return SUCCESS;
	  }
	  else if (wordName != null) {
	    word = wordService.findByWordName(wordName);
	    prons = pronunciationService.searchPronunciation(word.getWordId());
	    
	    return SUCCESS;
	  }
	  else {
	    return ERROR;
	  }
	}
	
}
