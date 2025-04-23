package com.app.dtos;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.app.pojos.DayWiseOrder;
import com.app.pojos.DeliveryAddress;
import com.app.pojos.Order;
import com.app.pojos.Payment;
import com.app.pojos.TiffinDetails;
import com.app.pojos.User;
import com.app.pojos.UserAddress;




@Component
public class DtoEntityConverter {

	
	
	public User UserDtotoUser(UserDto userdto) {
		User user = new User();
		user.setAadharNo(userdto.getAadharNo());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setPhone(userdto.getPhone());
		user.setRole(userdto.getRole());
		user.setUserName(userdto.getUserName());
		return user;
	}
	
	
	public TiffinDetailDto TiffinDetailstoTiffinDetailDto(TiffinDetails tDetails) {
		
		TiffinDetailDto tiffindetaildto=new  TiffinDetailDto();
		tiffindetaildto.setTiffinId(tDetails.getTiffinId());
		tiffindetaildto.setTiffinName(tDetails.getTiffinName());
		tiffindetaildto.setTiffinImage(tDetails.getTiffinImage());
		tiffindetaildto.setTiffinPrice(tDetails.getTiffinPrice());
		tiffindetaildto.setDescription(tDetails.getDescription());
		return tiffindetaildto;

	}
	
	public DayWiseOrderDto toDayWiseOrderDto(DayWiseOrder entity) {
	
		DayWiseOrderDto dto=new DayWiseOrderDto();
		dto.setDoId(entity.getDoId());
		dto.setOrderId(entity.getOrder().getOrderId());
		dto.setDate(entity.getDate());
		dto.setRequirement(entity.getRequirenment());
		dto.setStatus(entity.getStatus());
		return dto;
		
	}
	
	public UserDto usertoUserDto(User user) {
		
		UserDto userdto=new UserDto();
		userdto.setUserId(user.getUserId());
		userdto.setUserName(user.getUserName());
		userdto.setEmail(user.getEmail());
		userdto.setPassword(user.getPassword());
		userdto.setPhone(user.getPhone());
		userdto.setRole(user.getRole());
		userdto.setAadharNo(user.getAadharNo());
		
		return userdto;
	}
	
	public TiffinDetails toTiffinDetails(TiffinFormDto tiffinformdto) {
		TiffinDetails tiffin=new TiffinDetails();
		System.out.println(tiffinformdto.toString()+""+tiffin);
		BeanUtils.copyProperties(tiffinformdto, tiffin,"thumbnail");
		if(tiffinformdto.getTiffinImage()!=null) {
			tiffin.setTiffinImage(tiffinformdto.getTiffinImage().getOriginalFilename());
		}
		return tiffin;
	}
	
	
	public UserAddressDTo toUserAddressDto(UserAddress entity) {
		UserAddressDTo dto=new UserAddressDTo();
		dto.setAddressId(entity.getAddressId());
		dto.setAddressLine(entity.getAddressLine());
		dto.setLocationId(entity.getDeliveryAddress().getLocationId());
		dto.setUserId(entity.getUserId());
		return dto;
	}
	
	public UserAddress toUserAddress(UserAddressDTo dto) {
		UserAddress entity=new UserAddress();
		entity.setAddressId(dto.getAddressId());
		entity.setAddressLine(dto.getAddressLine());
		entity.setUserId(dto.getUserId());
		DeliveryAddress del=new DeliveryAddress();
		
		del.setLocationId(dto.getLocationId());
		
		entity.setDeliveryAddress(del);
		return entity;
	}
	
	public DeliveryAddressDto toDeliveryAddressDto(DeliveryAddress entity) {
		DeliveryAddressDto dto = new DeliveryAddressDto();
		dto.setLocationId(entity.getLocationId());
		dto.setDeliveryArea(entity.getDeliveryArea());
		dto.setCity(entity.getCity());
		dto.setPinCode(entity.getPincode());
		return dto;
	}
	
	
	public DeliveryAddress toDeliveryAddress(DeliveryAddressDto dto) {
		DeliveryAddress entity = new DeliveryAddress();
		entity.setLocationId(dto.getLocationId());
		entity.setDeliveryArea(dto.getDeliveryArea());
		entity.setCity(dto.getCity());
		entity.setPincode(dto.getPinCode());
		return entity;
	}

	public OrderDto toOrderDto(Order entity) {
		OrderDto dto = new OrderDto();
		dto.setOrderId(entity.getOrderId());
	//	dto.setUserId(entity.getUser().getUserId());
		dto.setStartDate(entity.getStartDate());
		dto.setEndDate(entity.getEndDate());
		dto.setTotalDays(entity.getTotalDays());
		dto.setTotalAmount(entity.getTotalAmount());
		dto.setTiffinId(entity.getTiffindetails().getTiffinId());
		return dto;
	}

	public Order userOrderToOrder(OrderDto orderdto) {
		Order order = new Order();
		order.setStartDate(orderdto.getStartDate());
		order.setEndDate(orderdto.getEndDate());
		order.setTotalAmount(orderdto.getTotalAmount());
//		order.setOrderId(userdto.getOrder_id());
		order.setUser(new User(orderdto.getUserId()));
		order.setTotalDays(orderdto.getTotalDays());
		order.setTiffindetails(new TiffinDetails(orderdto.getTiffinId()));
		return order;
	}
	
	public UserDto toUserDto(User entity) {
		UserDto dto = new UserDto();
		dto.setUserId(entity.getUserId());
		dto.setUserName(entity.getUserName());
		dto.setEmail(entity.getEmail());
		dto.setPassword(entity.getPassword());
		dto.setAadharNo(entity.getAadharNo());
		dto.setPhone(entity.getPhone());
		dto.setRole(entity.getRole());
		return dto;
	}
	
	
	public PaymentDto toPaymentDto(Payment entity) {
		PaymentDto dto = new PaymentDto();
		dto.setTransactionId(entity.getTransactionId());
		dto.setOrderId(entity.getOrderId());
		dto.setPaymentStatus(entity.getPaymentStatus());
		dto.setPaymentTime(entity.getPaymentTime());
		dto.setPaymentType(entity.getPaymentType());
		dto.setTotalPayment(entity.getTotalPayment());
		return dto;
	}
}
