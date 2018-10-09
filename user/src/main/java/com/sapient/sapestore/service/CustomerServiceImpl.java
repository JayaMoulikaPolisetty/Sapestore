package com.sapient.sapestore.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.sapestore.dao.CustomerRepository;
import com.sapient.sapestore.exception.CustomerNotFoundException;
import com.sapient.sapestore.model.Customer;
import com.sapient.sapestore.model.Message;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	 
	
	@Override
	public boolean addCustomer(Customer customer) {
		
		
		try {
			customer.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			customerRepository.save(customer);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Customer findCustomerById(int userId)throws CustomerNotFoundException {
		
		try {
				Customer customer= customerRepository.findById(userId).get();
				if(customer==null) {
					throw new CustomerNotFoundException("No Customer Found For this Id");
					
				}else {
					return customer;
				}
		}catch (Exception e) {
			throw new CustomerNotFoundException("No Customer Found For this Id");
		}
		
	}
	
	@Override
	public Customer login(String email, String password) throws CustomerNotFoundException {
		Customer customer=new Customer();
		try {
		customer=customerRepository.findByEmailAndPassword(email, password);
			if(customer==null) {
				throw new CustomerNotFoundException("Invalid login");
			}else {
				return customer;
			}
		
		}catch (Exception e) {
			throw new CustomerNotFoundException("login failed");
		}
	} 


	@Override
	public Customer findCustomerByEmail(String email) throws CustomerNotFoundException {
		
		try{
			Customer customer= customerRepository.findByEmail(email);
			if(customer==null) {
				throw new CustomerNotFoundException("No Customer found for this email");
			}
			else {
				return customer;
			}
		}catch (Exception e) {
			throw new CustomerNotFoundException("No Customer found for this email");
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return customerRepository.findAll();
	}

	@Override
	public Message updatePassword(int userId, String password) throws CustomerNotFoundException {
		
		try {
			Customer customer=customerRepository.findById(userId).get();
			if(customer==null) {
				throw new CustomerNotFoundException("No user found");
			}else {
				customer.setPassword(password);
				customerRepository.save(customer);
				return new Message("Password updated successfullty","");
			}
		}catch (Exception e) {
			throw new CustomerNotFoundException("Password not Updated");
		}
			
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		try {
			int userId=customer.getUserId();
			customer.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			customerRepository.save(customer);
			customer=customerRepository.findById(userId).get();
			return customer;
		}catch (Exception e) {
			throw new CustomerNotFoundException("Customer not updated");
		}
	}
}
