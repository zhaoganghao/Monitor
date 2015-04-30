package cn.itcast.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.IndexColumn;
@Entity
public class HandlerWay implements Serializable ,Comparable<HandlerWay> {
	private static final long serialVersionUID = 396746790372148693L;
	@Id
	@GeneratedValue
	private Integer id;
	@Column(length = 30)
	private String name;
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name = "parentid")
	private HandlerWay parent;
	@OneToMany(cascade = { CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "parent")
	@IndexColumn(name = "xxx")
	private Set<HandlerWay> children = new TreeSet<HandlerWay>();
	@OneToOne(mappedBy="register")
	private Relation relation;
	
	public HandlerWay() {
		super();
	}
	
	public HandlerWay(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public HandlerWay(Integer id) {
		super();
		this.id = id;
	}

	public HandlerWay(String name) {
		super();
		this.name = name;
	}
	
	/** 增加子集**/
	public void addChild(HandlerWay way){
		this.children.add(way);
		way.parent=this;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HandlerWay getParent() {
		return parent;
	}
	public void setParent(HandlerWay parent) {
		this.parent = parent;
	}
	
	

	public Set<HandlerWay> getChildren() {
		return children;
	}

	public void setChildren(Set<HandlerWay> children) {
		this.children = children;
	}

	public Relation getRelation() {
		return relation;
	}
	public void setRelation(Relation relation) {
		this.relation = relation;
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
		HandlerWay other = (HandlerWay) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(HandlerWay o) {
		return this.id.compareTo(o.id);
	}
	
	
	
}
