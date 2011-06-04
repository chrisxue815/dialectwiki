<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xfhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style1.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/dialect.css" />

<title>方言</title>

</head>


<body>

<div id="wrap">

<jsp:include page="../internal/header.jsp" />

<div id="content">

<div class="dialect">
<h2>方言列表</h2>
<h3>词条数大于1000</h3>
</div>

</div><!--content-->

<jsp:include page="../internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>