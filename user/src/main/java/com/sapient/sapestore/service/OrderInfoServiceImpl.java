package com.sapient.sapestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.sapestore.dao.OrderInfoRepository;
import com.sapient.sapestore.exception.OrderNotFoundException;
import com.sapient.sapestore.model.OrderInfo;

@Service
public class OrderInfoServiceImpl implements OrderInfoService{

	@Autowired
	OrderInfoRepository orderInfoRepository;
	
	@Override
	public OrderInfo getStatusByUserId(Integer userId,Integer orderId) throws OrderNotFoundException{
		// TODO Auto-generated method stub
		try {
			OrderInfo orderInfo= orderInfoRepository.findById(orderId).get();
			
			if(orderInfo==null) {
				throw new OrderNotFoundException("No order found for "+orderId);
			}
			else {
				if(orderInfo.getUserId()!=userId)
				{
					throw new OrderNotFoundException("Your provided a wrong userId");
				}
				return orderInfo;
			}
		}catch(Exception e)
		{
			throw new OrderNotFoundException(e.getMessage());
		}

	}

	@Override
	public List<OrderInfo> getOrderItems(Integer orderId) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	

}
