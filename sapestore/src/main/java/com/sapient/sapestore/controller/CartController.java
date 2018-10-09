package com.sapient.sapestore.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import java.net.URI;
import java.sql.Timestamp;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.sapient.sapestore.model.Book_Rating_Comments;
import com.sapient.sapestore.model.Books;
import com.sapient.sapestore.model.CartInfo;
import com.sapient.sapestore.model.CartItems;
import com.sapient.sapestore.model.Customer;
import com.sapient.sapestore.model.ItemsDisplay;
import com.sapient.sapestore.model.ShippingAddress;

@Controller
public class CartController {
	
	private Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	RestTemplate restTemplate;

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

	@SuppressWarnings({ "unchecked", "unused" })
	@RequestMapping(value = "/")
	public String cart(HttpSession session, ModelMap model) {
		
		logger.info("=============Home===============");
		Customer customer = (Customer) session.getAttribute("customer");
		
		if (customer != null) {
			try {
			ShippingAddress shippingAddress = (ShippingAddress) session.getAttribute("shippingAddress");
			if(shippingAddress == null)
			{
				throw new Exception();
			}
			}
			catch(Exception e) {
			ShippingAddress shippingAddress1 = new ShippingAddress();
			shippingAddress1.setAddressLine1(customer.getAddressLine1());
			shippingAddress1.setAddressLine2(customer.getAddressLine2());
			shippingAddress1.setCity(customer.getCity());
			shippingAddress1.setState(customer.getState());
			shippingAddress1.setPin(customer.getPin());
			shippingAddress1.setPhoneNumber(customer.getPhoneNumber());
			session.setAttribute("shippingAddress", shippingAddress1);
			}
			
		}
		CartInfo cartInfo;
		if (customer != null) {
			try {
				String url = getServiceURL(cartServiceName) + "/get-cart" +"/"+ customer.getUserId();
				cartInfo = restTemplate.getForObject(url, CartInfo.class);
				
				if (cartInfo == null) {
					throw new Exception();
				}
			} catch (Exception e) {

				CartInfo cartInfo1 = new CartInfo();
				cartInfo1.setCartPrice(0);
				cartInfo1.setCreatedDate(new Timestamp(System.currentTimeMillis()));
				cartInfo1.setQuantity(0);
				cartInfo1.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
				cartInfo1.setUserId(customer.getUserId());
				String uri = getServiceURL(cartServiceName) + "/create-cart";
				cartInfo = restTemplate.postForObject(uri, cartInfo1, CartInfo.class);
			}

			
			try {
				String uri = getServiceURL(cartServiceName) + "/get-all-cartitems/" + customer.getUserId();
				List<CartItems> cartItems = Arrays.asList(restTemplate.getForObject(uri, CartItems[].class));
				
				if (cartItems != null) {
					
					List<ItemsDisplay> items = new ArrayList<>();
					for(CartItems cartItem: cartItems)
					{
						uri = getServiceURL(bookServiceName)+"/books-by-ISBN/" + cartItem.getIsbn();
						Books book = restTemplate.getForObject(uri, Books.class);
						ItemsDisplay item = new ItemsDisplay();
						item.setBookName(book.getTitle());
						item.setBookPrice(book.getPrice());
						item.setBookImg(book.getBook_img());
						item.setQuantity(cartItem.getCartItemQuantity());
						item.setSubtotal(cartItem.getCartItemPrice());
						item.setId(cartItem.getCartItemId());
						item.setIsbn(book.getiSBN());
						item.setBookQuantity(book.getQuantity());
						items.add(item);
						
					}
					model.addAttribute("cartList", items);
					session.setAttribute("cartList", items);
				}
				if(cartItems==null)
				{
					throw new Exception();
				}
			}
			catch(Exception e) {
				model.addAttribute("message", "Cart is empty");
			}
			model.addAttribute("cart", cartInfo);
			session.setAttribute("cart", cartInfo);
			
		}
		
		try {
		String uri = getServiceURL(bookServiceName) + "/books/categories";
        List<String> categoriesList = restTemplate.getForObject(uri, List.class);
        model.addAttribute("categoriesList", categoriesList);
        String uri2 = getServiceURL(bookServiceName) + "/books/top-rated";
        List<Books> topRatedList = Arrays.asList(restTemplate.getForObject(uri2, Books[].class));
        
        double sumOfRating=0.0;
              double averageRating=0.0;
              boolean testRating=true;
              List<Book_Rating_Comments> bookRatingComments= new ArrayList<>();
              for(Books book : topRatedList) {
              
                     
                     String uri3=getServiceURL(bookServiceName) + "getCoomnetsByISBN/"+book.getiSBN();
                     bookRatingComments=Arrays.asList(restTemplate.getForObject(uri3, Book_Rating_Comments[].class));
                     int counter=0;
                     for(int i=0; i<bookRatingComments.size();i++) {
                           Book_Rating_Comments obj=bookRatingComments.get(i);
                           sumOfRating+=obj.getBook_rating();
                           counter++;
                     }
                   
                     averageRating=Math.floor(sumOfRating/counter);
                     if(counter==0)
                           book.setAvgRating(0.0);
                     else
                     book.setAvgRating(averageRating);
                     sumOfRating=0;
                    
                 }
              
              model.addAttribute("topRatedList", topRatedList);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return "home";

	}

	@RequestMapping("/addToCart/{isbn}")
	public String addToCart(@PathVariable("isbn") Integer isbn, HttpSession session, ModelMap model) {
		
		try {
			
		CartItems cartItem = new CartItems();
		Customer customer = (Customer) session.getAttribute("customer");
		CartInfo cartInfo;

		String url = getServiceURL(cartServiceName) + "/get-cart/" + customer.getUserId();
		cartInfo = restTemplate.getForObject(url, CartInfo.class);

		cartItem.setCartInfo(cartInfo);

		String uri = getServiceURL(bookServiceName) + "/books-by-ISBN/" + isbn;
		Books book = restTemplate.getForObject(uri, Books.class);
		if(book.getQuantity()>0 && cartItem.getCartItemQuantity()<book.getQuantity()) {
		cartItem.setUnitPrice(book.getPrice());
		cartItem.setCartItemQuantity(1);
		cartItem.setIsbn(book.getiSBN());
		cartItem.setCartItemPrice(cartItem.getUnitPrice() * cartItem.getCartItemQuantity());
		String url1 = getServiceURL(cartServiceName) + "/add-to-cart";
		restTemplate.postForObject(url1, cartItem, String.class);

		cartInfo.setQuantity(cartInfo.getQuantity() + cartItem.getCartItemQuantity());
		cartInfo.setCartPrice(cartInfo.getCartPrice()+cartItem.getCartItemPrice());
		cartInfo.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
		String url2 = getServiceURL(cartServiceName) + "/update-cart";
		restTemplate.postForObject(url2, cartInfo, String.class);
		model.addAttribute("message", "Book is added to Cart");
		session.setAttribute("message", "Book is added to Cart");
		
		}
		else {
			model.addAttribute("message", "Not in Stock");
			session.setAttribute("message", "Not in Stock");

		}
		}
		catch(Exception e) {
			
			logger.info("Exception in Add to cart");
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/deleteCart/{cartItemId}/{quantity}/{cartItemPrice}")
	public String deleteCart(@PathVariable("cartItemId") Integer cartItemId, @PathVariable("quantity") Integer quantity,
			@PathVariable("cartItemPrice") double cartItemPrice, HttpSession session, ModelMap model) {
		logger.info("===============Inside Delete Cart=================");
		try {
		Customer customer = (Customer) session.getAttribute("customer");
		
		String url = getServiceURL(cartServiceName) + "/get-cart/" + customer.getUserId();
		CartInfo cartInfo = restTemplate.getForObject(url, CartInfo.class);
		cartInfo.setQuantity(cartInfo.getQuantity() - quantity);
		cartInfo.setCartPrice(cartInfo.getCartPrice() - cartItemPrice);
		String uri = getServiceURL(cartServiceName) + "/delete-cartitem/" + cartItemId;
		restTemplate.getForObject(uri, String.class);

		uri = getServiceURL(cartServiceName) + "/update-cart";
		restTemplate.postForObject(uri, cartInfo, String.class);
		
		}catch(Exception e)
		{
			logger.info("Error in delete cartItem");
		}
		
		return "redirect:/";

	}

	@RequestMapping(value = "/updateCart/{cartItemId}")
	public String updateCartQuantity(@PathVariable("cartItemId") Integer cartItemId,@RequestParam("quantity")Integer quantity, HttpSession session, ModelMap model) {

	
		try {
			
		Customer customer = (Customer) session.getAttribute("customer");
		String url = getServiceURL(cartServiceName) + "/get-cart/" + customer.getUserId();
		CartInfo cartInfo = restTemplate.getForObject(url, CartInfo.class);
		url = getServiceURL(cartServiceName)+"/update-cartitem/"+cartInfo.getCartId()+"/"+cartItemId+"/"+quantity;
		cartInfo = restTemplate.getForObject(url, CartInfo.class);
		model.addAttribute("cart", cartInfo);
		session.setAttribute("cart", cartInfo);
		}catch(Exception e) {
			logger.info("Error in updating cart item");
		}
		return "redirect:/";
	}

	@GetMapping(value = "/error")
	public String error() {
		return "error";
	}
	

}
