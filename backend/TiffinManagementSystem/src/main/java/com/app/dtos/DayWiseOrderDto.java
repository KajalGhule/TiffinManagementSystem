package com.app.dtos;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DayWiseOrderDto {

	private int doId;
	
	private int orderId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private int requirement;
	
	private String status;
	
	private int deliveryBoyId;
	
}
