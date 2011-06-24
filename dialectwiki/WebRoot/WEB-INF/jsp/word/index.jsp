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
<title>方言百科 - 词条</title>
</head>


<body>

<div id="wrap">

<jsp:include page="../internal/header.jsp" />
<div id="content">
<!--左模块-->
<div class="module left">
  <h2>最新词条</h2>
<div class="list">
<ul>
  <s:iterator value="recentWords">
  <li>
  <a href="/dialectwiki/word?id=<s:property value="wordId" />"><s:property value="wordName" />
  </a>
  </li>
  </s:iterator>
 </ul>
</div>
</div><!--left-->

<!--中模块-->
<div class="module center">
<h2>最热词条</h2>
<div class="list">
<ul>
<s:iterator value="hotWords">
<li>
<a href="<%=path %>/word?id=<s:property value="wordId" />">
<s:property value="wordName" />
</a>
</li>
</s:iterator>
</ul>
</div>
</div><!--center-->

<!--右模块-->
<div class="module"> 
<h2>待发音词条</h2>
<div class="list">
<ul>
  <s:iterator value="waitProns">
  <li>
  <a href="/dialectwiki/word?id=<s:property value="wordId" />"><s:property value="wordName" />
  </a>
  </li>
  </s:iterator>
</ul>
</div>
</div><!--right-->



<div style="clear: both;"> </div>

</div>


<jsp:include page="../internal/footer.jsp" />
</div>

</body>
</html>