package com.sapestore.bookapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapestore.bookapp.model.CartInfo;
import com.sapestore.bookapp.model.CartItems;

@Repository
public interface ICartRepository extends JpaRepository<CartItems, Integer> {

CartItems findByCartInfoAndIsbn(CartInfo cartInfo,Integer iSBN);

}