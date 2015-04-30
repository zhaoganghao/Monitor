<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<html>
<head>
<title>查询检举控告类表</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/pure-min.css">
<style type="text/css">
body {
	font-size: 12px;
	font-family: arial, 'Hiragino Sans GB', 'Microsoft Yahei', '微软雅黑', '宋体',
		\5b8b\4f53, Tahoma, Arial, Helvetica, STHeiti;
}

.content {
	margin: 10px auto;
	margin-left: 20px;
	font-family: inherit;
}
</style>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/kalendae.css"
	type="text/css" />
<script
	src="${pageContext.request.contextPath}/js/kalendae.standalone.js"
	type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="/css/vip.css" type="text/css">
<SCRIPT language=JavaScript src="/js/FoshanRen.js"></SCRIPT>
<script language="JavaScript">
function checkfm(form){
	if (trim(form.name.value)==""){
		alert("品牌名称不能为空！");
		form.name.focus();
		return false;
	}	
	return true;
}
</script>
</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0"
	marginwidth="0" marginheight="0">
	<html:form action="/control/register/list"
		styleClass="pure-form pure-form-aligned" method="post"
		onsubmit="return checkfm(this)">
		<html:hidden property="query" value="true" />
		<table width="90%" border="0" cellspacing="2" cellpadding="3"
			align="center">
			<tr bgcolor="6f8ac4">
				<td colspan="2"><font color="#FFFFFF">查询检举控告类表：</font>
				</td>
			<tr bgcolor="f5f5f5">
				<td width="22%">
					<div align="right">索引编码：</div>
				</td>
				<td width="78%"><html:text property="indexcode" size="50"
						maxlength="40" /></td>
			</tr>
			<tr bgcolor="f5f5f5">
				<td width="22%">
					<div align="right">人员编号：</div>
				</td>
				<td width="78%"><html:text property="personcode" size="50"
						maxlength="40" /></td>
			</tr>
			<tr bgcolor="f5f5f5">
				<td width="22%">
					<div align="right">来源文号：</div>
				</td>
				<td width="78%"><html:text property="sourcenumber" size="50"
						maxlength="40" /></td>
			</tr>
			<tr bgcolor="f5f5f5">
				<td width="22%">
					<div align="right">转办文号：</div>
				</td>
				<td width="78%"><html:text property="handlernumber" size="50"
						maxlength="40" /></td>
			</tr>
			<tr bgcolor="f5f5f5">
				<td width="22%">
					<div align="right">被反映人：</div>
				</td>
				<td width="78%"><html:text property="reportedname" size="50"
						maxlength="40" /></td>
			</tr>
			<tr bgcolor="f5f5f5">
				<td width="22%">
					<div align="right">起始日期：</div>
				</td>
				<td width="78%"><html:text property="startdate" size="50"
						maxlength="40" styleClass="auto-kal" /></td>
			</tr>
			<tr bgcolor="f5f5f5">
				<td width="22%">
					<div align="right">结束日期：</div>
				</td>
				<td width="78%"><html:text property="enddate" size="50"
						maxlength="40" styleClass="auto-kal" /></td>
			</tr>

			<tr bgcolor="f5f5f5">
				<td width="22%">
					<div align="right">接受方式：</div>
				</td>
				<td width="78%"><html:select property="sourceid">
						<html:option value="">***无***</html:option>
						<html:optionsCollection name="sources" label="name" value="id" />
					</html:select></td>
			</tr>
			<tr bgcolor="f5f5f5">
				<td width="22%">
					<div align="right">线索来源：</div>
				</td>
				<td width="78%"><html:select property="sourcetwo">
						<html:option value="">***无***</html:option>
						<html:option value="信访举报">信访举报</html:option>
						<html:option value="上级交办">上级交办</html:option>
						<html:option value="公检法移送">公检法移送</html:option>
						<html:option value="执法监察中发现">执法监察中发现</html:option>
						<html:option value="办案中发现">办案中发现</html:option>
						<html:option value="审计中发现">审计中发现</html:option>
						<html:option value="巡视中发现">巡视中发现</html:option>
						<html:option value="其他">其他</html:option>
					</html:select></td>
			</tr>
			<tr bgcolor="f5f5f5">
				<td width="22%">
					<div align="right">问题类型：</div>
				</td>
				<td width="78%"><html:select property="typeid">
						<html:option value="">**无**</html:option>
						<c:forEach items="${types}" var="type">
							<html:option value="${ type.id}">${type.name }</html:option>
							<c:if test="${!empty type.children }">
								<c:forEach items="${type.children}" var="child">
									<html:option value="${ child.id}">----${child.name }</html:option>
								</c:forEach>
							</c:if>
						</c:forEach>
					</html:select></td>
			</tr>
			<tr bgcolor="f5f5f5">
				<td width="22%">
					<div align="right">职级：</div>
				</td>
				<td width="78%"><html:select property="rankid">
						<html:option value="">***无***</html:option>
						<html:optionsCollection name="ranks" label="name" value="id" />
					</html:select></td>
			</tr>
			<tr bgcolor="f5f5f5">
				<td width="22%">
					<div align="right">处置次数：</div>
				</td>
				<td width="78%"><select name="ispunish">

						<option value="5">***无***</option>
						<option value="3">3次</option>
						<option value="2">2次</option>
						<option value="1">1次</option>
						<option value="0">0次</option>
				</select></td>
			</tr>
			<tr bgcolor="f5f5f5">
				<td width="22%">
					<div align="right">主要问题线索：</div>
				</td>
				<td width="78%"><html:text property="mainthread" size="50"
						maxlength="40" /></td>
			</tr>
			<tr bgcolor="f5f5f5">
				<td colspan="2">
					<div align="center">
						<input type="submit" name="SYS_SET" value=" 确 定 " class="frm_btn">
					</div>
				</td>
			</tr>
		</table>
	</html:form>
	<br>
</body>
</html>