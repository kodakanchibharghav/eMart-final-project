package com.project.buyeritemservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.buyeritemservice.dao.entity.ItemEntity;


@Repository
public interface ItemDao extends JpaRepository<ItemEntity,Integer>{

}
