<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>以处理方式查询的检举控告类表列表</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/pure-min.css"/>
	<style type="text/css">
body {
	font-size: 14px;
	font-family: arial, 'Hiragino Sans GB', 'Microsoft Yahei', '微软雅黑', '宋体',
		\5b8b\4f53, Tahoma, Arial, Helvetica, STHeiti;
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
.content {
	margin: 10px auto;
	margin-left: 20px;
	font-family: inherit;
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
	<p align="left" style="font-size: 18px;color: blue;">以处理方式查询的检举控告:</p>
		<br />
		<html:form action="/control/register/manage" method="post">
		<input type="hidden" name="method" value="query"/>
			<html:hidden property="page" />
			<html:hidden property="query" />
			<html:hidden property="indexcode" />
			<html:hidden property="personcode" />
			<html:hidden property="reportedname" />
			<html:hidden property="startdate" />
			<html:hidden property="enddate" />
			<html:hidden property="sourceid" />
			<html:hidden property="typeid" />
			<html:hidden property="rankid" />
			<html:hidden property="ispunish" />
			<html:hidden property="mainthread" />
			<html:hidden property="handlerway1id" />
			<html:hidden property="handlernumber" />
			<html:hidden property="sourcenumber" />
			<html:hidden property="sourcetwo" />
			<table class="pure-table pure-table-bordered" align="center" style="width: 90%;">
				<thead>
					<tr>
						<th>线索编号</th>
						<th>被反映人</th>
						<th>问题类型</th>
						<th>职级</th>
						<th>接受方式</th>
						<th>时间</th>
						<th>处置次数</th>
						<th>处置走向</th>
						<th>删除</th>
						<th>修改</th>
						<th>打印</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageView.records}" var="entry">
						<tr>
							<td>${entry.register.indexcode }</td>
							<td>${entry.register.reportedname }</td>
							<td>${entry.register.type.name }</td>
							<td>${entry.register.rank.name }</td>
							<td>${entry.register.source.name }</td>
							<td>${entry.register.filldate }</td>
							<td>
							${entry.register.size }
							</td>
							<td>
							${entry.register.direct }
							</td>
							<td><a onclick="javascript: if(window.confirm('是否删除')) window.location='<html:rewrite action='/control/register/manage'/>?method=delete&id=${entry.register.id}';"
								>删除</a>
							</td>
							<td><a
								href="<html:rewrite action="/control/register/manage"/>?method=editUI&id=${entry.register.id}">修改</a>
							</td>
							<td><a
								href="<html:rewrite action="/control/register/manage"/>?method=print&id=${entry.id}">打印</a>
							</td>
						</tr>
					</c:forEach>

					<tr>
						<td colspan="11" align="center" style="color: red"><%@ include
								file="/WEB-INF/page/share/fenye.jsp"%>
						</td>
					</tr>
				</tbody>
			</table>
		</html:form>
	</div>
</body>
</html>
