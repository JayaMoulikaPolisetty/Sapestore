package com.sapestore.bookapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapestore.bookapp.model.CartInfo;
import com.sapestore.bookapp.model.CartItems;
import com.sapestore.bookapp.service.ICartService;

@RestController
public class CartController {

	private Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private ICartService iCartService;
		
	@PostMapping(value="/add-to-cart")
	public void addToCart(@RequestBody CartItems cartItems) {
		
		try {
			CartItems cartItem = iCartService.getbyIsbn(cartItems.getCartInfo(), cartItems.getIsbn());
			if(cartItem!=null && cartItem.getCartItemQuantity()<5)
			{
				cartItem.setCartItemQuantity(cartItem.getCartItemQuantity()+1);
				cartItem.setCartItemPrice(cartItem.getCartItemQuantity()*cartItem.getUnitPrice());
				iCartService.updateCartItem(cartItem);
			}
			else {
				iCartService.addToCart(cartItems);
			}
		}catch(Exception e)
		{
			logger.info(e.getMessage());
		}
		
	}
	
	@GetMapping(value="/getCartItembyIsbn/{isbn}/{userId}")
	public CartItems getItem(@PathVariable("isbn")Integer isbn, @PathVariable("userId")Integer userId)
	{
		
		CartInfo cartInfo = iCartService.getCart(userId);
		
		return iCartService.getbyIsbn( cartInfo ,isbn);
	}

	@RequestMapping(value="/update-cartitem/{cartId}/{cartItemId}/{quantity}")
	public CartInfo updateCartItem(@PathVariable("cartId") Integer cartId, @PathVariable("cartItemId") Integer cartItemId, @PathVariable("quantity")Integer quantity)
	{
		
	try {
	
	  CartItems cartItem = iCartService.findById(cartItemId);
	  CartInfo cartInfo = cartItem.getCartInfo();
	  cartInfo.setQuantity(cartInfo.getQuantity()-cartItem.getCartItemQuantity());
	  cartInfo.setCartPrice(cartInfo.getCartPrice()-cartItem.getCartItemPrice());
	  cartItem.setCartItemQuantity(quantity);
	  cartItem.setCartItemPrice(cartItem.getUnitPrice()*quantity);
	  cartItem = iCartService.updateCartItem(cartItem);
	  cartInfo.setQuantity(cartInfo.getQuantity()+cartItem.getCartItemQuantity());
	  cartInfo.setCartPrice(cartInfo.getCartPrice()+cartItem.getCartItemPrice());
	 
	  return iCartService.updateCart(cartInfo);
	}catch(Exception e)
	{
		logger.info(e.getMessage());
		return null;
	}
     
	}
	
	@GetMapping(value = "/delete-cartitem/{cartItemid}")
	public void deleteCartItem(@PathVariable("cartItemid") int cartItemId) {

		try {
		iCartService.deleteCartItem(cartItemId);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
		}
	}

	@GetMapping(value = "/get-all-cartitems/{userId}")
	public List<CartItems> getAllCartItems(@PathVariable("userId") Integer userId) {

		try {
		return iCartService.getCart(userId).getCartItems();
		}catch(Exception e)
		{
			logger.info(e.getMessage());
			return null;
		}
		
	}
	
	@PostMapping(value = "/update-cart")
	public void updateCart(@RequestBody CartInfo cartinfo) {
		try {
		iCartService.updateCart(cartinfo);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
		}
	}

	@GetMapping(value = "/delete-cart/{cartid}")
	public void deleteCart(@PathVariable("cartid") int cartId) {
		
		try {
		iCartService.deleteCart(cartId);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
		}

	}

	@PostMapping(value = "/create-cart")
	public CartInfo createCart(@RequestBody CartInfo cartinfo) {
		
		try {
		return	iCartService.createCart(cartinfo);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
			return null;
		}
		
	
	}
	
	@GetMapping(value="/get-cart/{customerId}")
	public CartInfo getCart(@PathVariable ("customerId") Integer customerId)
	{
		try {
		return iCartService.getCart(customerId);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
			return null;
		}
		
	}
	
	@GetMapping(value="/getCartItem/{cartItemId}")
	public CartItems getCartItems(@PathVariable("cartItemId") Integer cartItemId)
	{
		try {
		return iCartService.findById(cartItemId);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
			return null;
		}
	}
	
}
