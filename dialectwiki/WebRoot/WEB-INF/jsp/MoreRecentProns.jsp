<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xfhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>方言百科 - 首页</title>

<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style1.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/more.css" />
<script type="text/javascript">
function init()
{
document.getElementById("stext").focus();
}
</script>
</head>


<body onload="init()">

<div id="wrap">

<jsp:include page="internal/header.jsp" />

<div id="content">
<div class="listhead">最新发音</div>

<div class="listbody">
<s:iterator value="recentProns">
<div class="list">
<li>
<a href="/dialectwiki/word?id=<s:property value="word.wordId" />">
<s:property value="word.wordName" /> 
</a>
<span class="listregion">
<s:property value="city.province.provinceName"/> - 
<s:property value="city.cityName"/>
</span>
</li>
</div>

</s:iterator>
</div>
</div><!--content-->

<div style="clear: both;"></div>

<jsp:include page="internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>