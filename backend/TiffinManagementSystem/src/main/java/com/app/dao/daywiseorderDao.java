package com.app.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.DayWiseOrder;

public interface daywiseorderDao extends JpaRepository<DayWiseOrder, Integer>{

	List<DayWiseOrder> findByDateLessThan(Date date);
	
	DayWiseOrder findByDoId(int doId);
}
