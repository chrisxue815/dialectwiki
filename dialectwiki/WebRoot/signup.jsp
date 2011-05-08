<%@ page contentType="text/html; charset=utf-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="css/style1.css" />
<link rel="stylesheet" type="text/css" href="css/signup.css" />

<title>注册</title>

</head>


<body>

<div id="wrap">

<jsp:include page="internal/header.jsp" />

<div id="content">

<h2 class="title">注册用户</h2>

<form action="" method="post">
<table class="userInfo">
<tr>
<td>用户名：</td>
<td><input type="text" /></td>
</tr>
<tr>
<td>密码：</td>
<td><input type="password" /></td>
</tr>
<tr>
<td>确认密码：</td>
<td><input type="password" /></td>
</tr>
<tr>
<td>验证码：</td>
<td><input type="password" /></td>
</tr>
<tr>
<td></td>
<td><img src="" /></td>
</tr>
<tr>
<td class="submit" colspan="2"><input type="submit" value="注册" /></td>
</tr>
</table>
</form>

</div>

<jsp:include page="internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>