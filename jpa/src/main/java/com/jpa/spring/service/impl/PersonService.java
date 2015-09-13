package com.jpa.spring.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jpa.spring.dao.PersonDao;
import com.jpa.spring.entity.Person;

/**
 * 
 * desc:   TODO
 * @author xuelin
 * @date   Sep 13, 2015
 */
@Service
public class PersonService {
	@Resource
	private PersonDao personDao;
	
	public void save(Person p1, Person p2){
		personDao.save(p1);
		
		int n = 10 / 0;
		
		personDao.save(p2);
	}
	
}
