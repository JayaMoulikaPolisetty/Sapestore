package com.sapestore.bookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapestore.bookapp.model.CartInfo;
import com.sapestore.bookapp.model.CartItems;
import com.sapestore.bookapp.repository.ICartInfoRepository;
import com.sapestore.bookapp.repository.ICartRepository;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	ICartRepository iCartRepository;

	@Autowired
	ICartInfoRepository iCartInfoRepository;

	@Override
	public void addToCart(CartItems cartitems) {

		iCartRepository.save(cartitems);

	}

	@Override
	public CartItems updateCartItem(CartItems cartitems) {
		return iCartRepository.save(cartitems);

	}

	@Override
	public void deleteCartItem(Integer cartItemId) {
		iCartRepository.deleteById(cartItemId);

	}
	@Override
	public void deleteCart(Integer cartId) {
		iCartInfoRepository.deleteById(cartId);

	}

	@Override
	public CartInfo createCart(CartInfo cartInfo) {
		return iCartInfoRepository.save(cartInfo);
	}

	@Override
	public CartInfo updateCart(CartInfo cartInfo) {
		return iCartInfoRepository.save(cartInfo);

	}

	@Override
	public CartInfo getCart(Integer userId) {
		CartInfo cartInfo = iCartInfoRepository.findByUserId(userId);
		return cartInfo;
	}

	@Override
	public CartItems findByUserIdAndIsbn(CartInfo cartInfo, Integer iSBN) {
		return iCartRepository.findByCartInfoAndIsbn(cartInfo, iSBN);
	}

	@Override
	public CartItems getbyIsbn(CartInfo cartInfo, Integer isbn) {
		return iCartRepository.findByCartInfoAndIsbn(cartInfo, isbn);
	}

	@Override
	public CartItems findById(Integer cartItemId) {
		return iCartRepository.getOne(cartItemId);
	}

}
