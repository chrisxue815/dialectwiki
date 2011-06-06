<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<s:if test="#attr.headerUsername==null">
<a href="<%=basePath %>login">登陆</a>
<a href="<%=basePath %>signup">注册</a>
</s:if>
<s:else>
欢迎, <strong><s:property value="headerUsername" /></strong> 
| <a href="<%=basePath %>j_spring_security_logout">注销</a>
</s:else>
</div><!--user-->
</div><!--top-->

<div id="header">
<img src="<%=basePath %>css/images/logo.gif" />
</div>

<div id="menu">
<ul>
<li><a href="<%=basePath %>">首页</a></li>
<li><a href="<%=basePath %>words">词条</a></li>
</ul>
<div class="mright search">
<form action="<%=basePath %>word" method="post">
<input type="text" id="stext" name="name" />
<input type="submit" id="sbutton" value="搜索词条" />
</form>
</div>
</div>

<div style="clear: both;"></div>