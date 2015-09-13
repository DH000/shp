package com.learn.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JPA_MEMBER")
public class Member implements Serializable {
	
	private static final long serialVersionUID = 6021435461399274030L;
	
	private Integer id;
	/**
	 * 姓名
	 */
	private String name;
	private String nickname;
	private String password;
	private String email;
	private String mobile;
	/**
	 * 固话
	 */
	private String telephone;
	private Date registerTime;
	private Date loginTime;
	
	public Member() {
		super();
	}

	public Member(String name, String nickname, String password, String email, String mobile, String telephone) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.telephone = telephone;
		this.registerTime = new Date();
		this.loginTime = new Date();
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "NICKNAME")
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "MOBILE")
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Column(name = "TELEPHONE")
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Column(name = "REGISTER_TIME")
	public Date getRegisterTime() {
		return registerTime;
	}
	
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	
	@Column(name = "LOGIN_TIME")
	public Date getLoginTime() {
		return loginTime;
	}
	
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", nickname=" + nickname + ", password=" + password + ", email=" + email + ", mobile=" + mobile + ", telephone=" + telephone
				+ ", registerTime=" + registerTime + ", loginTime=" + loginTime + "]";
	}
	
}
