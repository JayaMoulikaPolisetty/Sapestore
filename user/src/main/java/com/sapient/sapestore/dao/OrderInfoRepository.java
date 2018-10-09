package com.sapient.sapestore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.sapestore.model.OrderInfo;

@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo, Integer>{

}
