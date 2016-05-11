package org.dao;

import java.math.BigDecimal;

import java.util.List;

import org.entity.WxPromotion;
import org.entity.WxPromotionGift;

import org.springframework.data.repository.CrudRepository;

public interface WxPromotionDao extends CrudRepository<WxPromotion, Integer> {
    WxPromotion findById(int id);   
    List<WxPromotion> findAll();
}
