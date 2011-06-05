<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xfhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style1.css"  />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/main.css"  />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/search.css"  />
<title>wordIndex</title>
</head>



<body>

<div id="wrap">

<jsp:include page="../internal/header.jsp" />

<div id="content">

<div id="topinfo">
“ <strong>好</strong> ”的搜索结果：找到2个词语.
</div>

<div id="sresult">

<div class="sitem">
<a onclick="return false;"><img src="" /></a>
<a href="word?wordId=1">好</a>
</div>

<div class="sitem">
<a onclick="return false;"><img src="" /></a>
<a href="word?wordId=2">很好</a>
</div>

</div><!-- sresult -->

</div><!-- content -->


<jsp:include page="../internal/footer.jsp" />
</div>

</body>
</html>