<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="../css/style1.css" />
<link rel="stylesheet" type="text/css" href="../css/word.css"/>

<title>添加词条</title>
</head>

<body>
<div id="wrap">

<jsp:include page="../internal/header.jsp" />

<div id="content">

<div class="left">
<div class="lefth1">添加词条</div>
<div class="lefth2">
恭喜，成功添加词条“ <span id="word_name"><a href="word?wordName=<s:property value="wordname" />"><s:property value="wordname" /></a></span> ”，
下面您可以为它发音或者添加新词条
</div>
<div class="alert">
<a href="../pronounce?wordName=<s:property value="wordname" />">
为“ <s:property value="wordname" /> ”发音
</a>
</div>

<div class="announcement">继续添加词条：</div>
<div class="lefth3">
词条：
<form action="add" method="post">
<input type="text" name="wordname"/>
<br /><br />
<input type="submit" value="  添加  "/>
</form> 
</div>
</div>

<div class="right">
广 告 招 商</div>

</div>
<!--content-->
<div style="clear: both;"> </div>
<jsp:include page="../internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>