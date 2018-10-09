package com.sapient.sapestore.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.sapient.sapestore.exception.AddressNotInsetedException;
import com.sapient.sapestore.exception.CustomerNotFoundException;
import com.sapient.sapestore.model.Customer;
import com.sapient.sapestore.model.Message;
import com.sapient.sapestore.service.CustomerService;

@RestController
public class CustomerServiceController {
	@Autowired
	CustomerService customerService;
	

	
	@PostMapping("/register")
	public	Message registerUser(@RequestBody Customer customer) {
		if(customerService.addCustomer(customer)) {
			return new Message("registered successfully. Please Login to continue..","");
			
		}else {
			return new Message("","Failed to Register! Email Id Already Exist ");
		}
	}
	
	
	@GetMapping("/user/{userId}")
	public Customer user(@PathVariable("userId")int userId) {
		try {
			return customerService.findCustomerById(userId);
		} catch (CustomerNotFoundException e) {
			
			return new Customer("", e.getMessage());
		}
	}
	
	
	@GetMapping("/users")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	
	
	
	@GetMapping("/login/{email}/{password}")
		public Customer login(@PathVariable("email") String email,@PathVariable("password") String password) {
			Customer customer=new Customer();
			
			try {
				customer=customerService.login(email, password);
			} catch (CustomerNotFoundException e) {
				
				customer.setFailiureMessage(e.getMessage());
				return customer;
			}
			
			customer.setSuccessMessage("login Successfull");
			
			return customer;
			
		}
		
	
		
	@GetMapping("/update-password/{userId}/{password}")
	public Message updatePassword(@PathVariable("userId")int userId,@PathVariable("password")String password) {
		try {
			Message message= customerService.updatePassword(userId,password);
			return message;
		}catch (CustomerNotFoundException e) {
			return new Message("",e.getMessage());
		}
		
	}
	
	
	@PostMapping("/update-user")
	public Customer  updateCustomer(@RequestBody Customer customer){
		try {
			customerService.updateCustomer(customer);
			customer=customerService.findCustomerById(customer.getUserId());
			customer.setSuccessMessage("Profile updated successfully");
			return customer;
		} catch (CustomerNotFoundException e) {
			customer.setFailiureMessage(e.getMessage());
			return customer;
		}
	}
		
	@GetMapping("/find-by-email/{email}")
	public Customer findCustomerByEmail(@PathVariable("email")String email) {
		
		try {
			return customerService.findCustomerByEmail(email);
		} catch (CustomerNotFoundException e) {
			
			return new Customer("", e.getMessage());
		}
	} 
	
	

}
