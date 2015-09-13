package com.learn.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "JPA_ORDER")
public class Order implements Serializable {
	
	private static final long serialVersionUID = -3010341473492135942L;
	
	private Integer id;
	private String orderName;
	private Member member;
	
	public Order() {
		super();
	}

	public Order(String orderName) {
		super();
		this.orderName = orderName;
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
	
	@Column(name = "ORDER_NAME", length = 50)
	public String getOrderName() {
		return orderName;
	}
	
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBER_ID")
	public Member getMember() {
		return member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderName=" + orderName + ", member=" + member + "]";
	}
	
}
