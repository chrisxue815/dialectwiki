<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ page import="java.util.List"  %>
<%@ page import="org.dw.model.*" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<base href="<%=basePath %>" />

<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style1.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/word.css"/>

<title>词条</title>
</head>

<body>

<div id="wrap">

<jsp:include page="../internal/header.jsp" />

<div id="content">
<%
	List<Pronunciation> prons = (List<Pronunciation>)request.getAttribute("prons");
    List<Province> provinceList = (List<Province>)request.getAttribute("provinceList");
	List<City> cityList = (List<City>)request.getAttribute("cityList");
	    
	List<Integer> pronsIndexs = (List<Integer>)request.getAttribute("pronsIndexs");
	List<Integer> cityIndexs = (List<Integer>)request.getAttribute("cityIndexs");
%>


<div class="left">
<div class="lefth1">词条：<strong><s:property value="word.wordName"/></strong></div>
<%
	int i = 0;
    int j = 0;
    int cityIndex = 0;
    int pronIndex = 0;
    
    for(Province province : provinceList)
    {
    	String provinceName = province.getProvinceName();
%>
<h5><%=provinceName%><a href="">我要发音</a>
<% 
        while(i < cityIndexs.get(cityIndex))
        {
        	String cityName = cityList.get(i).getCityName();
         
%>

<li><%=cityName %></li>
<%
			while( j < pronsIndexs.get(pronIndex))
			{
				Pronunciation pron = prons.get(j);
				String pronUser = pron.getUser().getUsername();
				String Date = pron.getUploadDate().toString();
				int goodVote = pron.getGoodVoteNum();
				int badVote = pron.getBadVoteNum(); 
%>
<p class="pro">[]&nbsp;&nbsp;<%=pronUser%>1&nbsp;XXXXXXXXXX&nbsp;&nbsp;&nbsp;发音时间<%=Date %> 评价得分：xx
<br />
评分 ***** <a href="">评论</a></p>


<%			
				j++;
			}
			pronIndex++;
	        i++;	
		}
		cityIndex++;
	}
 %>

</h5>
</div>
</div>
<div class="right">
helsdafasdfsdf
</div>
<!--content-->
<div style="clear: both;"> </div>
<jsp:include page="../internal/footer.jsp" />

</div><!--wrap-->

</body>
</html>