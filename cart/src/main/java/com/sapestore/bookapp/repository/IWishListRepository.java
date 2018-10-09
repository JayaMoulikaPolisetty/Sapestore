package com.sapestore.bookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapestore.bookapp.model.WishlistInfo;

@Repository
public interface IWishListRepository extends JpaRepository<WishlistInfo, Integer>{

	List<WishlistInfo> findAllByUserId(Integer userId);

	WishlistInfo findByUserIdAndIsbn(Integer userId,Integer isbn);
	
}
