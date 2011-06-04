package org.dw.utils;

import java.io.IOException;
import javax.servlet.*;

public class CharacterEncodingFilter implements javax.servlet.Filter
{
	protected String encoding = null;

	public void init(FilterConfig filterConfig) throws ServletException
	{
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		request.setCharacterEncoding(encoding);

		response.setContentType("text/html;charset=" + encoding);

		chain.doFilter(request, response);
	}

  public void destroy()
  {
  }
}
