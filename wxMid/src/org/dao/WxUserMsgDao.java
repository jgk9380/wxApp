package org.dao;

import java.math.BigDecimal;

import java.util.List;

import org.entity.WxUser;

import org.entity.WxUserMsg;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WxUserMsgDao  extends CrudRepository<WxUserMsg, BigDecimal>  {
    WxUserMsg findById(BigDecimal id);  
    @Query(value="select count(*) from wx_user_msg where user_id=?1 and occur_date>(sysdate-1) ",nativeQuery=true)
    long get24HourMsgByUserId(long userId);
}
