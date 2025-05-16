package com.app.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.dtos.DtoEntityConverter;
import com.app.dtos.UserDto;
import com.app.pojos.User;


@Transactional
@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordencoder;

	@Autowired
	private DtoEntityConverter Converter;
	
	public User AddUser(UserDto userdto) {
		String rawpassword = userdto.getPassword();
		System.out.println(rawpassword);
		String encrpassword = passwordencoder.encode(rawpassword);
		userdto.setPassword(encrpassword);
		User newUser = userDao.save(Converter.UserDtotoUser(userdto));
		return newUser;
	}
	
	public List<String> getUserRoles() {
		List<String> list = userDao.findDistinctRole();
		return list;
	}
	


	public User checkEmail(String email) {
		// TODO Auto-generated method stub
		User validuser=userDao.findByEmail(email);
		return validuser;
	}

	public User restPass(User u,String password) {
		// TODO Auto-generated method stub
		String encryptpass=passwordencoder.encode(password);
		System.out.println("inside userservice");
		System.out.println(u);
		u.setPassword(encryptpass);
		User persistentUser=userDao.save(u);
		return persistentUser;
	}
	
	public List<UserDto> getalldeliveryBoys(){
		
		System.out.println("inside of getalldeliveryBoys");
//		String role="ROLE_DELIVERYBOY";
		String role="DELIVERYBOY";
		
		List<User> user=userDao.findByRole(role);
		System.out.println("------------------");
		System.out.println(user);
		System.out.println("------------------");
		List<UserDto> userdto=new ArrayList<>();
		for(User u:user) {
			userdto.add(Converter.usertoUserDto(u));	
		}
				
		return userdto;
	} 
	
	public List<UserDto> getallcustomers(){
		
//		List<User> user=userDao.findByRole("ROLE_USER");
		List<User> user=userDao.findByRole("USER");
		List<UserDto> userdto=new ArrayList<>();
		
		for(User u:user) {
			userdto.add(Converter.usertoUserDto(u));
		}
		return userdto;
	}
	
	public String deleteCustomer(int id) {
		
		userDao.deleteById(id);;
		return "success";
	}
	
	
	public List<UserDto> getAllcustomers() {
		
		List<User> user=userDao.findByRole("ROLE_DELIVERYBOY");
		List<UserDto> userdto=new ArrayList<>();
		
		for(User u:user) {
			userdto.add(Converter.usertoUserDto(u));
		}
	
		return userdto;
	}
	
	public String deleteDeliveryBoy(int id) {
		User u=userDao.findByUserId(id);
		if(u!=null) {
			userDao.deleteById(id);
		return "success";
		}else {
			return "failure";
		}
	}
	
	public Map<String, Object> editUser(int userId, UserDto dto) {
		User user = userDao.findByUserId(userId);
		user.setUserName(dto.getUserName());
		user.setEmail(dto.getEmail());
		user.setPhone(dto.getPhone());
		user.setAadharNo(dto.getAadharNo());
		user = userDao.save(user);
		return Collections.singletonMap("userChanged", 1);
	}
	
	public UserDto findUserById(int userId) {
		User user = userDao.findByUserId(userId);
		return Converter.toUserDto(user);
	}
}
