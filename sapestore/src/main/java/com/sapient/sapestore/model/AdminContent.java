package com.sapient.sapestore.model;


import org.springframework.stereotype.Component;


@Component

public class AdminContent  {
	
	
	
	private Integer detailId;
	private String contactdetail;
	private String privacydetail;
	
	public AdminContent() {
		super();
		
	}
	public AdminContent(Integer detailId, String contactdetail, String privacydetail) {
		super();
		this.detailId = detailId;
		this.contactdetail = contactdetail;
		this.privacydetail = privacydetail;
	}
	
	
	public Integer getDetailId() {
		return detailId;
	}
	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}
	public String getContactdetail() {
		return contactdetail;
	}
	public void setContactdetail(String contactdetail) {
		this.contactdetail = contactdetail;
	}
	public String getPrivacydetail() {
		return privacydetail;
	}
	public void setPrivacydetail(String privacydetail) {
		this.privacydetail = privacydetail;
	}
	@Override
	public String toString() {
		return "AdminContent [detailId=" + detailId + ", contactdetail=" + contactdetail + ", privacydetail="
				+ privacydetail + "]";
	}
	
	

}
