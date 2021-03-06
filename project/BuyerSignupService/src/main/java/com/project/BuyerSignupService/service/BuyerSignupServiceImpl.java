package com.project.BuyerSignupService.service;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.BuyerSignupService.dao.BuyerSignupDao;
import com.project.BuyerSignupService.dao.entity.BuyerSignupEntity;
import com.project.BuyerSignupService.model.BuyerSignupPojo;

@Service
public class BuyerSignupServiceImpl implements BuyerSignupService{
	
	static Logger LOG = Logger.getLogger(BuyerSignupServiceImpl.class.getClass());
	@Autowired
	BuyerSignupDao buyerSignupDao;

	@Override
	@Transactional
	public BuyerSignupPojo addBuyer(BuyerSignupPojo buyerSignupPojo) {
		LOG.info("entered addBuyer()");
		BuyerSignupEntity buyerSignupEntity = new BuyerSignupEntity(buyerSignupPojo.getBuyerId(),
															buyerSignupPojo.getBuyerUsername(),
															buyerSignupPojo.getBuyerPassword(),
															buyerSignupPojo.getBuyerEmail(),
															buyerSignupPojo.getBuyerMobile(),
														 buyerSignupPojo.getBuyerDate());
		buyerSignupDao.save(buyerSignupEntity);
		LOG.info("Exited addBuyer()");
		return buyerSignupPojo;
	}

		
		

}
