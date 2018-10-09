package com.sapient.sapestore.controller;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.sapient.sapestore.model.Books;
import com.sapient.sapestore.model.CartInfo;
import com.sapient.sapestore.model.CartItems;
import com.sapient.sapestore.model.Customer;
import com.sapient.sapestore.model.OrderInfo;
import com.sapient.sapestore.model.OrderItemInfo;
import com.sapient.sapestore.model.ShippingAddress;

@Controller
public class OrderController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	private Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	
	private final String cartServiceName = "cart-service";
	private final String bookServiceName = "book-service";
	
	private URI getServiceURL(String service) {
		List<ServiceInstance> list = discoveryClient.getInstances(service);
		if (list != null && list.size() > 0)
			return list.get(0).getUri();
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/orderConfirmation")
	public String addToOrders(@RequestParam("mode")String mode, HttpSession session,ModelMap model)
	{
		logger.info("================OrderConfirmation================");
		try {
		Customer customer = (Customer) session.getAttribute("customer");
		
		ShippingAddress shippingAddress = (ShippingAddress) session.getAttribute("shippingAddress");
		
		String url = getServiceURL(cartServiceName)+"/add-to-orders/"+customer.getUserId()+"/"+shippingAddress.getShippingAddressId()+"/"+mode;
		OrderInfo orderInfo = restTemplate.getForObject(url, OrderInfo.class);
		
		String uri = getServiceURL(cartServiceName)+"/get-cart/"+customer.getUserId();
		CartInfo cartInfo = restTemplate.getForObject(uri, CartInfo.class);
		 uri = getServiceURL(cartServiceName) + "/get-all-cartitems/" + customer.getUserId();
		
		try {
			List<CartItems> cartItems = Arrays.asList(restTemplate.getForObject(uri, CartItems[].class));
			
		for(CartItems item : cartItems)
		{
			uri = getServiceURL(cartServiceName)+"/delete-cartitem/"+item.getCartItemId();
			restTemplate.getForObject(uri, String.class);
			uri = getServiceURL(bookServiceName)+"/books-by-ISBN/" + item.getIsbn();
			Books book = restTemplate.getForObject(uri, Books.class);
			book.setQuantity(book.getQuantity()-item.getCartItemQuantity());
			url = getServiceURL(bookServiceName)+"/update-book ";
			restTemplate.postForObject(url, book, String.class);
			
		}
		
		cartInfo.setQuantity(0);
		cartInfo.setCartPrice(0);
		cartInfo.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
		uri = getServiceURL(cartServiceName)+"/update-cart";
		restTemplate.postForObject(uri, cartInfo, String.class);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
		}
		model.addAttribute("orderInfo",orderInfo);
		url = getServiceURL(cartServiceName)+"/get-all-orderItems/"+orderInfo.getOrderId();
		List<OrderItemInfo> orderItems = restTemplate.getForObject(url, List.class);
		model.addAttribute("orderItemsList", orderItems);
		
		
		
		
		}
		catch(Exception e)
		
		{
			logger.info("Error in order confirmation");
		}
		return "acknowledgement";
	}

	@RequestMapping(value = "/myOrders/{userId}")
	public String myOrders(@PathVariable("userId") Integer userId, ModelMap model) {
		try {
			String uri = getServiceURL(cartServiceName) + "/my-orders/" + userId;
			@SuppressWarnings("unchecked")
			List<OrderInfo> orderInfo = restTemplate.getForObject(uri, List.class);
			model.addAttribute("orderInfo",orderInfo);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
		}
		return "orders";

	} 
	
	@SuppressWarnings("unchecked")
	@GetMapping(value="latestOrder/{userId}")
	public String LastOrder(@PathVariable("userId") Integer userId, ModelMap model)
	{
		try {
		String uri = getServiceURL(cartServiceName) + "/latestOrder/" + userId;
		List<OrderItemInfo> orderItems = restTemplate.getForObject(uri, List.class);
		model.addAttribute("orderItems", orderItems);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
		}
		return "dispatchList";
	}
	
	
	@RequestMapping(value="/payment")
	public String payment(HttpSession session)
	{
		return "payment";
	}
	

}
