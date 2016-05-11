package org.wx;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.WxBeanFactoryImpl;

import org.springframework.transaction.annotation.Transactional;

import org.apache.log4j.Logger;

import org.dao.WxAssertDao;
import org.dao.WxPromotionGiftDao;
import org.dao.WxUserDao;

import org.entity.asserts.WxAssert;
import org.entity.WxPromotionGift;
import org.entity.WxUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.util.WxUtils;


@Component("promotionManager")

public class PromotionManager {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    WxPromotionGiftDao wxPromotionGiftDao;

    @Autowired
    WxUserDao wxUserDao;
    @Autowired
    WxAssertDao wxAssertDao;
    //TODO   该函数需要事务管理
    public boolean ggkIncomeGift(long userId, String giftId,String ipAddress) {
        //System.out.println("-----ipAddress=" + ipAddress);
        WxUser wxUser = wxUserDao.findById(userId);
        
        WxPromotionGift pg = wxPromotionGiftDao.findById(giftId);
        { //TODO 检查是否已经被更新
            pg.setGainDate(new Date());
            pg.setGainWay("刮刮卡");
            pg.setGainer(wxUser);
            pg.setStatus(2);
            pg.setIpAddress(ipAddress);
            wxPromotionGiftDao.save(pg);
        }
        if (pg.getAssertType().getId().intValue() == 0 || pg.getAssertType() == null) {
            return true;
        }
        BigDecimal id = WxUtils.getSeqencesValue();
        WxAssert war = new WxAssert();
        war.setId(id);
        war.setAssertType(pg.getAssertType());
        war.setWxUser(wxUser);
        war.setFaceValue(pg.getFaceVaule());
        war.setWxPromotionGift(pg);
        war.setOccurDate(new Date());
        war.setRemark("来自刮刮卡活动奖励");
       
        wxAssertDao.save(war);
        return true;
    }
}
