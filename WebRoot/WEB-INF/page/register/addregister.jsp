<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>添加检举控告类表</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/pure-min.css"/>
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

.pull-right {
	float: right;
	margin-right: 8%;
}

.bigwidth div {
	width: 100%;
}
</style>
<style type="text/css">
<!--
.STYLE2 {
	font-size: 24
}
-->
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/kalendae.css"
	type="text/css" />
<script type="text/javascript">
	function TestLen(obj, len) {
		if (obj.value.length > len) {
			alert('长度不能超过' + len);
			return false;
		}
	}
</script>
<script src="${pageContext.request.contextPath}/js/kalendae.standalone.js"
	type="text/javascript" charset="utf-8"></script>
<script language="JavaScript">
	function tosubmit(form) {
	if (form.fillunit.value==""){
		alert("填报单位不能为空！");
		form.fillunit.focus();
		return false;
	}
	if (form.filldate.value==""){
		alert("填报日期不能为空！");
		form.filldate.focus();
		return false;
	}
	if (form.indexcode.value==""){
		alert("线索编码不能为空！");
		form.indexcode.focus();
		return false;
	}
	if (form.reportedname.value==""){
		alert("被反映人不能为空！");
		form.reportedname.focus();
		return false;
	}
	return true;
	}
</script>
<script language="JavaScript">
	function tosubmit(form) {
	if (form.fillunit.value==""){
		alert("填报单位不能为空！");
		form.fillunit.focus();
		return false;
	}
	if (form.filldate.value==""){
		alert("填报日期不能为空！");
		form.filldate.focus();
		return false;
	}
	if (form.indexcode.value==""){
		alert("线索编码不能为空！");
		form.indexcode.focus();
		return false;
	}
	if (form.reportedname.value==""){
		alert("被反映人不能为空！");
		form.reportedname.focus();
		return false;
	}
	return true;
	}
</script>
</head>

<body>
	<center>添加检举控告类表</center>

	<html:form styleClass="pure-form pure-form-aligned"
		action="/control/register/manage" method="post"
		onsubmit="return tosubmit(this)">
		<html:hidden property="method" value="add" />
		<fieldset>
			<div class="pure-control-group">
				<label for="name">填报单位:</label>
				<html:text property="fillunit" /><font color="#FF0000">*</font>
				<div class="pull-right">
					<label for="name">填报日期：</label>
					<html:text property="filldate" styleClass="auto-kal" /><font color="#FF0000">*</font>
				</div>
			</div>
		</fieldset>
		
		<h2 style="margin-left: 5%;">一、线索来源、问题类型及处置去向</h2>
		<hr style="width: 90%"/>
		<div class="content pure-g" style="font-family: inherit;">
			<div class="pure-u-2-24"></div>
			<div class="pure-u-10-24">
				<fieldset>
					<div class="pure-control-group">
						<label for="name">接收方式</label>
						<html:select property="sourceid">
							<html:optionsCollection name="sources" label="name" value="id" />
						</html:select>
					</div>
					
					<div class="pure-control-group">
						<label for="name">处置去向</label>
						<html:select property="direct">
							<html:option value="监察室直接核查">监察室直接核查（自办）</html:option>
							<html:option value="转交厅机关办理">转交厅机关办理（自办）</html:option>
							<html:option value="委托高校或市州教育局监察室办理">委托高校或市州教育局监察室办理（自办）</html:option>
							<html:option value="高校纪委">高校纪委（转办）</html:option>
							<html:option value="各市州教育局监察室">各市州教育局监察室（转办）</html:option>
						</html:select>
					</div>
					<div class="pure-control-group">
						<label for="name">问题类型</label>
						<html:select property="typeid">
							<c:forEach items="${types}" var="type">
								<html:option value="${ type.id}">${type.name }</html:option>
								<c:if test="${!empty type.children }">
									<c:forEach items="${type.children}" var="child">
										<html:option value="${ child.id}">----${child.name }</html:option>
									</c:forEach>
								</c:if>
							</c:forEach>
						</html:select>
					</div>
				</fieldset>
			</div>
			<div class="pure-u-10-24">
				<fieldset>
				<div class="pure-control-group">
						<label for="name">来源文号</label>
						<html:text property="sourcenumber"   />
					</div>
					<div class="pure-control-group">
						<label for="name">转办文号</label>
						<html:text property="handlernumber"   />
					</div>
					<div class="pure-control-group">
						<label for="name">线索来源</label>
						<html:select property="sourcetwo">
							<html:option value="信访举报">信访举报</html:option>
							<html:option value="上级交办">上级交办</html:option>
							<html:option value="公检法移送">公检法移送</html:option>
							<html:option value="执法监察中发现">执法监察中发现</html:option>
							<html:option value="办案中发现">办案中发现</html:option>
							<html:option value="审计中发现">审计中发现</html:option>
							<html:option value="巡视中发现">巡视中发现</html:option>
							<html:option value="其他">其他</html:option>
						</html:select>
					</div>
				</fieldset>
			</div>
			<div class="pure-u-2-24"></div>
		</div>
		<h2 style="margin-left: 5%;">二、具体信息</h2>
		<hr style="width: 90%"/>
		<div class="content pure-g">
			<div class="pure-u-2-24"></div>
			<div class="pure-u-10-24">
				<fieldset>
					<div class="pure-control-group">
						<label for="name">线索编码</label>
						<html:text property="indexcode" onblur="TestLen(this,8)"   /><font color="#FF0000">*</font>
					</div>
					<div class="pure-control-group">
						<label for="name">人员编号</label>
						<html:text property="personcode" onblur="TestLen(this,3)" />
					</div>
					<div class="pure-control-group">
						<label for="name">单位类或事故（事件）类问题线索</label>
						<html:select property="isaccident">
							<html:option value="true">是</html:option>
							<html:option value="false">否</html:option>
						</html:select>
					</div>
					<div class="pure-control-group">
						<label for="name">被反映人</label>
						<html:text property="reportedname" /><font color="#FF0000">*</font>
					</div>
					<div class="pure-control-group">
						<label for="name">出生年月</label>
						<html:text property="borndate" styleClass="auto-kal" />
					</div>
					<div class="pure-control-group">
						<label for="name">民族</label>
						<html:select property="nationality">
							<html:option value="">**无**</html:option>
							<html:option value="汉族">汉族</html:option>
							<html:option value="壮族">壮族</html:option>
							<html:option value="满族">满族</html:option>
							<html:option value="回族">回族</html:option>
							<html:option value="苗族">苗族</html:option>
							<html:option value="维吾尔族">维吾尔族</html:option>
							<html:option value="土家族">土家族</html:option>
							<html:option value="彝族">彝族</html:option>
							<html:option value="蒙古族">蒙古族</html:option>
							<html:option value="藏族">藏族</html:option>
							<html:option value="布依族">布依族</html:option>
							<html:option value="瑶族">瑶族</html:option>
							<html:option value="侗族">侗族</html:option>
							<html:option value="白族">白族</html:option>
							<html:option value="朝鲜族">朝鲜族</html:option>
							<html:option value="哈尼族">哈尼族</html:option>
							<html:option value="布朗族">布朗族</html:option>
							<html:option value="珞巴族">珞巴族</html:option>
							<html:option value="赫哲族">赫哲族</html:option>
							<html:option value="塔塔尔族">塔塔尔族</html:option>
							<html:option value="独龙族">独龙族</html:option>
							<html:option value="鄂伦春族">鄂伦春族</html:option>
							<html:option value="门巴族">门巴族</html:option>
							<html:option value="毛南族	">毛南族</html:option>
							<html:option value="撒拉族">撒拉族</html:option>
							<html:option value="塔吉克族">塔吉克族</html:option>
							<html:option value="阿昌族">阿昌族</html:option>
							<html:option value="普米族">普米族</html:option>
							<html:option value="鄂温克族	">鄂温克族</html:option>
							<html:option value="怒族">怒族</html:option>
							<html:option value="京族">京族</html:option>
							<html:option value="基诺族	">基诺族</html:option>
							<html:option value="德昂族	">德昂族</html:option>
							<html:option value="保安族	">保安族</html:option>
							<html:option value="俄罗斯族">俄罗斯族</html:option>
							<html:option value="哈萨克族">哈萨克族</html:option>
							<html:option value="裕固族	">裕固族</html:option>
							<html:option value="黎族">黎族</html:option>
							<html:option value="傣族	">傣族</html:option>
							<html:option value="畲族	">畲族</html:option>
							<html:option value="仡佬族	">仡佬族</html:option>
							<html:option value="东乡族	">东乡族</html:option>
							<html:option value="高山族	">高山族</html:option>
							<html:option value="拉祜族	">拉祜族</html:option>
							<html:option value="佤族">佤族</html:option>
							<html:option value="纳西族">纳西族</html:option>
							<html:option value="水族">水族</html:option>
							<html:option value="羌族">羌族</html:option>
							<html:option value="水族">水族</html:option>
							<html:option value="土族">土族</html:option>
							<html:option value="仫佬族">仫佬族</html:option>
							<html:option value="锡伯族">锡伯族</html:option>
							<html:option value="柯尔克孜族">柯尔克孜族</html:option>
							<html:option value="达斡尔族">达斡尔族</html:option>
							<html:option value="景颇族">景颇族</html:option>
						</html:select>
					</div>
					<div class="pure-control-group">
						<label for="name">政治面貌</label>
						<html:select property="politicsstatus">
							<html:option value="">**无**</html:option>
							<html:option value="党员">党员</html:option>
							<html:option value="团员">团员</html:option>
							<html:option value="民主党派">民主党派</html:option>
							<html:option value="党组织">党组织</html:option>
							<html:option value="法人">法人</html:option>
							<html:option value="其他">其他</html:option>
						</html:select>
					</div>
					<div class="pure-control-group">
						<label for="name">入党时间</label>
						<html:text property="partydate" styleClass="auto-kal" />
					</div>
				</fieldset>
			</div>
			<div class="pure-u-10-24">
				<fieldset>
					<div class="pure-control-group">
						<label for="name">职级</label>
						<html:select property="rankid">
							<html:optionsCollection name="ranks" label="name" value="id" />
						</html:select>
						<html:select property="otherrank">
							<html:option value="">***无***</html:option>
							<html:option value="中管干部">中管干部</html:option>
							<html:option value="省管干部">省管干部</html:option>
							<html:option value="市管干部">市管干部</html:option>
							<html:option value="县管干部">县管干部</html:option>
						</html:select>
					</div>
					<div class="pure-control-group">
						<label for="name">工作单位及职务</label>
						<html:text property="workunit" />
					</div>
					<div class="pure-control-group">
						<label for="name">人大代表</label>
						<html:select property="personrepresent">
							<html:option value="">**无**</html:option>
							<html:option value="全国人大代表">全国人大代表</html:option>
							<html:option value="省级人大代表">省级人大代表</html:option>
							<html:option value="市级人大代表">市级人大代表</html:option>
							<html:option value="县级人大代表">县级人大代表</html:option>
							<html:option value="乡级人大代表">乡级人大代表</html:option>
						</html:select>
					</div>
					<div class="pure-control-group">
						<label for="name">政协委员</label>
						<html:select property="politycommittee">
							<html:option value="">**无**</html:option>
							<html:option value="全国政协委员">全国政协委员</html:option>
							<html:option value="省级政协委员">省级政协委员</html:option>
							<html:option value="市级政协委员">市级政协委员</html:option>
							<html:option value="县级政协委员">县级政协委员</html:option>
						</html:select>
					</div>
					<div class="pure-control-group">
						<label for="name">监察对象</label>
						<html:select property="monitorobject">
							<html:option value="true">是</html:option>
							<html:option value="false">否</html:option>
						</html:select>
					</div>
					<div class="pure-control-group">
						<label for="name">公务员</label>
						<html:select property="servant">
							<html:option value="true">是</html:option>
							<html:option value="false">否</html:option>
						</html:select>
					</div>
					<div class="pure-control-group">
						<label for="name">办理机关</label>
						<html:select property="transactname">
							<html:option value="">**无**</html:option>
							<html:option value="中央纪委监察部">中央纪委监察部</html:option>
							<html:option value="省区市纪检监察机关">省区市纪检监察机关</html:option>
							<html:option value="地市州纪检监察机关">地市州纪检监察机关</html:option>
							<html:option value="乡镇纪委">乡镇纪委</html:option>
							<html:option value="军队纪委">军队纪委</html:option>
							<html:option value="中央和国家机关纪检监察机构">中央和国家机关纪检监察机构</html:option>
							<html:option value="省区市直属机关纪检监察机构">省区市直属机关纪检监察机构</html:option>
							<html:option value="地市州直属机关纪检监察机构">地市州直属机关纪检监察机构</html:option>
							<html:option value="县市区直属机关纪检监察机构">县市区直属机关纪检监察机构</html:option>
							<html:option value="企业单位纪检监察机构">企业单位纪检监察机构</html:option>
							<html:option value="事业单位纪检监察机构">事业单位纪检监察机构</html:option>
							<html:option value="其他">其他</html:option>
						</html:select>
					</div>
					<div class="pure-control-group">
						<label for="name">受理时间</label>
						<html:text property="transactdate" styleClass="auto-kal" />
					</div>
				</fieldset>
			</div>
		</div>

		<h2 style="margin-left: 5%;">三、处置方式</h2>
		<hr style="width: 90%"/>
		<div class="content pure-g">
			<div class="pure-u-2-24"></div>
			<div class="pure-u-10-24">
				<fieldset>
					
					<div class="pure-control-group">
						<label for="name">处置时间一</label>
						<html:text property="handlerdate1" styleClass="auto-kal" />
					</div>
					

					<div class="pure-control-group">
						<label for="name">处置时间二</label>
						<html:text property="handlerdate2" styleClass="auto-kal" />
					</div>
					<div class="pure-control-group">
						<label for="name">处置时间三</label>
						<html:text property="handlerdate3" styleClass="auto-kal" />
					</div>
					<div class="pure-control-group">
						<label for="name">挽回经济损失(万元)</label>
						<html:text property="redeemeconomy" />
					</div>
				</fieldset>
			</div>
			<div class="pure-u-10-24">
				<fieldset>
				<div class="pure-control-group">
						<label for="name">处置方式一</label>
						<html:select property="handlerway1id">
							<html:option value="">**无**</html:option>
							<c:forEach items="${handlerways}" var="handlerway">
								<html:option value="${ handlerway.id}">${handlerway.name }</html:option>
								<c:if test="${!empty handlerway.children }">
									<c:forEach items="${handlerway.children}" var="child">
										<html:option value="${ child.id}">--${child.name }</html:option>
									</c:forEach>
								</c:if>
							</c:forEach>
						</html:select>
					</div>
					<div class="pure-control-group">
						<label for="name">处置方式二</label>
						<html:select property="handlerway2id">
							<html:option value="">**无**</html:option>
							<c:forEach items="${handlerways}" var="handlerway">
								<html:option value="${ handlerway.id}">${handlerway.name }</html:option>
								<c:if test="${!empty handlerway.children }">
									<c:forEach items="${handlerway.children}" var="child">
										<html:option value="${ child.id}">--${child.name }</html:option>
									</c:forEach>
								</c:if>
							</c:forEach>
						</html:select>
					</div>
					<div class="pure-control-group">
						<label for="name">处置方式三</label>
						<html:select property="handlerway3id">
							<html:option value="">**无**</html:option>
							<c:forEach items="${handlerways}" var="handlerway">
								<html:option value="${ handlerway.id}">${handlerway.name }</html:option>
								<c:if test="${!empty handlerway.children }">
									<c:forEach items="${handlerway.children}" var="child">
										<html:option value="${ child.id}">--${child.name }</html:option>
									</c:forEach>
								</c:if>
							</c:forEach>
						</html:select>
					</div>
					<div class="pure-control-group">
						<label for="name">收缴涉案金额(万元)</label>
						<html:text property="suspecteconomy" />
					</div>
				</fieldset>
			</div>
			<div class="pure-u-2-24"></div>
		</div>
		<div class="bigwidth">
			<fieldset>
				<div class="pure-control-group">
					<label for="name">主要问题线索</label>
					<html:textarea cols="140" rows="5" property="mainthread" />
				</div>
				<div class="pure-control-group">
					<label for="name">处置 情况 报告</label>
					<html:textarea cols="140" rows="5" property="report" />
				</div>
				<div class="pure-control-group">
					<label for="name">备注</label>
					<html:textarea cols="140" rows="5" property="remark" />
				</div>

			</fieldset>


		</div>
		<hr style="width: 90%" />
		<fieldset>
			<div class="pure-control-group">
				<label for="name">填报人：</label>
				<html:text property="fillname" />
				&nbsp;&nbsp;&nbsp;
				<div class="pull-right">
					<label for="name">审核人：</label>
					<html:text property="checkname" />
				</div>
			</div>
		</fieldset>
		<center>
			<input class="pure-button pure-button-primary" type="submit"
				style="width: 150px;" value="提交" />
		</center>
		<br/>
		<br/>
		<br/>
	</html:form>
</body>
</html>
