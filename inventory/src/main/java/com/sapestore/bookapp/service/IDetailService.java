package com.sapestore.bookapp.service;



import com.sapestore.bookapp.model.AdminContent;




public interface IDetailService {
	
	
	public AdminContent getDataById(int detailId);
	
	/*AdminContent updatePrivacy(int detailId,String privacydetail);
	AdminContent updateContact(int detailId,String contactdetail);*/
	void updateDetail(AdminContent adminContent);
   

}
