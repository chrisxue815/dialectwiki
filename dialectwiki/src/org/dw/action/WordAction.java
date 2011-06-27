package org.dw.action;

import java.util.ArrayList;
import java.util.List;
import org.dw.model.City;
import org.dw.model.Pronunciation;
import org.dw.model.Word;
import org.dw.service.PronunciationService;
import org.dw.service.WordService;
import org.dw.utils.MyStringUtils;

import com.opensymphony.xwork2.ActionSupport;

public class WordAction extends ActionSupport {
	public static final String ID_NOT_EXIST = "idNotExist";
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
	private List<Pronunciation> mapProns;

	private List<List<Pronunciation>> pronList;
	private List<City> cityList;

	public List<Pronunciation> getProns() {
		return prons;
	}

	public void setProns(List<Pronunciation> prons) {
		this.prons = prons;
	}

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

	public void setPronunciationService(
			PronunciationService pronunciationService) {
		this.pronunciationService = pronunciationService;
	}

	public List<Pronunciation> getMapProns() {
		return mapProns;
	}

	public void setMapProns(List<Pronunciation> mapProns) {
		this.mapProns = mapProns;
	}

	public List<List<Pronunciation>> getPronList() {
		return pronList;
	}

	public void setPronList(List<List<Pronunciation>> pronList) {
		this.pronList = pronList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public String execute() {
		try {
			if (id != null && id != "") {
				int wordId = Integer.parseInt(id);
				word = wordService.getById(wordId);
				if (word == null)
					return ID_NOT_EXIST;
			} else if (name != null && name != "") {
				name = MyStringUtils.replaceBlank(name);
				word = wordService.findByWordName(name);
				if (word == null)
					return WORD_NOT_EXIST;
			} else {
				return WORDS;
			}
			return getWordData();
		} catch (NumberFormatException ex) {
			return INVALID_ID;
		}
	}

	public String getWordData() {
		int i;
		getMapProns(word.getWordId());

		System.out.println("get WordData() invoked");
		prons = pronunciationService.searchPronunciation(word.getWordId());

		pronList = new ArrayList<List<Pronunciation>>();
		cityList = new ArrayList<City>();
		if (prons == null || prons.size() == 0) {
			return PRONOUNCE;
		}

		City lastCity = null;
		City nextCity = null;

		int pronIndex = 0;
		lastCity = prons.get(pronIndex).getCity();

		i = 0;
		// city合并
		cityList.add(lastCity);
		pronList.add(new ArrayList<Pronunciation>());
		for (Pronunciation pron : prons) {
			nextCity = pron.getCity();
			if (false == nextCity.equals(lastCity)) {
				lastCity = nextCity;
				cityList.add(lastCity);
				pronList.add(new ArrayList<Pronunciation>());
				i++;
			}
			pronList.get(i).add(pron);
		}

		return SUCCESS;

	}

	public void getMapProns(int wordId) {
		mapProns = pronunciationService.getMapProns(wordId);
		for (Pronunciation pron : mapProns) {
			System.out.println(pron.getWord().getWordName()
					+ pron.getCity().getCityName());
		}
	}

}
