package org.dao;

import java.math.BigDecimal;

import org.entity.WxApp;

import org.entity.WxPerQrCode;

import org.springframework.data.repository.CrudRepository;

import org.wxenum.ScenenFlag;

public interface WxPerQrCodeDao extends CrudRepository<WxPerQrCode, String> {    
    WxPerQrCode findByTicket(String ticket);
    WxPerQrCode findByUserId(long userId);
    WxPerQrCode findBySencenId(BigDecimal sencenId);
}

