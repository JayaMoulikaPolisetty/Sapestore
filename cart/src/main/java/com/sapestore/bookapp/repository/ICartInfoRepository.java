package com.sapestore.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapestore.bookapp.model.CartInfo;

@Repository
public interface ICartInfoRepository extends JpaRepository<CartInfo, Integer>{
	
	CartInfo findByUserId(Integer userId);

}
