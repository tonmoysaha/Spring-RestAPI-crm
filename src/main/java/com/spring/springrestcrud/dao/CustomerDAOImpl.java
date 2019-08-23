package com.spring.springrestcrud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.springrestcrud.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> theCustomers = session.createQuery("from Customer order by lastName", Customer.class);
		return theCustomers.getResultList();
	}

	@Override
	public void saceCustomer(Customer theCustomer) {
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
