<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="top">
<div id="data">
<strong><s:property value="wordNum" /></strong>个词语
<strong><s:property value="pronNum" /></strong>个发音
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
<li><a href="<%=basePath %>pronunciation/">发音</a></li>
<li><a href="<%=basePath %>user/">用户</a></li>
</ul>
<div class="mright search">
<form action="<%=basePath %>word/word" method="post">
<input type="text" id="stext" name="wordName" />
<input type="submit" id="sbutton" value="搜索词条" />
</form>
</div>
<div class="mright">
<ul>
<li><a href="<%=basePath %>word/add.jsp">添加词条</a></li>
</ul>
</div>
</div>