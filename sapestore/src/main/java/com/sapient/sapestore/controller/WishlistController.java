package com.sapient.sapestore.controller;

import java.net.URI;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.sapient.sapestore.model.Books;
import com.sapient.sapestore.model.CartInfo;
import com.sapient.sapestore.model.CartItems;
import com.sapient.sapestore.model.Customer;
import com.sapient.sapestore.model.ItemsDisplay;
import com.sapient.sapestore.model.WishlistInfo;

@Controller
public class WishlistController {

	private Logger logger = LoggerFactory.getLogger(WishlistController.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;
	private final String cartServiceName = "cart-service";
	private final String bookServiceName = "book-service";

	private URI getServiceURL(String service) {
		List<ServiceInstance> list = discoveryClient.getInstances(service);
		if (list != null && list.size() > 0)
			return list.get(0).getUri();
		return null;
	}

	
	@RequestMapping(value = "/add-to-wishlist/{iSBN}")
	public String addTowishList(@PathVariable("iSBN") Integer iSBN, HttpSession session, ModelMap model) {
		
		try {

		Customer customer = (Customer) session.getAttribute("customer");
		System.out.println(customer.getUserId());

		String uri = getServiceURL(bookServiceName) + "/books-by-ISBN/" + iSBN;
		Books book = restTemplate.getForObject(uri, Books.class);

	
		WishlistInfo wishlistInfo = new WishlistInfo();
		wishlistInfo.setIsbn(book.getiSBN());
		wishlistInfo.setUserId(customer.getUserId());
		uri = getServiceURL(cartServiceName) + "/add-to-wishlist";
		wishlistInfo = restTemplate.postForObject(uri, wishlistInfo, WishlistInfo.class);
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
		}
		return "redirect:/wishlist";
	}

	@RequestMapping(value = "/delete-from-wishlist/{wishlist_itemid}")
	public String deletefromwishlist(@PathVariable("wishlist_itemid") Integer wishlist_itemid) {

		try {
		String uri = getServiceURL(cartServiceName) + "/delete-from-wishlist/" + wishlist_itemid;
		restTemplate.getForObject(uri, String.class);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
		}
		return "redirect:/wishlist";

	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/wishlist")
	public String getAllwishlistInfo(HttpSession session, ModelMap model) {
		
		try {

		Customer customer = (Customer) session.getAttribute("customer");
		System.out.println(customer.getUserId());

		String uri = getServiceURL(cartServiceName) + "/get-all-from-wishlist/" + customer.getUserId();

		try {
		List<WishlistInfo> wishlistInfo = Arrays.asList(restTemplate.getForObject(uri, WishlistInfo[].class));
		
		if (wishlistInfo != null) {
			System.out.println(wishlistInfo);
			List<ItemsDisplay> items = new ArrayList<>();
			for(WishlistInfo wish: wishlistInfo)
			{
				uri = getServiceURL(bookServiceName)+"/books-by-ISBN/" + wish.getIsbn();
				Books book = restTemplate.getForObject(uri, Books.class);
				System.out.println(book);
				ItemsDisplay item = new ItemsDisplay();
				item.setBookName(book.getTitle());
				item.setBookPrice(book.getPrice());
				item.setBookImg(book.getBook_img());
				item.setQuantity(book.getQuantity());
				item.setId(wish.getWishlisItemId());
				item.setIsbn(book.getiSBN());
				items.add(item);
				System.out.println(items);
			
			}
			System.out.println(items.size());
			model.addAttribute("quantity", items.size());
			
			model.addAttribute("wishlistInfo", items);
			
		}
		}catch(Exception e)
		{
			logger.info(e.getMessage());
		}
		
		uri = getServiceURL(bookServiceName) + "/books/categories";
		List<String> categoriesList = restTemplate.getForObject(uri, List.class);
		model.addAttribute("categoriesList", categoriesList);
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
		}
		return "wishlist";

	}

	@RequestMapping(value = "addToCartfromwishlist/{isbn}/{wishlist_itemid}")
	public String addTocartfromwishlist(@PathVariable("isbn") Integer isbn,@PathVariable("wishlist_itemid") Integer wishlist_itemid, HttpSession session, ModelMap model)
	{
		
		try {
		CartItems cartItem = new CartItems();
		Customer customer = (Customer) session.getAttribute("customer");

		System.out.println(customer.getUserId());

		CartInfo cartInfo;

		String url = getServiceURL(cartServiceName) + "/get-cart/" + customer.getUserId();
		cartInfo = restTemplate.getForObject(url, CartInfo.class);

		cartItem.setCartInfo(cartInfo);

		String uri = getServiceURL(bookServiceName) + "/books-by-ISBN/" + isbn;
		Books book = restTemplate.getForObject(uri, Books.class);
		cartItem.setUnitPrice(book.getPrice());
		cartItem.setCartItemQuantity(1);
		cartItem.setIsbn(book.getiSBN());
		cartItem.setCartItemPrice(cartItem.getUnitPrice() * cartItem.getCartItemQuantity());
		String url1 = getServiceURL(cartServiceName) + "/add-to-cart";
		restTemplate.postForObject(url1, cartItem, String.class);
		
		cartInfo.setQuantity(cartInfo.getQuantity() + 1);
		cartInfo.setCartPrice(cartInfo.getCartPrice()+book.getPrice());
		cartInfo.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
		String url2 = getServiceURL(cartServiceName) + "update-cart";
		restTemplate.postForObject(url2, cartInfo, String.class);
		
		String uri2 = getServiceURL(cartServiceName) + "/delete-from-wishlist/" + wishlist_itemid;
		restTemplate.getForObject(uri2, String.class);
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
		}
		return "redirect:/";
		
		
		
	}
	
	
	
}
