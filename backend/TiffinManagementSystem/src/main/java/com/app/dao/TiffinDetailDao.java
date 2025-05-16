package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.TiffinDetails;

public interface TiffinDetailDao extends JpaRepository<TiffinDetails, Integer>{

	TiffinDetails findByTiffinId(int tiffinId);
	
	List<TiffinDetails> findAll();
}
