<%@ page contentType="text/html; charset=utf-8" language="java"%>
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

<link rel="stylesheet" type="text/css" href="<%=path %>/css/style1.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/css/signup.css" />

<title>注册</title>

<script type="text/javascript">
function init()
{
document.getElementById("username").focus();
}
function disableBtn(btn){
  btn.disabled = 'disabled';
  var form = document.getElementById('myForm');
  form.submit();
  return true;
}
</script>
</head>

<body onload="init()">

<div id="wrap">

<jsp:include page="internal/header.jsp" />

<div id="content">
<h2 class="title">注册用户</h2>
<s:form action="/signupEx" theme="simple" id="myForm">
<table class="userInfo">
<tr>
<td>用户名：</td>
<td><s:textfield id="username" name="username"></s:textfield></td>
<td><s:fielderror fieldName="username"></s:fielderror></td>
</tr>
<tr>
<td>密码：</td>
<td><s:password name="password"></s:password></td>
<td><s:fielderror fieldName="password"></s:fielderror></td>
</tr>
<tr>
<td>确认密码：</td>
<td><s:password name="password2"></s:password></td>
<td><s:fielderror fieldName="password2"></s:fielderror></td>
</tr>
<tr>
<td>Email：</td>
<td><s:textfield name="email"></s:textfield></td>
<td><s:fielderror fieldName="email"></s:fielderror></td>
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
<td><img src="<%=path %>/vcode" /></td>
</tr>
<tr>
<td></td>
<td class="submit"><s:submit id="submitBtn" value="注册" onclick="return disableBtn(this);"></s:submit> </td>
</tr>
</table>
</s:form>

</div><!--content-->
<jsp:include page="internal/footer.jsp" />

</div><!--wrap-->


</body>
</html>