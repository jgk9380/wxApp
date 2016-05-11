package org.dao;

import java.math.BigDecimal;

import org.entity.WxApp;
import org.entity.WxMsgType;
import org.entity.WxUserMsg;

import org.springframework.data.repository.CrudRepository;

public interface WxMsgTypeDao extends CrudRepository<WxMsgType, String>{
    WxMsgType findById(String id);
}
