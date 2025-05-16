package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.Response;
import com.app.dtos.UserDto;
import com.app.services.UserService;
import com.app.services.dayWiseOrderService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/deliveryBoy")
public class DeliveryBoyController {

	@Autowired
	private dayWiseOrderService daywiseOrderService;

	@Autowired
	private UserService userservice;
	
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<?> getAllTodaysDeliveryDeliveryBoy(@PathVariable("id") int id) {
		System.out.println("userId  " + id);
		System.out.println("----------");
		return Response.success(daywiseOrderService.getDeliveryDetailsforDeliveryBoy(id));
	}
	
	@PostMapping("/Delivered")
	public ResponseEntity<?> makeitDelivered(@RequestBody ObjectNode objectNode) {
		int do_id = Integer.parseInt(objectNode.get("do_id").asText());

		return Response.success(daywiseOrderService.DispatchedToDelivered(do_id));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getDeliveryBoy(@PathVariable int id){
		
	return Response.success(userservice.findUserById(id));
	}
	
	@PutMapping("/editDeliveryBoy/{id}")
	public ResponseEntity<?> editDeliveryBoy(@PathVariable int id,@RequestBody UserDto userdto){
		System.out.println("--------------");
		return Response.success(userservice.editUser(id, userdto));
	}
}
