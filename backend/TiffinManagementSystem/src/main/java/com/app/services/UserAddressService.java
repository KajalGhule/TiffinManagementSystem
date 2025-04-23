package com.app.services;

import java.util.Collections;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserAddressDao;
import com.app.dao.UserDao;
import com.app.dtos.DtoEntityConverter;
import com.app.dtos.UserAddressDTo;
import com.app.pojos.User;
import com.app.pojos.UserAddress;


@Transactional
@Service
public class UserAddressService {

	@Autowired
	private UserAddressDao useraddressdao;
	
	@Autowired
	private DtoEntityConverter converter;
	
	@Autowired
	private UserDao userdao;
	
	public UserAddressDTo findByUserId(int userId) {
		
		UserAddress userAddress =useraddressdao.findByUserId(userId);
		if(userAddress==null)return null;
		
		return converter.toUserAddressDto(userAddress);
	}
	
	public Map<String,Integer> addUserAddress(UserAddressDTo dto){
	
		UserAddress entity=converter.toUserAddress(dto);
		entity=useraddressdao.save(entity);
		User u=userdao.findByUserId(dto.getUserId());
		u.setUserAddress(entity);
		return Collections.singletonMap("InsertedId", entity.getAddressId());
		
	}
}
