package com.project.buyeritemservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.buyeritemservice.dao.entity.BillDetailsEntity;


@Repository
public interface BillDetailsDao extends JpaRepository<BillDetailsEntity, Integer> {

}
