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
		<br />
		<strong>接受信访举报统计表一</strong>
		<br />
		统计时间：<font color="#ff0000"><fmt:formatDate value="${chartForm.startdate }"  pattern="yyyy-MM-dd"/></font> 至 <font color="#ff0000"><fmt:formatDate value="${chartForm.enddate }"  pattern="yyyy-MM-dd"/></font>
		<table class="pure-table pure-table-bordered" width="1600px" align="center">
			<thead>
			<tr>
					<td colspan="2">-------</td>
						
					<td></td>
					<td colspan="17" align="center">业务范围内</td>
					<td colspan="6" align="center">业务范围外</td>
					<td></td>
					
				</tr>
				<tr>
					<th colspan="2">-------</th>
					<th>接受信访举报总量</th>
					<th>总量</th>
					<th>基础量</th>
					<th>重复举报</th>
					<th>署名举报</th>
					<c:forEach items="${types}" var="type">
						<th>${type.name }</th>
					</c:forEach>
					<th>申诉</th>
					<th>批评与建议</th>
					<th>总量</th>
					<th>涉法涉诉</th>
					<th>征地拆迁</th>
					<th>环境保护</th>
					<th>劳动保障</th>
					<th>其他</th>
					<th>无实质内容</th>
					
				</tr>
			</thead>
			
			<tbody>
			<tr>
					<td></td>
					<td>合计</td>
					<td>${itcast:allType(chartForm.startdate,chartForm.enddate)+itcast:allOther(chartForm.startdate,chartForm.enddate)+itcast:allAppeal(chartForm.startdate,chartForm.enddate)+itcast:allCriticize(chartForm.startdate,chartForm.enddate)+itcast:allNoContent(chartForm.startdate,chartForm.enddate)}</td>
					<td>${itcast:allType(chartForm.startdate,chartForm.enddate)}</td>
					<td>xx</td>
					<td>xx</td>
					<td>xx</td>
					
					<c:forEach items="${types}" var="type">
						<td>${itcast:type(type.id,chartForm.startdate,chartForm.enddate)}</td>
					</c:forEach>
					<td>${itcast:allAppeal(chartForm.startdate,chartForm.enddate)}</td>
					<td>${itcast:allCriticize(chartForm.startdate,chartForm.enddate)}</td>
					<td>${itcast:allOther(chartForm.startdate,chartForm.enddate)}</td>
					<td>${itcast:allOtherByEach("涉法涉诉",chartForm.startdate,chartForm.enddate)}</td>
					<td>${itcast:allOtherByEach("征地拆迁",chartForm.startdate,chartForm.enddate)}</td>
					<td>${itcast:allOtherByEach("环境保护",chartForm.startdate,chartForm.enddate)}</td>
					<td>${itcast:allOtherByEach("劳动保障",chartForm.startdate,chartForm.enddate)}</td>
					<td>${itcast:allOtherByEach("其他",chartForm.startdate,chartForm.enddate)}</td>
					<td>${itcast:allNoContent(chartForm.startdate,chartForm.enddate)}</td>
			</tr>
				<c:forEach items="${sources}" var="source" varStatus="status">
					<tr>
					<td>
						<c:if test="${status.index==0 }" >接受方式</c:if>
						</td>
					<td>${source.name }</td>
						<td>${itcast:source(source.id,chartForm.startdate,chartForm.enddate)+
						itcast:sourceAndAppeal(source.id,chartForm.startdate,chartForm.enddate)+
						itcast:sourceAndCriticize(source.id,chartForm.startdate,chartForm.enddate)+
						itcast:sourceAndOther2(source.id,chartForm.startdate,chartForm.enddate)+
						itcast:sourceAndNoContent(source.id,chartForm.startdate,chartForm.enddate)}</td>
						<td>${itcast:source(source.id,chartForm.startdate,chartForm.enddate)}</td>
						<td>xx</td>
						<td>xx</td>
						<td>xx</td>
						<c:forEach items="${types}" var="type">
							<td>
					${itcast:sourceAndType(source.id,type.id,chartForm.startdate,chartForm.enddate)} 
							
							</td>
						</c:forEach>
						
					<td>${itcast:sourceAndAppeal(source.id,chartForm.startdate,chartForm.enddate)} </td>
					<td>${itcast:sourceAndCriticize(source.id,chartForm.startdate,chartForm.enddate)}</td>
					<td>${itcast:sourceAndOther2(source.id,chartForm.startdate,chartForm.enddate)}</td>
					<td>${itcast:sourceAndOther("涉法涉诉",source.id,chartForm.startdate,chartForm.enddate)}</td>
					<td>${itcast:sourceAndOther("征地拆迁",source.id,chartForm.startdate,chartForm.enddate)}</td>
					<td>${itcast:sourceAndOther("环境保护",source.id,chartForm.startdate,chartForm.enddate)}</td>
					<td>${itcast:sourceAndOther("劳动保障",source.id,chartForm.startdate,chartForm.enddate)}</td>
					<td>${itcast:sourceAndOther("其他",source.id,chartForm.startdate,chartForm.enddate)}</td>
					<td>${itcast:sourceAndNoContent(source.id,chartForm.startdate,chartForm.enddate)}</td>
						
					</tr>
				</c:forEach>
				
				<c:forEach items="${ranks}" var="rank" varStatus="status">
					<tr>
						<td >
						<c:if test="${status.index==0 }" >职级</c:if>
						</td>
					<td>${rank.name }</td>
						<td>${itcast:rank(rank.id,chartForm.startdate,chartForm.enddate)+itcast:rankAndAppeal(rank.id,chartForm.startdate,chartForm.enddate)}</td>
						<td>${itcast:rank(rank.id,chartForm.startdate,chartForm.enddate)}</td>
						<td>xx</td>
						<td>xx</td>
						<td>xx</td>
						<c:forEach items="${types}" var="type">
							<td>${itcast:rankAndType(rank.id,type.id,chartForm.startdate,chartForm.enddate)} </td>
						</c:forEach>
					<td>${itcast:rankAndAppeal(rank.id,chartForm.startdate,chartForm.enddate)} </td>
					<td>--</td>
					<td>--</td>
					<td>--</td>
					<td>--</td>
					<td>--</td>
					<td>--</td>
					<td>--</td>
					<td>--</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
