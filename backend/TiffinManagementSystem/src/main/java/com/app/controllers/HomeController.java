package com.app.controllers;

import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.AuthResp;
import com.app.dtos.Credential;
import com.app.dtos.Response;
import com.app.dtos.UserDto;
import com.app.dtos.EmailDTO;
import com.app.jwt_utils.JwtUtils;
import com.app.pojos.User;
import com.app.services.EmailService;
import com.app.services.UserAddressService;
import com.app.services.UserService;



@CrossOrigin(origins = "*")
@RestController
public class HomeController {

	@Autowired
	UserAddressService userAddressService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private JwtUtils utils;

	@Autowired(required = true)
	private ModelMapper mapper;
	
	@PostMapping("/signin")
	public ResponseEntity<?> Signin(@RequestBody Credential cred)
	{
		System.out.println("-------------");
		// UserDto userDto = userService.findUserByEmailAndPassword(cred);
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(cred.getEmail(),
						cred.getPassword());
				System.out.println("AuthToken : " + authToken);
				try {
					// authenticate the credentials
					Authentication authenticatedDetails = manager.authenticate(authToken);
					System.out.println("Auth Token Again : " + authenticatedDetails);
					  List<? extends GrantedAuthority> authorities = (List<? extends GrantedAuthority>) authenticatedDetails.getAuthorities();
					System.out.println("ROle Home : "+authorities.get(0).getAuthority());
			
					return Response.success(new AuthResp("success", utils.generateJwtToken(authenticatedDetails),authorities.get(0).getAuthority()));
					// return Response.success(authenticatedDetails);
				} catch (Exception e) { // lab work : replace this by a method in global exc handler
					// send back err resp code
					System.out.println("err " + e);
					return Response.error(new AuthResp("error",null,null));
				}
	}

	@PostMapping("/signup")
	public ResponseEntity<?> Signup(@RequestBody UserDto userdto) {
		System.out.println("----------------------");
		User persistentUser = userService.AddUser(userdto);
		UserDto result = mapper.map(persistentUser, UserDto.class);
		if (result == null)
			return Response.error("Something wrong happened");
		return Response.success(result);
	}
	
	@GetMapping("/roles")
	public ResponseEntity<?> getAllRoles() {
		System.out.println("getamap");
		return Response.success(userService.getUserRoles());
	}
	
}
