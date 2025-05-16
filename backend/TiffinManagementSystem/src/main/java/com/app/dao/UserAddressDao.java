package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.UserAddress;

public interface UserAddressDao extends JpaRepository<UserAddress, Integer>{

	UserAddress findByUserId(int userId);

}
