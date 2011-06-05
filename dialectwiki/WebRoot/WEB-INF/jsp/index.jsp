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
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/main.css" />

<title>首页</title>

</head>


<body>

<div id="wrap">

<jsp:include page="internal/header.jsp" />

<div id="content">

<!--上左模块-->
<div class="module left">
<h2>最新发音</h2>
<div class="list"></div>
</div><!--left-->

<!--上中模块-->
<div class="module center">
<h2>热门发音</h2>
<div class="list"></div>
</div><!--center-->

<!--上右模块-->
<div class="module right"> 
<h2>站点释义</h2>
<div class="list"></div>
</div><!--right-->

<!--下左模块-->
<div class="module left">
<h2>待解决词条</h2>
<div class="list"></div>
</div><!--left-->

<!--下中模块-->
<div class="module center">
<h2>热门词条</h2>
<div class="list"></div>
</div><!--center-->

<!--下右模块-->
<div class="module right"> 
<h2>牛逼用户</h2>
<div class="list"></div>
</div><!--right-->

</div><!--content-->

<div style="clear: both;"></div>

<jsp:include page="internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>