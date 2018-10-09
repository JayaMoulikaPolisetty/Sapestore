package com.sapestore.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapestore.bookapp.model.ShippingAddress;

@Repository
public interface IShippingAddressRepository extends JpaRepository<ShippingAddress, Integer>{

	
}
