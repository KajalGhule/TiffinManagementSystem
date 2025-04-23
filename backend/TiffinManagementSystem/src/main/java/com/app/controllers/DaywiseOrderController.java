package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.DispatchOrderDTO;
import com.app.dtos.OrderTiffinDetailsDto;
import com.app.dtos.Response;
import com.app.services.dayWiseOrderService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/daywiseOrder")
public class DaywiseOrderController {

	@Autowired
	private dayWiseOrderService daywiseorderservice;

	@GetMapping("/countpending")
	public ResponseEntity<?> getCountPending(){
		System.out.println("inside the count of pending");
		
		List<OrderTiffinDetailsDto> orderList=daywiseorderservice.countPending();
		System.out.println(orderList);
		return Response.success(orderList);
	}
	

	
}
