<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="java.util.List" %>
<%@ page import="org.dw.model.City" %>
<%@ page import="org.dw.model.Pronunciation" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xfhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style1.css"  />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/userIndex.css"  />
<title>方言百科 - 用户页</title>
</head>



<body>

<div id="wrap">

<jsp:include page="../internal/header.jsp" />
<div id="content">
<!--左模块-->
<div class="module left">
  <h2>发音最多的用户</h2>
<div class="list">
<ul>
  <s:iterator value="NBUsers">
  <li>
  <a href="/dialectwiki/user?id=<s:property value="userId" />"><s:property value="username" />
  </a>
  
  <span class="listregion">
  发音总数：<s:property value="pronunciations.size()" />
  </span>
  </li>
  </s:iterator>
</ul>
</div>
</div><!--left-->

<!--中模块-->
<div class="module center">
<h2>推荐的好评用户</h2>
<div class="list">
<ul>
<s:iterator value="GOODUsers" status="status">
  <li>
  <a href="/dialectwiki/user?id=<s:property value="userId" />"><s:property value="username" />
  </a> 
  <sec:authorize ifAnyGranted="ROLE_ADMIN">
  <span class="listregion">
	  <s:if test='Authoritys.get(#status.index).authority=="ROLE_USER"'>
	  	<a href="forbiddenUser?id=<s:property value="userId" />">封禁用户</a>
	  </s:if>
	  <s:else>
	  	<a href="unforbiddenUser?id=<s:property value="userId" />">解封用户</a>
	  </s:else>
  </span>
  </sec:authorize>
  </li>
  </s:iterator>
</ul>
</div>
</div><!--center-->

<!--右模块-->
<div class="module right">
<s:if test="user==null">
<h2>注册</h2>
<div class="innerright">
<div class="list">
<br  />
<span class="black">会员功能</span><br />
添加词条。你可以添加一个词条，给它发音或等待它在各地的读音。<br />
发音上传。让大家都听听你不同的嗓音，展示你们地方语言独特的魅力。<br />
投票顶踩。听到你认为不错的发音，顶一下吧；或则如果认为他发音不标准，也投出你宝贵的一票。<br />
<div class ="joinus"><a style="color:#FFF" href="<%=basePath %>signup">加入我们</a></div>
无论你熟悉哪种方言，会说哪种方言，请加入我们吧，让我们一起帮助别人更好的交流，感受方言文化
的独特魅力，享受学习与合作的乐趣。
</div>
</div>
</s:if>
<s:else>
<h2>用户信息</h2>
<div class="list">
<div class="itemLink">
用户名：<s:property value="user.username" /><br />
邮&nbsp;&nbsp;&nbsp;&nbsp;箱：<s:property value="user.email" /><br />
性&nbsp;&nbsp;&nbsp;&nbsp;别：
<s:if test='user.sex=="m"'>男</s:if><s:else>女</s:else>
<br />
<sec:authorize ifAnyGranted="ROLE_ADMIN">用户权限：管理员<br /></sec:authorize>
<sec:authorize ifNotGranted="ROLE_ADMIN">用户权限：普通用户<br />
状&nbsp;&nbsp;&nbsp;&nbsp;态：<sec:authorize ifAnyGranted="ROLE_USER">活跃</sec:authorize><sec:authorize ifAnyGranted="ROLE_FORBIDDEN">封禁</sec:authorize><br />
</sec:authorize>
<s:if test='pronList.size>0'>添加过的发音：<br/>

<s:iterator value="pronList" status="status">
	<s:if test="#status.index < 6">
	<div class="word">
			<s:property value="mapCity[#status.index].province.provinceName"/>
			-<s:property value="mapCity[#status.index].cityName"/>&nbsp;
			
	<s:iterator value="pronList.get(#status.index)" begin="0" end="0"status="st">
	
	<strong><s:property value="word.wordName"/></strong>&nbsp;<span class="gray">顶&nbsp;<s:property value="goodVoteNum"/>&nbsp;&nbsp;踩&nbsp;<s:property value="badVoteNum"/></span>

	</s:iterator>
	</div>
	</s:if>
</s:iterator>
</s:if>
</div>
</div><!-- rightItem -->
</s:else>
</div><!--right-->



<div style="clear: both;"> </div>

</div>


<jsp:include page="../internal/footer.jsp" />
</div>

</body>
</html>