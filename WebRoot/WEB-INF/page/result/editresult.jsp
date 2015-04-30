<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<title>立案表</title>
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
.pull-right{
	float: right;
	margin-right: 8%;
}
form {
	font-family: inherit;
}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/kalendae.css" type="text/css" charset="utf-8">
<script type="text/javascript">
function TestLen(obj,len){
    if(obj.value.length>len){
        alert('长度不能超过'+len);
        return false;
    }
}
</script>
<script src="${pageContext.request.contextPath}/js/kalendae.standalone.js" type="text/javascript" charset="utf-8"></script>
</HEAD>
<BODY>
	<div class="content">
		<center>
			<h1>立案表</h1>
		</center>
		<html:form styleClass="pure-form pure-form-aligned"
		action="/control/result/manage" method="post" 
		onsubmit="return tosubmit(this)" >
			<html:hidden property="method" value="edit" />
		<html:hidden property="id"  />
		<div class="pure-control-group">
			<label for="name">填报单位</label>
			<html:text property="fillunit" /><font color="#FF0000">*</font> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
			&nbsp; 
			<div class="pull-right">
			<label for="name">填报日期：</label>
				<html:text  property="filldate" styleClass="auto-kal"/><font color="#FF0000">*</font>
				
				</div>
		</div>
		<hr>
			<div class="pure-g">
				<div class="pure-u-8-24">
					<fieldset>
						<div class="pure-control-group">
							<label for="name">案件编码</label>  <html:text property="indexcode" onblur="TestLen(this,8)"/><font color="#FF0000">*</font>
						</div>

						<div class="pure-control-group">
							<label for="password">涉案人员编号</label><html:text property="personcode" onblur="TestLen(this,3)"/>
						</div>

						<div class="pure-control-group">
							<label for="name">是否对单位或事件事故</label> 
							<html:select property="isaccident">
							<html:option value="true">是</html:option>
							<html:option value="false">否</html:option>
							</html:select>
						</div>

						<div class="pure-control-group">
							<label for="foo">被反映人</label> <html:text property="reportedname" /><font color="#FF0000">*</font>
						</div>
						<div class="pure-control-group">
							<label for="foo">性别</label> 
							<html:select property="sex">
							<html:option value="男">男</html:option>
							<html:option value="女">女</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">名族</label> <html:select property="nationality">
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
								<html:option value="毛南族">毛南族</html:option>
								<html:option value="撒拉族">撒拉族</html:option>
								<html:option value="塔吉克族">塔吉克族</html:option>
								<html:option value="阿昌族">阿昌族</html:option>
								<html:option value="普米族">普米族</html:option>
								<html:option value="鄂温克族">鄂温克族</html:option>
								<html:option value="怒族">怒族</html:option>
								<html:option value="京族">京族</html:option>
								<html:option value="基诺族">基诺族</html:option>
								<html:option value="德昂族">德昂族</html:option>
								<html:option value="保安族">保安族</html:option>
								<html:option value="俄罗斯族">俄罗斯族</html:option>
								<html:option value="哈萨克族">哈萨克族</html:option>
								<html:option value="裕固族">裕固族</html:option>
								<html:option value="黎族">黎族</html:option>
								<html:option value="傣族	">傣族</html:option>
								<html:option value="畲族	">畲族</html:option>
								<html:option value="仡佬族">仡佬族</html:option>
								<html:option value="东乡族">东乡族</html:option>
								<html:option value="高山族">高山族</html:option>
								<html:option value="拉祜族">拉祜族</html:option>
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
							<label for="foo">出生年月</label><html:text property="borndate" styleClass="auto-kal"/> 
						</div>
						<div class="pure-control-group">
							<label for="foo">政治面貌</label><html:select property="politicsstatus">
								<html:option value="">***无***</html:option>
								<html:option value="党员">党员</html:option>
								<html:option value="团员">团员</html:option>
								<html:option value="民主党派">民主党派</html:option>
								<html:option value="党组织">党组织</html:option>
								<html:option value="法人">法人</html:option>
								<html:option value="其他">其他</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">入党时间</label> <html:text  property="partydate" styleClass="auto-kal"/> 
						</div>
						<div class="pure-control-group">
							<label for="foo">学历</label>
						<html:select property="education">
								<html:option value="">***无***</html:option>
								<html:option value="博士研究生">博士研究生</html:option>
								<html:option value="硕士研究生">硕士研究生</html:option>
								<html:option value="大学本科">大学本科</html:option>
								<html:option value="大专">大专</html:option>
								<html:option value="中专">中专</html:option>
								<html:option value="高中">高中</html:option>
								<html:option value="初中以下">初中以下</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">工作单位及职务</label> <html:text property="workunit" />
						</div>
						<div class="pure-control-group">
							<label for="foo">职级</label> <html:select property="rankid">
								<html:option value="">***无***</html:option>
								<html:optionsCollection name="ranks" label="name" value="id" />
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">任现职时间</label> <html:text property="workdate" styleClass="auto-kal"/>
						</div>
						
						<div class="pure-control-group">
							<label for="name">人大代表</label> <html:select property="personrepresent">
								<html:option value="">***无***</html:option>
								<html:option value="全国人大代表">全国人大代表</html:option>
								<html:option value="省级人大代表">省级人大代表</html:option>
								<html:option value="市级人大代表">市级人大代表</html:option>
								<html:option value="县级人大代表">县级人大代表</html:option>
								<html:option value="乡级人大代表">乡级人大代表</html:option>
							</html:select>
						</div>

						<div class="pure-control-group">
							<label for="password">政协委员</label> <html:select property="politycommittee">
								<html:option value="">***无***</html:option>
								<html:option value="全国政协委员">全国政协委员</html:option>
								<html:option value="省级政协委员">省级政协委员</html:option>
								<html:option value="市级政协委员">市级政协委员</html:option>
								<html:option value="县级政协委员">县级政协委员</html:option>
							</html:select>
						</div>

						<div class="pure-control-group">
							<label for="email">是否监督对象</label> <html:select property="monitorobject">
							<html:option value="true">是</html:option>
							<html:option value="false">否</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">是否国家公务员</label><html:select property="servant">
							<html:option value="true">是</html:option>
							<html:option value="false">否</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">部门分类</label>
							<html:select property="department">
							<html:option value="">***无***</html:option>
							<html:option value="党务机关">党务机关</html:option>
							<html:option value="政府机关">政府机关</html:option>
							<html:option value="人大机关">人大机关</html:option>
							<html:option value="政协机关">政协机关</html:option>
							<html:option value="审判机关">审判机关</html:option>
							<html:option value="检察机关">检察机关</html:option>
							<html:option value="人民团体">人民团体</html:option>
							<html:option value="事业单位">事业单位</html:option>
							<html:option value="企业单位">企业单位</html:option>
							<html:option value="农村">农村</html:option>
							<html:option value="其他">其他</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">企业性质</label>
							<html:select property="industrynature">
							<html:option value="">***无***</html:option>
							<html:option value="国有及国有控股企业">国有及国有控股企业</html:option>
							<html:option value="集体企业">集体企业</html:option>
							<html:option value="私营企业">私营企业</html:option>
							<html:option value="其他内资企业">其他内资企业</html:option>
							<html:option value="外商及港澳台投资企业">外商及港澳台投资企业</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">企业级别</label>
							<html:select property="industrylevel">
							<html:option value="">***无***</html:option>
							<html:option value="一级">一级</html:option>
							<html:option value="二级">二级</html:option>
							<html:option value="三级">三级</html:option>
							<html:option value="四级">四级</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">企业人员类别</label> 
							<html:select property="industrypersoncategory">
							<html:option value="">***无***</html:option>
							<html:option value="企业领导人员">企业领导人员</html:option>
							<html:option value="中层干管理人员">中层干管理人员</html:option>
							<html:option value="其他人员">其他人员</html:option>
							</html:select>
						</div>

						<div class="pure-control-group">
							<label for="foo">一把手违纪</label><html:select property="onebreakrule">
							<html:option value="">***无***</html:option>
							<html:option value="查处时任一把手">查处时任“一把手”</html:option>
							<html:option value="违纪时人一把手">违纪时人“一把手”</html:option>
							<html:option value="查处时违纪时均任一把手">查处时违纪时均任“一把手”</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
						<label for="name">案件来源</label>
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

				<div class="pure-u-8-24">
					<fieldset>
											<div class="pure-control-group">
							<label for="foo">主要违纪行为</label>
							<html:select property="mainbehaviorid">
							    <html:option value="">***无***</html:option>
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
						<div class="pure-control-group">
							<label for="foo">涉及金额</label><html:text  property="involvedmoney" /> 
						</div>
						<div class="pure-control-group">
							<label for="foo">涉及人数</label><html:text  property="involvedperson" /> 
						</div>
						<div class="pure-control-group">
							<label for="foo">次要违纪行为</label>
							<html:select property="nextbehaviorid">
							    <html:option value="">***无***</html:option>
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
						<div class="pure-control-group">
							<label for="foo">违反《廉政准则》情况</label><html:text  property="breakinfor" /> 
						</div>
						
						<div class="pure-control-group">
							<label for="foo">是否涉及商业贿赂</label> <html:select property="iscommercialbribe">
							<html:option value="true">是</html:option>
							<html:option value="false">否</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">商业贿赂涉案金额</label> <html:text  property="bribemoney" />万元
						</div>
						<div class="pure-control-group">
							<label for="foo">商业贿赂涉案领域</label> <html:select property="bribearea">
							<html:option value="">***无***</html:option>
							<html:option value="工程建设">工程建设</html:option>
							<html:option value="土地出让">土地出让</html:option>
							<html:option value="产权交易">产权交易</html:option>
							<html:option value="政府采购">政府采购</html:option>
							<html:option value="医药购销">医药购销</html:option>
							<html:option value="资源开发和经销">资源开发和经销</html:option>
							<html:option value="其他">其他</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">是否窝案</label>
							  <html:select property="isnestcase">
							<html:option value="true">是</html:option>
							<html:option value="false">否</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">窝案细节</label> 
							<html:select property="nestcaseinfor">
							<html:option value="">***无***</html:option>
							<html:option value="主要涉案人">主要涉案人</html:option>
							<html:option value="次要涉案人">次要涉案人</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">窝案涉案人细节</label> <html:text  property="nestcasepersoninfor" />
						</div>
						<div class="pure-control-group">
							<label for="foo">违纪总金额</label><html:text  property="totalmoney" />
								万元
						</div>
						<div class="pure-control-group">
							<label for="foo">失职渎职造成损失金额</label> <html:text  property="dutymoney" />万元
						</div>
						<div class="pure-control-group">
							<label for="foo">收缴涉案金额</label> <html:text  property="suspectmoney" />万元
						</div>
						<div class="pure-control-group">
							<label for="foo">挽回经济损失</label><html:text  property="redeemmoney" />万元
						</div>
						<div class="pure-control-group">
							<label for="foo">首次违纪时间</label> <html:text  property="firstbreakruledate" styleClass="auto-kal" />
						</div>
						<div class="pure-control-group">
							<label for="foo">末次违纪时间</label><html:text  property="lastbreakruledate" styleClass="auto-kal" />
						</div>
						<div class="pure-control-group">
							<label for="foo">其他违纪时间</label> <html:text  property="otherbreakruledate" styleClass="auto-kal"/>
						</div>
						<div class="pure-control-group">
							<label for="foo">立案时间</label> <html:text  property="resultdate" styleClass="auto-kal" />
						</div>
						<div class="pure-control-group">
							<label for="foo">立案机关</label> <html:select property="reusltorgan">
							<html:option value="">***无***</html:option>
							<html:option value="中央纪委监察部">中央纪委监察部</html:option>
							<html:option value="省区市纪检察机关">省区市纪检察机关</html:option>
							<html:option value="地市州纪检察机关">地市州纪检察机关</html:option>
							<html:option value="县市区纪检察机关">县市区纪检察机关</html:option>
							<html:option value="乡镇纪委">乡镇纪委</html:option>
							<html:option value="军队纪委">军队纪委</html:option>
							<html:option value="中央和国家机关纪监察机构">中央和国家机关纪监察机构</html:option>
							<html:option value="省市区直属机关纪监察机构">省市区直属机关纪监察机构</html:option>
							<html:option value="事业单位纪监察机构">事业单位纪监察机构</html:option>
							<html:option value="其他">其他</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">与司法机关联合办案</label> 
							<html:select property="commoncase">
							<html:option value="">***无***</html:option>
							<html:option value="检察院">检察院</html:option>
							<html:option value="公安">公安</html:option>
							<html:option value="其他">其他</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">使用措施</label>
							<html:select property="useameasure">
							<html:option value="">***无***</html:option>
							<html:option value="两规">两规</html:option>
							<html:option value="两指">两指</html:option>
							</html:select>
						</div>
					</fieldset>
				</div>
				<div class="pure-u-8-24">
					<fieldset>
						<div class="pure-control-group" >
							<label for="foo">两规两指时间</label><html:text property="twotwofromdate" styleClass="auto-kal"/>
						</div>
						<div class="pure-control-group">
							<label for="foo">至</label><html:text  property="twotwotodate" styleClass="auto-kal"/>
						</div>
						<div class="pure-control-group">
							<label for="foo">实施措施机关</label> <html:text  property="implementmeasureorgan" />
						</div>
						<div class="pure-control-group">
							<label for="foo">调查中(终)止时间</label> <html:text  property="terminatedate" styleClass="auto-kal"/>
						</div>
						<div class="pure-control-group">
							<label for="foo">审理受理时间</label> <html:text  property="accepteddate" styleClass="auto-kal"/>
						</div>
						<div class="pure-control-group">
							<label for="foo">审理机关</label> <html:select property="acceptorgan">
							<html:option value="">***无***</html:option>
							<html:option value="中央纪委监察部">中央纪委监察部</html:option>
							<html:option value="省区市纪检察机关">省区市纪检察机关</html:option>
							<html:option value="地市州纪检察机关">地市州纪检察机关</html:option>
							<html:option value="县市区纪检察机关">县市区纪检察机关</html:option>
							<html:option value="乡镇纪委">乡镇纪委</html:option>
							<html:option value="军队纪委">军队纪委</html:option>
							<html:option value="中央和国家机关纪监察机构">中央和国家机关纪监察机构</html:option>
							<html:option value="省市区直属机关纪监察机构">省市区直属机关纪监察机构</html:option>
							<html:option value="事业单位纪监察机构">事业单位纪监察机构</html:option>
							<html:option value="其他">其他</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">审结时间</label> <html:text  property="acceptedfinishdate" styleClass="auto-kal"/>
						</div>
						<div class="pure-control-group">
							<label for="foo">潜逃时间</label><html:text  property="absconddate" styleClass="auto-kal"/>
						</div>
						<div class="pure-control-group">
							<label for="foo">潜逃去向</label>
							<html:select property="absconddirection">
							<html:option value="">***无***</html:option>
							<html:option value="国（境）内">国（境）内</html:option>
							<html:option value="国（境）外">国（境）外</html:option>
							<html:option value="不明">不明</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">抓获时间</label> <html:text  property="capturedate" styleClass="auto-kal"/>
						</div>
						<div class="pure-control-group">
							<label for="foo">结案时间</label><html:text  property="finishcasedate" styleClass="auto-kal"/>
						</div>
						<div class="pure-control-group">
							<label for="foo">党纪处分</label> 
							<html:select property="partypunish">
							<html:option value="">***无***</html:option>
							<html:option value="警告">警告</html:option>
							<html:option value="严重警告">严重警告</html:option>
							<html:option value="撤销党内职务">撤销党内职务</html:option>
							<html:option value="留党察看">留党察看</html:option>
							<html:option value="开除党籍">开除党籍</html:option>
							</html:select>
						</div>
						<div class="pure-control-group">
							<label for="foo">政纪处分</label>
							
							<html:select property="politypunish">
							<html:option value="">***无***</html:option>
							<html:option value="警告">警告</html:option>
							<html:option value="记过">记过</html:option>
							<html:option value="记大过">记大过</html:option>
							<html:option value="降级">降级</html:option>
							<html:option value="撤职">撤职</html:option>
							<html:option value="开除">开除</html:option>
							</html:select> 
						</div>
						<div class="pure-control-group">
							<label for="foo">解除政纪处分时间</label> <html:text  property="relievepolitypunishdate" styleClass="auto-kal"/>
						</div>
						<div class="pure-control-group">
							<label for="foo">提出问责建议</label> <html:text  property="dutyremark" />
						</div>
						<div class="pure-control-group">
							<label for="foo">其他处理</label> <html:text  property="otherhandle" />
						</div>
						<div class="pure-control-group">
							<label for="foo">责任追究</label>
							<html:select property="isdutylookinto">
							<html:option value="false">否</html:option>
							<html:option value="true">是</html:option>
							</html:select> 
						</div>
						<div class="pure-control-group">
							<label for="foo">销案时间</label><html:text  property="closecasedate" styleClass="auto-kal"/>
						</div>
						<div class="pure-control-group">
							<label for="foo">移送司法机关时间</label><html:text  property="pushtojudicialauthoritydate" styleClass="auto-kal"/>
						</div>
						<div class="pure-control-group">
							<label for="foo">公检法处理时间</label><html:text  property="publiclawhandledate" styleClass="auto-kal"/>
						</div>
						<div class="pure-control-group">
							<label for="foo">公检法处理</label>
							<html:select property="publiclawhandle">
							<html:option value="">***无***</html:option>
							<html:option value="刑事处理">刑事处理</html:option>
							<html:option value="其他处罚">其他处罚</html:option>
							</html:select> 
						</div>
						<div class="pure-control-group">
							<label for="foo">司法判决金额</label> <html:text  property="judicialauthoritymoney" />万元
						</div>
						<div class="pure-control-group">
							<label for="foo">专项统计</label> 
							<html:select property="specialstatistics">
							<html:option value="">***无***</html:option>
							<html:option value="商业贿赂">商业贿赂</html:option>
							<html:option value="土地征用">土地征用</html:option>
							<html:option value="房屋拆迁">房屋拆迁</html:option>
							<html:option value="企业改制破产">企业改制破产</html:option>
							<html:option value="买官卖官">买官卖官</html:option>
							<html:option value="拉票贿选">拉票贿选</html:option>
							<html:option value="生活作风问题">生活作风问题</html:option>
							<html:option value="官商勾结">官商勾结</html:option>
							<html:option value="设立小金库和使用小金库款项案件">设立小金库和使用小金库款项案件</html:option>
							<html:option value="提出问责建议">提出问责建议</html:option>
							<html:option value="工程建设领域">工程建设领域</html:option>
							<html:option value="生产安全事故涉及的失职渎职和背后的腐败问题">生产安全事故涉及的失职渎职和背后的腐败问题</html:option>
							<html:option value="群体性事件涉及的失职渎职和背后的腐败问题">群体性事件涉及的失职渎职和背后的腐败问题</html:option>
							</html:select> 
						</div>
					</fieldset>

				</div>
				<div class="pure-u-24-24">
					<fieldset>
						<div class="pure-control-group">
							<label for="foo">简要案情</label>
							<html:textarea cols="150" rows="6" property="briefinfor" />
						</div>
						<div class="pure-control-group">
							<label for="foo">调查报告</label>
							<html:textarea cols="150" rows="6" property="surveyreport" />
						</div>
						<div class="pure-control-group">
							<label for="foo">立案呈批报告</label>
							<html:textarea cols="150" rows="6" property="resultreport" />
						</div>
						<div class="pure-control-group">
							<label for="foo">立案决定书</label>
							<html:textarea cols="150" rows="6" property="resultdecisionbook" />
						</div>
						<div class="pure-control-group">
							<label for="foo">审理报告</label>
							<html:textarea cols="150" rows="6" property="checkreport" />
						</div>
						<div class="pure-control-group">
							<label for="foo">处分决定</label>
							<html:textarea cols="150" rows="6" property="punishresult" />
						</div>
						<div class="pure-control-group">
							<label for="foo">案件剖析报告</label>
							<html:textarea cols="150" rows="6" property="caseanalysereport" />
						</div>
						<div class="pure-control-group">
							<label for="foo">备注</label>
							<html:textarea cols="150" rows="6" property="remark" />
						</div>
						<hr>
						<div class="pure-control-group">
							<label for="foo">填表人</label><html:text  property="fillname" />
							<div class="pull-right">
								<label for="foo">审核人</label><html:text  property="checkname" />
							</div>
						</div>
						<div class="pure-control-group pull-right">
					<html:submit  property="提交" styleClass="pure-button pure-button-primary button-large" value="提交" style="font-size: 110%;width:200px;"/>
						</div>
					</fieldset>
				</div>
			</div>
	
	
	</html:form>
	
	</div>
</BODY>
</HTML>