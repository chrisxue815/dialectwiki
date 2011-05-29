package org.dw.action;

import org.dw.model.Word;
import org.dw.service.WordService;
import com.opensymphony.xwork2.ActionSupport;

public class WordHomeAction extends ActionSupport{

	private static final long serialVersionUID = 2409752678054918663L;
	private WordService wordService;
	private Word word;
}
