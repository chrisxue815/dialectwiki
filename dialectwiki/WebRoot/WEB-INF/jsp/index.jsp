<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xfhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>方言百科 - 首页</title>

<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style1.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/index.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/more1.css" />

<script type="text/javascript">
function init()
{
document.getElementById("stext").focus();
}
</script>
</head>


<body onload="init()">

<div id="wrap">

<jsp:include page="internal/header.jsp" />

<div id="content">

<!--上左模块-->
<div class="module left">
<h2>待发音词条<a class="more" href="moreWaitProns">更多</a></h2>
<div class="list">
<ul>
  <s:iterator value="waitProns">
  <li>
  <a href="/dialectwiki/word?id=<s:property value="wordId" />"><s:property value="wordName" />
  </a>
  </li>
  </s:iterator>
</ul>
</div>
</div><!--left-->

<!--上中模块-->
<div class="module center">
<h2>热门词条<a class="more" href="moreHotWords">更多</a></h2>
<div class="list">
<ul>
<s:iterator value="hotWords">
<li>
<a href="<%=path %>/word?id=<s:property value="wordId" />">
<s:property value="wordName" />
</a>
</li>
</s:iterator>
</ul>
</div>
</div><!--center-->

<!--上右模块-->
<div class="module right siteintro">
<h2>什么是方言百科？</h2>
<div class="innerright">
<div class="list">
<div style="height:12px"></div>
方言百科是一个关于中国方言的发音指南。<br />
<ul>
<li>你是否想知道“给力”是哪个地方的话？</li>
<li>你是否想知道某个词语在其它的方言下如何发音？</li>
<li>你是否曾经外出旅游时对当地语言产生过强烈的兴趣？</li>
</ul>
　　搜索这个词语吧，你可以听到其他用户的发音，你也可以帮助其他用户，录制你所熟悉的方言发音。
<div class ="joinus">
<a style="color:#FFF" href="<%=basePath %>signup">加入我们</a>
</div>
　　无论你熟悉哪种方言，请加入我们吧，让我们一起促进方言间的交流，
感受方言文化的独特魅力，享受学习与合作的乐趣。
</div>
</div>
</div><!--right-->

<!--下左模块-->
<div class="module left">
<h2>最新词条<a class="more" href="moreRecentWords">更多</a></h2>
<div class="list">
<ul>
  <s:iterator value="recentWords">
  <li>
  <a href="/dialectwiki/word?id=<s:property value="wordId" />"><s:property value="wordName" />
  </a>
  </li>
  </s:iterator>
 </ul>
</div>
</div><!--left-->

<!--下中模块-->
<div class="module center">
<h2>最新发音<a class="more" href="moreRecentProns">更多</a></h2>
<div class="list">
<ul>
<s:iterator value="recentProns">
<li>
<a href="/dialectwiki/word?id=<s:property value="word.wordId" />">
<s:property value="word.wordName" /> 
</a>
<span class="listregion">
地区:
<s:property value="city.province.provinceName"/> - 
<s:property value="city.cityName"/>
</span>
</li>
</s:iterator>
</ul>
</div>
</div><!--center-->

<!--下右模块-->
<div class="module right siteintro"> 
<h2>使用指南</h2>
<div class="list">
<div class="intro"><br />
<span class="black">你是新手么？</span><br />
  <li>1.你想发音？</li><br />
  在搜索框中输入你想发音的词语<br />
  如果该词语不存在，进入添加词语页面<br />
  添加词语成功后可以进入发音页面<br />
  <li>2.你想询问发音么？</li><br />
  在搜索框中输入你想询问的词语<br />
  如果该词语不存在，进入添加词语页面,便可等待该条词语被发音<br />
  <li>3.你想听取发音？</li><br />
  在搜索框中输入你想询问的词语<br />
  找到对应的词语，听取你想要的发音</div></div>
</div><!--right-->

</div><!--content-->

<div style="clear: both;"></div>

<jsp:include page="internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>