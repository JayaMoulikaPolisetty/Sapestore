package com.sapestore.bookapp.service;

import java.util.List;
import com.sapestore.bookapp.exception.OrderNotFoundException;
import com.sapestore.bookapp.model.OrderInfo;
import com.sapestore.bookapp.model.OrderItemInfo;

public interface IOrderService {

	 
	public void addOrders(OrderItemInfo orderItemInfo);
	public List<OrderInfo> myOrders();
	public List<OrderInfo> allOrders();
	public OrderInfo createOrder(OrderInfo orderInfo);
	public List<OrderInfo>  getByUserId(Integer userId);
	public OrderInfo getOrder(Integer orderId);
	public OrderItemInfo getOrderItemInfo(Integer orderItemId);
	public OrderInfo getOrderTracking(Integer orderId);
	public void updateOrderDispatched(  OrderInfo orderInfo); 
	public void updateOrderDelivered(  OrderInfo orderInfo); 
	OrderInfo getStatusByUserId(Integer userId,Integer orderId) throws OrderNotFoundException;
	List<OrderInfo> findAllByStatus(Integer userId, String orderStatus) throws OrderNotFoundException;
	public List<OrderInfo> findAllByStatus(String orderStatus);
	public List<OrderInfo> getOrderList(String startDate, String endDate);
	public void updateOrderItemDelivered(OrderItemInfo orderItemInfo);
	public void updateOrderItemDispatched(OrderItemInfo orderItemInfo);
	public List<OrderItemInfo> allOrderItems();
	
}
