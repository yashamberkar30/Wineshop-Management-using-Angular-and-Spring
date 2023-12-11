package com.wineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wineshop.model.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}


