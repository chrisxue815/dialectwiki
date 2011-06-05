package org.dw.utils;

import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CharacterEncodingFilter implements Filter
{
  CodepageDetectorProxy detector;

  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException
  {
    HttpServletRequest req = (HttpServletRequest) request;
    
    if (req.getMethod().equalsIgnoreCase("GET") &&
        request.getCharacterEncoding() == null)
    {
      Map map = req.getParameterMap();
      //Charset charset = detector.detectCodepage(, req.getContentLength());
      //request.setCharacterEncoding(charset.name());
      request = new Request(req);
    }
    
    chain.doFilter(request, response);
  }

  public void init(FilterConfig filterConfig) throws ServletException
  {
    detector = CodepageDetectorProxy.getInstance();
    detector.add(JChardetFacade.getInstance());
  }
  
  public void destroy()
  {
  }
  
  /**
   * Request类 对 HttpServletRequestWrapper 进行扩充,
   * 不影响原来的功能并能提供所有的 HttpServletRequest 接口中的功能.
   * 它可以统一的对 Tomcat 默认设置下的中文问题进行解决而只需要用新的 Request
   * 对象替换页面中的 request 对象即可.
   */
  class Request extends HttpServletRequestWrapper
  {
    private String encoding = null;

    public Request(HttpServletRequest request)
    {
      super(request);
      encoding = request.getCharacterEncoding();
    }

    /**
     * 转换由表单读取的数据的内码. 从 ISO 字符转到 检测到的编码.
     */
    public String encode(String input)
    {
      if (input == null)
      {
        return null;
      } else
      {
        try
        {
          byte[] bytes = input.getBytes("ISO8859-1");
          return new String(bytes, encoding);
        } catch (Exception ex)
        {
        }
        return null;
      }
    }

    /**
     * Return the HttpServletRequest holded by this object.
     */
    private HttpServletRequest getHttpServletRequest()
    {
      return (HttpServletRequest) super.getRequest();
    }

    /**
     * 读取参数 -- 修正了中文问题.
     */
    public String getParameter(String name)
    {
      return encode(getHttpServletRequest().getParameter(name));
    }

    /**
     * 读取参数列表 - 修正了中文问题.
     */
    public String[] getParameterValues(String name)
    {
      String values[] = getHttpServletRequest().getParameterValues(name);
      if (values != null)
      {
        for (int i = 0; i < values.length; i++)
        {
          values[i] = encode(values[i]);
        }
      }
      return values;
    }
  }
}
