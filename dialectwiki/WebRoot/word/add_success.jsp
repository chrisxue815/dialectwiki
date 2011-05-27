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
<div class="lefth2">恭喜，成功添加词条<s:property value="wordname"></s:property>，下面您可以为它发音或者添加新词条</div>
<div class="alert">
<a href="">为XXX发音</a></div>

<div class="announcement">继续添加词条：</div>
<div class="lefth3">
词条：
<input type="text" id="word" name="word"/>
<br /><br />
<input type="button" id="post"  name="post" value="  添加  "/> 
</div>
</div>

<div class="right">
广 告 招 商</div>

</div>
<!--content-->

<jsp:include page="../internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>