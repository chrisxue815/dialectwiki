<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>方言百科 - 添加发音</title>

<link rel="stylesheet" type="text/css" href="<%=path %>/css/style1.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/css/pronounce.css" />
<script type="text/javascript" src="<%=path %>/js/province-city.js"></script>
<script type="text/javascript" src="<%=path %>/js/swfobject.js"></script>
<script charset="utf-8" src="http://s.map.qq.com/api/js/beta/v2.1/QQMapAPI.js"></script>
<script type="text/javascript">
var geocoder, map, marker = null;
var init = function() {
  var wordid = document.getElementById("wordidHidden").value;

  var so = new SWFObject("swf/record.swf", "MyMovie", "350", "300", "10", "#FFF");
  
  so.addParam("allowScriptAccess","always");
  so.addVariable("word", wordid);
  so.addVariable("addr","<%=basePath %>");
  so.write("flash");
  
  map = new QQMap.QMap(
    document.getElementById("qqmap"),
    {
    center: new QQMap.QLatLng(39.916527,116.397128),
    zoomLevel: 11,
    }
  );
  geocoder = new QQMap.QGeocoder();
  updateCity();
}

function upLoad_success()
{
	window.location.href='<%=basePath %>word?id=<s:property value="id" />';
}
function upLoad_error()
{
  alert("错误！提交发音失败");
  history.go(0);
}
</script>
</head>

<body onload="init()">

<div id="wrap">
 
<jsp:include page="internal/header.jsp" />

<div id="content">
<div class="left">
<div class="inner">
<s:if test="#parameters.fromWord!=null">
<div class="prontip">词条还没有发音，请发音：</div>
<h1>
<s:property value="word.wordName" />
</h1>
</s:if>
<s:else>
<div class="prontip">您正在录制发音：</div>
<h1>
<a href="<%=path %>/word?id=<s:property value="word.wordId" />" id="wordLink">
<s:property value="word.wordName" />
</a>
</h1>
</s:else>
</div>
<div class="region">
  
<form id="form1">
<div class="tips">第一步：选择你的地区</div>

<select id="selProvince" onchange="updateCity()">
<option value="1" selected="selected">
  北京市
</option>
<option value="2">
  上海市
</option>
<option value="3">
  天津市
</option>
<option value="4">
  重庆市
</option>
<option value="5">
  黑龙江省
</option>
<option value="6">
  吉林省
</option>
<option value="7">
  辽宁省
</option>
<option value="8">
  山东省
</option>
<option value="9">
  山西省
</option>
<option value="10">
  陕西省
</option>
<option value="11">
  河北省
</option>
<option value="12">
  河南省
</option>
<option value="13">
  湖北省
</option>
<option value="14">
  湖南省
</option>
<option value="15">
  海南省
</option>
<option value="16">
  江苏省
</option>
<option value="17">
  江西省
</option>
<option value="18">
  广东省
</option>
<option value="19">
  广西省
</option>
<option value="20">
  云南省
</option>
<option value="21">
  贵州省
</option>
<option value="22">
  四川省
</option>
<option value="23">
  内蒙古自治区
</option>
<option value="24">
  宁夏回族自治区
</option>
<option value="25">
  甘肃省
</option>
<option value="26">
  青海省
</option>
<option value="27">
  西藏自治区
</option>
<option value="28">
  新疆自治区
</option>
<option value="29">
  安徽省
</option>
<option value="30">
  浙江省
</option>
<option value="31">
  福建省
</option>
<option value="32">
  台湾省
</option>
<option value="33">
  香港
</option>
<option value="34">
  澳门
</option>
</select>
<select id="selCity" onchange="codeAddress();">
</select>
</form>
</div>

<div style="width:665px;height:400px"id="qqmap"></div>
</div>

<div class="right">
<div class="tips">第二步：单击圆形按钮开始发音</div>
<div id="flash">
this is a flash!
</div>
<h1>
如何添加发音
</h1>
点击允许按钮，让录音器使用您的话筒
<h2>
录制
</h2>
你有3秒时间来录制发音。但是不要担心，你可以尝试多次录制直到你认为完美为止。请注意保持正确的口音
<h2>
播放
</h2>
你可以在录制结束之后，单击播放按钮检查刚才的发音
<h2>
提交
</h2>
  当你认为发音很完美时，单击确定发送按钮，提交发音
</div>
</div>
<!--content-->
<div style="clear: both;">
</div>
<jsp:include page="internal/footer.jsp" />

</div>
<!--wrap-->
<input type="hidden" id="wordidHidden" value='<s:property value="id" />' />
</body>
</html>