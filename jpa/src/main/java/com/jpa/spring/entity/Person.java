package com.jpa.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * desc: TODO
 * 
 * @author xuelin
 * @date Sep 13, 2015
 */
@Entity
@Table(name = "JPA_PERSION")
public class Person implements Serializable {
	
	/**
	 * desc: TODO
	 */
	private static final long serialVersionUID = -7608754740161771161L;
	
	private Integer id;
	private String name;
	private Short age;
	
	public Person() {
		super();
	}

	public Person(String name, Short age) {
		super();
		this.name = name;
		this.age = age;
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
	
	@Column(name = "AGE")
	public Short getAge() {
		return age;
	}
	
	public void setAge(Short age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
