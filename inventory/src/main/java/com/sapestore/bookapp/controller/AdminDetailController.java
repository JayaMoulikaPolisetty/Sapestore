package com.sapestore.bookapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.sapestore.bookapp.repository.IDetailRepository;
import com.sapestore.bookapp.model.AdminContent;
import com.sapestore.bookapp.service.IDetailService;

@RestController
public class AdminDetailController {

	@Autowired
	IDetailRepository detailRepository;

	@Autowired
	IDetailService detailService;
	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/detail-by-detailId/{detailId}")
	public AdminContent getBookByISBN(@PathVariable("detailId") Integer detailId) {
		AdminContent admincontent = detailService.getDataById(detailId);
		return admincontent;
	}
	

	@PostMapping(value = "/updatedetail")
	public AdminContent updateDetail(@RequestBody AdminContent admincontent) {
		
		
		detailService.updateDetail(admincontent);
		
		return detailService.getDataById(1);

	}

	
}
