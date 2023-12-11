package com.wineshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wineshop.model.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	public List<Payment> findByOrderId(long orderId);

	//public Payment findByOrder(Order order);
}