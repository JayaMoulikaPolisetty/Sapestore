package com.sapestore.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapestore.bookapp.exception.OrderNotFoundException;
import com.sapestore.bookapp.model.OrderInfo;
import com.sapestore.bookapp.model.OrderItemInfo;
import com.sapestore.bookapp.repository.IOrderInfoRepository;
import com.sapestore.bookapp.repository.IOrderItemInfoRepository;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderItemInfoRepository iOrderItemInfoRepository;

	@Autowired
	IOrderInfoRepository iOrderInfoRepository;

	@Override
	public void addOrders(OrderItemInfo orderItemInfo) {

		iOrderItemInfoRepository.save(orderItemInfo);

	}

	@Override
	public OrderInfo createOrder(OrderInfo orderInfo) {
		
		return iOrderInfoRepository.save(orderInfo);
	}

	@Override
	public List<OrderInfo> myOrders() {

		return iOrderInfoRepository.findAll();
	}

	@Override
	public List<OrderInfo> getByUserId(Integer userId) {

		return iOrderInfoRepository.findAllByUserId(userId);

	}

	@Override
	public OrderInfo getOrder(Integer orderId) {
		return iOrderInfoRepository.getOne(orderId);

	}

	@Override
	public OrderInfo getOrderTracking(Integer orderId) {
		return iOrderInfoRepository.getOne(orderId);
	}
	
	@Override
	public List<OrderInfo> allOrders() {
		return iOrderInfoRepository.findAll();
	}

	@Override
	public OrderInfo getStatusByUserId(Integer userId, Integer orderId) throws OrderNotFoundException {

		try {
			OrderInfo orderInfo = iOrderInfoRepository.findByUserIdAndOrderId(userId, orderId);

			return orderInfo;
		} catch (Exception e) {
			throw new OrderNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<OrderInfo> findAllByStatus(Integer userId, String orderStatus) throws OrderNotFoundException {
		return iOrderInfoRepository.findAllByUserIdAndOrderStatus(userId, orderStatus);
	}

	@Override
	public List<OrderInfo> findAllByStatus(String orderStatus) {
		return iOrderInfoRepository.findAllByOrderStatus(orderStatus);
	}

	@Override
	public void updateOrderDispatched(OrderInfo orderInfo) {

		iOrderInfoRepository.save(orderInfo);
	}

	@Override
	public void updateOrderDelivered(OrderInfo orderInfo) {

		iOrderInfoRepository.save(orderInfo);
	}

	@Override
	public List<OrderInfo> getOrderList(String startDate, String endDate) {
		 return iOrderInfoRepository.findAll();
	}

	@Override
	public OrderItemInfo getOrderItemInfo(Integer orderItemId) {
		return iOrderItemInfoRepository.getOne(orderItemId);
				
	}

	@Override
	public void updateOrderItemDelivered(OrderItemInfo orderItemInfo) {
		 iOrderItemInfoRepository.save(orderItemInfo);
	}

	@Override
	public void updateOrderItemDispatched(OrderItemInfo orderItemInfo) {
		 iOrderItemInfoRepository.save(orderItemInfo);
	}

	@Override
	public List<OrderItemInfo> allOrderItems() {
		return iOrderItemInfoRepository.findAll();
	}

	
}
