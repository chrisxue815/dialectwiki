<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <meta http-equiv="refresh" content="3; url=<%=basePath%>login">
    <title>方言百科 - 成功找回密码</title>


  </head>
  
  <body>
  恭喜你，密码修改成功。5秒钟后自动跳转到登陆页。<br/>
  <a href="<%=basePath%>login">（或使用此链接直接跳转）</a>
  </body>
</html>
