package com.project.SellerSignupService.controller;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.SellerSignupService.model.SellerSignupServicePojo;
import com.project.SellerSignupService.service.SellerSignupService;




@CrossOrigin
@RestController
@RequestMapping("emart")


public class SellerSignupServiceController {

	static Logger LOG = Logger.getLogger(SellerSignupServiceController.class.getClass());
	
	@Autowired
	SellerSignupService sellerSignup;
	
	@PostMapping("seller")
	

	SellerSignupServicePojo addSeller(@RequestBody SellerSignupServicePojo sellerPojo)
	{
		BasicConfigurator.configure();
		LOG.info("entered controller add seller");

		LOG.info("exited controller add seller");
		return sellerSignup.addSeller(sellerPojo);
	}
	
	
	
}
