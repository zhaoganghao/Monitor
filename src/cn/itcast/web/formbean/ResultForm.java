package cn.itcast.web.formbean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ResultForm extends BaseForm{
	private Integer id;
	private String fillunit;
	private Date filldate;
	private String indexcode;
	private String sourcetwo;
	/** 涉嫌人员编号 **/
	private String personcode;
	/** 单位类或事故类问题 **/
	private Boolean isaccident;
	/** 被调查人 **/
	private String reportedname;
	/** 性别 **/
	private String sex;
	/** 出生年月 **/
	private Date borndate;
	/** 名族 **/
	private String nationality;
	/** 政治面貌 **/
	private String politicsstatus;
	/** 入党时间 **/
	private Date partydate;
	/** 工作单位及职务 **/
	private String workunit;
	/** 学历 **/
	private String education;
	/** 职级 **/
	private Integer rankid;
	/** 任现职时间 **/
	private Date workdate;
	/** 人大代表 **/
	private String personrepresent;
	/** 政协委员 **/
	private String politycommittee;
	/** 是否监察对象 **/
	private Boolean monitorobject;
	/** 是否国家公务员 **/
	private Boolean servant;
	/** 部门分类 **/
	private String department;
	/** 企业性质 **/
	private String industrynature;
	/** 企业级别 **/
	private String industrylevel;
	/** 企业人员类别 **/
	private String industrypersoncategory;
	/** 一把手违纪 **/
	private String onebreakrule;
	/** 案件来源 **/
	private Integer sourceid;

	/** 主要违纪行为 **/
	private Integer mainbehaviorid;
	/** 涉及金额 **/
	private Float involvedmoney;
	/** 涉及人数 **/
	private Integer involvedperson;
	/** 次要违纪行为 **/
	private Integer nextbehaviorid;
	/** 违反《廉政准则》情况 **/
	private String breakinfor;
	/** 是否涉及商业贿赂 **/
	private Boolean iscommercialbribe;
	/** 商业贿赂涉案金额 **/
	private Integer bribemoney;
	/** 商业贿赂涉及领域 **/
	private String bribearea;
	/** 是否窝案 **/
	private Boolean isnestcase;
	/** 窝案细节 **/
	private String nestcaseinfor;
	/** 窝案涉案人细节 **/
	private String nestcasepersoninfor;
	/** 违纪总金额 **/
	private Float totalmoney;
	/** 失职渎职造成损失金额 **/
	private Float dutymoney;
	/** 收缴涉嫌金额（万元） **/
	private Float suspectmoney;
	/** 挽回经济损失（万元） **/
	private Float redeemmoney;
	/** 首次违纪时间 **/
	private Date firstbreakruledate;

	/** 末次违纪时间 **/
	private Date lastbreakruledate;

	/** 其他违纪时间 **/
	private Date otherbreakruledate;

	/** 立案时间 **/
	private Date resultdate;
	/** 立案机关 **/
	private String reusltorgan;

	/** 与司法机关联合办案 **/
	private String commoncase;

	/** 使用措施 **/
	private String useameasure;

	/** 两规两指时间 **/
	private Date twotwofromdate;

	/** 至 **/
	private Date twotwotodate;

	/** 实施措施机关 **/
	private String implementmeasureorgan;

	/** 调查中（终）止时间 **/
	private Date terminatedate;

	/** 审理受理时间 **/
	private Date accepteddate;

	/** 审理机关 **/
	private String acceptorgan;

	/** 审结时间 **/
	private Date acceptedfinishdate;

	/** 潜逃时间 **/
	private Date absconddate;

	/** 潜逃去向 **/
	private String absconddirection;

	/** 抓获时间 **/
	private Date capturedate;

	/** 结案时间 **/
	private Date finishcasedate;

	/** 党纪处分 **/
	private String partypunish;

	/** 政纪处分 **/
	private String politypunish;
	/** 解除政纪处分时间 **/
	private Date relievepolitypunishdate;

	/** 提出问责建议 **/
	private String dutyremark;

	/** 其他处理 **/
	private String otherhandle;

	/** 责任追究 **/
	private Boolean isdutylookinto;

	/** 销案时间 **/
	private Date closecasedate;

	/** 移送司法机关时间 **/
	private Date pushtojudicialauthoritydate;

	/** 公检法处理关时间 **/
	private Date publiclawhandledate;

	/** 公检法处理 **/
	private String publiclawhandle;
	/** 司法判决金额 **/
	private Float judicialauthoritymoney;
	/** 专项统计 **/
	private String specialstatistics;
	/** 简要案情 **/
	private String briefinfor;
	/** 调查报告 **/
	private String surveyreport;
	/** 立案成批报告 **/
	private String resultreport;
	/** 立案决定书 **/
	private String resultdecisionbook;
	/** 审理报告 **/
	private String checkreport;
	/** 处分决定 **/
	private String punishresult;
	/** 案件剖析报告 **/
	private String caseanalysereport;
	/** 备注 **/
	private String remark;

	/** 填表人 **/
	private String fillname;
	/** 审核人 **/
	private String checkname;
	private String filldateyear;
	private String filldatemonth;
	private Date startdate;
	private Date enddate;
	
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getFilldateyear() {
		return filldateyear;
	}
	public void setFilldateyear(String filldateyear) {
		this.filldateyear = filldateyear;
	}
	public String getFilldatemonth() {
		return filldatemonth;
	}
	public void setFilldatemonth(String filldatemonth) {
		this.filldatemonth = filldatemonth;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFillunit() {
		return fillunit;
	}
	public void setFillunit(String fillunit) {
		this.fillunit = fillunit;
	}
	public Date getFilldate() {
		return filldate;
	}
	public void setFilldate(Date filldate) {
		this.filldate = filldate;
	}
	
	public String getPersoncode() {
		return personcode;
	}
	public void setPersoncode(String personcode) {
		this.personcode = personcode;
	}
	
	public String getSourcetwo() {
		return sourcetwo;
	}
	public void setSourcetwo(String sourcetwo) {
		this.sourcetwo = sourcetwo;
	}
	public Boolean getIsaccident() {
		return isaccident;
	}
	public void setIsaccident(Boolean isaccident) {
		this.isaccident = isaccident;
	}
	
	public String getIndexcode() {
		return indexcode;
	}
	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode;
	}
	public Integer getNextbehaviorid() {
		return nextbehaviorid;
	}
	public void setNextbehaviorid(Integer nextbehaviorid) {
		this.nextbehaviorid = nextbehaviorid;
	}
	public String getReportedname() {
		return reportedname;
	}
	public void setReportedname(String reportedname) {
		this.reportedname = reportedname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBorndate() {
		return borndate;
	}
	public void setBorndate(Date borndate) {
		this.borndate = borndate;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPoliticsstatus() {
		return politicsstatus;
	}
	public void setPoliticsstatus(String politicsstatus) {
		this.politicsstatus = politicsstatus;
	}
	public Date getPartydate() {
		return partydate;
	}
	public void setPartydate(Date partydate) {
		this.partydate = partydate;
	}
	public String getWorkunit() {
		return workunit;
	}
	public void setWorkunit(String workunit) {
		this.workunit = workunit;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Integer getRankid() {
		return rankid;
	}
	public void setRankid(Integer rankid) {
		this.rankid = rankid;
	}
	public Date getWorkdate() {
		return workdate;
	}
	public void setWorkdate(Date workdate) {
		this.workdate = workdate;
	}
	public String getPersonrepresent() {
		return personrepresent;
	}
	public void setPersonrepresent(String personrepresent) {
		this.personrepresent = personrepresent;
	}
	public String getPolitycommittee() {
		return politycommittee;
	}
	public void setPolitycommittee(String politycommittee) {
		this.politycommittee = politycommittee;
	}
	public Boolean getMonitorobject() {
		return monitorobject;
	}
	public void setMonitorobject(Boolean monitorobject) {
		this.monitorobject = monitorobject;
	}
	public Boolean getServant() {
		return servant;
	}
	public void setServant(Boolean servant) {
		this.servant = servant;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getIndustrynature() {
		return industrynature;
	}
	public void setIndustrynature(String industrynature) {
		this.industrynature = industrynature;
	}
	public String getIndustrylevel() {
		return industrylevel;
	}
	public void setIndustrylevel(String industrylevel) {
		this.industrylevel = industrylevel;
	}
	public String getIndustrypersoncategory() {
		return industrypersoncategory;
	}
	public void setIndustrypersoncategory(String industrypersoncategory) {
		this.industrypersoncategory = industrypersoncategory;
	}
	public String getOnebreakrule() {
		return onebreakrule;
	}
	public void setOnebreakrule(String onebreakrule) {
		this.onebreakrule = onebreakrule;
	}
	public Integer getSourceid() {
		return sourceid;
	}
	public void setSourceid(Integer sourceid) {
		this.sourceid = sourceid;
	}
	
	public Integer getMainbehaviorid() {
		return mainbehaviorid;
	}
	public void setMainbehaviorid(Integer mainbehaviorid) {
		this.mainbehaviorid = mainbehaviorid;
	}
	public Float getInvolvedmoney() {
		return involvedmoney;
	}
	public void setInvolvedmoney(Float involvedmoney) {
		this.involvedmoney = involvedmoney;
	}
	public Integer getInvolvedperson() {
		return involvedperson;
	}
	public void setInvolvedperson(Integer involvedperson) {
		this.involvedperson = involvedperson;
	}
	public String getBreakinfor() {
		return breakinfor;
	}
	public void setBreakinfor(String breakinfor) {
		this.breakinfor = breakinfor;
	}
	public Boolean getIscommercialbribe() {
		return iscommercialbribe;
	}
	public void setIscommercialbribe(Boolean iscommercialbribe) {
		this.iscommercialbribe = iscommercialbribe;
	}
	public Integer getBribemoney() {
		return bribemoney;
	}
	public void setBribemoney(Integer bribemoney) {
		this.bribemoney = bribemoney;
	}
	public String getBribearea() {
		return bribearea;
	}
	public void setBribearea(String bribearea) {
		this.bribearea = bribearea;
	}
	public Boolean getIsnestcase() {
		return isnestcase;
	}
	public void setIsnestcase(Boolean isnestcase) {
		this.isnestcase = isnestcase;
	}
	public String getNestcaseinfor() {
		return nestcaseinfor;
	}
	public void setNestcaseinfor(String nestcaseinfor) {
		this.nestcaseinfor = nestcaseinfor;
	}
	public String getNestcasepersoninfor() {
		return nestcasepersoninfor;
	}
	public void setNestcasepersoninfor(String nestcasepersoninfor) {
		this.nestcasepersoninfor = nestcasepersoninfor;
	}
	public Float getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(Float totalmoney) {
		this.totalmoney = totalmoney;
	}
	public Float getDutymoney() {
		return dutymoney;
	}
	public void setDutymoney(Float dutymoney) {
		this.dutymoney = dutymoney;
	}
	public Float getSuspectmoney() {
		return suspectmoney;
	}
	public void setSuspectmoney(Float suspectmoney) {
		this.suspectmoney = suspectmoney;
	}
	public Float getRedeemmoney() {
		return redeemmoney;
	}
	public void setRedeemmoney(Float redeemmoney) {
		this.redeemmoney = redeemmoney;
	}
	public Date getFirstbreakruledate() {
		return firstbreakruledate;
	}
	public void setFirstbreakruledate(Date firstbreakruledate) {
		this.firstbreakruledate = firstbreakruledate;
	}
	public Date getLastbreakruledate() {
		return lastbreakruledate;
	}
	public void setLastbreakruledate(Date lastbreakruledate) {
		this.lastbreakruledate = lastbreakruledate;
	}
	public Date getOtherbreakruledate() {
		return otherbreakruledate;
	}
	public void setOtherbreakruledate(Date otherbreakruledate) {
		this.otherbreakruledate = otherbreakruledate;
	}
	public Date getResultdate() {
		return resultdate;
	}
	public void setResultdate(Date resultdate) {
		this.resultdate = resultdate;
	}
	public String getReusltorgan() {
		return reusltorgan;
	}
	public void setReusltorgan(String reusltorgan) {
		this.reusltorgan = reusltorgan;
	}
	public String getCommoncase() {
		return commoncase;
	}
	public void setCommoncase(String commoncase) {
		this.commoncase = commoncase;
	}
	public String getUseameasure() {
		return useameasure;
	}
	public void setUseameasure(String useameasure) {
		this.useameasure = useameasure;
	}
	public Date getTwotwofromdate() {
		return twotwofromdate;
	}
	public void setTwotwofromdate(Date twotwofromdate) {
		this.twotwofromdate = twotwofromdate;
	}
	public Date getTwotwotodate() {
		return twotwotodate;
	}
	public void setTwotwotodate(Date twotwotodate) {
		this.twotwotodate = twotwotodate;
	}
	public String getImplementmeasureorgan() {
		return implementmeasureorgan;
	}
	public void setImplementmeasureorgan(String implementmeasureorgan) {
		this.implementmeasureorgan = implementmeasureorgan;
	}
	public Date getTerminatedate() {
		return terminatedate;
	}
	public void setTerminatedate(Date terminatedate) {
		this.terminatedate = terminatedate;
	}
	public Date getAccepteddate() {
		return accepteddate;
	}
	public void setAccepteddate(Date accepteddate) {
		this.accepteddate = accepteddate;
	}
	public String getAcceptorgan() {
		return acceptorgan;
	}
	public void setAcceptorgan(String acceptorgan) {
		this.acceptorgan = acceptorgan;
	}
	public Date getAcceptedfinishdate() {
		return acceptedfinishdate;
	}
	public void setAcceptedfinishdate(Date acceptedfinishdate) {
		this.acceptedfinishdate = acceptedfinishdate;
	}
	public Date getAbsconddate() {
		return absconddate;
	}
	public void setAbsconddate(Date absconddate) {
		this.absconddate = absconddate;
	}
	public String getAbsconddirection() {
		return absconddirection;
	}
	public void setAbsconddirection(String absconddirection) {
		this.absconddirection = absconddirection;
	}
	public Date getCapturedate() {
		return capturedate;
	}
	public void setCapturedate(Date capturedate) {
		this.capturedate = capturedate;
	}
	public Date getFinishcasedate() {
		return finishcasedate;
	}
	public void setFinishcasedate(Date finishcasedate) {
		this.finishcasedate = finishcasedate;
	}
	public String getPartypunish() {
		return partypunish;
	}
	public void setPartypunish(String partypunish) {
		this.partypunish = partypunish;
	}
	public String getPolitypunish() {
		return politypunish;
	}
	public void setPolitypunish(String politypunish) {
		this.politypunish = politypunish;
	}
	public Date getRelievepolitypunishdate() {
		return relievepolitypunishdate;
	}
	public void setRelievepolitypunishdate(Date relievepolitypunishdate) {
		this.relievepolitypunishdate = relievepolitypunishdate;
	}
	public String getDutyremark() {
		return dutyremark;
	}
	public void setDutyremark(String dutyremark) {
		this.dutyremark = dutyremark;
	}
	public String getOtherhandle() {
		return otherhandle;
	}
	public void setOtherhandle(String otherhandle) {
		this.otherhandle = otherhandle;
	}
	public Boolean getIsdutylookinto() {
		return isdutylookinto;
	}
	public void setIsdutylookinto(Boolean isdutylookinto) {
		this.isdutylookinto = isdutylookinto;
	}
	public Date getClosecasedate() {
		return closecasedate;
	}
	public void setClosecasedate(Date closecasedate) {
		this.closecasedate = closecasedate;
	}
	public Date getPushtojudicialauthoritydate() {
		return pushtojudicialauthoritydate;
	}
	public void setPushtojudicialauthoritydate(Date pushtojudicialauthoritydate) {
		this.pushtojudicialauthoritydate = pushtojudicialauthoritydate;
	}
	public Date getPubliclawhandledate() {
		return publiclawhandledate;
	}
	public void setPubliclawhandledate(Date publiclawhandledate) {
		this.publiclawhandledate = publiclawhandledate;
	}
	public String getPubliclawhandle() {
		return publiclawhandle;
	}
	public void setPubliclawhandle(String publiclawhandle) {
		this.publiclawhandle = publiclawhandle;
	}
	public Float getJudicialauthoritymoney() {
		return judicialauthoritymoney;
	}
	public void setJudicialauthoritymoney(Float judicialauthoritymoney) {
		this.judicialauthoritymoney = judicialauthoritymoney;
	}
	public String getSpecialstatistics() {
		return specialstatistics;
	}
	public void setSpecialstatistics(String specialstatistics) {
		this.specialstatistics = specialstatistics;
	}
	public String getBriefinfor() {
		return briefinfor;
	}
	public void setBriefinfor(String briefinfor) {
		this.briefinfor = briefinfor;
	}
	public String getSurveyreport() {
		return surveyreport;
	}
	public void setSurveyreport(String surveyreport) {
		this.surveyreport = surveyreport;
	}
	public String getResultreport() {
		return resultreport;
	}
	public void setResultreport(String resultreport) {
		this.resultreport = resultreport;
	}
	public String getResultdecisionbook() {
		return resultdecisionbook;
	}
	public void setResultdecisionbook(String resultdecisionbook) {
		this.resultdecisionbook = resultdecisionbook;
	}
	public String getCheckreport() {
		return checkreport;
	}
	public void setCheckreport(String checkreport) {
		this.checkreport = checkreport;
	}
	public String getPunishresult() {
		return punishresult;
	}
	public void setPunishresult(String punishresult) {
		this.punishresult = punishresult;
	}
	public String getCaseanalysereport() {
		return caseanalysereport;
	}
	public void setCaseanalysereport(String caseanalysereport) {
		this.caseanalysereport = caseanalysereport;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getFillname() {
		return fillname;
	}
	public void setFillname(String fillname) {
		this.fillname = fillname;
	}
	public String getCheckname() {
		return checkname;
	}
	public void setCheckname(String checkname) {
		this.checkname = checkname;
	}

}
