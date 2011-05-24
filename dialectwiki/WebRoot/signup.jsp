<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
	var checkSubmitFlg = false;
	function checkSubmit(){
	alert("function invoked!");
	if(!checkSubmitFlg){
		checkSubmitFlg = true;
		return true;
	}else{
	alert("禁止重复提交！");
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="css/style1.css" />
<link rel="stylesheet" type="text/css" href="css/signup.css" />

<title>注册</title>
</head>

<body>

<div id="wrap">

<jsp:include page="internal/header.jsp" />

<div id="content">
<h2 class="title">注册用户</h2>
<s:form action="SignupAction" theme="simple" onsubmit="return checkSubmit();">
<s:fielderror></s:fielderror>
<table class="userInfo">
<tr>
<td>用户名：</td>
<td><s:textfield name="username"></s:textfield></td><td><s:fielderror fieldName="username"></s:fielderror><s:property value="FieldErrors.username[0]"></s:property></td>
</tr>
<tr>
<td>密码：</td>
<td><s:password name="password"></s:password></td><td><s:fielderror fieldName="password"></s:fielderror></td>
</tr>
<tr>
<td>确认密码：</td>
<td><s:password name="password2"></s:password></td><td><s:fielderror fieldName="password2"></s:fielderror></td>
</tr>
<tr>
<td>Email：</td>
<td><s:textfield name="email"></s:textfield></td><td><s:fielderror fieldName="email"></s:fielderror></td>
</tr>
<tr>
<td>性别：</td>
<td>
<span onclick="document.getElementById('sexm').checked=true;">
<input name="sex" type="radio" value="m" checked="checked" id="sexm" />
&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;
</span>
<span onclick="document.getElementById('sexf').checked=true;">
<input name="sex" type="radio" value="f" id="sexf" />
&nbsp;女&nbsp;&nbsp;&nbsp;&nbsp;
</span>
</td>
</tr>
<tr>
<td>验证码：</td>
<td><s:textfield name="validatecode"></s:textfield></td><td><s:fielderror fieldName="validatecode"></s:fielderror></td>
</tr>
<tr>
<td></td>
<td><img src="" /></td>
</tr>
<tr>
<td></td>
<td class="submit"><s:submit value="注册"></s:submit> </td>
</tr>
</table>
</s:form>




<!--
<form action="loginAction" method="post">
<table class="userInfo">
<tr>
<td>用户名：</td>
<td><input name="username" type="text" /></td>
</tr>
<tr>
<td>密码：</td>
<td><input name="password" type="password" /></td>
</tr>
<tr>
<td>确认密码：</td>
<td><input name="password2" type="password" /></td>
</tr>
<tr>
<td>Email：</td>
<td><input name="email" type="text" /></td>
</tr>
<tr>
<td>性别：</td>
<td>
<span onclick="document.getElementById('sexm').checked=true;">
<input name="sex" type="radio" value="m" checked="checked" id="sexm" />
&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;
</span>
<span onclick="document.getElementById('sexf').checked=true;">
<input name="sex" type="radio" value="f" id="sexf" />
&nbsp;女&nbsp;&nbsp;&nbsp;&nbsp;
</span>
</td>
</tr>
<tr>
<td>验证码：</td>
<td><input type="password" /></td>
</tr>
<tr>
<td></td>
<td><img src="" /></td>
</tr>
<tr>
<td></td>
<td class="submit"><input type="submit" value="注册" /></td>
</tr>
</table>
</form>
-->
</div>

<jsp:include page="internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>