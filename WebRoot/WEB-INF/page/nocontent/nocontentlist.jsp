<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>登记业务范围外业务</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/pure-min.css" />
<style type="text/css" >
body { font-size: 14px; font-family: arial, 'Hiragino Sans GB',
'Microsoft Yahei', '微软雅黑', '宋体', \5b8b\4f53, Tahoma, Arial, Helvetica,
STHeiti; } 
.content { margin: 10px auto; margin-left: 20px; font-family:
inherit; }
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
<script language="JavaScript">
<!--
	//到指定的分页页面
	function topage(page) {
		var form = document.forms[0];
		form.page.value = page;
		form.submit();
	}
//-->
</script>
</head>

<body>
	<div class="content">
		<p align="left" style="font-size: 18px;color: blue;">无实质内容管理:</p>
		<center>
			<a class="pure-button pure-button-primary"
				href="<html:rewrite action="/control/nocontent/manage"/>?method=addUI">添加</a>
			<a class="pure-button pure-button-primary"
				href="<html:rewrite action="/control/nocontent/manage"/>?method=queryUI">查询</a>
		</center>
		<br />
		<html:form action="/control/nocontent/list" method="post">
			<html:hidden property="page" />
			<html:hidden property="query" />
			<html:hidden property="indexcode" />
			<html:hidden property="startdate" />
			<html:hidden property="enddate" />
			<html:hidden property="sourceid" />
			<html:hidden property="handlerway" />
			<table class="pure-table pure-table-bordered" align="center"
				style="width: 90%;">
				<thead>
					<tr>
						<th>线索编号</th>
						<th>被反映人或事</th>
						<th>接受方式</th>
						<th>处置去向</th>
						<th>时间</th>
						<th>删除</th>
						<th>修改</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageView.records}" var="entry">
						<tr>
							<td>${entry.indexcode }</td>
							<td>${entry.reportedname }</td>
							<td>${entry.source.name }</td>
							<td>${entry.handlerway }</td>

							<td>${entry.filldate }</td>
							<td><a
								onclick="javascript: if(window.confirm('是否删除')) window.location='<html:rewrite action="/control/nocontent/manage"/>?method=delete&id=${entry.id}';">删除</a>
							</td>
							<td><a
								href="<html:rewrite action="/control/nocontent/manage"/>?method=editUI&id=${entry.id}">修改</a>
							</td>
						</tr>
					</c:forEach>

					<tr>
						<td colspan="7" align="center" style="color: red"><%@ include
								file="/WEB-INF/page/share/fenye.jsp"%></td>
					</tr>
				</tbody>
			</table>
		</html:form>
	</div>
</body>
</html>
