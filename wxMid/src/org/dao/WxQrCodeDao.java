package org.dao;

import java.math.BigDecimal;

import org.entity.qrcode.WxPermQrCode;
import org.entity.qrcode.WxQrCode;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WxQrCodeDao extends CrudRepository<WxQrCode, String> {
    WxQrCode findByTicket(String ticket);
    @Query("select o from WxQrCode o where o.destType='user'  and o.destId=?1")
    WxQrCode findByUserId(long userId);
    @Query("select o from WxQrCode o where o.destType='coupon' and o.destId=?1")
    WxQrCode findByConponId(long conponId);
    @Query("select o from WxQrCode o where o.destType='coupon' and o.sencenId=?1")
    WxQrCode findCouponQrCodeByScenenId(long scenenId);
}
