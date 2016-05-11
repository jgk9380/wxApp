package org.wx;

import java.util.Date;

import org.WxBeanFactoryImpl;

import org.dao.WxPromotionDao;

import org.dao.WxPromotionGiftDao;

import org.entity.WxPromotion;

import org.entity.WxPromotionGift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

public abstract class PromotionGiftSelectorBaseImpl implements PromotionGiftSelector {
    public PromotionGiftSelectorBaseImpl() {
        super();
    }

    @Autowired
    JdbcTemplate jdbcTemplate; // = WxBeanFactoryImpl.getInstance().getJdbcTemplate();
    @Autowired
    WxPromotionDao wxPromotionDao;

    @Override
    abstract public WxPromotionGift getGiftId(long userId, int promotionId);

    protected boolean isUserAllowJoioned(long userId, int promotionId) {
        // TODO Implement this method
        WxPromotion wp = wxPromotionDao.findById(promotionId);
        Date currentDate = new Date();
        if (!wp.getStartDate().before(currentDate) || !wp.getEndDate().after(currentDate)) {
            return false;
        }
        return true;
    }
    
   
    protected WxPromotionGift preOccupy(String giftId) {
        WxPromotionGiftDao wxPromotionGiftDao =
            WxBeanFactoryImpl.getInstance().getBean("wxPromotionGiftDao", WxPromotionGiftDao.class);
        WxPromotionGift wpg = wxPromotionGiftDao.findById(giftId);
        if (wpg.getStatus().intValue() != 0)
            return null;
        wpg.setStatus(1);
        wxPromotionGiftDao.save(wpg);
        return wpg;
    }


}
