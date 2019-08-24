package com.spring.springrestcrud.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springrestcrud.entity.Customer;
import com.spring.springrestcrud.exceptionhandler.CustomNotFoundException;
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
	
	@GetMapping("/customers/{customerId}")
	public Customer getcustomer(@PathVariable int customerId) {
		Customer customer = customerservice.getCustomer(customerId);
		
		if (customer == null) {
			throw new CustomNotFoundException("the person with this id is invalid: "+customerId);
		}
		
		return customer;
		
	}
}
