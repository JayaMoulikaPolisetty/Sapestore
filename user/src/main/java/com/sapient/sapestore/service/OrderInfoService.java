package com.sapient.sapestore.service;


import java.util.List;

import com.sapient.sapestore.exception.OrderNotFoundException;
import com.sapient.sapestore.model.OrderInfo;

public interface OrderInfoService {

	OrderInfo getStatusByUserId(Integer userId,Integer orderId) throws OrderNotFoundException;
	List<OrderInfo> getOrderItems(Integer orderId);
}
