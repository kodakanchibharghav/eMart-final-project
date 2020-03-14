package com.project.SellerSignupService.service;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SellerSignupService.dao.SellerSignupServiceDao;
import com.project.SellerSignupService.dao.entity.SellerSignupServiceEntity;
import com.project.SellerSignupService.model.SellerSignupServicePojo;

@Service

public class SellerSignupServiceImpl implements SellerSignupService {
	
	static Logger LOG = Logger.getLogger(SellerSignupServiceImpl.class.getClass());
	@Autowired
	SellerSignupServiceDao sellerDao;

	

	@Override
	public SellerSignupServicePojo addSeller(SellerSignupServicePojo sellerPojo) {
		LOG.info("entered addSeller()");
		SellerSignupServiceEntity SellerSignupEntity = new SellerSignupServiceEntity(sellerPojo.getId(),sellerPojo.getUsername(),sellerPojo.getPassword(),
			sellerPojo.getCompany(),sellerPojo.getBrief(),sellerPojo.getGst(),sellerPojo.getAddress(),sellerPojo.getEmail(),sellerPojo.getWebsite(),sellerPojo.getContact());
		sellerDao.save(SellerSignupEntity);
		LOG.info("Exited addSeller()");
		return sellerPojo;

		@Override
		public SellerSignupServicePojo validateSeller(SellerSignupServicePojo sellerSignupPojo) {
		//LOG.info("Entered validateSeller() ");
		SellerSignupServiceEntity sellerSignupEntity = SellerSignupServiceDao.findBySellerUsernameAndSellerPassword(
		sellerSignupPojo.getSellerUsername(), sellerSignupPojo.getSellerPassword());

		sellerSignupPojo = new SellerSignupServicePojo(sellerSignupEntity.getSellerId(), sellerSignupEntity.getSellerUsername(),
		sellerSignupEntity.getSellerPassword(), sellerSignupEntity.getSellerCompany(),
		sellerSignupEntity.getSellerBrief(), sellerSignupEntity.getSellerGst(),
		sellerSignupEntity.getSellerAddress(),sellerSignupEntity.getSellerEmail(),
		sellerSignupEntity.getSellerContact(),sellerSignupEntity.getSellerWebsite());

		//BasicConfigurator.configure();
		//LOG.info("Exited validateSeller() ");
		return sellerSignupPojo;
		}

		@Override
		public SellerSignupServicePojo getSellerItems(Integer sellerId) {
		LOG.info("Entered getSellerItems() ");
		SellerSignupServicePojo sellerSignupPojo = new SellerSignupServicePojo();
		ItemEntity itemEntity = ItemDao.findById(sellerId).get();
		if (sellerSignupEntity != null) {
		Set<BillEntity> allBillsEntity = sellerSignupEntity.getAllBills();
		Set<BillPojo> allBillPojo = new HashSet<BillPojo>();
		for (BillEntity billEntity : allBillsEntity) {
		Set<BillDetailsEntity> allBillDetailsEntity = billEntity.getAllBillDetails();
		Set<BillDetailsPojo> allBillDetailsPojo = new HashSet<BillDetailsPojo>();

		for (BillDetailsEntity billDetailsEntity : allBillDetailsEntity) {

		ItemEntity itemEntity = billDetailsEntity.getItem();
		SubCategoryEntity subCategoryEntity = itemEntity.getSubcategory();
		CategoryEntity categoryEntity = subCategoryEntity.getCategory();
		SellerSignupEntity sellerSignupEntity = itemEntity.getSeller();

		BuyerSignupPojo buyerSignupPojo = new BuyerSignupPojo(buyerSignupEntity.,
		sellerSignupEntity.getSellerUsername(), sellerSignupEntity.getSellerPassword(),
		sellerSignupEntity.getSellerCompany(), sellerSignupEntity.getSellerBrief(),
		sellerSignupEntity.getSellerGst(), sellerSignupEntity.getSellerAddress(),
		sellerSignupEntity.getSellerEmail(), sellerSignupEntity.getSellerContact(),
		sellerSignupEntity.getSellerWebsite());

		CategoryPojo categoryPojo = new CategoryPojo(categoryEntity.getCategoryId(),
		categoryEntity.getCategoryName(), categoryEntity.getCategoryBrief());

		SubCategoryPojo subCategoryPojo = new SubCategoryPojo(subCategoryEntity.getSubCategoryId(),
		subCategoryEntity.getSubCategoryName(), categoryPojo,
		subCategoryEntity.getSubCategoryBrief(), subCategoryEntity.getSubCategoryGst());
		ItemPojo itemPojo = new ItemPojo(itemEntity.getItemId(), itemEntity.getItemName(),
		itemEntity.getItemImage(), itemEntity.getItemPrice(), itemEntity.getItemStock(),
		itemEntity.getItemDescription(), subCategoryPojo, itemEntity.getItemRemarks(),
		sellerSignupPojo);

		BillDetailsPojo billDetailsPojo = new BillDetailsPojo(billDetailsEntity.getBillDetailsId(), null,
		itemPojo);
		allBillDetailsPojo.add(billDetailsPojo);
		}
		BillPojo billPojo = new BillPojo(billEntity.getBillId(), null, billEntity.getBillType(),
		billEntity.getBillDate(), billEntity.getBillRemarks(), billEntity.getBillAmount(),
		allBillDetailsPojo);
		allBillPojo.add(billPojo);
		}
		sellerSignupPojo = new SellerSignupServicePojo(sellerSignupServiceEntity, buyerSignupServiceEntity.getBuyerUsername(),
		buyerSignupEntity.getBuyerPassword(), buyerSignupEntity.getBuyerEmail(),
		buyerSignupServiceEntity.getBuyerMobile(), buyerSignupEntity.getBuyerDate(), allBillPojo);
		}
		BasicConfigurator.configure();
		LOG.info("Exited getSellerItems() ");
		return sellerSignupPojo;

		}
		}

		 

		 
	}
	

}
