<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/pure-min.css"/>
<style type="text/css">
body {
	font-size: 14px;
	font-family: arial, 'Hiragino Sans GB', 'Microsoft Yahei', '微软雅黑', '宋体',
		\5b8b\4f53, Tahoma, Arial, Helvetica, STHeiti;
}

.content {
	margin: 10px auto;
	margin-left: 20px;
	font-family: inherit;
}
a { 
color:#000000
}
a:link {
 text-decoration: none;
}
a:visited {
 text-decoration: none;
}
a:hover {
 text-decoration: underline;
}
</style>
	<style type="text/css">
<!--
.STYLE2 {
	font-size: 30
}
-->
</style>
</head>

<body>
	<dir class="content">
		<center>
			<a class="pure-button pure-button-primary"
				href="<html:rewrite action="/control/user/manage"/>?method=addUI">添加</a>
		</center>
		<br> <html:form action="/control/user/list" method="post">
				<html:hidden property="page" />
				<html:hidden property="query" />
				<table class="pure-table pure-table-bordered" align="center" style="width:90%;">
					<thead>
					<tr>
						<td>用户名</td>
						<td>Email</td>
						<td>电话</td>
						<td>删除</td>
						<td>修改</td>
					</tr>
					</thead>
					<c:forEach items="${pageView.records}" var="entry">
						<tr>
							<td>${entry.username }</td>
							<td>${entry.email }</td>
							<td>${entry.phone }</td>
							<td><a onclick="javascript: if(window.confirm('是否删除')) window.location='<html:rewrite action="/control/user/manage"/>?method=delete&id=${entry.id}';"
								>删除</a>
							</td>
							<td><a
								href="<html:rewrite action="/control/user/manage"/>?method=editUI&id=${entry.id}">修改</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" bgcolor="6f8ac4" align="right"><%@ include
								file="/WEB-INF/page/share/fenye.jsp"%>
						</td>
					</tr>
				</table>
			</html:form>
	</dir>
</body>
</html>
