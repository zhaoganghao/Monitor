package cn.itcast.bean;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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

@Entity
public class Appeal implements Serializable {
	private static final long serialVersionUID = 5096787680321906270L;
	/** id**/
	@Id
	@GeneratedValue
	private Integer id;
	/**�����**/
	@Temporal(TemporalType.DATE)
	private Date filldate;
	
	/**��������**/
	@Column(length=8)
	private String indexcode;
	/** ����Ӧ��**/
	@Column(length=30)
	private String reportedname;
	/** ��������**//*
	@Temporal(TemporalType.DATE)
	private Date borndate;
	*//** ����**//*
	@Column(length=6)
	private String nationality;
	*//** ������ò**//*
	@Column(length=4)
	private String politicsstatus;*/
	
	/** ְ��**/
	@ManyToOne
	@JoinColumn(name="rankid")
	private Rank rank;
	
	/** ������Դ**/
	@ManyToOne
	@JoinColumn(name="sourceid")
	private Source source;
	/**��ע**/
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


	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
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
		Appeal other = (Appeal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	


}
