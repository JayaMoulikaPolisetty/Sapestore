package com.sapient.sapestore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.sapestore.model.OrderInfo;
import com.sapient.sapestore.service.IOrderService;


@RestController
public class OrderController {

	@Autowired
	IOrderService iOrderService;

	

	

	@GetMapping("/get-all-orders/{userId}" )
	public List<OrderInfo> allOrdersByuserId(@PathVariable("userId") Integer userId) {
		List<OrderInfo> orders = iOrderService.getByUserId(userId);
		return orders;

	}
}
