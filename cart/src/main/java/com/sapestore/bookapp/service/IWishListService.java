package com.sapestore.bookapp.service;

import java.util.List;

import com.sapestore.bookapp.model.WishlistInfo;

public interface IWishListService {

	public WishlistInfo addTowishlist(WishlistInfo wishlistInfo);
	
	public void deleteFromwishlist(Integer wishlisItemId);
	
	public List<WishlistInfo> getAllwishlistInfo(Integer userId);
	
	public WishlistInfo findAllByUserIdAndIsbn(Integer userId,Integer iSBN);
	
}
