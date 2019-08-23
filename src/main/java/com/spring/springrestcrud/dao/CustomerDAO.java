package com.spring.springrestcrud.dao;

import java.util.List;

import com.spring.springrestcrud.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int customerId);

	public void deleteCustomer(int customerId);

}
