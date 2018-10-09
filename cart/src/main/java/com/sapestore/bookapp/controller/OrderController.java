package com.sapestore.bookapp.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapestore.bookapp.exception.OrderNotFoundException;
import com.sapestore.bookapp.model.CartInfo;
import com.sapestore.bookapp.model.CartItems;
import com.sapestore.bookapp.model.OrderInfo;
import com.sapestore.bookapp.model.OrderItemInfo;
import com.sapestore.bookapp.service.ICartService;
import com.sapestore.bookapp.service.IOrderService;

@RestController
public class OrderController {

	private Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	IOrderService iOrderService;

	@Autowired
	ICartService iCartService;

	public OrderInfo createOrder(Integer shippingAddressId, Integer cartId, Integer userId) {

		OrderInfo orderInfo = new OrderInfo();
		try {
		CartInfo cartInfo = iCartService.getCart(userId);
		
		orderInfo.setOrderQuantity(cartInfo.getQuantity());
		orderInfo.setOrderStatus("Ordered");
		orderInfo.setShippingAddressId(shippingAddressId);
		orderInfo.setTotalPayment(cartInfo.getCartPrice());
		orderInfo.setDeliveryDate(new Timestamp(System.currentTimeMillis()));
		orderInfo.setDispatchDate(new Timestamp(System.currentTimeMillis()));
		orderInfo.setOrderDate(new Timestamp(System.currentTimeMillis()));
		orderInfo.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		orderInfo.setUserId(cartInfo.getUserId());
		iOrderService.createOrder(orderInfo);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
		}
		return orderInfo;

	}

	@RequestMapping("/add-to-orders/{userId}/{shippingAddressId}/{mode}")
	public OrderInfo addOrders(@PathVariable("userId") Integer userId,
			@PathVariable("shippingAddressId") Integer shippingAddressId, @PathVariable("mode") String mode) {

		try {
		List<CartItems> cartList = iCartService.getCart(userId).getCartItems();
		CartInfo cartInfo = iCartService.getCart(userId);
		OrderInfo orderInfo = createOrder(shippingAddressId, cartInfo.getCartId(), userId);

		for (CartItems cartItems : cartList) {

			OrderItemInfo orderItemInfo = new OrderItemInfo();
			orderItemInfo.setOrderInfo(orderInfo);
			orderItemInfo.setOrderItemPrice(cartItems.getCartItemPrice());
			orderItemInfo.setOrderItemQuantity(cartItems.getCartItemQuantity());
			orderItemInfo.setIsbn(cartItems.getIsbn());
			orderItemInfo.setOrderedDate(new Timestamp(System.currentTimeMillis()));
			orderItemInfo.setDeliveredDate(null);
			orderItemInfo.setDispatchedDate(null);
			orderItemInfo.setStatus("Ordered");
			orderItemInfo.setModeOfPayment(mode);
			if(mode.equalsIgnoreCase("cod"))
			{
				orderItemInfo.setPaymentReceived(false);
			}
			else
			{
				orderItemInfo.setPaymentReceived(true);
			}
			iOrderService.addOrders(orderItemInfo);
		}
		return orderInfo;
		}
		catch(Exception e)
		{
			
			logger.info(e.getMessage());
			return null;
		}
		
		

	}

	@GetMapping("/my-orders/{userId}")
	public List<OrderInfo> myOrders(@PathVariable("userId") Integer userId) {
		try {
		
			return  iOrderService.getByUserId(userId);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
			return null;
		}
		

	}

	@GetMapping("/latestOrder/{userId}")
	public List<OrderItemInfo> latestOrder(@PathVariable("userId") Integer userId) {
		try {
		List<OrderInfo> orders = iOrderService.getByUserId(userId);
		List<Integer> orderArray = new ArrayList<>();
		for (OrderInfo order : orders) {

			Integer orderid = order.getOrderId();
			orderArray.add(orderid);
		}

		Integer orderId = orderArray.get(orderArray.size() - 1);
		return iOrderService.getOrder(orderId).getOrderItems();
		}catch(Exception e)
		{
			logger.info(e.getMessage());
			return null;
		}

	}

	@GetMapping("/get-all-orderItems/{orderId}")
	public List<OrderItemInfo> orderItemsByOrderId(@PathVariable("orderId") Integer orderId) {
		try {
		return iOrderService.getOrder(orderId).getOrderItems();
		}catch(Exception e)
		{
			logger.info(e.getMessage());
			return null;
		}
	}

	@GetMapping("/get-order-tracking/{orderId}")
	public OrderInfo getOrderTracking(@PathVariable("orderId") Integer orderId) {
		try {
		return iOrderService.getOrder(orderId);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
			return null;
		}

	} 
	@GetMapping("/lastOrder")
	public List<OrderItemInfo> latestOrder() {
		
		try {
		List<OrderInfo> orders = iOrderService.allOrders();
		List<Integer> orderArray = new ArrayList<>();
		for (OrderInfo order : orders) {

			Integer orderid = order.getOrderId();
			orderArray.add(orderid);
		}

		Integer orderId = orderArray.get(orderArray.size() - 1);
		return iOrderService.getOrder(orderId).getOrderItems();
		}catch(Exception e)
		{
			logger.info(e.getMessage());
			return null;
		}

	}
	
	@GetMapping("/status-by-orderId/{userId}/{orderId}")
	public OrderInfo statusByorderId(@PathVariable("userId") Integer userId,@PathVariable("orderId") Integer orderId)
	{
		try {
			return iOrderService.getStatusByUserId(userId, orderId);
		} catch (OrderNotFoundException e) {
			logger.info(e.getMessage());
			return null;
		}
	} 
	
	@GetMapping("/all-orders")
	public List<OrderInfo> allOrders()
	{
		try {
		return iOrderService.allOrders();
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
			return null;
		}
	}

	@GetMapping("/my-orders-status/{userId}")
	public List<OrderInfo> myOrdersbystatus(@PathVariable("userId") Integer userId) {
		
		String orderStatus = "Delivered";
		try {
			return iOrderService.findAllByStatus(userId, orderStatus);
		}
		catch(OrderNotFoundException e)
		{
			logger.info(e.getMessage());
			return null;
		}
		

	}
	
	@GetMapping("/find-all-by-status")
	public List<OrderItemInfo> findAllByStatus(String orderStatus) {
		orderStatus = "ORDERED";
		try {
		List<OrderInfo> orderInfo = iOrderService.findAllByStatus(orderStatus);
		List<OrderItemInfo> orderItemInfo2 = new ArrayList<OrderItemInfo>();
		for (OrderInfo orderInfo1 : orderInfo) {
			List<OrderItemInfo> orderItemInfo = orderInfo1.getOrderItems();
			for (OrderItemInfo orderItemInfo3 : orderItemInfo) {
				orderItemInfo2.add(orderItemInfo3);
			}
		}
		return orderItemInfo2;
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
			return null;
		}
	}
	
		
	@GetMapping(value="/update-order-delivered/{orderItemId}")
	public Boolean updateOrderDelivered(@PathVariable("orderItemId")Integer orderItemId)
	{
		String status="Delivered";
		try {
		OrderItemInfo orderItemInfo = iOrderService.getOrderItemInfo(orderItemId);
		orderItemInfo.setStatus(status);
		
		orderItemInfo.setDeliveredDate(new Timestamp(System.currentTimeMillis()));
		iOrderService.updateOrderItemDelivered(orderItemInfo);
		
		return true;
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
			return false;
		}
      	
	}
	
	@GetMapping(value="/update-order-dispatched/{orderItemId}")
	public Boolean updateOrderDispatched(@PathVariable("orderItemId")Integer orderItemId)
	{
		String status="Dispatched";
		try {
		OrderItemInfo orderItemInfo = iOrderService.getOrderItemInfo(orderItemId);
		orderItemInfo.setStatus(status);
		
		orderItemInfo.setDispatchedDate(new Timestamp(System.currentTimeMillis()));
		iOrderService.updateOrderItemDelivered(orderItemInfo);
		
		return true;
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
			return false;
		}
      	

	}
	
	
    @GetMapping(value = "/get-order-dates/{startDate}/{endDate}")
    public List<OrderInfo> getOrderInfoList(@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate){
           
    	try {
           List<OrderInfo> completeListFromDB=iOrderService.allOrders();
           

           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");	
           List<OrderInfo> orderInfoList = null;
           Date startDateOj;
           Date endDateObj;
		
			startDateOj = dateFormat.parse(startDate);
			endDateObj = dateFormat.parse(endDate);
		
           orderInfoList = completeListFromDB.stream()               
             .filter(orderInfo -> ((Date)orderInfo.getOrderDate()).after(startDateOj) && ((Date)orderInfo.getOrderDate()).before(endDateObj))     
             .collect(Collectors.toList());  
           return orderInfoList;
			} 
			catch(Exception e)
			{
				logger.info(e.getMessage());
				return null;
			}
    }
	
    @GetMapping(value="/getAllOrderItems")
    public List<OrderItemInfo> allOrderItems()
    {
    	try {
    		List<OrderItemInfo> list= iOrderService.allOrderItems();
    		System.out.println(list);
    		return list;
    	}catch(Exception e)
    	{
    		logger.info(e.getMessage());
    		return null;
    	}
    }
   
}
