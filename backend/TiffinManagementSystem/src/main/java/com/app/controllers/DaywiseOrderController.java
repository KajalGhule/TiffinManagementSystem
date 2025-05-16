package com.app.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	
	@GetMapping("/countDispatched")
	public ResponseEntity<?> getDispatched(){
		
		List<OrderTiffinDetailsDto> dispatchedList=daywiseorderservice.countDispatched();
		return Response.success(dispatchedList);
	}
	
	@GetMapping("/countDelivered")
	public ResponseEntity<?> getDelivered(){
		
		List<OrderTiffinDetailsDto> dispatchedList=daywiseorderservice.CountDelivered();
		return Response.success(dispatchedList);
	}
	
	@GetMapping("/todaysOrders")
	public ResponseEntity<?> getTodaysOrders(){
		System.out.println("---------------");
		
		try {
			return Response.success(daywiseorderservice.addDaywiseOrder());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/ListOfPendingOrders")
	public ResponseEntity<?> getListOfPendingOrders(){
		System.out.println("-------");
		return Response.success(daywiseorderservice.getAllOrders());
	}
	
	@PostMapping("/dispatchOrder")
	public ResponseEntity<?> dispatchOrders(@RequestBody DispatchOrderDTO object){
		System.out.println(object.getDoId()+" "+object.getUserId());
		
		return Response.success(daywiseorderservice.DispatchOrder(object.getDoId(), object.getUserId()));
		
	}
	
	@PostMapping("/ListOfDelivered")
	public ResponseEntity<?> getListOfDelivered(){
		
		return Response.success(daywiseorderservice.totaltodaysDeliveredOrders());
	}
	
	@GetMapping("/ListOfDispatched")
	public ResponseEntity<?> getListOfDispatchedOrders(){
		return Response.success(daywiseorderservice.totaltodaysDispatchedOrders());
	}
	
}
