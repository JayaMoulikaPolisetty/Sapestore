package com.sapestore.bookapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sapestore.bookapp.model.ShippingAddress;
import com.sapestore.bookapp.service.IShippingAddress;

@RestController
public class ShippingAddressController {
	
	private Logger logger = LoggerFactory.getLogger(ShippingAddressController.class);
	
	@Autowired
	IShippingAddress iShippingAddress;
	
	
	@PostMapping(value="/shipping-address")
	public ShippingAddress addShippingAddresss(@RequestBody ShippingAddress shippingAddress)
	{
		try {
		return iShippingAddress.addShippingAddresss(shippingAddress);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
			return null;
		}
	} 
	

}
