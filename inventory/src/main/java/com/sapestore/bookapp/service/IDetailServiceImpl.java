package com.sapestore.bookapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapestore.bookapp.repository.IDetailRepository;
import com.sapestore.bookapp.model.AdminContent;
@Service
public class IDetailServiceImpl implements IDetailService {

	@Autowired
	IDetailRepository deatilRepository;
	
	

	@Override
	public AdminContent getDataById(int detailId) {
		return deatilRepository.findById(detailId).get();
		
	}

	@Override
	public void updateDetail (AdminContent adminContent) {
		
		 deatilRepository.save(adminContent);
	}

	

	
	
}
