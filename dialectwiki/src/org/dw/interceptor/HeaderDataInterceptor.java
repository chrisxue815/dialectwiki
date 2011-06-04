package org.dw.interceptor;

import java.util.Map;

import org.dw.service.PronunciationService;
import org.dw.service.WordService;
import org.springframework.security.core.context.SecurityContextHolder;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class HeaderDataInterceptor implements Interceptor
{
  public static final String WORD_NUM = "wordNum";
  public static final String PRONUNCIATION_NUM = "pronNum";
  public static final String USER_NAME = "username";
  
  private WordService wordService;
  private PronunciationService pronService;
  
  public WordService getWordService() {
    return wordService;
  }
  public void setWordService(WordService wordService) {
    this.wordService = wordService;
  }
  public PronunciationService getPronService() {
    return pronService;
  }
  public void setPronService(PronunciationService pronService) {
    this.pronService = pronService;
  }
  
  public String intercept(ActionInvocation invocation) throws Exception
  {
    Map<String, Object> map = invocation.getInvocationContext().getContextMap();
    
    Long wordNum = wordService.getWordNumber();
    Long pronNum = pronService.getPronunciationNumber();
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    
    map.put(WORD_NUM, wordNum.toString());
    map.put(PRONUNCIATION_NUM, pronNum.toString());
    map.put(USER_NAME, username);
    
    return invocation.invoke();
  }
  
  public void init()
  {
  }
  
  public void destroy()
  {
  }

}
