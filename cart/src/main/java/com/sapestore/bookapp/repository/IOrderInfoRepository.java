package com.sapestore.bookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapestore.bookapp.model.OrderInfo;


@Repository
public interface IOrderInfoRepository extends JpaRepository<OrderInfo, Integer> {



	List<OrderInfo> findAllByUserId(Integer userId);	

	OrderInfo findByUserIdAndOrderId(Integer userId, Integer orderId);
	
	List<OrderInfo> findAllByUserIdAndOrderStatus(Integer userId, String orderStatus);

	List<OrderInfo> findAllByOrderStatus(String orderStatus);

	
}
