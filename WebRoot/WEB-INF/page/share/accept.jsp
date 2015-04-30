<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/page/share/taglib.jsp"%>
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
			<li class="pure-menu-heading"><b>请选择受理范围</b></li>
			<li class="pure-menu-separator"></li>
			<li><a href="<html:rewrite action='/control/inbusiness'/>">业务范围内</a></li>
			<li><a href="<html:rewrite action='/control/other/manage'/>?method=addUI">业务范围外</a></li>
			<li><a href="<html:rewrite action='/control/nocontent/manage'/>?method=addUI">无实质内容的信访举报</a></li>
		</ul>
	</div>
</body>
</html>
