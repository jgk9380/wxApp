package org.dao;

import java.util.List;

import org.entity.WxMail;
import org.entity.WxMailArticle;
import org.entity.WxMsgType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WxMailArticleDao extends CrudRepository<WxMailArticle, Long>{
    WxMailArticle findById(Long id);
    @Query("select u from WxMailArticle  u where u.userId = ?1 and u.isSend=false")
    List<WxMailArticle> findNoSendedMailByUserId(long userId);
}
