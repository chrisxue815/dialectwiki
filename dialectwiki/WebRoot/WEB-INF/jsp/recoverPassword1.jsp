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

<title>方言百科 - 注册</title>

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
<s:form action="/recover2" theme="simple" id="myForm">

<table>

<tr>
<td>用户名：</td>
<td><input type="text" name="username" /></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="下一步" /></td>
</tr>

</table>

</s:form>

</div><!--content-->
<jsp:include page="internal/footer.jsp" />

</div><!--wrap-->


</body>
</html>