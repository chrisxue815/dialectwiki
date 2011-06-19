<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xfhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style1.css"  />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/main.css"  />
<title>方言百科 - 用户页</title>
</head>



<body>

<div id="wrap">

<jsp:include page="../internal/header.jsp" />
<div id="content">
<!--左模块-->
<div class="module left">
  <h2>发音最多的用户</h2>
<div class="list">
<ul>
  <s:iterator value="NBUsers">
  <li>
  <a href="/dialectwiki/user?id=<s:property value="userId" />"><s:property value="username" />
  </a>
  </li>
  </s:iterator>
</ul>
</div>
</div><!--left-->

<!--中模块-->
<div class="module center">
<h2>好评用户</h2>
<div class="list">
<ul>
<s:iterator value="GOODUsers">
  <li>
  <a href="/dialectwiki/user?id=<s:property value="userId" />"><s:property value="username" />
  </a>
  </li>
  </s:iterator>
</ul>
</div>
</div><!--center-->

<!--右模块-->
<div class="module right"> 
<h2>注册</h2>
<div class="list"></div>
</div><!--right-->



<div style="clear: both;"> </div>

</div>


<jsp:include page="../internal/footer.jsp" />
</div>

</body>
</html>