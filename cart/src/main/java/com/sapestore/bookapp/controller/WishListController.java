package com.sapestore.bookapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapestore.bookapp.model.WishlistInfo;
import com.sapestore.bookapp.service.IWishListService;

@RestController
public class WishListController {
	
	private Logger logger = LoggerFactory.getLogger(WishListController.class);

	@Autowired
	IWishListService iWishListService;

	@PostMapping(value = "/add-to-wishlist")
	public WishlistInfo addTowishlist(@RequestBody WishlistInfo wishlistInfo) {

		try {
			WishlistInfo wishlist = iWishListService.findAllByUserIdAndIsbn(wishlistInfo.getUserId(), wishlistInfo.getIsbn());
			if(wishlist!=null)
			{
				return wishlist;
			}
			else {
				return iWishListService.addTowishlist(wishlistInfo);
			}

		}catch(Exception e)
		{
			logger.info(e.getMessage());
			return null;
		}
	}

	@GetMapping(value = "/delete-from-wishlist/{wishlist_itemid}")
	public void deletefromwishlist(@PathVariable("wishlist_itemid") Integer wishlisItemId) {

		try {
		iWishListService.deleteFromwishlist(wishlisItemId);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
			
		}
	}

	@GetMapping(value = "/get-all-from-wishlist/{userId}")
	public List<WishlistInfo> getAllwishlistInfo(@PathVariable("userId") Integer userId) {
		
		try {
		return iWishListService.getAllwishlistInfo(userId);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
			return null;
		}

	}
	@GetMapping(value="/wishlist-by-isbn/{userId}/{isbn}")
	public WishlistInfo findAllByUserIdAndIsbn(@PathVariable("userId") Integer userId,
			                                        @PathVariable("iSBN")Integer iSBN) {
		try {
		return iWishListService.findAllByUserIdAndIsbn(userId, iSBN);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
			return null;
		}
		
	}


}
