package com.project.BuyerSignupService.dao.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyer_signup_table")
public class BuyerSignupEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "buyer_id")
	int buyerId;

	@Column(name = "buyer_username")
	String buyerUsername;

	@Column(name = "buyer_password")
	String buyerPassword;

	@Column(name = "buyer_email")
	String buyerEmail;

	@Column(name = "buyer_mobile")
	long buyerMobile;

	@Column(name = "buyer_date")
	Date buyerDate;

	

	public BuyerSignupEntity(int buyerId, String buyerUsername, String buyerPassword, String buyerEmail,
			long buyerMobile, Date buyerDate) {
		super();
		this.buyerId = buyerId;
		this.buyerUsername = buyerUsername;
		this.buyerPassword = buyerPassword;
		this.buyerEmail = buyerEmail;
		this.buyerMobile = buyerMobile;
		this.buyerDate = buyerDate;
		
	}

	public BuyerSignupEntity() {
		super();
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerUsername() {
		return buyerUsername;
	}

	public void setBuyerUsername(String buyerUsername) {
		this.buyerUsername = buyerUsername;
	}

	public String getBuyerPassword() {
		return buyerPassword;
	}

	public void setBuyerPassword(String buyerPassword) {
		this.buyerPassword = buyerPassword;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public long getBuyerMobile() {
		return buyerMobile;
	}

	public void setBuyerMobile(long buyerMobile) {
		this.buyerMobile = buyerMobile;
	}

	public Date getBuyerDate() {
		return buyerDate;
	}

	public void setBuyerDate(Date buyerDate) {
		this.buyerDate = buyerDate;
	}

	
}
