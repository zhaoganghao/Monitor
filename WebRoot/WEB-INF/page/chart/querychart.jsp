<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<html>
<head>
<title>品牌查询</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/pure-min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/kalendae.css"
	type="text/css" charset="utf-8">
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
<link rel="stylesheet" href="/css/vip.css" type="text/css">
<SCRIPT language=JavaScript src="/js/FoshanRen.js"></SCRIPT>
<script src="${pageContext.request.contextPath}/js/kalendae.standalone.js"
	type="text/javascript" charset="utf-8"></script>
<script language="JavaScript">
function checkfm(form){
	if (form.startdate.value==""){
		alert("起始日期不能为空！");
		form.startdate.focus();
		return false;
	}
	if (form.enddate.value==""){
		alert("结束日期不能为空！");
		form.enddate.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<html:form action="/control/chart/manage" styleClass="pure-form pure-form-aligned" method="post"  onsubmit="return checkfm(this)">
<html:hidden property="method" value="dispatch"/>
  <table  width="70%" border="0" cellspacing="2" cellpadding="3" align="center">
  <tr bgcolor="6f8ac4"><td colspan="2"> <font color="#FFFFFF">查询：</font></td>
  <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">起始日期：</div></td>
      <td width="78%"> <html:text property="startdate" size="50" maxlength="40" styleClass="auto-kal" /><font color="#FF0000">*</font>
        </td>
    </tr>
  <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">结束日期：</div></td>
      <td width="78%"> <html:text property="enddate" size="50" maxlength="40" styleClass="auto-kal"/><font color="#FF0000">*</font>
        </td>
    </tr>
  <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">选择报表类型：</div></td>
      <td width="78%"> 
	      	接受信访举报统计表一<input type="radio" value="1" name="type" checked="checked">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	       	接受信访举报统计表二<input type="radio" value="2" name="type">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	反映问题线索处置情况统计表三<input type="radio" value="3" name="type">
        <font color="#FF0000"></font></td>
    </tr>
  
    <tr bgcolor="f5f5f5"> 
      <td colspan="2"> <div align="center"> 
          <input type="submit" name="SYS_SET" value=" 确 定 " class="frm_btn">
        </div></td>
    </tr>
</table>
</html:form>
<br>
<table width="70%" height="228" border="0" align="center" >
  <tr align="center"  bgcolor="6f8ac4">
    <td><font color="#FFFFFF">表格下载：</font>    </td>
  </tr>
  <tr align="center" bgcolor="f5f5f5">
    <td><a href="<html:rewrite action='/control/user/manage?method=download1'/>" >中共湖北省高校纪律检查工作委员会受理违纪线索或材料登记表</a>    </td>
  </tr>
  <tr   bgcolor="f5f5f5" >
    <td align="center" ><a href="<html:rewrite action='/control/user/manage?method=download2'/>" >中共湖北省高校纪律检查工作委员会初步核实呈批表</a></td>
  </tr>
  <tr bgcolor="f5f5f5">
    <td align="center"><a href="<html:rewrite action='/control/user/manage?method=download3'/>" >初核延期审批表</a> </td>
  </tr>
  <tr bgcolor="f5f5f5"> 
    <td align="center"><a href="<html:rewrite action='/control/user/manage?method=download4'/>" >党纪政纪处分决定执行情况报告表</a> </td>
  </tr>
  <tr bgcolor="f5f5f5">
    <td align="center"><a href="<html:rewrite action='/control/user/manage?method=download5'/>" >处分决定执行告知卡</a>  </td>
  </tr>
  <tr bgcolor="f5f5f5">
    <td align="center"><a href="<html:rewrite action='/control/user/manage?method=download6'/>" >解除行政处分审批表</a>  </td>
  </tr>
  <tr bgcolor="f5f5f5">
    <td align="center"><a href="<html:rewrite action='/control/user/manage?method=download7'/>" >解除处分呈批表</a>  </td>
  </tr>
</table>

</body>
</html>