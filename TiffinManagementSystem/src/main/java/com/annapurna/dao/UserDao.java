package com.annapurna.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annapurna.pojos.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
