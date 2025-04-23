package com.app.pojos;

import java.util.Date;
import java.util.Objects;

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
@Table(name="t_daywise_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DayWiseOrder {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="do_id")
	private int doId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="order_id")
	private Order order;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	private Date date;

	
	@Column(name="requirenment")
	private int requirenment;
	
	@Column(name="status")
	private String status;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="delivery_boy_id")
	private User deliveryBoy;

	@Column(name="sesssion")
	private String session;

	public DayWiseOrder(Date date, int requirenment, String status,Order order, User deliveryBoy) {
		super();
		this.order = order;
		this.date = date;
		this.session="lunch";
		this.requirenment = requirenment;
		this.status = status;
		this.deliveryBoy = deliveryBoy;
	}


	@Override
	public int hashCode() {
		final int prime =31;
		int result=1;
		result=prime*result+((order==null)?0:order.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DayWiseOrder other = (DayWiseOrder) obj;
		if(order==null) {
			if(other.order!=null) {
				return false;
			}else if(!order.equals(other.order))
				return false;
		
		}
		return true;
	}
	
	
		

	
}
