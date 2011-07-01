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
document.getElementById("answer").focus();
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

<h1>找回密码 - 第二步</h1>

<s:form action="/recover3" theme="simple" id="myForm">

<table>
<tr>
<th>密保问题：</th>
<td><s:property value="question" /></td>
</tr>
<tr>
<th>密保答案：</th>
<td><s:textfield name="answer" id="answer" ></s:textfield></td>
</tr>
<tr>
<th></th>
<td><s:fielderror name="answer"></s:fielderror></td>
</tr>
<tr>
<th></th>
<td><input type="submit" value="下一步" /></td>
</tr>
</table>

<input type="hidden" name="username" value='<s:property value="username" />' />
</s:form>

</div><!--content-->
<jsp:include page="internal/footer.jsp" />

</div><!--wrap-->


</body>
</html>