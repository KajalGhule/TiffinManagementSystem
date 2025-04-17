package com.annapurna.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="t_user_address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"user","deliveryAddress"})
public class UserAddress {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="address_id")
	private int addressId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="address_line1")
	private String addressLine;
	
	
	@OneToOne(mappedBy="userAddress",fetch = FetchType.LAZY)
	private User user;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="location_id")
	private DeliveryAddress deliveryAddress;

}
