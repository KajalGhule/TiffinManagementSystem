package com.annapurna.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.annapurna.dao.UserDao;
import com.annapurna.dtos.DtoEntityConverter;
import com.annapurna.dtos.UserDto;
import com.annapurna.pojos.User;

@Service
public class UserService {
	
//	@Autowired
//	private UserDto userDto;

	@Autowired
	private PasswordEncoder passwordencoder;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DtoEntityConverter converter;
	
	public User addUser(UserDto userDto) {
		String rawpassword = userDto.getPassword();
		System.out.println(rawpassword);
		String encrpassword = passwordencoder.encode(rawpassword);
		userDto.setPassword(encrpassword);
		User newUser = userDao.save(converter.UserDtotoUser(userDto));
		return newUser;
	}
}
