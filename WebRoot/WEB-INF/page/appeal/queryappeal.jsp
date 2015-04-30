<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>

<html>
<head>
<title>申诉查询</title>

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
<link rel="stylesheet" href="/css/vip.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/kalendae.css"
	type="text/css" charset="utf-8">
<SCRIPT language=JavaScript src="/js/FoshanRen.js"></SCRIPT>
<script src="${pageContext.request.contextPath}/js/kalendae.standalone.js"
	type="text/javascript" charset="utf-8"></script>
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
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<html:form action="/control/appeal/list" styleClass="pure-form pure-form-aligned" method="post"  onsubmit="return checkfm(this)">
<html:hidden property="query" value="true"/>
  <table  width="90%" border="0" cellspacing="2" cellpadding="3" align="center">
  <tr bgcolor="6f8ac4"><td colspan="2"> <font color="#FFFFFF">申诉查询：</font></td>
  <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">索引编码：</div></td>
      <td width="78%"> <html:text property="indexcode" size="30" maxlength="30"/>
      </td>
    </tr>
     <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">被反映人或事：</div></td>
      <td width="75%"><html:text property="reportedname" size="30" maxlength="30" />
							</td>
    </tr>
  <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">起始日期：</div></td>
      <td width="78%"> <html:text property="startdate"  size="30" maxlength="30" styleClass="auto-kal"/>
         </td>
    </tr>
  <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">结束日期：</div></td>
      <td width="78%"> <html:text property="enddate" size="30" maxlength="30" styleClass="auto-kal"/>
         </td>
    </tr>
  <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">接受方式：</div></td>
      <td width="78%"> <html:select property="sourceid">
          <html:option value="">***无***</html:option>
          <html:optionsCollection name="sources" label="name" value="id"/>
        </html:select>
         </td>
    </tr>
  <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">职级：</div></td>
      <td width="78%"> <html:select property="rankid">
          <html:option value="">***无***</html:option>
          <html:optionsCollection name="ranks" label="name" value="id"/>
        </html:select>
         </td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td colspan="2"> <div align="center"> 
          <input type="submit" name="SYS_SET" value=" 确 定 " class="frm_btn">
        </div></td>
    </tr>
</table>
</html:form>
<br>
</body>
</html>