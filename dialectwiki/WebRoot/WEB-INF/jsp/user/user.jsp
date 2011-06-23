<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="java.util.List" %>
<%@ page import="org.dw.model.City" %>
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
	info  = new QQMap.QInfoWindow({
		visible:false,
		map:map
	});
	geocoder = new QQMap.QGeocoder();
	QQMap.QEvent.addListener(
		map,
		'click',
		function(){
			info.setVisible(false);
			info.reset();					
	});
	markcitys();
	
}
<%
	List<City> mapCity = (List<City>)request.getAttribute("mapCity");
	List<List<Pronunciation>> pronList = (List<List<Pronunciation>>)request.getAttribute("pronList");
	int cityI = 0; 
%>
function markcitys() {
	var pronUrlList = new Array();
	var cityName = null;
	var i = 0;
	var cityName = null;
	var prUrl;
<%

	String cityName;
	String provinceName;
	
	String PrUrl;
	String WordName;
	int goodVote;
	int badVote; 
	int pronId;
	
	for(City city : mapCity)
	{
		cityName = city.getCityName();
		provinceName = city.getProvince().getProvinceName();
%>
		geocoder.geocode({'address': "<%=cityName%>"}, function(results, status){
			if (status == QQMap.QGeocoderStatus.OK) {
				
				marker[<%=cityI%>] = new QQMap.QMarker({
					map: map,
					position: results.location,
					title: results.address
				});

				QQMap.QEvent.addListener(
					marker[<%=cityI%>],
					'click',
					function(){
					var tempstr = '<div class="pronmap"><div class="rtProv"><%=provinceName%> - <%=cityName%></div>';
<%
			for( Pronunciation pron : pronList.get(cityI))
			{
				PrUrl = pron.getPrUrl();
				WordName = pron.getWord().getWordName();
				pronId = pron.getPronId();
%>
						tempstr += '<div class="worddiv"><div class="pimgmap"><a href="#" onclick="playSound(\'<%=PrUrl%>\');return false;"><img src="<%=path%>/css/images/ico_play.gif" /></a></div><div class="pword"><span>词条</span>&nbsp;<span class="pwordname"><%=WordName %></span></div></div>';
<%
			}
%>
						tempstr += '</div>';
						info.open(tempstr,marker[<%=cityI%>]);
						info.reset();
				});
			}
		});
<%
		cityI++;
	}
%>
}
</script>
</head>


<body onload="init()">

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

<%
cityI = 0;
for(City city : mapCity)
	{
		cityName = city.getCityName();
		provinceName = city.getProvince().getProvinceName();
%>
<div class="rtitle">
<span class="rtTip">发音</span>
&nbsp;&nbsp;
<span class="rtProv">
<%=provinceName%> - <%=cityName %>
</span>
</div>
<%
			for( Pronunciation pron : pronList.get(cityI))
			{
				PrUrl = pron.getPrUrl();
				WordName = pron.getWord().getWordName();
				goodVote = pron.getGoodVoteNum();
				badVote = pron.getBadVoteNum(); 
				pronId = pron.getPronId();
%>
<div class="pron" id="pron">

<div class="pimg">
<a href="#" onclick="playSound('<%=PrUrl %>');return false;">
<img src="<%=path %>/css/images/ico_play.gif" />
</a>
</div>
<div class="word">
<span>词条</span>
&nbsp;
<span class="wordname"><%=WordName %></span>
</div>
<div class="pvote">
<a href="vote?pronId=<%=pronId %>&voteMark=1">顶 + <%=goodVote %></a>
&nbsp;
<a href="vote?pronId=<%=pronId %>&voteMark=-1">踩 - <%=badVote %></a>
</div>

</div><!--pron-->
<%}cityI++;} %>
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