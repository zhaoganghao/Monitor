package cn.itcast.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Other  implements Serializable {
	private static final long serialVersionUID = 7458162307983555549L;
	/** id**/
	@Id
	@GeneratedValue
	private Integer id;
	/**填报日期**/
	@Temporal(TemporalType.DATE)
	private Date filldate;
	/**线索编码**/
	@Column(length=8)
	private String indexcode;
	/** 被反应人**/
	@Column(length=30)
	private String reportedname;
	/** 职级**//*
	@ManyToOne
	@JoinColumn(name="rankid")
	private Rank rank;*/
	
	/** 线索来源**/
	@ManyToOne
	@JoinColumn(name="sourceid")
	private Source source;
	@Column(length=10)
	private String handlerway;//转、退、存
	
	@Column(length=5)
	private String questiontype;

	/**备注**/
	@Lob
	private String remark;
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getId() {
		return id;
	}


	public String getReportedname() {
		return reportedname;
	}

	public void setReportedname(String reportedname) {
		this.reportedname = reportedname;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Date getFilldate() {
		return filldate;
	}

	public String getIndexcode() {
		return indexcode;
	}

	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode;
	}

	public void setFilldate(Date filldate) {
		this.filldate = filldate;
	}




	public Source getSource() {
		return source;
	}


	public void setSource(Source source) {
		this.source = source;
	}


	public String getHandlerway() {
		return handlerway;
	}


	public void setHandlerway(String handlerway) {
		this.handlerway = handlerway;
	}


	public String getQuestiontype() {
		return questiontype;
	}


	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Other other = (Other) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
