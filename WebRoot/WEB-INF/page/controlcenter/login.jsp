<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>高校纪检监察监督管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="${pageContext.request.contextPath}/css/admin.css" type="text/css" rel="stylesheet">
</HEAD>
<BODY onload=document.form1.name.focus();>
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" bgColor=#002779 
border=0>
  <TR>
    <TD align=middle>
      <TABLE cellSpacing=0 cellPadding=0 width=468 border=0>
        <TR>
          <TD><IMG height=23 src="${pageContext.request.contextPath}/images/login_1.jpg" 
          width=468></TD></TR>
        <TR>
          <TD><IMG height=147 src="${pageContext.request.contextPath}/images/login_2.jpg" 
            width=468></TD></TR></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width=468 bgColor=#ffffff border=0>
        <TR>
          <TD width=16><IMG height=122 src="${pageContext.request.contextPath}/images/login_3.jpg" 
            width=16></TD>
          <TD align=middle>
            <TABLE cellSpacing=0 cellPadding=0 width=230 border=0>
             <html:form styleClass="pure-form pure-form-aligned"
		action="/user/login" method="post" 
		onsubmit="return tosubmit(this)" >
              <TR height=5>
                <TD width=5></TD>
                <TD width=56></TD>
                <TD></TD></TR>
              <TR height=36>
                <TD></TD>
                <TD>用户名</TD>
                <TD><INPUT 
                  style="BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; BORDER-LEFT: #000000 1px solid; BORDER-BOTTOM: #000000 1px solid" 
                 maxLength=30 size=24  name="username">${message }</TD></TR>
              <TR height=36>
                <TD>&nbsp; </TD>
                <TD>密码</TD>
                <TD><INPUT 
                  style="BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; BORDER-LEFT: #000000 1px solid; BORDER-BOTTOM: #000000 1px solid" 
                  type=password maxLength=30 size=24 
                name="password"></TD></TR>
              <TR height=5>
                <TD colSpan=3></TD></TR>
              <TR>
                <TD>&nbsp;</TD>
                <TD>&nbsp;</TD>
                <TD><INPUT type=image height=18 width=70 
                  src="${pageContext.request.contextPath}/images/bt_login.gif"></TD></TR>
                  
                 </html:form>
                  
                  
                  </TABLE></TD>
          <TD width=16><IMG height=122 src="${pageContext.request.contextPath}/images/login_4.jpg" 
            width=16></TD></TR></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width=468 border=0>
        <TR>
          <TD><IMG height=16 src="${pageContext.request.contextPath}/images/login_5.jpg" 
          width=468></TD></TR></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width=468 border=0>
        <TR>
          <TD align=right><A href="http://www.865171.cn/" target=_blank><IMG 
            height=26 src="${pageContext.request.contextPath}/images/login_6.gif" width=165 
            border=0></A></TD></TR></TABLE></TD></TR></TABLE></BODY></HTML>
