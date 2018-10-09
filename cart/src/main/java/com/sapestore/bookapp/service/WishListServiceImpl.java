package com.sapestore.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sapestore.bookapp.model.WishlistInfo;
import com.sapestore.bookapp.repository.IWishListRepository;

@Service
public class WishListServiceImpl implements IWishListService
{
	
@Autowired
IWishListRepository iWishListRepository;

@Override
public WishlistInfo addTowishlist(WishlistInfo wishlistInfo) {

	return iWishListRepository.save(wishlistInfo);
	
}

	@Override
	public void deleteFromwishlist(Integer wishlisItemId) {
	
		iWishListRepository.deleteById(wishlisItemId);
	}

	@Override
	public List<WishlistInfo> getAllwishlistInfo(Integer userId) {
		
		return iWishListRepository.findAllByUserId(userId);
	}

	@Override
	public WishlistInfo findAllByUserIdAndIsbn(Integer userId, Integer iSBN) {
		
		return iWishListRepository.findByUserIdAndIsbn(userId, iSBN);
	}

	

}
