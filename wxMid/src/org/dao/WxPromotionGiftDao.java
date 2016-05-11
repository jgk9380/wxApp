package org.dao;

import org.entity.WxPromotionGift;
import org.entity.WxUser;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//WxPromotionGift
public interface WxPromotionGiftDao extends CrudRepository<WxPromotionGift, String> {
    WxPromotionGift findById(String id);

    @Query(value =
           "select count(*) from wx_promotion_gift " +
           "where ip_address=?1 and to_char(gain_date,'YYYYMMDD')=to_char(sysdate,'YYYYMMDD')", nativeQuery = true)
    int findByIp(String ipAddress);
}
