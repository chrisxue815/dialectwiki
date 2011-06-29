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
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/play.css" />
<script type="text/javascript" src="<%=path %>/js/province-city.js"></script>
<script type="text/javascript" src="<%=path %>/js/swfobject.js"></script>
<script type="text/javascript" src="<%=path %>/js/playMP3.js"></script>
<script charset="utf-8" src="http://s.map.qq.com/api/js/beta/v2.1/QQMapAPI.js"></script>
<title>方言百科 - 播放发音</title>

<script type="text/javascript">
var geocoder, map ,maker;
var init = function(){
	map = new QQMap.QMap(
		document.getElementById("qqmap"),
		{
		center: new QQMap.QLatLng(39.916527,116.397128),
		zoomLevel: 11
		}
	);
	
	geocoder = new QQMap.QGeocoder();
	
	geocoder.geocode({'address': "重庆"}, function(results, status)
	{
		if (status == QQMap.QGeocoderStatus.OK) {
			map.setCenter(results.location);
			if (marker != null) {
				marker.setMap(null);
			}
			marker = new QQMap.QMarker({
				map: map,
				position:results.location,
				title: cityNode.options[cityNode.selectedIndex].text
			});
		} else {
		alert("检索没有结果，原因: " + status);
		}
	});
}
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
</script>
</head>

<body onload="init();MM_preloadImages('images/up3.gif','images/down3.gif')">
<div id="finishplayer"></div>

<div id="wrap">

<jsp:include page="../internal/header.jsp" />

<div id="content">
<div class="left">
<div class="playtop">词语:<strong>XXX词语</strong><a href="">返回到xxx词语</a></div><div class="playbutton">
<a href="#" onclick="playSound('http://localhost:8081/dialectwiki/pron/201106/m1.mp3');return false;"><img src="<%=path %>/css/images/ico_play.gif" /></a></div><div class="playcenter"><span class="user">发音者：yyy</span>
<span class="city">(发音地：黑龙江哈尔滨) 票</span>
</div>
<div class="map">
<div style="width:680px;height:350px" id="qqmap"></div>
</div>
<div class="votetable">
<table class="vote"><tr>
  <td width="150"><a href="wshixc" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image2','','<%=basePath %>css/images/up3.gif',1)"><img src="<%=basePath %>css/images/up1.gif" name="Image2" width="50" height="50" border="0" id="Image2" /></a></td><td width="150"><a href="mmmm" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image3','','<%=basePath %>css/images/down3.gif',1)"><img src="<%=basePath %>css/images/down1.gif" alt="ggg" name="Image3" width="50" height="50" border="0" id="Image3" /></a></td></tr></table>
</div>
</div>
<div class="right">
<h1>欢迎使用</h1>
<li>请在下方对该发音进行投票，如果您认为这个发音很标准请顶一下，如果您认为这个发音不尽人意请踩一下。
</li>
<li>注册登录后您也可以为词语添加您自己的地方语音</li></div>

</div><!--content-->

<jsp:include page="../internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>
