package org.dao;

import java.math.BigDecimal;

import org.entity.WxApp;

import org.entity.WxSmsLog;

import org.springframework.data.repository.CrudRepository;

public interface WxSmsLogDao extends CrudRepository<WxSmsLog, BigDecimal>{
  
}
