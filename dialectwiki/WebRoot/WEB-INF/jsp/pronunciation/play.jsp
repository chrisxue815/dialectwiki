<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xfhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style1.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/play.css" />

<title>播放发音</title>
</head>

<body>


<div id="wrap">

<jsp:include page="../internal/header.jsp" />

<div id="content">
<div class="left">
<div class="playtop">词语:<strong>XXX词语</strong><a href="">返回到xxx词语</a></div>
<div class="playcenter"><span class="user">发音者：yyy</span>
<span class="city">(发音地：黑龙江哈尔滨)</span>
<div>
票<span><a class="vote">顶</a><a class="vote">踩</a></span>
</div>
</div>

<div class="map"></div>
</div>
<div id="right">
</div>

</div><!--content-->

<jsp:include page="../internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>
