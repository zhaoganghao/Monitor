<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="${pageContext.request.contextPath}/css/admin.css"
	type="text/css" rel="stylesheet">
<SCRIPT language=javascript>
	function expand(el) {
		childObj = document.getElementById("child" + el);

		if (childObj.style.display == 'none') {
			childObj.style.display = 'block';
		} else {
			childObj.style.display = 'none';
		}
		return;
	}
</SCRIPT>
</HEAD>
<BODY>
	<TABLE height="100%" cellSpacing=0 cellPadding=0 width=170
		background="${pageContext.request.contextPath}/images/menu_bg.jpg"
		border=0>
		<TR>
			<TD vAlign=top align=middle>
				<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>

					<TR>
						<TD height=10></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>

					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background="${pageContext.request.contextPath}/images/menu_bt.jpg"><A href="<html:rewrite action='/control/center/main'/>" target="main">首页</A>
						</TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>

					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background="${pageContext.request.contextPath}/images/menu_bt.jpg">
							<A href="<html:rewrite action='/control/accept'/>" target="main">受理登记</A>
						</TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>

					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background="${pageContext.request.contextPath}/images/menu_bt.jpg">
							<A href="<html:rewrite action='/control/register/list'/>" target="main">检举控告类管理</A>
						</TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				 <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>

					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background="${pageContext.request.contextPath}/images/menu_bt.jpg">
							<A href="<html:rewrite action='/control/register/manage'/>?method=queryHandlerWay" target="main">处理方式查询</A>
						</TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>

					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background="${pageContext.request.contextPath}/images/menu_bt.jpg">
							<A href="<html:rewrite action='/control/appeal/list'/>" target="main">申诉管理</A>
						</TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>

					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background="${pageContext.request.contextPath}/images/menu_bt.jpg">
							<A href="<html:rewrite action='/control/criticize/list'/>" target="main">批评与建议管理</A>
						</TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>

					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background="${pageContext.request.contextPath}/images/menu_bt.jpg">
							<A href="<html:rewrite action='/control/other/list'/>" target="main">业务范围外管理</A>
						</TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>

					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background="${pageContext.request.contextPath}/images/menu_bt.jpg">
							<A href="<html:rewrite action='/control/nocontent/list'/>" target="main">无实质内容管理</A>
						</TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>

					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background="${pageContext.request.contextPath}/images/menu_bt.jpg"><A
							class=menuParent
							href="<html:rewrite action='/control/result/list'/>"
							target="main">立案登记管理</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>

					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background="${pageContext.request.contextPath}/images/menu_bt.jpg"><A
							class=menuParent
							href="<html:rewrite action='/control/chart/manage'/>?method=queryUI"
							target="main">生成报表</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<%-- <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>

					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background="${pageContext.request.contextPath}/images/menu_bt.jpg"><A
							class=menuParent
							href="<html:rewrite action='/control/chart/manage'/>?method=queryUI"
							target="main">打印报表</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE> --%>
				
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>

					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background="${pageContext.request.contextPath}/images/menu_bt.jpg"><A
							class=menuParent
							href="<html:rewrite action='/control/user/list'/>"
							target="main">用户管理</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				</TD>
			<TD width=1 bgColor=#d1e6f7></TD>
		</TR>
	</TABLE>
</BODY>
</HTML>
