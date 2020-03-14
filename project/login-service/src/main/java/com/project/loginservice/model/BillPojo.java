package com.project.loginservice.model;

import java.util.*;

public class BillPojo {

	private int billId;

	private BuyerSignupPojo buyerPojo;

	private String billType;

	private Date billDate;

	private String billRemarks;

	private int billAmount;

	private Set<BillDetailsPojo> allBillDetails;

	public Set<BillDetailsPojo> getAllBillDetails() {
		return allBillDetails;
	}

	public void setAllBillDetails(Set<BillDetailsPojo> allBillDetails) {
		this.allBillDetails = allBillDetails;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public BuyerSignupPojo getBuyerPojo() {
		return buyerPojo;
	}

	public void setBuyerPojo(BuyerSignupPojo buyerPojo) {
		this.buyerPojo = buyerPojo;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getBillRemarks() {
		return billRemarks;
	}

	public void setBillRemarks(String billRemarks) {
		this.billRemarks = billRemarks;
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}

	public BillPojo(int billId, BuyerSignupPojo buyerPojo, String billType, Date billDate, String billRemarks,
			int billAmount, Set<BillDetailsPojo> allBillDetails) {
		super();
		this.billId = billId;
		this.buyerPojo = buyerPojo;
		this.billType = billType;
		this.billDate = billDate;
		this.billRemarks = billRemarks;
		this.billAmount = billAmount;
		this.allBillDetails = allBillDetails;
	}

	public BillPojo() {
		super();

	}

	@Override
	public String toString() {
		return "BillPojo [billId=" + billId + ", buyerPojo=" + buyerPojo + ", billType=" + billType + ", billDate="
				+ billDate + ", billRemarks=" + billRemarks + ", billAmount=" + billAmount + ", allBillDetails="
				+ allBillDetails + "]";
	}

}
