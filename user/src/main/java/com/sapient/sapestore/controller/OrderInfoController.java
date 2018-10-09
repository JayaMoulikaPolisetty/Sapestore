package com.sapient.sapestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.sapestore.exception.OrderNotFoundException;
import com.sapient.sapestore.model.OrderInfo;
import com.sapient.sapestore.service.OrderInfoServiceImpl;

@RestController
public class OrderInfoController {

	
	@Autowired
	OrderInfoServiceImpl orderInfoServiceImpl;
	
	@GetMapping("/status-by-orderId/{userId}/{orderId}")
	public OrderInfo statusByorderId(@PathVariable("userId") Integer userId,@PathVariable("orderId") Integer orderId)
	{
		try {
			return orderInfoServiceImpl.getStatusByUserId(userId, orderId);
		} catch (OrderNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
}
