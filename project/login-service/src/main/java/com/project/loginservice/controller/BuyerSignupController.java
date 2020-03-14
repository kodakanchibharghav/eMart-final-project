package com.project.loginservice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.loginservice.model.BuyerSignupPojo;
import com.project.loginservice.service.BuyerSignupService;


@RestController
@RequestMapping("eMart")
@CrossOrigin
public class BuyerSignupController {
	static Logger LOG = Logger.getLogger(BuyerSignupController.class.getClass());

	@Autowired
	BuyerSignupService buyerSignupService;

	// To Validate Buyer fields using username and password
	@GetMapping("validate")
	BuyerSignupPojo validateBuyer(@RequestHeader("Authorization") String data) {
		LOG.info("Entered end point \'eMart/validate \' ");
		String token[] = data.split(":");
		BuyerSignupPojo buyerSignupPojo = new BuyerSignupPojo();
		buyerSignupPojo.setBuyerUsername(token[0]);
		buyerSignupPojo.setBuyerPassword(token[1]);
		LOG.info("Exited end point \'eMart/validate \' ");
		return buyerSignupService.validateBuyer(buyerSignupPojo);
	}

	// to validate buyer using Id
	@GetMapping("buyer/{buyerId}")
	BuyerSignupPojo getBuyer(@PathVariable("buyerId") Integer buyerId) {
		LOG.info("Entered end point \'eMart/buyer/{buyerId} \' ");
		LOG.info("Exited end point \'eMart/buyer/{buyerId}\' ");
		return buyerSignupService.getBuyer(buyerId);
	}
}
