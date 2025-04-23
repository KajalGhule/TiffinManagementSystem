package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="t_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString()
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="user_id")
	private int userId;
	
	@Column(name ="user_name")
	private String userName;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="password")
	private String password;
	
	@Column(name ="mobile_no")
	private String phone;

	@Column(name ="adhar_no")
	private String aadharNo;

	@Column(name="role")
	private String role;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userAddressId")
	private UserAddress userAddress;

	public User(int userId) {
		super();
		this.userId = userId;
	}
	
}
