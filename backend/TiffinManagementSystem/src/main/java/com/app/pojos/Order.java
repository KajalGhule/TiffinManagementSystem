package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="t_orders")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="order_id")
	private int orderId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="total_days")
	private int totalDays;

	@Column(name="total_amount")
	private int totalAmount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tiffin_id")
	private TiffinDetails tiffindetails;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Payment payment;
	
	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TiffinDetails getTiffindetails() {
		return tiffindetails;
	}

	public void setTiffindetails(TiffinDetails tiffindetails) {
		this.tiffindetails = tiffindetails;
	}
	
	
		
}
