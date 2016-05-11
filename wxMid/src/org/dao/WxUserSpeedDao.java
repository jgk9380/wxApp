package org.dao;

import org.entity.WxTestSpeedLog;

import org.entity.WxUserSpeed;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WxUserSpeedDao extends CrudRepository<WxUserSpeed, Long> {
    WxUserSpeed findByUserId(Long userId);
    //
    @Query(value =
           "select nvl(r,0) " +
           "from (select user_id,speed,rank() over(order by speed desc) r from  wx_user_speed ) where user_id=?1",
           nativeQuery = true)
    int findRankByUserid(Long userId);

    @Query(value = "select count(*) from wx_user_speed  ", nativeQuery = true)
    int findAllSpeedUser();
}
