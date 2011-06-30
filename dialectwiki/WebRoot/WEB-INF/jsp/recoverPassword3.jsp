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

<link rel="stylesheet" type="text/css" href="<%=path %>/css/style1.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/css/recover1.css" />

<title>方言百科 - 密码找回</title>

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
<h1>找回密码 - 第三步</h1>
<s:form action="/recover4" theme="simple" id="myForm">

<table>
<tr>
<th>新密码：</th>
<td><input type="password" name="password" /></td>
</tr>
<tr>
<th>确认密码：</th>
<td><input type="password" name="password2" /></td>
</tr>
<tr>
<th></th>
<td><s:fielderror name="password"></s:fielderror></td>
</tr>
<tr>
<th></th>
<td><input type="submit" value="下一步" /></td>
</tr>
</table>

</s:form>

</div><!--content-->
<jsp:include page="internal/footer.jsp" />

</div><!--wrap-->


</body>
</html>