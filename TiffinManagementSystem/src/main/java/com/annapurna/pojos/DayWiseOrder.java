package com.annapurna.pojos;


import java.util.Date;
import java.util.Objects;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
