<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="top">
<div id="data">
<strong><s:property value="wordNum" /></strong>个词条
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
<div class="func">
  <a href="<%=basePath %>addword">添加词条</a>
</div>
</div>

<div id="menu">
<ul>

<li><a href="<%=basePath %>">首页</a></li>
<li><a href="<%=basePath %>words">词条</a></li>
<li><a href="<%=basePath %>users">用户</a></li>

</ul>
<div class="search">
<form id="searchForm" action="<%=basePath %>word" method="post" onsubmit="return checkSearch(this);">
<input type="text" id="stext" name="name" />
<input type="submit" id="sbutton" value="搜索词条" />
</form>
</div>
</div>
<script type="text/javascript" src="<%=path %>/js/validation.js"></script>
<div style="clear: both;"></div>