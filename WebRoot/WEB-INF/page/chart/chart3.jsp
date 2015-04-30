<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<%@taglib uri="/itcast" prefix="itcast"%>
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
		<br /> <strong> 反映问题线索处置情况统计表三</strong> <br /> 统计时间：<font color="#ff0000"><fmt:formatDate
				value="${chartForm.startdate }" pattern="yyyy-MM-dd" /> </font> 至 <font
			color="#ff0000"><fmt:formatDate value="${chartForm.enddate }"
				pattern="yyyy-MM-dd" /> </font>
		<table class="pure-table pure-table-bordered" width="2200px"
			align="center">
			<thead>
				<tr>
					<td>---</td>
					<td></td>
					<td colspan="8" align="center">线索来源</td>

					<td colspan="${fn:length(types)}" align="center">问题类型</td>

					<td colspan="17" align="center">处置方式</td>


				</tr>
				<tr>
					<th>---</th>
					<th>线索处置总数</th>
						<th>信访举报</th>	
						<th>上级交办</th>	
						<th>公检法移送</th>	
						<th>执法监察中发现</th>	
						<th>办案中发现</th>	
						<th>审计中发现</th>	
						<th>巡视中发现</th>	
						<th>其他</th>
					<c:forEach items="${types}" var="type">
						<th>${type.name }</th>

					</c:forEach>
					<c:forEach items="${handlerways}" var="handler">
								<th>${handler.name}(合计)</th>
						<c:if test="${!empty handler.children }">
							<c:forEach items="${handler.children}" var="child">
								<th>${child.name }<font color="#FFFFFF">(${handler.name})</font>
								</th>
							</c:forEach>
						</c:if>
							<%-- <c:if test="${empty handler.children }">
								<th>${handler.name}</th>
							</c:if> --%>
					</c:forEach>



				</tr>
			</thead>

			<tbody>
				<tr>
					<td>合计</td>

					<td>${itcast:allTypeHandlered(chartForm.startdate,chartForm.enddate)}</td>
						<td>${itcast:sourceTwo("信访举报",chartForm.startdate,chartForm.enddate)}</td>	
						<td>${itcast:sourceTwo("上级交办",chartForm.startdate,chartForm.enddate)}</td>	
						<td>${itcast:sourceTwo("公检法移送",chartForm.startdate,chartForm.enddate)}</td>	
						<td>${itcast:sourceTwo("执法监察中发现",chartForm.startdate,chartForm.enddate)}</td>	
						<td>${itcast:sourceTwo("办案中发现",chartForm.startdate,chartForm.enddate)}</td>	
						<td>${itcast:sourceTwo("审计中发现",chartForm.startdate,chartForm.enddate)}</td>	
						<td>${itcast:sourceTwo("巡视中发现",chartForm.startdate,chartForm.enddate)}</td>	
						<td>${itcast:sourceTwo("其他",chartForm.startdate,chartForm.enddate)}</td>
					<c:forEach items="${types}" var="type">
						<td>${itcast:type(type.id,chartForm.startdate,chartForm.enddate)}</td>

					</c:forEach>
					<c:forEach items="${handlerways}" var="handler">
					<td>${itcast:handlerWay(handler.name,chartForm.startdate,chartForm.enddate)}</td>
						<c:if test="${!empty handler.children }">
							<c:forEach items="${handler.children}" var="child">
								<td>${itcast:handlerWay(child.name,chartForm.startdate,chartForm.enddate)}</td>
							</c:forEach>

						</c:if>
					</c:forEach>
				</tr>

				<c:forEach items="${ranks}" var="rank">
					<tr>
						<td>${rank.name }</td>
						<td>${itcast:rank(rank.id,chartForm.startdate,chartForm.enddate)}</td>

						<td>${itcast:sourceTwoAndRank("信访举报",rank.id,chartForm.startdate,chartForm.enddate)}</td>	
						<td>${itcast:sourceTwoAndRank("上级交办",rank.id,chartForm.startdate,chartForm.enddate)}</td>	
						<td>${itcast:sourceTwoAndRank("公检法移送",rank.id,chartForm.startdate,chartForm.enddate)}</td>	
						<td>${itcast:sourceTwoAndRank("执法监察中发现",rank.id,chartForm.startdate,chartForm.enddate)}</td>	
						<td>${itcast:sourceTwoAndRank("办案中发现",rank.id,chartForm.startdate,chartForm.enddate)}</td>	
						<td>${itcast:sourceTwoAndRank("审计中发现",rank.id,chartForm.startdate,chartForm.enddate)}</td>	
						<td>${itcast:sourceTwoAndRank("巡视中发现",rank.id,chartForm.startdate,chartForm.enddate)}</td>	
						<td>${itcast:sourceTwoAndRank("其他",rank.id,chartForm.startdate,chartForm.enddate)}</td>
						<c:forEach items="${types}" var="type">
							<td>${itcast:rankAndType(rank.id,type.id,chartForm.startdate,chartForm.enddate)}</td>

						</c:forEach>
						<c:forEach items="${handlerways}" var="handler">
						<td>${itcast:rankAndHandlerWay(handler.name,rank.id,chartForm.startdate,chartForm.enddate)}</td>
							<c:if test="${!empty handler.children }">
								<c:forEach items="${handler.children}" var="child">
									<td>${itcast:rankAndHandlerWay(child.name,rank.id,chartForm.startdate,chartForm.enddate)}</td>
								</c:forEach>
							</c:if>
							<%-- <c:if test="${empty handler.children }">
								<td>${itcast:rankAndHandlerWay(handler.name,rank.id,chartForm.startdate,chartForm.enddate)}</td>
							</c:if> --%>
						</c:forEach>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
