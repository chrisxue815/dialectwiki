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
<link rel="stylesheet" type="text/css" href="<%=path %>/css/style1.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/css/dialect.css" />

<title>方言百科 - 404未找到资源</title>

</head>


<body>

<div id="wrap">

<jsp:include page="internal/header.jsp" />

<div id="content">

<div class="center">
<img style="margin-right: 100px" src="<%=path %>/css/images/fileNotFound.jpg" />
</div>
</div><!--content-->

<jsp:include page="internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>