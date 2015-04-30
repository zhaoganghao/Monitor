package cn.itcast.web.formbean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.struts.upload.FormFile;

import cn.itcast.bean.QuestionType;
import cn.itcast.bean.Rank;
import cn.itcast.bean.Source;


public class RegisterForm extends BaseForm {
	private Integer id;
	/**填报单位**/
	private String fillunit;
	private String sourcenumber;
	/**职级注释**/
	private String sourcetwo;
	private String otherrank;
	private String handlernumber;
	/**填报日期**/
	private Date filldate;
	private String direct;
	/**线索编码**/
	private String indexcode;
	/** 人员编号**/
	private String personcode;
	/** 单位类或事故类问题**/
	private Boolean isaccident;
	/** 被反应人**/
	private String reportedname;
	/** 出身年月**/
	private Date borndate;
	/** 名族**/
	private String nationality;
	/** 政治面貌**/
	private String politicsstatus;
	/** 入党时间**/
	private Date partydate;
	/** 工作单位及职务**/
	private String workunit;
	/** 人大代表**/
	private String  personrepresent;
	/** 政治委员**/
	private String politycommittee;
	/**监察对象**/
	private Boolean  monitorobject;
	/**公务员**/
	private Boolean servant;
	/** 办理机关**/
	private String transactname;
	/** 受理时间**/
	private Date transactdate;
	/**挽回经济损失（万元）**/
	private Float redeemeconomy;
	/**收缴涉嫌金额（万元）**/
	private Float suspecteconomy;
	/**主要问题线索**/
	private String	mainthread;
	/** 处置情况报告**/
	private String report;
	/**备注**/
	private String remark;
	private Integer rankid;
	/** 线索来源**/
	private Integer sourceid;
	private Integer	typeid;
	/**填表人**/
	private String fillname;
	/** 审核人**/
	private String checkname;
	
	private Date handlerdate1;
	private Date handlerdate2;
	private Date handlerdate3;
	private Integer handlerway1id;
	private Integer handlerway2id;
	private Integer handlerway3id;
	private String handlerway1;
	private String handlerway2;
	private String handlerway3;
	
	private String filldateyear;
	private String filldatemonth;
	private Date startdate;
	private Date enddate;
	private Integer ispunish;
	private Integer relationid1;
	private Integer relationid2;
	private Integer relationid3;
	
	
	
	public String getDirect() {
		return direct;
	}

	public void setDirect(String direct) {
		this.direct = direct;
	}

	public Integer getRelationid1() {
		return relationid1;
	}

	public void setRelationid1(Integer relationid1) {
		this.relationid1 = relationid1;
	}

	public Integer getRelationid2() {
		return relationid2;
	}
	

	public String getSourcetwo() {
		return sourcetwo;
	}

	public void setSourcetwo(String sourcetwo) {
		this.sourcetwo = sourcetwo;
	}

	public void setRelationid2(Integer relationid2) {
		this.relationid2 = relationid2;
	}

	public String getHandlerway1() {
		return handlerway1;
	}

	public void setHandlerway1(String handlerway1) {
		this.handlerway1 = handlerway1;
	}

	public String getHandlerway2() {
		return handlerway2;
	}

	public void setHandlerway2(String handlerway2) {
		this.handlerway2 = handlerway2;
	}

	public String getHandlerway3() {
		return handlerway3;
	}

	public void setHandlerway3(String handlerway3) {
		this.handlerway3 = handlerway3;
	}

	public String getHandlernumber() {
		return handlernumber;
	}

	public void setHandlernumber(String handlernumber) {
		this.handlernumber = handlernumber;
	}

	public Integer getRelationid3() {
		return relationid3;
	}

	public void setRelationid3(Integer relationid3) {
		this.relationid3 = relationid3;
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
	
	public String getFilldatemonth() {
		return filldatemonth;
	}

	public void setFilldatemonth(String filldatemonth) {
		this.filldatemonth = filldatemonth;
	}

	public String getSourcenumber() {
		return sourcenumber;
	}

	public void setSourcenumber(String sourcenumber) {
		this.sourcenumber = sourcenumber;
	}

	public String getOtherrank() {
		return otherrank;
	}

	public void setOtherrank(String otherrank) {
		this.otherrank = otherrank;
	}

	public Date getFilldate() {
		return filldate;
	}
	public void setFilldate(Date filldate) {
		this.filldate = filldate;
	}
	public String getIndexcode() {
		return indexcode;
	}
	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode;
	}
	public Integer getIspunish() {
		return ispunish;
	}

	public void setIspunish(Integer ispunish) {
		this.ispunish = ispunish;
	}

	public String getPersoncode() {
		return personcode;
	}
	public void setPersoncode(String personcode) {
		this.personcode = personcode;
	}
	public Boolean getIsaccident() {
		return isaccident;
	}
	public void setIsaccident(Boolean isaccident) {
		this.isaccident = isaccident;
	}
	public String getReportedname() {
		return reportedname;
	}
	public void setReportedname(String reportedname) {
		this.reportedname = reportedname;
	}
	
	public String getFilldateyear() {
		return filldateyear;
	}

	public void setFilldateyear(String filldateyear) {
		this.filldateyear = filldateyear;
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
	public String getTransactname() {
		return transactname;
	}
	public void setTransactname(String transactname) {
		this.transactname = transactname;
	}
	public Date getTransactdate() {
		return transactdate;
	}
	public void setTransactdate(Date transactdate) {
		this.transactdate = transactdate;
	}
	
	public Float getRedeemeconomy() {
		return redeemeconomy;
	}
	public void setRedeemeconomy(Float redeemeconomy) {
		this.redeemeconomy = redeemeconomy;
	}
	public Float getSuspecteconomy() {
		return suspecteconomy;
	}
	public void setSuspecteconomy(Float suspecteconomy) {
		this.suspecteconomy = suspecteconomy;
	}
	public String getMainthread() {
		return mainthread;
	}
	public void setMainthread(String mainthread) {
		this.mainthread = mainthread;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getRankid() {
		return rankid;
	}
	public void setRankid(Integer rankid) {
		this.rankid = rankid;
	}
	public Integer getSourceid() {
		return sourceid;
	}
	public void setSourceid(Integer sourceid) {
		this.sourceid = sourceid;
	}
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
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

	
	public Date getHandlerdate1() {
		return handlerdate1;
	}

	public void setHandlerdate1(Date handlerdate1) {
		this.handlerdate1 = handlerdate1;
	}

	public Date getHandlerdate2() {
		return handlerdate2;
	}

	public void setHandlerdate2(Date handlerdate2) {
		this.handlerdate2 = handlerdate2;
	}

	public Date getHandlerdate3() {
		return handlerdate3;
	}

	public void setHandlerdate3(Date handlerdate3) {
		this.handlerdate3 = handlerdate3;
	}


	public Integer getHandlerway1id() {
		return handlerway1id;
	}

	public void setHandlerway1id(Integer handlerway1id) {
		this.handlerway1id = handlerway1id;
	}

	public Integer getHandlerway2id() {
		return handlerway2id;
	}

	public void setHandlerway2id(Integer handlerway2id) {
		this.handlerway2id = handlerway2id;
	}

	public Integer getHandlerway3id() {
		return handlerway3id;
	}

	public void setHandlerway3id(Integer handlerway3id) {
		this.handlerway3id = handlerway3id;
	}

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
	
	
}
