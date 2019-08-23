package com.spring.springrestcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.spring.springrestcrud.dao.CustomerDAO;
import com.spring.springrestcrud.entity.Customer;

@Service
public class CustomServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer getCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub

	}

}
