package cn.itcast.web.formbean;

import java.util.Date;

import cn.itcast.bean.Rank;
import cn.itcast.bean.Source;

public class OtherForm extends BaseForm{
	private Integer id;
	/**填报日期**/
	private Date filldate;
	private String indexcode;
	/** 线索来源**/
	private Integer sourceid;
	private String handlerway;//去向
	private String remark;
	private String questiontype;
	private Date startdate;
	private Date enddate;
	private String reportedname;
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
	
	public String getReportedname() {
		return reportedname;
	}
	public void setReportedname(String reportedname) {
		this.reportedname = reportedname;
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
	public String getIndexcode() {
		return indexcode;
	}
	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode;
	}
	public Integer getSourceid() {
		return sourceid;
	}
	public void setSourceid(Integer sourceid) {
		this.sourceid = sourceid;
	}
	public String getHandlerway() {
		return handlerway;
	}
	public void setHandlerway(String handlerway) {
		this.handlerway = handlerway;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getQuestiontype() {
		return questiontype;
	}
	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}
	
	
}
