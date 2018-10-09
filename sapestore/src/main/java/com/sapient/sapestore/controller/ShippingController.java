package com.sapient.sapestore.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.sapient.sapestore.model.Customer;
import com.sapient.sapestore.model.ShippingAddress;

@Controller
public class ShippingController {
	
	private Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private	RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
		
	private final String cartServiceName = "cart-service";
	
	private URI getServiceURL(String service) {
		List<ServiceInstance> list = discoveryClient.getInstances(service);
		if (list != null && list.size() > 0)
			return list.get(0).getUri();
		return null;
	}
	
	@GetMapping("/shipping")
	public String shipping()
	{
		return "shipping";
	}
	 
	@RequestMapping(value="/summary")
	public String addShippingAddress(ShippingAddress shippingAddress, HttpSession session,ModelMap model, BindingResult result)
	{
		
		try {
		Customer customer = (Customer) session.getAttribute("customer");
		shippingAddress.setUserId(customer.getUserId());
		String uri = getServiceURL(cartServiceName) +"/shipping-address";
		shippingAddress = restTemplate.postForObject(uri,shippingAddress, ShippingAddress.class);
		model.addAttribute("shippingAddress", shippingAddress);
		session.setAttribute("shippingAddress", shippingAddress);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
		}
		return "orders";
		
	}
	
	

}
