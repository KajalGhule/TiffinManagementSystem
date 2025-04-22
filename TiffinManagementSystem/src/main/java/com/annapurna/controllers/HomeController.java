package com.annapurna.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.annapurna.dtos.Response;
import com.annapurna.dtos.UserDto;
import com.annapurna.pojos.User;
import com.annapurna.services.UserService;

@RestController
public class HomeController {
	@Autowired
	private UserService userService; 

	@Autowired(required = true)
	private ModelMapper mapper;
	
	@PostMapping("/singup")
	public ResponseEntity<?> singUp(@RequestBody UserDto userDto) {
		User persistentUser = userService.addUser(userDto);
		UserDto result = mapper.map(persistentUser, UserDto.class);
		if (result == null)
			return Response.error("Something wrong happened");
		return Response.success(result);
	}
}
