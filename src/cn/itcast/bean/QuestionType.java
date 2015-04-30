package cn.itcast.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * 问题类型
 * 
 * @author acer
 * 
 */
@Entity
public class QuestionType implements Serializable {
	private static final long serialVersionUID = 3462834156517069909L;
	@Id
	@GeneratedValue
	private Integer id;
	@Column(length = 30)
	private String name;
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name = "parentid")
	private QuestionType parent;
	@OneToMany(cascade = { CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "parent")
	private List<QuestionType> children = new ArrayList<QuestionType>();
	
	@Transient
	private Integer size;
	
	public Integer getSize() {
		return this.getChildren().size();
	}
	/** 增加子集**/
	public void addChild(QuestionType type){
		this.children.add(type);
		type.parent=this;
	}
	public QuestionType(){
		super();
	}
	
	public QuestionType(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public QuestionType(String name) {
		super();
		this.name = name;
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

	public QuestionType getParent() {
		return parent;
	}
	public void setParent(QuestionType parent) {
		this.parent = parent;
	}
	
	public List<QuestionType> getChildren() {
		return children;
	}
	public void setChildren(List<QuestionType> children) {
		this.children = children;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		QuestionType other = (QuestionType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
