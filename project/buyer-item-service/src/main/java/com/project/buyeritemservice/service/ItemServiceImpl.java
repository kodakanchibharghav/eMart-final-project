package com.project.buyeritemservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
import java.util.Optional;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.buyeritemservice.dao.ItemDao;
import com.project.buyeritemservice.dao.entity.CategoryEntity;
import com.project.buyeritemservice.dao.entity.ItemEntity;
import com.project.buyeritemservice.dao.entity.SellerSignupEntity;
import com.project.buyeritemservice.dao.entity.SubCategoryEntity;
import com.project.buyeritemservice.model.CategoryPojo;
import com.project.buyeritemservice.model.ItemPojo;
import com.project.buyeritemservice.model.SellerSignupPojo;
import com.project.buyeritemservice.model.SubCategoryPojo;

@Service
public class ItemServiceImpl implements ItemService {
	static Logger LOG = Logger.getLogger(ItemServiceImpl.class.getClass());

	@Autowired
	ItemDao itemDao;

	@Override
	//Fetching all Items
	public List<ItemPojo> getAllItems() {
		LOG.info("entered getAllItems()");
		List<ItemPojo> allItemPojo = new ArrayList();
		Iterable<ItemEntity> allItemEntity = itemDao.findAll();
		Iterator itr = allItemEntity.iterator();
		while (itr.hasNext()) {
			ItemEntity itemEntity = (ItemEntity) itr.next();
			SubCategoryEntity subCategoryEntity = itemEntity.getSubcategory();
			CategoryEntity categoryEntity = subCategoryEntity.getCategory();
			SellerSignupEntity sellerSignupEntity = itemEntity.getSeller();

			CategoryPojo categoryPojo = new CategoryPojo(categoryEntity.getCategoryId(),
					categoryEntity.getCategoryName(), categoryEntity.getCategoryBrief());
			SubCategoryPojo subCategoryPojo = new SubCategoryPojo(subCategoryEntity.getSubCategoryId(),
					subCategoryEntity.getSubCategoryName(), categoryPojo, subCategoryEntity.getSubCategoryBrief(),
					subCategoryEntity.getSubCategoryGst());
			SellerSignupPojo sellerPojo = new SellerSignupPojo(sellerSignupEntity.getSellerId(),
					sellerSignupEntity.getSellerUsername(), sellerSignupEntity.getSellerPassword(),
					sellerSignupEntity.getSellerCompany(), sellerSignupEntity.getSellerBrief(),
					sellerSignupEntity.getSellerGst(), sellerSignupEntity.getSellerAddress(),
					sellerSignupEntity.getSellerEmail(), sellerSignupEntity.getSellerContact(),
					sellerSignupEntity.getSellerWebsite());

			ItemPojo itemPojo = new ItemPojo(itemEntity.getItemId(), itemEntity.getItemName(),
					itemEntity.getItemImage(), itemEntity.getItemPrice(), itemEntity.getItemStock(),
					itemEntity.getItemDescription(), subCategoryPojo, itemEntity.getItemRemarks(), sellerPojo);

			allItemPojo.add(itemPojo);

		}
		BasicConfigurator.configure();
		LOG.info("exited getAllItems()");
		return allItemPojo;
	}

	@Override
// Fetching  Item with particularId
	public ItemPojo getItem(Integer itemId) {
		{
			LOG.info("Entered getItem()");
			ItemPojo itemPojo = null;
			Optional result = itemDao.findById(itemId);
			if (result.isPresent()) {

				ItemEntity itemEntity = (ItemEntity) result.get();
				SubCategoryEntity subCategoryEntity = itemEntity.getSubcategory();
				CategoryEntity categoryEntity = subCategoryEntity.getCategory();
				SellerSignupEntity sellerSignupEntity = itemEntity.getSeller();

				CategoryPojo categoryPojo = new CategoryPojo(categoryEntity.getCategoryId(),
						categoryEntity.getCategoryName(), categoryEntity.getCategoryBrief());
				SubCategoryPojo subCategoryPojo = new SubCategoryPojo(subCategoryEntity.getSubCategoryId(),
						subCategoryEntity.getSubCategoryName(), categoryPojo, subCategoryEntity.getSubCategoryBrief(),
						subCategoryEntity.getSubCategoryGst());
				SellerSignupPojo sellerPojo = new SellerSignupPojo(sellerSignupEntity.getSellerId(),
						sellerSignupEntity.getSellerUsername(), sellerSignupEntity.getSellerPassword(),
						sellerSignupEntity.getSellerCompany(), sellerSignupEntity.getSellerBrief(),
						sellerSignupEntity.getSellerGst(), sellerSignupEntity.getSellerAddress(),
						sellerSignupEntity.getSellerEmail(), sellerSignupEntity.getSellerContact(),
						sellerSignupEntity.getSellerWebsite());

				itemPojo = new ItemPojo(itemEntity.getItemId(), itemEntity.getItemName(), itemEntity.getItemImage(),
						itemEntity.getItemPrice(), itemEntity.getItemStock(), itemEntity.getItemDescription(),
						subCategoryPojo, itemEntity.getItemRemarks(), sellerPojo);

			}
			BasicConfigurator.configure();
			LOG.info("Exited getItem() ");
			return itemPojo;

		}
	}

	@Override
	public void deleteItem(Integer itemId) {
		LOG.info("Entered deleteItem()");
		itemDao.deleteById(itemId);
		LOG.info("exited deleteItem()");
	}

	@Override
	public ItemPojo addItem(ItemPojo itemPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemPojo updateItem(ItemPojo itemPojo) {
		// TODO Auto-generated method stub
		return null;
	}

}
