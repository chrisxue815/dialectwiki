package org.dw.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestEncodingFilter implements Filter
{
  public static String encoding = null;
  
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException
  {
    HttpServletRequest req = (HttpServletRequest) request;
    
    if (req.getMethod().equalsIgnoreCase("POST"))
    {
        request.setCharacterEncoding(encoding);
    }
    else
    {
      try
      {
        Map<String, String[]> params = request.getParameterMap();
        
        if (!params.isEmpty())
        {
          Method method = params.getClass().getMethod("setLocked", new Class[]{boolean.class});
          method.invoke(params, new Object[]{new Boolean(false)});
          
          Iterator<Entry<String, String[]>> it = params.entrySet().iterator();
          
          while (it.hasNext())
          {
            Entry<String, String[]> e = it.next();
            String[] val = e.getValue();
            
            for (int i = 0; i < val.length; i++)
            {
              byte[] bytes = val[i].getBytes("ISO8859-1");
              val[i] = new String(bytes, "UTF-8");
            }
          }
        }
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    
    chain.doFilter(request, response);
  }

  public void init(FilterConfig filterConfig) throws ServletException
  {
    encoding = filterConfig.getInitParameter("encoding");
  }
  
  public void destroy()
  {
  }
}
