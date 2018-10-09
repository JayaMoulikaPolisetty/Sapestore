package com.sapestore.bookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapestore.bookapp.model.ShippingAddress;
import com.sapestore.bookapp.repository.IShippingAddressRepository;

@Service
public class ShippingAddressImpl implements IShippingAddress{

	@Autowired
	IShippingAddressRepository iShippingAddressRepository;
	
	@Override
	public ShippingAddress addShippingAddresss(ShippingAddress shippingAddress) {
		
		return iShippingAddressRepository.save(shippingAddress);
	}

}
