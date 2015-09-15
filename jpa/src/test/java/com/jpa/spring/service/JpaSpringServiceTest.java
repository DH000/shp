package com.jpa.spring.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jpa.spring.entity.Person;
import com.jpa.spring.service.impl.PersonService;
import com.jpa.spring.service.impl.ShopService;
import com.jpa.spring.shop.entity.Shop;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JpaSpringServiceTest {
	@Resource
	private PersonService personService;
	
	@Resource
	private ShopService shopService;
	
	@Test
	public void testSave(){
		Person p1 = new Person("p1", (short)10);
		Person p2 = new Person("p2", (short)10);
		
		Shop shop1 = new Shop("shop1");
		Shop shop2 = new Shop("shop2");
		
		shop1.setPerson(p1);
		shop2.setPerson(p1);
		
		shop2.setPerson(p2);
		
		personService.save(p1, p2);
		
		shopService.save(shop1);
		shopService.save(shop2);
	}
	
	@Test
	public void testJpql(){
		personService.findByJpql(1);
	}
	
	/**
	 * 
	 * desc: 不在同一个session范围内无法实现懒加载 但spring提供了OpenEntityManagerInViewFilter<br/>
	 *  <filter>
	 *		<filter-name>openEntityManagerInViewFilter</filter-name>
	 *		<filter-class>org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter</filter-class>
	 *	</filter>
	 *	<filter-mapping>
	 *		<filter-name>openEntityManagerInViewFilter</filter-name>
	 *		<url-pattern>/*</url-pattern>
	 *	</filter-mapping>
	 * 
	 * 
	 * 
	 */
	@Test
	public void testFind(){
		Shop shop = shopService.find(2);
		System.out.println(shop);
		System.out.println(shop.getPerson());
	}
}
