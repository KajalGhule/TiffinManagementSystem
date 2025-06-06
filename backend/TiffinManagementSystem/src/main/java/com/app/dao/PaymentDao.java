package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Payment;

public interface PaymentDao extends JpaRepository<Payment, Integer>{

	Payment findByTransactionId(int transactionId);
}
