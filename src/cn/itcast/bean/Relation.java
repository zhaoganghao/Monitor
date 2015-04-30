package cn.itcast.bean;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Relation  implements Serializable,Comparable<Relation> {
	private static final long serialVersionUID = 4165795605762097296L;
	/** id**/
	@Id
	@GeneratedValue
	private Integer id;
	/**Ìî±¨ÈÕÆÚ**/
	@Temporal(TemporalType.DATE)
	private Date createdate;
	@OneToOne
	@JoinColumn(name="registerid")
	private Register register;
	@OneToOne
	@JoinColumn(name="handlerwayid")
	private HandlerWay handlerway;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Register getRegister() {
		return register;
	}
	public void setRegister(Register register) {
		this.register = register;
	}
	public HandlerWay getHandlerway() {
		return handlerway;
	}
	public void setHandlerway(HandlerWay handlerway) {
		this.handlerway = handlerway;
	}
	@Override
	public int compareTo(Relation o) {
		return this.getCreatedate().compareTo(o.getCreatedate());
	}
	
}
