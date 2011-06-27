<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ page import="java.util.List"  %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.dw.model.*" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<script charset="utf-8" src="http://s.map.qq.com/api/js/beta/v2.1/QQMapAPI.js"></script>
<script type="text/javascript" src="<%=path %>/js/province-city.js"></script>
<script type="text/javascript" src="<%=path %>/js/swfobject.js"></script>
<script type="text/javascript" src="<%=path %>/js/playMP3.js"></script>
<script type="text/javascript">
var geocoder, map = null, info, flag=false;
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
	List<Pronunciation> mapProns = (List<Pronunciation>)request.getAttribute("mapProns");
	int mapi = 0; 
%>
function markcitys() {
	var pronUrlList = new Array();
	var cityName = null;
	var i = 0;
	var cityName = null;
	var prUrl;

<%
	for(Pronunciation pron : mapProns)
	{
		String tmpCityName = pron.getCity().getCityName();
		String tmpProvinceName = pron.getCity().getProvince().getProvinceName();
		String mapPrUrl = pron.getPrUrl();
		String mapUserName = pron.getUser().getUsername();
		int goodVote = pron.getGoodVoteNum();
		int badVote = pron.getBadVoteNum(); 
		int pronId = pron.getPronId();
%>
		geocoder.geocode({'address': "<%=tmpCityName%>"}, function(results, status){
			if (status == QQMap.QGeocoderStatus.OK) {
				
				marker[<%=mapi%>] = new QQMap.QMarker({
					map: map,
					position: results.location,
					title: results.address
				});

				QQMap.QEvent.addListener(
					marker[<%=mapi%>],
					'click',
					function(){
					var tempstr = '<div class="pronmap"><div class="rtProv"><%=tmpProvinceName%> - <%=tmpCityName%></div><div class="userdiv">';
						tempstr += '<div class="pimg"><a href="#" onclick="playSound(\'<%=mapPrUrl%>\');return false;"><img src="<%=path%>/css/images/ico_play.gif" /></a></div><div class="puser"><span>发音者</span>&nbsp;<span class="pusername"><a href="user?name=<%=mapUserName %>"><%=mapUserName %></a></span></div><div class="pvote"><a href="vote?pronId=<%=pronId %>&voteMark=1">顶 + <%=goodVote%></a>&nbsp;<a href="vote?pronId=<%=pronId %>&voteMark=-1">踩 - <%=badVote%></a></div></div>';
						tempstr += '</div>';
						info.open(tempstr,marker[<%=mapi%>]);
						info.reset();
				});
			}
		});
<%
		mapi++;
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

<div class="wordcontent">

<div class="top">
<span class="worditem">词条：</span>
<span class="wordname"><s:property value="word.wordName"/></span>
</div>

<div class="bottomleft">

<div class="module mapmodule">

<div class="moduletitle">
口音在地图上的分布情况
</div>

<div class="maptop" id="maptop">
</div>

</div>

<div class="module">
<%
List<Pronunciation> prons = (List<Pronunciation>)request.getAttribute("prons");
List<Province> provinceList = (List<Province>)request.getAttribute("provinceList");
List<City> cityList = (List<City>)request.getAttribute("cityList");    
List<Integer> pronsIndexs = (List<Integer>)request.getAttribute("pronsIndexs");
List<Integer> cityIndexs = (List<Integer>)request.getAttribute("cityIndexs");
int i = 0;
int j = 0;
int cityIndex = 0;
int pronIndex = 0;

Pronunciation pron;
int pronId;
String pronUser;
int pronUserId;
SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");;
String Date;
int goodVote;
int badVote;
String aprUrl;

String provinceName,cityName;

%>
<%
i = 0;
j = 0;
cityIndex = 0;
pronIndex = 0;
for(Province province : provinceList)
{
provinceName = province.getProvinceName();
while(i < cityIndexs.get(cityIndex))
{
cityName = cityList.get(i).getCityName();
%>
<div class="region">

<div class="rtitle">
<span class="rtTip">发音</span>
&nbsp;&nbsp;
<span class="rtProv">
<%=provinceName%> - <%=cityName %>
</span>
</div>
<%
while( j < pronsIndexs.get(pronIndex))
{
pron = prons.get(j);
pronId = pron.getPronId();
pronUser = pron.getUser().getUsername();
pronUserId = pron.getUser().getUserId();
Date = dateFm.format(pron.getUploadDate());
goodVote = pron.getGoodVoteNum();
badVote = pron.getBadVoteNum(); 
aprUrl = basePath+pron.getPrUrl();
%>
<div class="pron" id="pron<%=pronId %>">

<div class="pimg">
<a href="#" onclick="playSound('<%=aprUrl%>');return false;">
<img src="<%=path %>/css/images/ico_play.gif" />
</a>
</div>

<div class="puser">
<span>发音者</span>
&nbsp;
<span class="pusername"><a href="user?name=<%=pronUser %>"><%=pronUser%></a></span>
</div>

<div class="pvote">
<a href="vote?pronId=<%=pronId %>&voteMark=1">顶 + <%=goodVote %></a>
&nbsp;
<a href="vote?pronId=<%=pronId %>&voteMark=-1">踩 - <%=badVote %></a>
</div>

</div><!-- pron -->


<%			
j++;
}
pronIndex++;
i++;
%>
</div><!-- region -->
<%
}
cityIndex++;
}
%>

<div class="userBottom">&nbsp;</div>
</div>
</div><!-- bottomleft -->

<div class="bottomright">

<div class="rightList">
<div class="rightItem">
<div class="itemTitle">修改词语</div>
<div class="itemLink">
· 
<a href="pronounce?id=<s:property value='id' />">
添加<strong>发音</strong>
</a>
</div>
</div><!-- rightItem -->
</div><!-- rightList -->
</div><!-- bottomright -->

</div><!-- wordcontent -->
</div><!-- content -->

<div style="clear: both;"> </div>

<jsp:include page="../internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>