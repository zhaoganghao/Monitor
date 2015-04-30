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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Register implements Serializable {
	private static final long serialVersionUID = -7962994747335387154L;
	/** id**/
	@Id
	@GeneratedValue
	private Integer id;
	//--------------------------------------------��ͷ
	/**���λ**/
	@Column(length=30)
	private String fillunit;
	/**�����**/
	@Temporal(TemporalType.DATE)
	private Date filldate;
	
	//-------------------------------------------����
	/**��������**/
	@Column(length=8)
	private String indexcode;
	/**��Դ�ĺ�**/
	@Column(length=20)
	private String sourcenumber;
	/**���������ĺ�**/
	@Column(length=20)
	private String handlernumber;
	/**ְ��ע��**/
	@Column(length=4)
	private String otherrank;
	/**������Դ**/
	@Column(length=7)
	private String sourcetwo;
	/** ��Ա���**/
	@Column(length=3)
	private String personcode;
	/** ��λ����¹�������**/
	private Boolean isaccident;
	/** ����Ӧ��**/
	@Column(length=30)
	private String reportedname;
	/** ��������**/
	@Temporal(TemporalType.DATE)
	private Date borndate;
	/** ����**/
	@Column(length=6)
	private String nationality;
	/** ������ò**/
	@Column(length=4)
	private String politicsstatus;
	/** �뵳ʱ��**/
	@Temporal(TemporalType.DATE)
	private Date partydate;
	/** ������λ��ְ��**/
	@Column(length=50)
	private String workunit;
	/** �˴����**/
	@Column(length=6)
	private String  personrepresent;
	/** ����ίԱ**/
	@Column(length=6)
	private String politycommittee;
	/**������**/
	private Boolean  monitorobject;
	/**����Ա**/
	private Boolean servant;
	/** �������**/
	@Column(length=20)
	private String transactname;
	/** ����ʱ��**/
	@Temporal(TemporalType.DATE)
	private Date transactdate;
	/**��ؾ�����ʧ����Ԫ��**/
	private Float redeemeconomy;
	/**�ս����ӽ���Ԫ��**/
	private Float suspecteconomy;
	/**��Ҫ��������**/
	@Lob
	private String	mainthread;
	/** �����������**/
	@Lob
	private String report;
	/**��ע**/
	@Lob
	private String remark;
	
	@OneToMany(mappedBy="register",cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	private Set<Relation>  relations=new HashSet<Relation>();
	//----------------------������------------------------------------
	/** ְ��**/
	@ManyToOne
	@JoinColumn(name="rankid")
	private Rank rank;
	/** ������Դ**/
	@ManyToOne
	@JoinColumn(name="sourceid")
	private Source source;
	/** ��������**/
	@ManyToOne
	@JoinColumn(name="typeid")
	private QuestionType	type;
	//---------------------------------------------------------��β
	/**�����**/
	@Column(length=6)
	private String fillname;
	/** �����**/
	@Column(length=6)
	private String checkname;
	private Integer size;
	@Column(length=16)
	private String direct;
	public void setSize(Integer size) {
		this.size = size;
	}


	public Integer getSize() {
		return this.relations.size();
	}

	public Register(){
	}

	public Register(String fillunit, Date filldate, String indexcode,
			String personcode, Boolean isaccident, String reportedname,
			Date borndate, String nationality, String politicsstatus,
			Date partydate, String workunit, String personrepresent,
			String politycommittee, Boolean monitorobject, Boolean servant,
			String transactname, Date transactdate, Float redeemeconomy,
			Float suspecteconomy, String mainthread, String report,
			String remark,  String fillname, String checkname) {
		super();
		this.fillunit = fillunit;
		this.filldate = filldate;
		this.indexcode = indexcode;
		this.personcode = personcode;
		this.isaccident = isaccident;
		this.reportedname = reportedname;
		this.borndate = borndate;
		this.nationality = nationality;
		this.politicsstatus = politicsstatus;
		this.partydate = partydate;
		this.workunit = workunit;
		this.personrepresent = personrepresent;
		this.politycommittee = politycommittee;
		this.monitorobject = monitorobject;
		this.servant = servant;
		this.transactname = transactname;
		this.transactdate = transactdate;
		this.redeemeconomy = redeemeconomy;
		this.suspecteconomy = suspecteconomy;
		this.mainthread = mainthread;
		this.report = report;
		this.remark = remark;
		this.fillname = fillname;
		this.checkname = checkname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getHandlernumber() {
		return handlernumber;
	}


	public void setHandlernumber(String handlernumber) {
		this.handlernumber = handlernumber;
	}


	public String getDirect() {
		return direct;
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


	public void setDirect(String direct) {
		this.direct = direct;
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
	public String getIndexcode() {
		return indexcode;
	}
	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode;
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
	
	public String getSourcetwo() {
		return sourcetwo;
	}


	public void setSourcetwo(String sourcetwo) {
		this.sourcetwo = sourcetwo;
	}


	public String getReportedname() {
		return reportedname;
	}
	public void setReportedname(String reportedname) {
		this.reportedname = reportedname;
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
	public void setPolitycommittee(String politycommittee) {
		this.politycommittee = politycommittee;
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

	public QuestionType getType() {
		return type;
	}
	public void setType(QuestionType type) {
		this.type = type;
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

	public Set<Relation> getRelations() {
		return relations;
	}


	public void setRelations(Set<Relation> relations) {
		this.relations = relations;
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
		Register other = (Register) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
