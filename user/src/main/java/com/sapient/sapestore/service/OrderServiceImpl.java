package com.sapient.sapestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.sapestore.dao.IOrderInfoRepository;
import com.sapient.sapestore.model.OrderInfo;


@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	IOrderInfoRepository iOrderInfoRepository;

	@Override
	public List<OrderInfo> getByUserId(Integer userId) {

		return iOrderInfoRepository.findAllByUserId(userId);
	}
	
	
	

	
}
