package com.sapestore.bookapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapestore.bookapp.model.OrderItemInfo;

@Repository
public interface IOrderItemInfoRepository extends JpaRepository<OrderItemInfo, Integer>{
	
	
	

}
