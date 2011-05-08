<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xfhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style1.css"  />
<title>首页</title>
</head>


<body>

<div id="wrap">

<jsp:include page="internal/header.jsp" />
<div id="content">

<div class="left"> 

<h2>Categories :</h2>
<div class="list"></div>
<h2>Archives</h2>
<div class="list"></div>


</div>

<div class="center">
<div class="list"></div>
<br/>

</div>

<div class="right"> 



<h2>Categories :</h2>
<div class="list"></div><br />
<h2>Archives</h2>
<div class="list"></div>
</div>


<div style="clear: both;"> </div>

</div>


<jsp:include page="internal/footer.jsp" />
</div>

</body>
</html>