package org.dao;

import java.util.List;

import org.entity.WxMail;
import org.entity.WxMsgType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WxMailDao extends CrudRepository<WxMail, Long>{
    WxMail findById(Long id);
    @Query("select u from WxMail  u where u.userId = ?1 and u.isSend=false")
    List<WxMail> findNoSendedMailByUserId(long userId);
}
