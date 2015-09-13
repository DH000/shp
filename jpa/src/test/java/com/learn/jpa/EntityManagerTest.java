package com.learn.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.learn.jpa.entity.Member;
import com.learn.jpa.entity.Order;

public class EntityManagerTest {
	private EntityManagerFactory factory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	@Test
	public void entityManagerTest(){
		// 创建EntityManagerFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
		
		// 创建EntityManager
		EntityManager entityManager = factory.createEntityManager();
		
		// 开启事务
		EntityTransaction tr = entityManager.getTransaction();
		tr.begin();
		
		// 持久化操作
		Member member = new Member("lin", "lin", "hhh", "example@163.com", "15989218145", "020-33647434");
		entityManager.persist(member);
		
		// 关闭事务
		tr.commit();
		
		// 关闭EntityManager
		entityManager.close();
		
		// 关闭EntityManagerFactory
		factory.close();
	}
	
	@Before
	public void init(){
		factory = Persistence.createEntityManagerFactory("jpa");
		entityManager = factory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	}
	
	@After
	public void destory(){
		if(null != entityTransaction){
			entityTransaction.commit();
		}
		if(null != entityManager){
			entityManager.close();
		}
		if(null != factory){
			factory.close();
		}
	}
	
	@Test
	public void testManyToOneSave(){
		Member member = new Member("xxx", "lin", "hhh", "lin@163.com", "15989218145", "020-33647434");
		Order order1 = new Order("O-1");
		Order order2 = new Order("O-2");
		
		order1.setMember(member);
		order2.setMember(member);
		
		entityManager.persist(order1);
		entityManager.persist(order2);
		
		entityManager.persist(member);
	}
	
	@Test
	public void testManyToOneFind(){
		Order ordr = entityManager.find(Order.class, 3);
		System.out.println(ordr);
	}
}








