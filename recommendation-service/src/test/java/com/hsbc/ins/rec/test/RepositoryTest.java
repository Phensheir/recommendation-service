package com.hsbc.ins.rec.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsbc.ins.rec.app.Application;
import com.hsbc.ins.rec.domain.CusFavourite;
import com.hsbc.ins.rec.domain.Customer;
import com.hsbc.ins.rec.domain.Order;
import com.hsbc.ins.rec.domain.Product;
import com.hsbc.ins.rec.persistence.CusFavouriteRepository;
import com.hsbc.ins.rec.persistence.CustomerRepository;
import com.hsbc.ins.rec.persistence.OrderRepository;
import com.hsbc.ins.rec.persistence.ProductRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RepositoryTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CusFavouriteRepository cusFavouriteRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void testGoods() throws JsonProcessingException {
		Long count = this.productRepository.count();
		Pageable pageable = new  PageRequest(1, 10);
		Page <Product> goods = this.productRepository.findAll(pageable);
		System.out.println("Total goods :" + count);
		System.out.println("Page : 1" + ", count:" + 10); 
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(objectMapper.writeValueAsString(goods.getContent()));
	}
	
	@Test
	public void testOrder() throws JsonProcessingException {
		Long count = this.orderRepository.count();
		Pageable pageable = new  PageRequest(1, 10);
		Page <Order> orders = this.orderRepository.findAll(pageable);
		System.out.println("Total goods :" + count);
		System.out.println("Page : 1" + ", count:" + 10); 
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(objectMapper.writeValueAsString(orders.getContent()));
	}
	
	@Test
	public void testCusFavourite() throws JsonProcessingException {
		Long count = this.orderRepository.count();
		Pageable pageable = new  PageRequest(1, 10);
		Page <CusFavourite> favouris = this.cusFavouriteRepository.findAll(pageable);
		System.out.println("Total goods :" + count);
		System.out.println("Page : 1" + ", count:" + 10); 
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(objectMapper.writeValueAsString(favouris.getContent()));
	}
	
	@Test
	public void testCustomer() throws JsonProcessingException {
		Long count = this.orderRepository.count();
		Pageable pageable = new  PageRequest(1, 10);
		Page <Customer> customers = this.customerRepository.findAll(pageable);
		System.out.println("Total goods :" + count);
		System.out.println("Page : 1" + ", count:" + 10); 
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(objectMapper.writeValueAsString(customers.getContent()));
	}
}
