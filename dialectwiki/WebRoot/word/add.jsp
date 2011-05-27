<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="../css/style1.css" />
<link rel="stylesheet" type="text/css" href="../css/word.css"/>

<title>添加词条</title>
</head>

<body>
<div id="wrap">

<jsp:include page="../internal/header.jsp" />

<div id="content">

<div class="left">
<div class="lefth1">添加词条</div>
<div class="lefth2">如果你想知道一个词条的发音或者想对一个词条进行发音，请从下面添加一个词条。</div>
<div class="lefth3">
词条：
<s:form action="AddWordAction.action" theme="simple">
<s:textfield name="wordname" /><br /><br />
<s:submit value="添加"></s:submit>
</s:form>
</div>
</div>

<div class="right">
广 告 招 商</div>

</div>
<!--content-->

<jsp:include page="../internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>