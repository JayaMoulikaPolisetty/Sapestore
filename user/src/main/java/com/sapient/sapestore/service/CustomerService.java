package com.sapient.sapestore.service;

import java.util.List;

import com.sapient.sapestore.exception.CustomerNotFoundException;
import com.sapient.sapestore.model.Customer;
import com.sapient.sapestore.model.Message;


public interface CustomerService {

	boolean addCustomer(Customer customer);
	Customer findCustomerById(int userId) throws CustomerNotFoundException;
	Customer updateCustomer(Customer customer)throws CustomerNotFoundException;
	Customer login(String email,String password) throws CustomerNotFoundException; 
	Customer findCustomerByEmail(String email)throws CustomerNotFoundException; 
	List<Customer> getAllCustomers();
	Message updatePassword(int userId, String password) throws CustomerNotFoundException;
}
