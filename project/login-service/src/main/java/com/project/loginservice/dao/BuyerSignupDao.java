package com.project.loginservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.loginservice.dao.entity.BuyerSignupEntity;


@Repository
public interface BuyerSignupDao extends JpaRepository<BuyerSignupEntity, Integer> {

	BuyerSignupEntity findByBuyerUsernameAndBuyerPassword(String username, String password);
}
