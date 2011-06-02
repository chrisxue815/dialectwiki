<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="css/style1.css" />
<link rel="stylesheet" type="text/css" href="css/pronounce.css" />

<script type="text/javascript" src="js/province-city.js"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<script type="text/javascript">
function init() {
  updateCity();
  var so = new SWFObject("swf/record.swf", "MyMovie", "350", "300", "10", "#FFF");
  
  so.addParam("allowScriptAccess","always");
  so.addVariable("word", "<s:property value="word.wordId" />");
  
  so.write("flash");
}
</script>

<title>发音</title>
</head>

<body onload="init()">

<div id="wrap">

<jsp:include page="internal/header.jsp" />

<div id="content">
<div class="left">
<div class="inner">您正在录制发音：
<h1><s:property value="word.wordName" /></h1>
</div>
<div class="region">
地区�
<form id="form1">
<select id="selProvince" onchange="updateCity()">
<option value="1" selected="selected">北京�/option>
<option value="2">上海�/option>
<option value="3">天津�/option>
<option value="4">重庆�/option>
<option value="5">黑龙江省</option>
<option value="6">吉林�/option>
<option value="7">辽宁�/option>
<option value="8">山东�/option>
<option value="9">山西�/option>
<option value="10">陕西�/option>
<option value="11">河北�/option>
<option value="12">河南�/option>
<option value="13">湖北�/option>
<option value="14">湖南�/option>
<option value="15">海南�/option>
<option value="16">江苏�/option>
<option value="17">江西�/option>
<option value="18">广东�/option>
<option value="19">广西�/option>
<option value="20">云南�/option>
<option value="21">贵州�/option>
<option value="22">四川�/option>
<option value="23">内蒙古自治区</option>
<option value="24">宁夏回族自治�/option>
<option value="25">甘肃�/option>
<option value="26">青海�/option>
<option value="27">西藏自治�/option>
<option value="28">新疆自治�/option>
<option value="29">安徽�/option>
<option value="30">浙江�/option>
<option value="31">福建�/option>
<option value="32">台湾�/option>
<option value="33">香港</option>
<option value="34">澳门</option>
</select>
<select id="selCity">
</select>
</form>
</div>
<div id="flash">this is a flash!</div>
</div>

<div class="right">
<h1>如何添加发音�/h1>
点击允许按钮，让录音器使用您的话�
<h2>录制</h2>
你有3秒时间来录制发音。但是不要担心，你可以尝试多次录制直到你认为完美为止。请注意保持正确的口音�
<h2>播放</h2>
你可以在录制结束之后，单击播放按钮检查刚才的发音�
<h2>提交</h2>
当你认为发音很完美时，单�确定发�按钮，提交发音�
</div>
</div><!--content-->
<div style="clear: both;"> </div>
<jsp:include page="internal/footer.jsp" />

</div><!--wrap-->
</body>
</html>