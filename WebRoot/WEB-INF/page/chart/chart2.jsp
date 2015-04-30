<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
 <%@taglib uri="/itcast" prefix="itcast" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>登记列表</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/pure-min.css">
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
		<br /><strong>接受信访举报统计表二</strong>
		<br />
		统计时间：<font color="#ff0000"><fmt:formatDate value="${chartForm.startdate }"  pattern="yyyy-MM-dd"/></font> 至 <font color="#ff0000"><fmt:formatDate value="${chartForm.enddate }"  pattern="yyyy-MM-dd"/></font>
		<table class="pure-table pure-table-bordered" width="4000px" align="center">
			<thead>
			<tr>
					<td  colspan="2">---</td>
					<c:forEach items="${types}" var="type">
												<td colspan="${type.size}" align="center">${type.name }</td>
						
					</c:forEach>
			</tr>
				<tr>
				<th  colspan="2">---</th>
					<c:forEach items="${types}" var="type">
						<c:if test="${!empty type.children }">
											<c:forEach items="${type.children}" var="child">
												<th>${child.name }</th>
											</c:forEach>
						</c:if>
						<c:if test="${empty type.children }">
												<th>--</th>
						</c:if>
						
					</c:forEach>
				</tr>
			</thead>
			
			<tbody>
			<tr>
					<td></td>
					<td>合计</td>
					<c:forEach items="${types}" var="type">
											<c:forEach items="${type.children}" var="child">
												<td>${itcast:type(child.id,chartForm.startdate,chartForm.enddate)}</td>
											</c:forEach>
											<c:if test="${empty type.children }">
												<td>--</td>
											</c:if>
					</c:forEach>
			</tr>
				<c:forEach items="${sources}" var="source" varStatus="status">
					<tr>
					<td>
						<c:if test="${status.index==0 }" >接受方式</c:if>
					</td>
					<td>${source.name }</td>
						<c:forEach items="${types}" var="type">
											<c:forEach items="${type.children}" var="child">
												<td>${itcast:sourceAndType(source.id,child.id,chartForm.startdate,chartForm.enddate)}</td>
											</c:forEach>
											<c:if test="${empty type.children }">
												<td>--</td>
											</c:if>
						</c:forEach>
						
					</tr>
				</c:forEach>
				
				<c:forEach items="${ranks}" var="rank" varStatus="status">
					<tr>
					<td >
						<c:if test="${status.index==0 }" >职级</c:if>
						</td>
					<td>${rank.name }</td>
						<c:forEach items="${types}" var="type">
											<c:forEach items="${type.children}" var="child">
												<td>${itcast:rankAndType(rank.id,child.id,chartForm.startdate,chartForm.enddate)}</td>
											</c:forEach>
											<c:if test="${empty type.children }">
												<td>--</td>
											</c:if>
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
