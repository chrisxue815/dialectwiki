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

<base href="<%=basePath %>" />

<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style1.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/word.css"/>


<title>方言百科 - 词条</title>
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
	
	geocoder = new QQMap.QGeocoder();
	markcitys();
}
function markcitys() {
	var cityList = new Array();
	var pronUrlList = new Array();
	var cityName = null;
	var citySize = null
	var i = null;
<%
	List<String> cityNames = (List<String>)request.getAttribute("cityNames");
	List<String> mapPrUrlList = (List<String>)request.getAttribute("mapPrUrlList");
	int citynumbers = cityNames.size();
%>
	citySize = "<%=citynumbers %>"
<%
	int aIndex = 0;
	for(aIndex = 0;aIndex<citynumbers;aIndex++)
	{
		String aCityName = cityNames.get(aIndex);
		String aPrurl = mapPrUrlList.get(aIndex);
%>
	var cityName = "<%=aCityName %>"
	var prUrl = "<%=aPrurl %>"
	cityList.push(cityName);
	pronUrlList.push(prUrl);
	
<%
	}
%>
	var i = 0;
	var j = 0;
	for (i = 0; i < citySize; i++)
	{
		geocoder.geocode({'address': cityList[i]}, function(results, status){
			if (status == QQMap.QGeocoderStatus.OK) {
				map.setCenter(results.location);
				
				marker[j] = new QQMap.QMarker({
					map: map,
					position: results.location,
					title: results.address
				});
				j++;
			}
		});
	}
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
<%
List<Pronunciation> prons = (List<Pronunciation>)request.getAttribute("prons");
List<Province> provinceList = (List<Province>)request.getAttribute("provinceList");
List<City> cityList = (List<City>)request.getAttribute("cityList");    
List<Integer> pronsIndexs = (List<Integer>)request.getAttribute("pronsIndexs");
List<Integer> cityIndexs = (List<Integer>)request.getAttribute("cityIndexs");
%>

<div class="module">

<%
int i = 0;
int j = 0;
int cityIndex = 0;
int pronIndex = 0;

for(Province province : provinceList)
{
String provinceName = province.getProvinceName();
while(i < cityIndexs.get(cityIndex))
{
String cityName = cityList.get(i).getCityName();
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
Pronunciation pron = prons.get(j);
int pronId = pron.getPronId();
String pronUser = pron.getUser().getUsername();
int pronUserId = pron.getUser().getUserId();
SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
String Date = dateFm.format(pron.getUploadDate());
int goodVote = pron.getGoodVoteNum();
int badVote = pron.getBadVoteNum(); 
String aprUrl = basePath+pron.getPrUrl();
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
<span class="pusername"><%=pronUser%></span>
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