<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>用户信息修改</title>
<style type="text/css">
<!--
.STYLE2 {
	font-size: 24
}
-->
</style>
</head>
<script language="JavaScript">
	function tosubmit(form) {
	if (form.username.value==""){
		alert("用户名不能为空！");
		form.username.focus();
		return false;
	}
	if (form.password.value==""){
		alert("密码不能为空！");
		form.password.focus();
		return false;
	}
	if(confirm("确定修改吗？")==false){
		return false;
	}
	return true;
	}
</script>
<body>
	<html:form action="/control/user/manage" method="post" onsubmit="return tosubmit(this)" >
	<html:hidden property="method" value="update"/>
	<html:hidden property="id" />
		<table width="98%" border="0" cellspacing="1" cellpadding="3" align="center">
    <tr bgcolor="6f8ac4"> 
      <td colspan="2" ><font color="#FFFFFF">用户信息修改：</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">用户名  ：</div></td>
      <td width="75%"><html:text property="username" size="30" maxlength="30" /><font color="#FF0000">*</font>
							</td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">密码  ：</div></td>
      <td width="75%">
      <input  type="password" name="password"/><font color="#FF0000">*</font>
							</td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">email：</div></td>
      <td width="75%"><html:text property="email" size="30" maxlength="30" />
							</td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">电话：</div></td>
      <td width="75%"><html:text property="phone" size="30" maxlength="30" />
							</td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td colspan="2"> <div align="center"> 
          <input type="submit" name="Add" value=" 修改 " class="frm_btn" onClick="javascript:SureSubmit(this.form)">
          &nbsp;&nbsp;<input type="button" name="Button" value=" 返 回 " class="frm_btn" onclick="javascript:history.back()">
        </div></td>
    </tr>
  </table>
	</html:form>
</body>
</html>
