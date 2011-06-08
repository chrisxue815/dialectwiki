<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xfhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style1.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/user.css" />

<title>方言百科 - 用户</title>
<script charset="utf-8" src="http://s.map.qq.com/api/js/beta/v2.1/QQMapAPI.js"></script>
<script type="text/javascript" src="<%=path %>/js/province-city.js"></script>
<script type="text/javascript" src="<%=path %>/js/swfobject.js"></script>
<script type="text/javascript" src="<%=path %>/js/playMP3.js"></script>
</head>


<body>

<div id="wrap">
<div id="finishplayer"></div>

<jsp:include page="../internal/header.jsp" />

<div id="content">

<div class="usercontent">

<div class="top">
<span class="useritem">用户：</span>
<span class="username"><s:property value="user.userName"/></span>
</div>

<div class="bottomleft">

<div class="module mapmodule">

<div class="moduletitle">
该用户发音在地图上的分布情况
</div>

<div class="maptop" id="maptop">
</div>
</div>


<div class="module">

<div class="region">

<div class="rtitle">
<span class="rtTip">发音</span>
&nbsp;&nbsp;
<span class="rtProv">
<!--<%=provinceName%> - <%=cityName %> -->
</span>
</div>

<div class="pron" id="pron<%=1 //pronId %>">

<div class="pimg">
<a href="#" onclick="playSound('<%=1 //aprUrl%>');return false;">
<img src="<%=path %>/css/images/ico_play.gif" />
</a>
</div>
<div class="word">
<span>发音者</span>
&nbsp;
<span class="wordname"><%=1//pronWord%></span>
</div>
<div class="pvote">
<a href="vote?pronId=<%=1 %>&voteMark=1">顶 + <%=1 //goodVote%></a>
&nbsp;
<a href="vote?pronId=<%=1 %>&voteMark=-1">踩 - <%=1 //badVote%></a>
</div>

</div>
</div>
</div>
</div>
<!--content-->

<jsp:include page="../internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>