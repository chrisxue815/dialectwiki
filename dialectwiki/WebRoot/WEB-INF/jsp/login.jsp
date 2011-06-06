<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
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
<link rel="stylesheet" type="text/css" href="<%=path %>/css/style1.css"  />
<link rel="stylesheet" type="text/css" href="<%=path %>/css/login.css"  />
<title>方言百科 - 登录</title>
<script charset="utf-8" src="http://s.map.qq.com/api/js/beta/v2.1/QQMapAPI.js"></script>
<script type="text/javascript">
var init = function(){
	var map = new QQMap.QMap(document.getElementById("left"))
	map.moveTo(new QQMap.QLatLng(39.914850, 116.403765))
	map.zoomTo(13)
	
	document.getElementById("username").focus();
}

</script>


</head>

<body onload="init()">
<div id="wrap">

<jsp:include page="internal/header.jsp" />

<div id="content">
<div id="left" class="left"></div>
<div class="right">
<s:if test="#parameters.signupSuccess!=null">
<h2>注册成功，请登录</h2>
</s:if>
<s:elseif test="#parameters.loginError!=null">
<h2>登录失败，用户名或密码错误</h2>
</s:elseif>
<s:else>
<h2>登录</h2>
</s:else>

<form id="dw_login" name="f" action="<%=path %>/j_spring_security_check" method="post">
<table class="login">
<tr>
<td><label for="login">用户名：</label></td>
<td><input id="username" name="j_username" type="text" /></td>
</tr>

<tr>
<td><label for="password">密　码：</label></td>
<td><input name="j_password" type="password" /></td>
<td><a href="<%=path %>/password-reminder">忘记你的密码了？</a></td>
</tr>

<tr>
<td></td>
<td><input class="submit" name="submit" type="submit" value="登录" /></td>
<td><input name="_spring_security_remember_me" type="checkbox" />下次自动登录</td>
</tr>
</table>
</form>
</div>

</div><!--content-->

<jsp:include page="internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>