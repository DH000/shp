package com.jpa.spring.shop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jpa.spring.entity.Person;

@Entity
@Table(name = "JPA_SHOP")
public class Shop implements Serializable {
	
	/**
	 * desc: TODO
	 */
	private static final long serialVersionUID = 1638482588871367210L;
	
	private Integer id;
	private String name;
	private Person person;
	
	public Shop() {
		super();
	}

	public Shop(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue
	@Column(name = "ID")
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSION_ID")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + "]";
	}
	
}
