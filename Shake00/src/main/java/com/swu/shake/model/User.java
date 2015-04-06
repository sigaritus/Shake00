package com.swu.shake.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//实体类，注解
@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "uid",nullable=false)
	private String uid;
	/** 姓名 */
	@Column(name = "name",nullable=false)
	private String name;
	/** 密码 */
	@Column(name = "password",nullable=false)
	private String password;
	/** 性别 */
	@Column(name = "sex",nullable=false)
	private String sex;
	/** 电话 */
	@Column(name = "phone",nullable=false)
	private Integer phone;
	/** OICQ */
	@Column(name = "QQ",nullable=false)
	private Integer QQ;
	/** 联系地址 */
	@Column(name = "addr",nullable=false)
	private String addr;
	/** 邮箱 */
	@Column(name = "email",nullable=false)
	private String email;
	@Column(name = "regDate",nullable=false)
	private Date regDate;
	@Column(name = "IP",nullable=false)
	private String IP;

	// 设置唯一主键，自增长
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Integer getQQ() {
		return QQ;
	}

	public void setQQ(Integer qQ) {
		QQ = qQ;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}
	
}
