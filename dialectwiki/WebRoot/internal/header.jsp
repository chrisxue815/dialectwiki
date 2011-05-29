<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="top">
<div id="data">
<strong>10000</strong>个词语
<strong>10000</strong>个发音
<strong>10000</strong>种方言
</div><!--data-->
<div id="user">
<a href="<%=basePath %>login.jsp">登陆</a>
<a href="<%=basePath %>signup.jsp">注册</a>
</div><!--user-->
</div><!--top-->

<div id="header">
<img src="<%=basePath %>css/images/logo.gif" />
</div>

<div id="menu">
<ul>
<li><a href="<%=basePath %>">首页</a></li>
<li><a href="<%=basePath %>dialect/">方言</a></li>
<li><a href="<%=basePath %>word/">词条</a></li>
<li><a href="<%=basePath %>pronounce/">发音</a></li>
<li><a href="<%=basePath %>user/">用户</a></li>
</ul>
</div>