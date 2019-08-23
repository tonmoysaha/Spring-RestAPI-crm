package com.spring.springrestcrud.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springrestcrud.entity.Customer;
import com.spring.springrestcrud.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerservice;

	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerservice.getCustomers();
	}
}
