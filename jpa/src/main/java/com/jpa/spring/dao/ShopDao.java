package com.jpa.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.jpa.spring.shop.entity.Shop;

/**
 * 
 * desc:   TODO
 * @author xuelin
 * @date   Sep 13, 2015
 */
@Repository
public class ShopDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Shop shop){
		System.out.println("ShopDao-entityManager: " + entityManager);
		entityManager.persist(shop);
	}
	
}
