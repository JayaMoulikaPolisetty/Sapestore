package com.sapestore.bookapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="AdminContent")
public class AdminContent implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}