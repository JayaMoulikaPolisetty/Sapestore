package com.sapient.sapestore.service;



import java.util.List;

import com.sapient.sapestore.model.OrderInfo;
public interface IOrderService {

	 
	

	public List<OrderInfo> getByUserId(Integer userId);
	
}
