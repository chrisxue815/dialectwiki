package org.dw.service;

import org.dw.model.Pronunciation;
import java.util.Set;

public interface PronunciationService {
	public Set<Pronunciation> getPronunciationByWordId(int wordId);
	

}
