<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException, javax.servlet.FilterChain, javax.servlet.ServletException, javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.http.HttpSession, org.springframework.security.core.AuthenticationException, org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter, org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices, org.springframework.web.filter.GenericFilterBean" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fuck.spring.security.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<%
AuthenticationException ex = (AuthenticationException) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
out.println(ex.getMessage());
%>
<sec:authentication property='name' />
  </body>
</html>
