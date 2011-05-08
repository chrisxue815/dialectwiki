<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style1.css"  />
<link rel="stylesheet" type="text/css" href="css/login.css"  />
<title>登录</title>
</head>

<body>
<div id="wrap">

<jsp:include page="internal/header.jsp" />

<div id="content">
<div class="left"></div>
<div class="right">
<h2>登录</h2>
<form id="dw_login" action="#" method="post">
<div class=""><label for="login">用户名：</label><input name="login" type="text" /></div>
<div class=""><label for="password"><br />密&nbsp;&nbsp;&nbsp;&nbsp;码：</label><input name="password" type="password" />
</div>
<div class=""></div>


</form>
</div>
</div>

</div><!--content-->

<jsp:include page="internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>