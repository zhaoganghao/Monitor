<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/page/share/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>受理登记</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/pure-min.css">
  </head>
  
  <body>
  	<div class="pure-menu pure-menu-open">
		<ul style="font-size: 16px;">
			<li class="pure-menu-heading"><a href="<html:rewrite action='/control/inbusiness'/>"><b>业务范畴内：</b></a></li>
			<li class="pure-menu-separator"></li>
			<li><a href="<html:rewrite action='/control/register/manage'/>?method=addUI">检举控告类</a></li>
			<li><a href="<html:rewrite action='/control/appeal/manage'/>?method=addUI">申诉</a></li>
			<li><a href="<html:rewrite action='/control/criticize/manage'/>?method=addUI">批评与建议</a></li>
		</ul>
	</div>
  </body>
</html>
