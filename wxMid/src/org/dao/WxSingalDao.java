package org.dao;

import org.entity.WxApp;

import org.entity.WxSingal;

import org.springframework.data.repository.CrudRepository;
//WxSingal
public interface WxSingalDao extends CrudRepository<WxSingal, String> {
  
}
