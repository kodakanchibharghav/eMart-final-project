package com.project.buyeritemservice.service;

import java.util.HashSet;
import java.util.Set;
import javax.transaction.Transactional;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.buyeritemservice.dao.BillDetailsDao;
import com.project.buyeritemservice.dao.BillDao;
import com.project.buyeritemservice.dao.entity.BillDetailsEntity;
import com.project.buyeritemservice.dao.entity.BillEntity;
import com.project.buyeritemservice.dao.entity.BuyerSignupEntity;
import com.project.buyeritemservice.dao.entity.CategoryEntity;
import com.project.buyeritemservice.dao.entity.ItemEntity;
import com.project.buyeritemservice.dao.entity.SellerSignupEntity;
import com.project.buyeritemservice.dao.entity.SubCategoryEntity;
import com.project.buyeritemservice.model.BillDetailsPojo;
import com.project.buyeritemservice.model.BillPojo;
import com.project.buyeritemservice.model.BuyerSignupPojo;
import com.project.buyeritemservice.model.CategoryPojo;
import com.project.buyeritemservice.model.ItemPojo;
import com.project.buyeritemservice.model.SellerSignupPojo;
import com.project.buyeritemservice.model.SubCategoryPojo;

@Service
public class BillServiceImpl implements BillService {
	static Logger LOG = Logger.getLogger(BillServiceImpl.class.getClass());
	@Autowired 
	BillDao billDao;

	@Autowired
	BillDetailsDao BillDetailsDao;
	
	@Override
	@Transactional
	//adds the bill to the database
	public BillPojo saveBill(BillPojo billPojo) {
		LOG.info("Entered saveBill() ");
		BuyerSignupPojo buyerSignupPojo = billPojo.getBuyerPojo();
		BuyerSignupEntity buyerSignupEntity = new BuyerSignupEntity(buyerSignupPojo.getBuyerId(),
				buyerSignupPojo.getBuyerUsername(), buyerSignupPojo.getBuyerPassword(), buyerSignupPojo.getBuyerEmail(),
				buyerSignupPojo.getBuyerMobile(), buyerSignupPojo.getBuyerDate(), null);

		BillEntity billEntity = new BillEntity();
		billEntity.setBillId(0);
		billEntity.setBillAmount(billPojo.getBillAmount());
		billEntity.setBillRemarks(billPojo.getBillRemarks());
		billEntity.setBillType(billPojo.getBillType());
		billEntity.setBillDate(billPojo.getBillDate());
		billEntity.setBuyer(buyerSignupEntity);
		billEntity = billDao.saveAndFlush(billEntity);
		billPojo.setBillId(billEntity.getBillId());

		BillEntity setBillEntity = billDao.findById(billEntity.getBillId()).get();

		Set<BillDetailsEntity> allBillDetailsEntity = new HashSet<BillDetailsEntity>();
		Set<BillDetailsPojo> allBillDetailsPojo = billPojo.getAllBillDetails();

		for (BillDetailsPojo billDetailsPojo : allBillDetailsPojo) {
			ItemPojo itemPojo = billDetailsPojo.getItemPojo();
			SubCategoryPojo subCategoryPojo = itemPojo.getSubCategoryPojo();
			CategoryPojo categoryPojo = subCategoryPojo.getCategoryPojo();
			SellerSignupPojo sellerSignupPojo = itemPojo.getSellerPojo();

			SellerSignupEntity sellerSignupEntity = new SellerSignupEntity(sellerSignupPojo.getSellerId(),
					sellerSignupPojo.getSellerUsername(), sellerSignupPojo.getSellerPassword(),
					sellerSignupPojo.getSellerCompany(), sellerSignupPojo.getSellerBrief(),
					sellerSignupPojo.getSellerGst(), sellerSignupPojo.getSellerAddress(),
					sellerSignupPojo.getSellerEmail(), sellerSignupPojo.getSellerContact(),
					sellerSignupPojo.getSellerWebsite());

			CategoryEntity categoryEntity = new CategoryEntity(categoryPojo.getCategoryId(),
					categoryPojo.getCategoryName(), categoryPojo.getCategoryBrief());

			SubCategoryEntity subCategoryEntity = new SubCategoryEntity(subCategoryPojo.getSubCategoryId(),
					subCategoryPojo.getSubCategoryName(), categoryEntity, subCategoryPojo.getSubCategoryBrief(),
					subCategoryPojo.getSubCategoryGst());

			ItemEntity itemEntity = new ItemEntity(itemPojo.getItemId(), itemPojo.getItemName(),
					itemPojo.getItemImage(), itemPojo.getItemPrice(), itemPojo.getItemStock(),
					itemPojo.getItemDescription(), subCategoryEntity, itemPojo.getItemRemarks(), sellerSignupEntity);

			BillDetailsEntity billDetailsEntity = new BillDetailsEntity(billDetailsPojo.getBillDetailsId(),
					setBillEntity, itemEntity);
			BillDetailsDao.save(billDetailsEntity);

		}
		BasicConfigurator.configure();
		LOG.info("Exited saveBill() ");
		return billPojo;
	}

	}

