package com.annapurna.pojos;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="t_payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="order")
public class Payment {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="transaction_id")
	private int transactionId;

	@Column(name="order_id")
	private int orderId;
	
	@Column(name="payment_type")
	private String paymentType;
	
	@Column(name="total_payment")
	private int totalPayment;
	
	@Column(name="payment_status")
	private String paymentStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="payment_time")
	private Date paymentTime;
	
	@OneToOne(mappedBy="payment",fetch = FetchType.LAZY)
	private Order order;
	
}
