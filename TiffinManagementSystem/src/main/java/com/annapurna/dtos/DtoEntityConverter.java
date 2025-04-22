package com.annapurna.dtos;

import org.springframework.stereotype.Component;

import com.annapurna.pojos.User;

@Component
public class DtoEntityConverter {
	
	public User UserDtotoUser(UserDto userdto) {
		User user = new User();
		user.setAadharNo(userdto.getAadharNo());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setPhone(userdto.getPhone());
		user.setRole(userdto.getRole());
		user.setUserName(userdto.getUserName());
		return user;
	}
}
