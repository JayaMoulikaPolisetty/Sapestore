package com.sapient.sapestore.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.sapestore.model.Books;
import com.sapient.sapestore.model.Customer;
import com.sapient.sapestore.model.OrderInfo;
import com.sapient.sapestore.model.OrderItemInfo;
import com.sapient.sapestore.model.Transaction;

@Controller
public class TransactionController {
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

	@GetMapping(value = "/transactionHistory")
	public ModelAndView transactionHistory(HttpSession session) {
		try {
			Customer customer = (Customer) session.getAttribute("customer");
			String uri = getServiceURL(cartServiceName) + "/my-orders/" + customer.getUserId();
			
			OrderInfo[] orders = restTemplate.getForObject(uri, OrderInfo[].class);
			List<OrderInfo> ordersList = Arrays.asList(orders);
			List<Transaction> transactions = new ArrayList<>();
			for (OrderInfo order : ordersList) {
				uri = getServiceURL(cartServiceName) + "/get-all-orderItems/" + order.getOrderId();
				OrderItemInfo[] itemArr= restTemplate.getForObject(uri, OrderItemInfo[].class);
				List<OrderItemInfo> items = Arrays.asList(itemArr);
				for (OrderItemInfo item : items) {
					Transaction transaction = new Transaction();
					transaction.setOrderDate(order.getOrderDate());
					uri = getServiceURL(bookServiceName) + "/books-by-ISBN/" + item.getIsbn();
					Books book = restTemplate.getForObject(uri, Books.class);
					transaction.setPrice(item.getOrderItemPrice());
					transaction.setOrderId(order.getOrderId());
					transaction.setBookImage(book.getBook_img());
					transaction.setName(book.getTitle());
					transaction.setOrderStatus(order.getOrderStatus());
					transactions.add(transaction);
				}

			}
			return new ModelAndView("transactionHistory", "transactions", transactions);

		} catch (Exception e) {
			return new ModelAndView("redirect:/error");
		}

	}
	
	@GetMapping(value="/orderStatusPage")
	public String orderStatusPage(){
		return "orderstatus";
		
	}

	@PostMapping(value = "/orderStatus")
	public ModelAndView trackMyOrderStatus(@RequestParam("orderId") Integer orderId, HttpSession session) {
		try{
		Customer customer = (Customer) session.getAttribute("customer");
		String uri = getServiceURL(cartServiceName) + "/status-by-orderId/" + customer.getUserId() + "/" + orderId;
		OrderInfo order = restTemplate.getForObject(uri, OrderInfo.class);
		session.setAttribute("orderStatus", "Your Order No. <span style=\"color: red;\">"+order.getOrderId()+" </span> Has\r\n" + 
				"						"+order.getOrderStatus());
		return new ModelAndView("redirect:/orderStatusPage");
		}catch (Exception e) {
			session.setAttribute("orderStatus","<span style=\"color: red;\">Invalid orderId</span>");
			return new ModelAndView("redirect:/orderStatusPage");
		}

		
	}

}