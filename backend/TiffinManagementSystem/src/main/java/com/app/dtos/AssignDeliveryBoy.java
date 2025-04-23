package com.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AssignDeliveryBoy {

	private int do_id;
	private String userName;
	private int OrderId;
	private String user_address;
	private String area;
	private String city;
	private int pincode;
	
}
