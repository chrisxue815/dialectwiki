<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="java.util.List" %>
<%@ page import="org.dw.model.Pronunciation" %>
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
<script type="text/javascript">

var geocoder, map = null,flag=false;
var marker = new Array();
var init = function(){
	map = new QQMap.QMap(document.getElementById("maptop"),
	{
		center: new QQMap.QLatLng(37, 110),
		zoomLevel: 1,
	})
	
	//geocoder = new QQMap.QGeocoder();
}
</script>
</head>


<body onload="init()">
<% 
	List<Pronunciation> userProns = (List<Pronunciation>)request.getAttribute("userProns");
	
%>
<div id="wrap">
<div id="finishplayer"></div>

<jsp:include page="../internal/header.jsp" />

<div id="content">

<div class="usercontent">

<div class="top">
<span class="useritem">用户：</span>
<span class="username"><s:property value="user.username"/></span>
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
</span>
</div>

<div class="pron" id="pron">

<div class="pimg">
<a href="#" onclick="playSound('');return false;">
<img src="<%=path %>/css/images/ico_play.gif" />
</a>
</div>
<div class="word">
<span>发音地</span>
&nbsp;
<span class="wordname"></span>
</div>
<div class="pvote">
<a href="vote?pronId=&voteMark=1">顶 + </a>
&nbsp;
<a href="vote?pronId=&voteMark=-1">踩 - </a>
</div>

</div><!--pron-->
</div><!--region-->
</div><!--module-->
</div><!--bottomleft-->

<div class="bottomright">

<div class="rightList">
<div class="rightItem">
<div class="itemTitle">用户信息</div>
<div class="itemLink">
用户名：<s:property value="user.username" /><br />
邮&nbsp;&nbsp;&nbsp;&nbsp;箱：<s:property value="user.email" /><br />
性&nbsp;&nbsp;&nbsp;&nbsp;别：<s:property value="user.sex" /><br />
好评率：<br />
排&nbsp;&nbsp;&nbsp;&nbsp;名：<br />
</div>
</div><!-- rightItem -->
</div><!-- rightList -->
</div><!-- bottomright -->

</div><!-- wordcontent -->
</div><!-- content -->

<jsp:include page="../internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>