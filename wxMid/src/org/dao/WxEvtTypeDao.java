package org.dao;

import org.entity.WxEventType;
import org.entity.WxMsgType;

import org.springframework.data.repository.CrudRepository;

public interface WxEvtTypeDao extends CrudRepository<WxEventType, String>{
    WxEventType findById(String id);
}