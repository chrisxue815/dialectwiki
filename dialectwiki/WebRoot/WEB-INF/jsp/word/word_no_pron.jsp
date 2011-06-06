<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ page import="java.util.List"  %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.dw.model.*" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style1.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/word.css"/>


<title>方言百科 - 词条</title>

</head>


<body>

<div id="wrap">

<div id="finishplayer"></div>
<jsp:include page="../internal/header.jsp" />

<div id="content">

<div class="wordcontent">

<div class="top">
<span class="worditem">词条：</span>
<span class="wordname"><s:property value="word.wordName"/></span>
</div>

<div class="bottomleft">

<div class="nopron">
该词条还没有发音，你可以
<a href="pronounce?id=<s:property value='word.wordId' />&fromWord">
添加<strong>发音</strong>
</a>
</div>

</div><!-- bottomleft -->


</div><!-- wordcontent -->
</div><!-- content -->

<div style="clear: both;"> </div>

<jsp:include page="../internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>