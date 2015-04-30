<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>打印页面</title>

<style>
body {font-size: 12px;line-height:16px}
.table{
	text-align: center;
}
</style>
</head>

<body onload="javascript:window.print()">
<!--  -------  -------  -------  -------  -------  -------  ------- ------- -->
   <p align="center" style="font-size: 25px">纪检监察机关反映问题线索处置情况登记表</p>
   <html:form styleClass="pure-form pure-form-aligned"
		action="/control/register/manage" method="post"
		>
   <table  style="margin: 0px auto ;margin-bottom:0px; padding: 0px;" width="716"  align="center" border="0" cellpadding="0" cellspacing="0">
   <tr >
    <td height="33"  width="16%">&nbsp;填报单位:</td>
    <td height="33" width="16%">&nbsp;${register.fillunit} </td>
    <td  height="33"  width="16%">&nbsp; </td>
    <td  height="33"   width="16%">填报日期：</td>
    <td   height="33"  width="16%">&nbsp; ${register.filldate}</td>
    <td   height="33"  width="16%">&nbsp;</td>
  </tr>
</table>

<table class="table" style="margin-top:0px; padding: 0px;" width="716" height="919" align="center" border="1" cellpadding="0" cellspacing="0">
 
  
  
  <tr height="36">
    <td colspan="1" height="36" width="81">线索编码</td>
    <td colspan="3" height="36" width="206">&nbsp; ${register.indexcode} </td>
    <td colspan="3" height="36" width="165">人员编号</td>
    <td height="36" width="103">&nbsp; ${register.personcode}
</td>
    <td colspan="2" height="36" width="144">单位类或事故（事件）类问题线索</td>
    <td height="36" width="80">&nbsp; <c:if test="${register.isaccident==true}">是</c:if><c:if test="${register.isaccident==false}">否</c:if></td>
  </tr>
  <tr height="36">
    <td colspan="1"  height="36" width="81">被反映人</td>
    <td colspan="3" height="36" width="206"> ${register.reportedname} </td>
    <td colspan="3"  height="36" width="165">出生年月</td>
    <td height="36" width="103">&nbsp; ${register.borndate} </td>
    <td colspan="2"  height="36" width="144">民族</td>
    <td   height="36" width="80">&nbsp; ${register.nationality} </td>
  </tr>
  <tr height="36">
    <td colspan="1"   height="36" width="81">政治面貌</td>
    <td colspan="3"   height="36" width="206">&nbsp; ${register.politicsstatus} 
</td>
    <td colspan="3"   height="36" width="165">入党时间</td>
    <td height="36" width="103">&nbsp; ${register.partydate}</td>
    <td   height="36" width="72">职级</td>
    <td height="36" width="72">&nbsp;${register.rank.name }</td>
    <td height="36" width="80">&nbsp;${register.otherrank }</td>
  </tr>
  <tr height="36">
    <td colspan="2"   height="36" width="162">工作单位及职务</td>
    <td colspan="9" height="36" width="483">&nbsp; ${register.workunit} </td>
  </tr>
  <tr height="36">
    <td   height="36" width="81">人大代表</td>
    <td colspan="2" height="36" width="144">&nbsp; ${register.personrepresent} </td>
    <td colspan="3"   height="36" width="86">政协委员</td>
    <td height="36" width="89">&nbsp; ${register.politycommittee} </td>
    <td   height="36" width="103">监察对象</td>
    <td height="36" width="72">&nbsp;<c:if test="${register.monitorobject==true}">是</c:if><c:if test="${register.monitorobject==false}">否</c:if></td>
    <td   height="36" width="72">公务员</td>
    <td height="36" width="80">&nbsp;<c:if test="${register.servant==true}">是</c:if><c:if test="${register.servant==false}">否</c:if></td>
  </tr>
  <tr height="36">
    <td   height="36" width="81">线索来源</td>
    <td colspan="6" height="36" width="300">&nbsp;${register.sourcetwo }</td>
    <td   height="36" width="103">问题类型</td>
    <td colspan="3"   height="36" width="216">${register.type.name }</td>
  </tr>
  <tr height="36">
    <td   height="36" width="81">办理机关</td>
    <td colspan="6"   height="36" width="300"> ${register.transactname} 
</td>
    <td   height="36" width="103">受理时间</td>
    <td colspan="3" height="36" width="216">&nbsp; ${register.transactdate} </td>
  </tr>
  <tr height="36">
    <td   height="36" width="81">处置时间</td>
    <td height="36" width="72" colspan="4">&nbsp; ${registerForm.handlerdate1} 
    </td>
    <td height="36" width="62" colspan="2">处置方式</td>
    <td height="36" width="2" colspan="4" >&nbsp;${registerForm.handlerway1} </td>
   
    
   
  </tr>
  <tr height="36">
     <td   height="36" width="81">处置时间</td>
    <td height="36" width="72" colspan="4">&nbsp;${registerForm.handlerdate2}</td>
    <td height="36" width="62" colspan="2">处置方式</td>
    <td height="36" width="2" colspan="4" >&nbsp;${registerForm.handlerway2} </td>
  </tr>
  <tr height="36">
     <td   height="36" width="81">处置时间</td>
    <td height="36" width="72" colspan="4">&nbsp;${registerForm.handlerdate3}</td>
    <td height="36" width="62" colspan="2">处置方式</td>
    <td height="36" width="2" colspan="4" >&nbsp;${registerForm.handlerway3} </td>
  </tr>
  <tr height="36">
    <td colspan="3"   height="36" width="197">挽回经济损失(万元)</td>
    <td colspan="4" height="36" width="87">&nbsp;${register.redeemeconomy}</td>
    <td colspan="2"   height="36" width="206">收缴涉案金额(万元)</td>
    <td colspan="2" height="36" width="144">&nbsp;${register.suspecteconomy}</td>
  </tr>
  <tr height="19">
    <td height="188" width="81">主要<br />
        <br />
      问题<br />
      <br />
      线索</td>
    <td height="19" width="72" colspan="10"  align="left">&nbsp; ${register.mainthread}</td>
    
  </tr>
  
  <tr height="19">
    <td   height="185" width="81">处置<br />
        <br />
      情况<br />
      <br />
      报告</td>
   <td height="19" width="72" colspan="10" align="left">&nbsp; ${register.report}</td>
  </tr>
  <tr >
    <td   height="40" width="81">备注</td>
   <td height="19" width="72" colspan="10">&nbsp; ${register.remark}</td>
  </tr>
  
  
  
</table>
<table width="716"  align="center" border="0" cellpadding="0" cellspacing="0">
<tr >
    <td   height="19" width="16%" >&nbsp;填表人：</td>
    <td   width="16%">&nbsp; ${register.fillname}
    </td>
	<td  height="19" width="16%">&nbsp;</td>
    <td   height="19" width="16%">审核人：</td>
    <td  height="19" width="16%">&nbsp; ${register.checkname} </td>
  </tr>
</table>
</html:form>
</body>
</html>
