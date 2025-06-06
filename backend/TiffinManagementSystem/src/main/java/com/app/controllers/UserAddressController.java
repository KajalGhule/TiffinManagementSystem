package com.app.controllers;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.Response;
import com.app.dtos.UserAddressDTo;
import com.app.services.UserAddressService;

@CrossOrigin(origins = "*")
@RestController
public class UserAddressController {

	@Autowired
	UserAddressService userAddressService;

	@GetMapping("/user/userAddress/{id}")
	public ResponseEntity<?> displayUserAddressByUserId(@PathVariable("id") int id) {
		System.out.println(id);
		UserAddressDTo userAddressDto = userAddressService.findByUserId(id);
		if (userAddressDto == null)
			return Response.error("Please add Address");
		return Response.success(userAddressDto);
	}
	
	@PostMapping("/user/userAddress/add")
	public ResponseEntity<?> addUserAddress(@RequestBody UserAddressDTo dto) {
		System.out.println(dto);
		
		Map<String, Integer> result = userAddressService.addUserAddress(dto);
		return Response.success(result);
	}

}
