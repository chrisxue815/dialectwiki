<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xfhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style1.css"  />
<link rel="stylesheet" type="text/css" href="css/main.css"  />
<title>首页</title>
</head>


<body>

<div id="wrap">

<jsp:include page="internal/header.jsp" />

<div id="content">

<!--上左模块-->
<div class="module left">
<h2>Categorie</h2>
<div class="list"></div>
</div><!--left-->

<!--上中模块-->
<div class="module center">
<h2>Just A Title</h2>
<div class="list"></div>
</div><!--center-->

<!--右模块-->
<div class="module right"> 
<h2>Categories</h2>
<div class="list"></div>
</div><!--right-->

<!--下左模块-->
<div class="module left">
<h2>Archives</h2>
<div class="list"></div>
</div><!--left-->

<!--下中模块-->
<div class="module center">
<h2>Just Another Title</h2>
<div class="list"></div>
</div><!--center-->

<!--下右模块-->
<div class="module right"> 
<h2>Archives</h2>
<div class="list"></div>
</div><!--right-->

</div><!--content-->

<jsp:include page="internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>