<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>方言百科 - 添加词条</title>

<link rel="stylesheet" type="text/css" href="<%=path %>/css/style1.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/css/addword.css"/>

<script type="text/javascript">
function init()
{
document.getElementById("wordnameinput").focus();
}
</script>

</head>

<body onload="init()">
<div id="wrap"> 

<jsp:include page="../internal/header.jsp" />

<div id="content">

<div class="left">
<div class="lefth1">添加词条</div>
<s:if test="#parameters.fromWord!=null && #parameters.wordname!=null">
<div class="lefth2c">
词条 
<span class="wordnametip"><s:property value="#parameters.wordname" /></span> 
不存在，请添加
</div>
</s:if>
<s:else>
<div class="lefth2">如果你想知道一个词条的发音或者想对一个词条进行发音，请从下面添加一个词条。</div>
</s:else>
<div class="lefth3">
<div class="worditemtip">词条：</div>
<s:form action="/addwordEx" method="post" theme="simple">
<s:textfield name="wordname" value="%{#parameters.wordname}" id="wordnameinput" /><br /><br />
<s:submit value="  添加  " />
</s:form>
</div>
</div>

<div class="right">
广 告 招 商
</div>

</div>
<!--content-->
<div style="clear: both;"> </div>
<jsp:include page="../internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>