package com.spring.springrestcrud.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);
		customerservice.saveCustomer(theCustomer);
		return theCustomer;
		
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerservice.saveCustomer(customer);
		return customer;
		
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId ) {
		Customer thCustomer =  customerservice.getCustomer(customerId);
		if (thCustomer == null) {
			throw new CustomNotFoundException("the person with this id is invalid: "+customerId);
		}
		customerservice.deleteCustomer(customerId);
		
		return "customerdeleted successfully: " + customerId;
	}
}
