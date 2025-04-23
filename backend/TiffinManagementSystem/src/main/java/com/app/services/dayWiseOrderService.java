package com.app.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.OrderDao;
import com.app.dao.TiffinDetailDao;
import com.app.dao.UserAddressDao;
import com.app.dao.UserDao;
import com.app.dao.daywiseorderDao;
import com.app.dtos.AssignDeliveryBoy;
import com.app.dtos.DayWiseOrderDto;
import com.app.dtos.DtoEntityConverter;
import com.app.dtos.OrderTiffinDetailsDto;
import com.app.pojos.DayWiseOrder;
import com.app.pojos.Order;
import com.app.pojos.TiffinDetails;
import com.app.pojos.User;
import com.app.pojos.UserAddress;

@Service
@Transactional
public class dayWiseOrderService {

	@Autowired
	private daywiseorderDao daywiseorderdao;
	
	@Autowired
	private TiffinDetailDao tiffindetaildao;
	
	@Autowired
	private OrderDao orderdao;
	
	@Autowired
	private DtoEntityConverter converter;
	
	@Autowired
	private UserAddressDao useraddressdao;
	
	@Autowired 
	private UserDao userdao;
	
	
	
	
	public  List<OrderTiffinDetailsDto> countPending(){
		
		List<DayWiseOrder> daywiseorder=daywiseorderdao.findAll();
		HashMap<Integer, Integer> count=new HashMap<Integer, Integer>();
		System.out.println(daywiseorder);
		for(DayWiseOrder d : daywiseorder) {
			if(d.getStatus().equals("pending")) {
				Order o=d.getOrder();
				int tiffinId=o.getTiffindetails().getTiffinId();
				
				count.put(tiffinId, count.getOrDefault(tiffinId, 0)+1);
			}
		}
		List<OrderTiffinDetailsDto> list=new ArrayList<OrderTiffinDetailsDto>();
		
		for(Integer i : count.keySet()) {
			
			int c=count.get(i);
			TiffinDetails tiffindetails = tiffindetaildao.findByTiffinId(i);
			
			OrderTiffinDetailsDto ot=new OrderTiffinDetailsDto(tiffindetails.getTiffinName(),c);
			list.add(ot);
		}
		System.out.println(list);
		return list;
	}
	

	
	public List<OrderTiffinDetailsDto> countDispatched() {
		
		List<DayWiseOrder> daywiseorder=daywiseorderdao.findAll();
		HashMap<Integer, Integer> count=new HashMap<Integer, Integer>();
		System.out.println(daywiseorder);
		for(DayWiseOrder d : daywiseorder) {
			if(d.getStatus().equals("dispatched")) {
				Order o=d.getOrder();
				int tiffinId=o.getTiffindetails().getTiffinId();
				
				count.put(tiffinId, count.getOrDefault(tiffinId, 0)+1);
			}
		}
		List<OrderTiffinDetailsDto> list=new ArrayList<OrderTiffinDetailsDto>();
		
		for(Integer i : count.keySet()) {
			
			int c=count.get(i);
			TiffinDetails tiffindetails = tiffindetaildao.findByTiffinId(i);
			
			OrderTiffinDetailsDto ot=new OrderTiffinDetailsDto(tiffindetails.getTiffinName(),c);
			list.add(ot);
		}
		System.out.println(list);
		return list;
	}
	
	public List<OrderTiffinDetailsDto> CountDelivered(){
		List<DayWiseOrder> daywiseorder=daywiseorderdao.findAll();
		HashMap<Integer, Integer> count=new HashMap<Integer, Integer>();
		System.out.println(daywiseorder);
		for(DayWiseOrder d : daywiseorder) {
			if(d.getStatus().equals("delivered")) {
				Order o=d.getOrder();
				int tiffinId=o.getTiffindetails().getTiffinId();
				
				count.put(tiffinId, count.getOrDefault(tiffinId, 0)+1);
			}
		}
		List<OrderTiffinDetailsDto> list=new ArrayList<OrderTiffinDetailsDto>();
		
		for(Integer i : count.keySet()) {
			
			int c=count.get(i);
			TiffinDetails tiffindetails = tiffindetaildao.findByTiffinId(i);
			
			OrderTiffinDetailsDto ot=new OrderTiffinDetailsDto(tiffindetails.getTiffinName(),c);
			list.add(ot);
		}
		System.out.println(list);
		return list;
	}
	
	public List<DayWiseOrderDto> addDaywiseOrder() throws ParseException{
		List<Order> orders=orderdao.findAll();
		List<DayWiseOrderDto> daywiseorderdto=new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dateWithouttime=sdf.parse(sdf.format(new Date()));
		System.out.println(dateWithouttime);
		
		List<DayWiseOrder> oldDois=daywiseorderdao.findByDateLessThan(dateWithouttime);
		
		System.out.println("Before today DOI"+oldDois);
		System.out.println(oldDois.size());
		for(int i=0;i<oldDois.size();i++) {
			daywiseorderdao.deleteById(oldDois.get(i).getDoId());
		}
		//daywiseorderdao.deleteAll(oldDois);
		
		List<DayWiseOrder> findAll=daywiseorderdao.findAll();
		System.out.println("Todays old doi"+findAll);
		HashSet<DayWiseOrder> allDayWiseOrders=new HashSet<DayWiseOrder>(findAll);
		
		User user=userdao.findByUserId(1);
		for(Order o : orders) {
			Date date=new Date();
			
			System.out.println(date);
			if(!(o.getStartDate().compareTo(date)>1)) {
				if(o.getEndDate().compareTo(date)>=1) {
					DayWiseOrder dwo=new DayWiseOrder(date,1,"pending",o,user);
					if(!allDayWiseOrders.contains(dwo)) {
						dwo=daywiseorderdao.save(dwo);
						System.out.println("new DOI"+dwo);
						allDayWiseOrders.add(dwo);
					}
				}
			}
		}
		for(DayWiseOrder dayO:allDayWiseOrders) {
			
			daywiseorderdto.add(converter.toDayWiseOrderDto(dayO));
			
		}
		
		return daywiseorderdto;
	}
	
	
	public List<AssignDeliveryBoy> getAllOrders(){
		
		List<DayWiseOrder> daywiseorder=daywiseorderdao.findAll();
		System.out.println(daywiseorder);
		List<AssignDeliveryBoy> assignd=new ArrayList<AssignDeliveryBoy>();
		for(DayWiseOrder d:daywiseorder) {
			if(d.getStatus().equals("pending")) {
				System.out.println("yupp inside of getallorders");
				System.out.println(d.getOrder().getUser().getUserId()+" ---");
				UserAddress ud=useraddressdao.findByUserId(d.getOrder().getUser().getUserId());
				
				System.out.println(ud);
				AssignDeliveryBoy a=new AssignDeliveryBoy(d.getDoId(),
						d.getOrder().getUser().getUserName(),d.getOrder().getOrderId(),
						ud.getAddressLine(),ud.getDeliveryAddress().getDeliveryArea(),ud.getDeliveryAddress().getCity(),
						ud.getDeliveryAddress().getPincode());
				System.out.println(a.getDo_id());
				assignd.add(a);
			}
		}
		System.out.println(assignd);
		return assignd;
	}
	
	public List<AssignDeliveryBoy> totaltodayPendingOrderList(){
	    List<DayWiseOrder> daywiseorder=daywiseorderdao.findAll();	
	    List<AssignDeliveryBoy> assign=new ArrayList<>();
	    for(DayWiseOrder d:daywiseorder) {
	    	if(d.getStatus().equals("pending")) {
	    		UserAddress ud=useraddressdao.findByUserId(d.getOrder().getUser().getUserId());
	    		
	    		AssignDeliveryBoy a=new AssignDeliveryBoy(d.getDoId(),d.getOrder().getUser().getUserName(),
	    				d.getOrder().getOrderId(),ud.getAddressLine(),ud.getDeliveryAddress().getDeliveryArea()
	    				,ud.getDeliveryAddress().getCity(),ud.getDeliveryAddress().getPincode());
	    		System.out.println(a.getDo_id());
	    		assign.add(a);
	    	}

	    }
	    return assign;
	}
	
	public List<AssignDeliveryBoy> totaltodaysDeliveredOrders(){
	    List<DayWiseOrder> daywiseorder=daywiseorderdao.findAll();	
	    List<AssignDeliveryBoy> assign=new ArrayList<>();
	    for(DayWiseOrder d:daywiseorder) {
	    	if(d.getStatus().equals("delivered")) {
	    		UserAddress ud=useraddressdao.findByUserId(d.getOrder().getUser().getUserId());
	    		
	    		AssignDeliveryBoy a=new AssignDeliveryBoy(d.getDoId(),d.getOrder().getUser().getUserName(),
	    				d.getOrder().getOrderId(),ud.getAddressLine(),ud.getDeliveryAddress().getDeliveryArea()
	    				,ud.getDeliveryAddress().getCity(),ud.getDeliveryAddress().getPincode());
	    		System.out.println(a.getDo_id());
	    		assign.add(a);
	    	}

	    }
	    return assign;
	}
	

	public List<AssignDeliveryBoy> totaltodaysDispatchedOrders(){
	    List<DayWiseOrder> daywiseorder=daywiseorderdao.findAll();	
	    List<AssignDeliveryBoy> assign=new ArrayList<>();
	    for(DayWiseOrder d:daywiseorder) {
	    	if(d.getStatus().equals("dispatched")) {
	    		UserAddress ud=useraddressdao.findByUserId(d.getOrder().getUser().getUserId());
	    		
	    		AssignDeliveryBoy a=new AssignDeliveryBoy(d.getDoId(),d.getOrder().getUser().getUserName(),
	    				d.getOrder().getOrderId(),ud.getAddressLine(),ud.getDeliveryAddress().getDeliveryArea()
	    				,ud.getDeliveryAddress().getCity(),ud.getDeliveryAddress().getPincode());
	    		System.out.println(a.getDo_id());
	    		assign.add(a);
	    	}

	    }
	    return assign;
	}
	
	public String DispatchOrder(int do_id,int userId) {
		System.out.println("-----------Inside the DispatchOrder method --------");
		DayWiseOrder d=daywiseorderdao.findByDoId(do_id);
		System.out.println(d);
		d.setDeliveryBoy(userdao.findByUserId(userId));
		d.setStatus("dispatched");
		System.out.println(d);
		daywiseorderdao.save(d);
		return "successfully done";
	}
	
	public int DispatchedToDelivered(int do_id) {
		System.out.println("inside delivered");
		DayWiseOrder d = daywiseorderdao.findByDoId(do_id);
		d.setStatus("delivered");
		DayWiseOrder d1=daywiseorderdao.findByDoId(do_id);
		if(d1.getStatus()=="delivered") {
			FileOutputStream fileOS =null;
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy.HH:mm:ss");
			String timeStamp = df.format(new Date());
			String mydata="\n"+timeStamp+" Successfully delivered to userId-"+d1.getOrder().getUser().getUserId()+"  UserName="+d1.getOrder().getUser().getUserName()+" At "+d1.getOrder().getUser().getUserAddress();
			
			try {
				fileOS=new FileOutputStream(new File("log.txt"));
				byte[] byteArr=mydata.getBytes();
				fileOS.write(byteArr);
				fileOS.flush();
				System.out.println("successfully inserted");
				
			}catch(FileNotFoundException e) {
				System.out.println("File not Found");
			}catch (IOException e) {
				// TODO: handle exception
			}finally {
				try {
					fileOS.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		return 1;
	}
	
	public List<AssignDeliveryBoy> getDeliveryDetailsforDeliveryBoy(int userId) {
		List<DayWiseOrder> dayorders = daywiseorderdao.findAll();
		List<AssignDeliveryBoy> dblist = new ArrayList<AssignDeliveryBoy>();
		for (DayWiseOrder d : dayorders) {
			if (d.getDeliveryBoy()!=null && d.getDeliveryBoy().getUserId() == userId && d.getStatus().equals("dispatched")) {
				UserAddress ud = useraddressdao.findByUserId(d.getOrder().getUser().getUserId());

				AssignDeliveryBoy a = new AssignDeliveryBoy(d.getDoId(), d.getOrder().getUser().getUserName(),
						d.getOrder().getOrderId(), ud.getAddressLine(), ud.getDeliveryAddress().getDeliveryArea(),
						ud.getDeliveryAddress().getCity(), ud.getDeliveryAddress().getPincode());
				System.out.println(a.getDo_id());
				dblist.add(a);
			}
		}
		return dblist;

	}
}
