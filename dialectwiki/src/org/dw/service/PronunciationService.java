package org.dw.service;

import org.dw.model.Pronunciation;
import java.util.List;
public interface PronunciationService {
	public List<Pronunciation> getPronunciationByWordId(int wordId);
	

}
