package com.wineshop.serviceinterface;

import java.util.List;

import com.wineshop.model.Customer;

public interface CustomerService {
	Customer saveCustomer(Customer customer);

	Customer loginCustomer(Customer customer);

	Customer updateCustomer(Customer customer, long customerId);

	Customer getCustomerById(long customerId);

	List<Customer> getAllCustomers();

	Customer getCustomerByEmail(Customer customer);

	void deleteCustomer(long customerId);

}