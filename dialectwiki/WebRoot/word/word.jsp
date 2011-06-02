<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="../css/style1.css" />
<link rel="stylesheet" type="text/css" href="../css/word.css"/>

<title>词条</title>
</head>

<body>

<div id="wrap">

<jsp:include page="../internal/header.jsp" />

<div id="content">

<div class="left">
<div class="lefth1">词条：<strong><s:property value="word.wordName"/></strong></div>
<h5>四川话：<a href="">我要发音</a>
<p class="pro">[]&nbsp;&nbsp;发音者1&nbsp;XXXXXXXXXX&nbsp;&nbsp;&nbsp;发音时间2010-10-10 评价得分：xx</pre>
<br />
评分 ***** <a href="">评论</a></p>
<p class="pro">[]&nbsp;&nbsp;发音者2&nbsp;XXXXXXXXXX&nbsp;&nbsp;&nbsp;发音时间2010-10-10 评价得分：xx</pre>
<br />
评分 ***** <a href="">评论</a></p>
</h5>
<h5>北京话：<a href="">我要发音</a>
<p class="pro">[]&nbsp;&nbsp;发音者1&nbsp;XXXXXXXXXX&nbsp;&nbsp;&nbsp;发音时间2010-10-10 评价得分：xx</pre>
<br />
评分 ***** <a href="">评论</a></p>
<p class="pro">[]&nbsp;&nbsp;发音者2&nbsp;XXXXXXXXXX&nbsp;&nbsp;&nbsp;发音时间2010-10-10 评价得分：xx</pre>
<br />
评分 ***** <a href="">评论</a></p>
</h5>
</div>
</div>
<div class="right">
helsdafasdfsdf
</div>
<!--content-->
<div style="clear: both;"> </div>
<jsp:include page="../internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>