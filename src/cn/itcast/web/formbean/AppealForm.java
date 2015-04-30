package cn.itcast.web.formbean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.itcast.bean.Rank;
import cn.itcast.bean.Source;

public class AppealForm extends BaseForm{
	private Integer id;
	/**填报日期**/
	private Date filldate;
	
	/**线索编码**/
	private String indexcode;
	/** 被反应人**/
	private String reportedname;
	
	/** 职级**/
	private Integer rankid;
	
	/** 线索来源**/
	private Integer sourceid;
	private String remark;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getReportedname() {
		return reportedname;
	}
	public void setReportedname(String reportedname) {
		this.reportedname = reportedname;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
