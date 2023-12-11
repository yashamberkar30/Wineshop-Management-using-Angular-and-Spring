package com.wineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wineshop.model.Cart;
import com.wineshop.model.Customer;



@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	void deleteCartByCustomer(Customer c);
}