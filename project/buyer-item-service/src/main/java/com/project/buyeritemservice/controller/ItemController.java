package com.project.buyeritemservice.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.buyeritemservice.model.ItemPojo;
import com.project.buyeritemservice.service.ItemService;

@RestController
@CrossOrigin
@RequestMapping("eMart")

public class ItemController {
	static Logger LOG = Logger.getLogger(ItemController.class.getClass());

	@Autowired
	ItemService itemService;

	// it displays allitems
	@GetMapping("/item/all")
	List<ItemPojo> getAllItems() {
		LOG.info("Entered end point \'eMart/item/all \' ");
		LOG.info("Exited end point \'eMart/item/all \' ");
		return itemService.getAllItems();
	}

	// it displays item with particular Id
	@GetMapping("item/{itemId}")
	ItemPojo getItem(@PathVariable("itemId") Integer itemId) {
		LOG.info("Entered end point \'eMart/item/{itemId} \' ");
		LOG.info("Exited end point \'eMart/item/{itemId} \' ");
		return itemService.getItem(itemId);
	}

	// it deletes item with particularId
	@DeleteMapping("/item/{itemId}")
	void deleteEmployee(@PathVariable("itemId") Integer itemId) {
		LOG.info("Entered end point \'eMart/item/{itemId} \' ");
		LOG.info("Exited end point \'eMart/item/{itemId}\' ");
		itemService.deleteItem(itemId);
	}

	// it adds the item
	@PostMapping("/item")
	ItemPojo additem(@RequestBody ItemPojo itemPojo) {
		LOG.info("Entered end point \'eMart/item \' ");
		LOG.info("Exited end point \'eMart/item\' ");
		return itemService.addItem(itemPojo);
	}
}
