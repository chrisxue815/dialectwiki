package org.dw.action;

import java.net.URLEncoder;
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

public class WordAction extends ActionSupport
{
  public static final String WORD_NOT_EXIST = "wordNotExist";
  public static final String WORDS = "words";
  public static final String INVALID_ID = "invalidId";
  public static final String PRONOUNCE = "pronounce";

  private static final long serialVersionUID = 2409752678054918663L;
  private String id;
  private String name;
  private WordService wordService;
  private PronunciationService pronunciationService;

  private Word word;
  private List<Pronunciation> prons;
  private int citySize;
  private List<String> cityNames;

  public List<Pronunciation> getProns()
  {
    return prons;
  }

  public void setProns(List<Pronunciation> prons)
  {
    this.prons = prons;
  }

  public List<String> getCityNames()
  {
    return cityNames;
  }

  public void setCityNames(List<String> cityNames)
  {
    this.cityNames = cityNames;
  }

  public int getCitySize()
  {
    return citySize;
  }

  public void setCitySize(int citySize)
  {
    this.citySize = citySize;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public WordService getWordService()
  {
    return wordService;
  }

  public void setWordService(WordService wordService)
  {
    this.wordService = wordService;
  }

  public Word getWord()
  {
    return word;
  }

  public void setWord(Word word)
  {
    this.word = word;
  }

  public PronunciationService getPronunciationService()
  {
    return pronunciationService;
  }

  public void setPronunciationService(PronunciationService pronunciationService)
  {
    this.pronunciationService = pronunciationService;
  }

  public String execute()
  {
	System.out.print("invoked");
    try
    {
      if (id != null)
      {
        int wordId = Integer.parseInt(id);
       
        word = wordService.getById(wordId);

        if (word == null)
          return WORD_NOT_EXIST;
      }
      else if (name != null)
      {
        word = wordService.findByWordName(name);
        
        if (word == null)
          return WORD_NOT_EXIST;
      }
      else
      {
        return WORDS;
      }
      
      return getWordData();
    }
    catch (NumberFormatException ex)
    {
      return INVALID_ID;
    }
  }

  public String getWordData()
  {
	System.out.println("get WordData() invoked");
    //prons = pronunciationService.searchPronunciation(word.getWordId());
    
    if (prons == null || prons.size() == 0)
      return PRONOUNCE;

    List<Province> provinceList = new ArrayList<Province>();
    List<City> cityList = new ArrayList<City>();

    List<Integer> pronsIndexs = new ArrayList<Integer>();
    List<Integer> cityIndexs = new ArrayList<Integer>();
    List<String> mapPrUrlList = new ArrayList<String>();
    
    City lastCity = null;
    City nextCity = null;

    Province lastProvince = null;
    Province nextProvince = null;

    int pronIndex = 0;
    lastCity = prons.get(pronIndex).getCity();
    
    cityList.add(lastCity);
    mapPrUrlList.add(prons.get(pronIndex).getPrUrl());
    //System.out.println(prons.get(pronIndex).getPrUrl());
    for (Pronunciation pron : prons)
    {
      nextCity = pron.getCity();
      if (false == nextCity.equals(lastCity))
      {
        lastCity = nextCity;
        pronsIndexs.add(pronIndex);
        cityList.add(lastCity);
        mapPrUrlList.add(prons.get(pronIndex).getPrUrl());
        //System.out.println(prons.get(pronIndex).getPrUrl());
        //System.out.println(prons.get(pronIndex).getCity().getCityName());
      }

      pronIndex++;

    }
    pronsIndexs.add(pronIndex);

    int cityIndex = 0;
    lastProvince = prons.get(cityIndex).getCity().getProvince();
    provinceList.add(lastProvince);

    for (City city : cityList)
    {
      nextProvince = city.getProvince();
      if (false == nextProvince.equals(lastProvince))
      {
        lastProvince = nextProvince;
        cityIndexs.add(cityIndex);
        provinceList.add(lastProvince);
      }
      cityIndex++;
    }
    cityIndexs.add(cityIndex);

    List<String> cityNames = new ArrayList<String>();
    for (City city : cityList)
    {
      cityNames.add(city.getCityName());
      //System.out.println(city.getCityName());
    }
    
    List<String> prUrlList = new ArrayList<String>();
    for(Pronunciation pron: prons)
    {
    	prUrlList.add(pron.getPrUrl());
    	//System.out.println(pron.getPrUrl());
    }
    

    ServletActionContext.getRequest().setAttribute("provinceList", provinceList);
    ServletActionContext.getRequest().setAttribute("cityList", cityList);
    ServletActionContext.getRequest().setAttribute("pronsIndexs", pronsIndexs);
    ServletActionContext.getRequest().setAttribute("cityIndexs", cityIndexs);
    ServletActionContext.getRequest().setAttribute("prons", prons);
    ServletActionContext.getRequest().setAttribute("cityNames", cityNames);
    ServletActionContext.getRequest().setAttribute("prUrlList", prUrlList);
    ServletActionContext.getRequest().setAttribute("mapPrUrlList", mapPrUrlList);
    citySize = cityList.size();
    
    for(String mapUrl : prUrlList)
    	System.out.println(mapUrl);

    return SUCCESS;

  }
}
