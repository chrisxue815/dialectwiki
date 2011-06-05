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


<title>词条</title>
<script charset="utf-8" src="http://s.map.qq.com/api/js/beta/v2.1/QQMapAPI.js"></script>
<script type="text/javascript" src="<%=path %>/js/province-city.js"></script>
<script type="text/javascript">
var geocoder, map = null;
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
	var pronList = new Array();
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
	pronList.push(prUrl);
	
<%
	}
%>
	for(i = 0;i<citySize;i++)
	{
		geocoder.geocode({'address': cityList[i]}, function(results, status){
		if (status == QQMap.QGeocoderStatus.OK){
			map.setCenter(results.location);
			
			marker[i] = new QQMap.QMarker({
				map: map,
				position:results.location,
				title: cityList[i]
				})
			QQMap.QEvent.addListener(marker[i], 'click', playSound("<%=basePath %>" + prUrl[i]))
		}
		else{
			alert("error");
		}
		});
	}
}

function addListeners()
{	
	
}

</script>
</head>

<body onload="init()">

<div id="wrap">

<jsp:include page="../internal/header.jsp" />

<div id="content">
<div class="maptop" id="maptop">


</div>
<%
	List<Pronunciation> prons = (List<Pronunciation>)request.getAttribute("prons");
    List<Province> provinceList = (List<Province>)request.getAttribute("provinceList");
	List<City> cityList = (List<City>)request.getAttribute("cityList");
	    
	List<Integer> pronsIndexs = (List<Integer>)request.getAttribute("pronsIndexs");
	List<Integer> cityIndexs = (List<Integer>)request.getAttribute("cityIndexs");
%>


<div class="left">
<div class="lefth1">词条：
<strong><s:property value="word.wordName"/></strong></div>
<%
	int i = 0;
    int j = 0;
    int cityIndex = 0;
    int pronIndex = 0;
    
    for(Province province : provinceList)
    {
    	String provinceName = province.getProvinceName();
%>
<div class="region">
<span class="rt"><%=provinceName%></span>
<a href="" >我要发音</a>
<% 
        while(i < cityIndexs.get(cityIndex))
        {
        	String cityName = cityList.get(i).getCityName();
         
%>

<li><%=cityName %></li>
<%
			while( j < pronsIndexs.get(pronIndex))
			{
				Pronunciation pron = prons.get(j);
				String pronUser = pron.getUser().getUsername();
				SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
				String Date = dateFm.format(pron.getUploadDate());
				int goodVote = pron.getGoodVoteNum();
				int badVote = pron.getBadVoteNum(); 
%>
<p class="pro">发音用户：<%=pronUser%> &nbsp;&nbsp;&nbsp;发音时间<%=Date %> &nbsp;&nbsp;&nbsp;顶：<%=goodVote %>&nbsp;踩：<%=badVote %> </a></p>


<%			
				j++;
			}
			pronIndex++;
	        i++;	
		}
		cityIndex++;
%>		
</div>
<% 
	}
%>


</div>
</div>


</div>
<!--content-->
<div style="clear: both;"> </div>
<jsp:include page="../internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>