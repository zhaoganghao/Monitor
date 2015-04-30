package cn.itcast.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User implements Serializable{
	private static final long serialVersionUID = -3877645730734457344L;
	@Id@GeneratedValue
	private Integer id;
	/** 用户名 **/
	@Column(unique=true,length=32,nullable=false)
	private String username;//只允许字母/数字/下划线
	/** 密码 **/
	@Column(length=32,nullable=false)
	private String password;//采用MD5加密
	/** 电子邮箱 **/
	@Column(length=30)
	private String email;
	/** 电话 **/
	@Column(length=15)
	private String phone;
	/** 注册时间 **/
	@Temporal(TemporalType.DATE)
	private Date regtime = new Date();
	/** 用户类型 1-->管理员，2--->普通用户**/
	
	private Integer type;
	public User(){
	}
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	public User(String username, String password, String email, String phone,
			Integer type) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.type = type;
	}
	public User(String username, String password, String email, String phone
			) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
