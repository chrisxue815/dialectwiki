<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="css/style1.css" />
<link rel="stylesheet" type="text/css" href="css/pronounce.css" />

<script type="text/javascript" src="js/swfobject.js"></script>
<script type="text/javascript">
function loadSwf() {
  var so = new SWFObject("swf/record.swf", "MyMovie", "350", "300", "10", "#FFF");
  so.write("flash");
  so.addVariable("wordId", "<s:property value="word.wordId" />");
}
</script>

<title>发音</title>
</head>

<body onload="loadSwf()">

<div id="wrap">

<jsp:include page="internal/header.jsp" />

<div id="content">
<div class="left">
<div class="inner">您正在录制发音：
<h1><s:property value="word.wordName" /></h1>
</div>
<div id="flash">this is a flash!</div>
</div>

<div class="right">
<h1>如何添加发音？</h1>
点击允许按钮，让录音器使用您的话筒
<h2>录制</h2>
你有3秒时间来录制发音。但是不要担心，你可以尝试多次录制直到你认为完美为止。请注意保持正确的口音。
<h2>播放</h2>
你可以在录制结束之后，单击播放按钮检查刚才的发音。
<h2>提交</h2>
当你认为发音很完美时，单击"确定发送"按钮，提交发音。
</div>
</div><!--content-->
<div style="clear: both;"> </div>
<jsp:include page="internal/footer.jsp" />

</div><!--wrap-->
</body>
</html>