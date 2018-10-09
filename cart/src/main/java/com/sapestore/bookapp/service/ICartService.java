package com.sapestore.bookapp.service;

import com.sapestore.bookapp.model.CartInfo;
import com.sapestore.bookapp.model.CartItems;

public interface ICartService {

	public void addToCart(CartItems cartItems);

	public void deleteCartItem(Integer cartItemId);

	public CartItems getbyIsbn(CartInfo cartInfo, Integer isbn);

	public CartItems updateCartItem(CartItems cartItems);

	public CartInfo createCart(CartInfo cartInfo);

	public CartInfo updateCart(CartInfo cartInfo);

	public void deleteCart(Integer cartId);
	
	public CartInfo getCart(Integer userId);

	CartItems findByUserIdAndIsbn(CartInfo cartInfo, Integer iSBN);
	
	CartItems findById(Integer cartItemId);

}
