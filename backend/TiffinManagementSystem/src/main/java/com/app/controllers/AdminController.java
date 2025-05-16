package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.Response;
import com.app.dtos.UserDto;
import com.app.services.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userservice;
	
	@GetMapping("/deliveryBoys")
	public ResponseEntity<?> findalldeliveryBoys(){
	System.out.println("get delivery Boy");
		List<UserDto> userdto=userservice.getalldeliveryBoys();
		
		return Response.success(userdto);
	}
	 
	@GetMapping("/CustomerList")
	public ResponseEntity<?> getAllcustomers(){
		
		return Response.success(userservice.getallcustomers());
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<?> deletetheCustomer (@PathVariable int id)
	{
		System.out.println("inside deletecustomer");
		System.out.println("id is "+id);
		
		return Response.success(userservice.deleteCustomer(id));
	}
	
	@GetMapping("/DeliveryBoys")
	public ResponseEntity<?> getDeliveryBoys(){
		System.out.println("inside getdeliveryBoys method");
		return Response.success(userservice.getalldeliveryBoys());
	}
	
	@DeleteMapping("/DeliveryBoys/Delete/{userid}")
	public ResponseEntity<?> deleteDeliveryBoy(@PathVariable int userid){
		System.out.println("inside deleteDeliveryBoy");
		System.out.println("id is "+userid);
		return Response.success(userservice.deleteDeliveryBoy(userid));
	}
	
}
