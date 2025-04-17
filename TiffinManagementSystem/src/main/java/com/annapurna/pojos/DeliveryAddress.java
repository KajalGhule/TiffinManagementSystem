package com.annapurna.pojos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="t_delivery_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeliveryAddress {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="location_id")
	private int locationId;
	
	@Column(name="delivery_area")
	private String deliveryArea;
	
	@Column(name="city")
	private String city;
	
	@Column(name="pincode")
	private int pincode;
	
	@OneToMany(mappedBy = "deliveryAddress")
	List<UserAddress> userAddresses;
}
