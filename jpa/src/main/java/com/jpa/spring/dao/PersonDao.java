package com.jpa.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jpa.spring.entity.Person;

/**
 * 
 * desc:   TODO
 * @author xuelin
 * @date   Sep 13, 2015
 */
@Repository
public class PersonDao {
	
	// 不需要重新创建
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Person person){
		System.out.println("PersonDao-entityManager: " + entityManager);
		
		entityManager.persist(person);
	}
	
	public Person findByJpql(Integer id){
		Query query = entityManager.createQuery("from Person p where p.id = :id");
		query.setParameter("id", id);
		return (Person) query.getSingleResult();
	}
}
