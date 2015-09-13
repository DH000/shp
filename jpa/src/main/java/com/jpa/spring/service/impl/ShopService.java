package com.jpa.spring.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jpa.spring.dao.ShopDao;
import com.jpa.spring.shop.entity.Shop;

/**
 * 
 * desc:   TODO
 * @author xuelin
 * @date   Sep 13, 2015
 */
@Service
public class ShopService {
	@Resource
	private ShopDao shopDao;
	
	public void save(Shop shop){
		shopDao.save(shop);
	}
	
	public Shop find(Integer id){
		return shopDao.find(id);
	}
	
}
