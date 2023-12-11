package com.wineshop.serviceinterface;

import java.util.List;

import com.wineshop.model.Admin;
import com.wineshop.model.Customer;
import com.wineshop.model.Product;

public interface AdminService {
	Admin saveAdmin(Admin admin);

	Admin loginAdmin(Admin admin);

	public List<Product> getAllProducts(long adminId);

	public List<Customer> getAllCustomers(long adminId);
}