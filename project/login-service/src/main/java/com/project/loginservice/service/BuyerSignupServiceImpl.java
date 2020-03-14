package com.project.loginservice.service;

import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.loginservice.dao.BuyerSignupDao;
import com.project.loginservice.dao.entity.BillDetailsEntity;
import com.project.loginservice.dao.entity.BillEntity;
import com.project.loginservice.dao.entity.BuyerSignupEntity;
import com.project.loginservice.dao.entity.CategoryEntity;
import com.project.loginservice.dao.entity.ItemEntity;
import com.project.loginservice.dao.entity.SellerSignupEntity;
import com.project.loginservice.dao.entity.SubCategoryEntity;
import com.project.loginservice.model.BillDetailsPojo;
import com.project.loginservice.model.BillPojo;
import com.project.loginservice.model.BuyerSignupPojo;
import com.project.loginservice.model.CategoryPojo;
import com.project.loginservice.model.ItemPojo;
import com.project.loginservice.model.SellerSignupPojo;
import com.project.loginservice.model.SubCategoryPojo;


@Service
public class BuyerSignupServiceImpl implements BuyerSignupService {
	static Logger LOG = Logger.getLogger(BuyerSignupServiceImpl.class.getClass());

	@Autowired
	BuyerSignupDao buyerSignupDao;

	//to validate buyer with username and password
	@Override
	public BuyerSignupPojo validateBuyer(BuyerSignupPojo buyerSignupPojo) {
		LOG.info("Entered validateBuyer() ");
		BuyerSignupEntity buyerSignupEntity = buyerSignupDao.findByBuyerUsernameAndBuyerPassword(
				buyerSignupPojo.getBuyerUsername(), buyerSignupPojo.getBuyerPassword());

		if (buyerSignupEntity != null) {
			Set<BillEntity> allBillsEntity = buyerSignupEntity.getAllBills();
			Set<BillPojo> allBillPojo = new HashSet<BillPojo>();

			for (BillEntity billEntity : allBillsEntity) {
				Set<BillDetailsEntity> allBillDetailsEntity = billEntity.getAllBillDetails();
				Set<BillDetailsPojo> allBillDetailsPojo = new HashSet<BillDetailsPojo>();

				for (BillDetailsEntity billDetailsEntity : allBillDetailsEntity) {
					ItemEntity itemEntity = billDetailsEntity.getItem();
					SubCategoryEntity subCategoryEntity = itemEntity.getSubcategory();
					CategoryEntity categoryEntity = subCategoryEntity.getCategory();
					SellerSignupEntity sellerSignupEntity = itemEntity.getSeller();

					SellerSignupPojo sellerSignupPojo = new SellerSignupPojo(sellerSignupEntity.getSellerId(),
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
			buyerSignupPojo = new BuyerSignupPojo(buyerSignupEntity.getBuyerId(), buyerSignupEntity.getBuyerUsername(),
					buyerSignupEntity.getBuyerPassword(), buyerSignupEntity.getBuyerEmail(),
					buyerSignupEntity.getBuyerMobile(), buyerSignupEntity.getBuyerDate(), allBillPojo);
		}
		BasicConfigurator.configure();
		LOG.info("Exited validateBuyer() ");
		return buyerSignupPojo;
	}

	//to validate buyer with Id
	@Override
	public BuyerSignupPojo getBuyer(Integer buyerId) {
		LOG.info("Entered getBuyer() ");
		BuyerSignupPojo buyerSignupPojo = new BuyerSignupPojo();
		BuyerSignupEntity buyerSignupEntity = buyerSignupDao.findById(buyerId).get();
		if (buyerSignupEntity != null) {
			Set<BillEntity> allBillsEntity = buyerSignupEntity.getAllBills();
			Set<BillPojo> allBillPojo = new HashSet<BillPojo>();
			for (BillEntity billEntity : allBillsEntity) {
				Set<BillDetailsEntity> allBillDetailsEntity = billEntity.getAllBillDetails();
				Set<BillDetailsPojo> allBillDetailsPojo = new HashSet<BillDetailsPojo>();

				for (BillDetailsEntity billDetailsEntity : allBillDetailsEntity) {

					ItemEntity itemEntity = billDetailsEntity.getItem();
					SubCategoryEntity subCategoryEntity = itemEntity.getSubcategory();
					CategoryEntity categoryEntity = subCategoryEntity.getCategory();
					SellerSignupEntity sellerSignupEntity = itemEntity.getSeller();

					SellerSignupPojo sellerSignupPojo = new SellerSignupPojo(sellerSignupEntity.getSellerId(),
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
			buyerSignupPojo = new BuyerSignupPojo(buyerSignupEntity.getBuyerId(), buyerSignupEntity.getBuyerUsername(),
					buyerSignupEntity.getBuyerPassword(), buyerSignupEntity.getBuyerEmail(),
					buyerSignupEntity.getBuyerMobile(), buyerSignupEntity.getBuyerDate(), allBillPojo);
		}
		BasicConfigurator.configure();
		LOG.info("Exited getBuyer() ");
		return buyerSignupPojo;
	}
}