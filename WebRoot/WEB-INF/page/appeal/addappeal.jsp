<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<html>
<head>
<title>登记申诉</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/vip.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/kalendae.css"
	type="text/css" charset="utf-8">
<SCRIPT language=JavaScript src="/js/FoshanRen.js"></SCRIPT>
<script type="text/javascript" src="/js/jscripts/tiny_mce/tiny_mce.js"></script>
<script src="${pageContext.request.contextPath}/js/kalendae.standalone.js"
	type="text/javascript" charset="utf-8"></script>
<script language="javascript" type="text/javascript">

function Formfield(name, label){
	this.name=name;
	this.label=label;
}
function verifyForm(objForm){
	tinyMCE.triggerSave();//手动把iframe的值赋给textarea表单元素
	var list  = new Array(new Formfield("name", "产品名称"),new Formfield("typeid", "产品类型"),
	new Formfield("baseprice", "产品底价"),new Formfield("marketprice", "产品市场价")
	,new Formfield("sellprice", "产品销售价"),new Formfield("description", "产品描述"),
	new Formfield("stylename", "产品图片的样式"),new Formfield("imagefile", "产品图片"));
	for(var i=0;i<list.length;i++){
		var objfield = eval("objForm."+ list[i].name);
		if(trim(objfield.value)==""){
			alert(list[i].label+ "不能为空");
			if(objfield.type!="hidden" && objfield.focus()) objfield.focus();
			return false;
		}
	}
	var imagefile = objForm.imagefile.value;
	var ext = imagefile.substring(imagefile.length-3).toLowerCase();
	if (ext!="jpg" && ext!="gif" && ext!="bmp" && ext!="png"){
		alert("只允许上传gif、jpg、bmp、png！");
		return false; 
	}
    return true;
}
function SureSubmit(objForm){
	if (verifyForm(objForm)) objForm.submit();
} 
</script>
</head>

<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<html:form action="/control/appeal/manage" enctype="multipart/form-data" method="post">
<input type="hidden" name="method" value="add">
  <table width="98%" border="0" cellspacing="1" cellpadding="3" align="center">
    <tr bgcolor="6f8ac4"> 
      <td colspan="2" ><font color="#FFFFFF">登记申诉：</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">编码  ：</div></td>
      <td width="75%"><html:text property="indexcode" size="30" maxlength="30" />
							</td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">日期  ：</div></td>
      <td width="75%"><html:text property="filldate" size="30" maxlength="30" styleClass="auto-kal" />
							</td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">被反映人或事：</div></td>
      <td width="75%"><html:text property="reportedname" size="30" maxlength="30" />
							</td>
    </tr>
    
    <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">职级  ：</div></td>
      <td width="75%">
							<html:select property="rankid">
								<html:option value="">***无***</html:option>
								<html:optionsCollection name="ranks" label="name" value="id" />
							</html:select>
							</td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">接受方式：</div></td>
      <td width="75%">
							<html:select property="sourceid">
							<html:option value="">**无**</html:option>
								<html:optionsCollection name="sources" label="name" value="id" />
							</html:select>
            </td>
    </tr>
    	<tr bgcolor="f5f5f5"> 
      <td width="25%" valign="top"> <div align="right">备注 ：</div></td>
      <td width="75%"><html:textarea property="remark" cols="80" rows="23"></html:textarea></td>
	</tr>
    <tr bgcolor="f5f5f5"> 
      <td colspan="2"> <div align="center"> 
          <input type="submit" name="Add" value=" 确 认 " class="frm_btn" onClick="javascript:SureSubmit(this.form)">
          &nbsp;&nbsp;<input type="button" name="Button" value=" 返 回 " class="frm_btn" onclick="javascript:history.back()">
        </div></td>
    </tr>
  </table>
</html:form>
<br>
</body>
</html>