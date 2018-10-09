package com.sapient.sapestore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.sapestore.model.OrderInfo;



@Repository
public interface IOrderInfoRepository extends JpaRepository<OrderInfo, Integer> {


	List<OrderInfo> findAllByUserId(Integer userId);

	

	
}
