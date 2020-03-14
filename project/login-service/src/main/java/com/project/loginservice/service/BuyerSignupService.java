package com.project.loginservice.service;

import com.project.loginservice.model.BuyerSignupPojo;

public interface BuyerSignupService {

	BuyerSignupPojo validateBuyer(BuyerSignupPojo buyerSignupPojo);

	BuyerSignupPojo getBuyer(Integer buyerId);

}
