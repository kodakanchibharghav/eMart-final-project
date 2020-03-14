package com.project.buyeritemservice.service;

import java.util.*;

import com.project.buyeritemservice.model.ItemPojo;

public interface ItemService {
	List<ItemPojo> getAllItems();

	ItemPojo getItem(Integer itemId);

	void deleteItem(Integer itemId);

	ItemPojo addItem(ItemPojo itemPojo);

	ItemPojo updateItem(ItemPojo itemPojo);
}
