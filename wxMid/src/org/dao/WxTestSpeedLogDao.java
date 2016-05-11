package org.dao;

import java.math.BigDecimal;

import java.util.List;

import org.entity.WxPromotionGift;
import org.entity.WxSmsLog;

import org.entity.WxTestSpeedLog;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WxTestSpeedLogDao extends CrudRepository<WxTestSpeedLog, Long> {

    WxTestSpeedLog findMaxSpeedByUserId(Long id);
    @Query(value =
           "select count(*) from wx_test_speed_log " +
           "where user_id=?1 and to_char(test_date,'YYYYMMDD')=to_char(sysdate,'YYYYMMDD')", nativeQuery = true)
    int findTimesByUserId(Long userId);
 
}
