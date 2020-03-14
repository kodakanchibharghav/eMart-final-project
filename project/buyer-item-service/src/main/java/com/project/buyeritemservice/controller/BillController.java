package com.project.buyeritemservice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.buyeritemservice.model.BillPojo;
import com.project.buyeritemservice.service.BillService;

@RestController
@RequestMapping("eMart")
@CrossOrigin

public class BillController {
	static Logger LOG = Logger.getLogger(BillController.class.getClass());

	@Autowired
	BillService billService;

	@PostMapping("bill")
	BillPojo saveBill(@RequestBody BillPojo billPojo) {
		LOG.info("Entered end point \'eMart/bill \' ");
		LOG.info("Exited end point \'eMart/bill \' ");
		return billService.saveBill(billPojo);
	}
}
