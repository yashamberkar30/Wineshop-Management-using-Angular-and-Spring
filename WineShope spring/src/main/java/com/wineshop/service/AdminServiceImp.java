package com.wineshop.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wineshop.exception.ResourceNotFoundException;
import com.wineshop.model.Admin;
import com.wineshop.model.Customer;
import com.wineshop.model.Product;
import com.wineshop.repository.AdminRepository;
import com.wineshop.repository.CustomerRepository;
import com.wineshop.repository.ProductRepository;
import com.wineshop.serviceinterface.AdminService;



@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	public AdminServiceImp(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		System.out.println("admin register service" + admin);

		return adminRepository.save(admin);
	}

	@Override
	public Admin loginAdmin(Admin admin) {
		return this.adminRepository.findByAdminEmailIdAndAdminPassword(admin.adminEmailId, admin.adminPassword)
				.orElseThrow(() -> new ResourceNotFoundException("Admin ", "Id",
						admin.adminEmailId + "and password " + admin.adminPassword));
	}

	@Override
	public List<Product> getAllProducts(long adminId) {

		return productRepository.findAll();
	}

	@Override
	public List<Customer> getAllCustomers(long adminId) {
		return customerRepository.findAll();
	}

}