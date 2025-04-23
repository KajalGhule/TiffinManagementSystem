package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Order;
import com.app.pojos.TiffinDetails;

public interface OrderDao extends JpaRepository<Order, Integer>{

	Order findByOrderId(int orderId);

	List<Order> findByTiffindetails(TiffinDetails tiffin);

}
