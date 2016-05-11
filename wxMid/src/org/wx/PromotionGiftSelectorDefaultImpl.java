package org.wx;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.WxBeanFactory;
import org.WxBeanFactoryImpl;

import org.dao.WxPromotionDao;

import org.dao.WxPromotionGiftDao;

import org.entity.WxPromotion;

import org.entity.WxPromotionGift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component("defaultPromotionGiftSelector")
public class PromotionGiftSelectorDefaultImpl extends PromotionGiftSelectorBaseImpl {
    public PromotionGiftSelectorDefaultImpl() {
        super();
    }
    @Autowired
    JdbcTemplate jdbcTemplate; // = WxBeanFactoryImpl.getInstance().getJdbcTemplate();
    @Autowired
    WxPromotionDao wxPromotionDao; // = WxBeanFactoryImpl.getInstance().getBean("wxPromotionDao", WxPromotionDao.class);
    @Autowired
    WxPromotionGiftDao wxPromotionGiftDao;


    @Override
    //TODO 事务管理
    //@Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
    //@Transactional(isolation = Isolation.SERIALIZABLE)
    //    public WxPromotionGift getGiftId(long userId, int promotionId) {
    //        if (!isUserAllowJoioned(userId, promotionId))
    //            return null;
    //        WxPromotion wp = wxPromotionDao.findById(promotionId);
    //        String sql = wp.getGiftSelectSql();
    //        Map<String, Object> params = new HashMap<>();
    //        params.put("userId", userId);
    //        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(jdbcTemplate);
    //        List<String> gfitIdList = npjt.queryForList(sql, params, String.class);
    //        if (gfitIdList.size() == 0)
    //            return null;
    //        for (int i = 0; i < 10; i++) {
    //            Date currentDate = new Date();
    //            int rand = (int) (currentDate.getTime() % gfitIdList.size());
    //            String giftId = gfitIdList.get(rand);
    //            //根据当前毫秒随机取Gift并改为预占用状态
    //            WxPromotionGift wpg = super.preOccupy(giftId);
    //            if (wpg != null) {
    //                return wpg;
    //            }
    //        }
    //
    //        return null;
    //    }

    //@Transactional(isolation = Isolation.SERIALIZABLE)
    public WxPromotionGift getGiftId(long userId, int promotionId) {
        if (!isUserAllowJoioned(userId, promotionId))
            return null;
        WxPromotion wp = wxPromotionDao.findById(promotionId);
        String sql = wp.getGiftSelectSql();
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(jdbcTemplate);
        List<String> gfitIdList = npjt.queryForList(sql, params, String.class);
        if (gfitIdList.size() == 0)
            return null;
        for (int i = 0; i < 10; i++) {
            Date currentDate = new Date();
            int rand = (int) (currentDate.getTime() % gfitIdList.size());
            String giftId = gfitIdList.get(rand);
            //根据当前毫秒随机取Gift并改为预占用状态
            //WxPromotionGift wpg = super.preOccupy(giftId);
            WxPromotionGift wpg = super.preOccupy(giftId);
            if (wpg != null) {
                return wpg;
            }
        }
        return null;
    }


    protected boolean isUserAllowJoioned(long userId, int promotionId) {
        // TODO Implement this method
        if (super.isUserAllowJoioned(userId, promotionId) == false)
            return false;

        WxPromotion wp = wxPromotionDao.findById(promotionId);
        String sql = wp.getAllowJoinSql();
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(jdbcTemplate);
        List<Long> allowUserIds = npjt.queryForList(sql, params, Long.class);
        if (allowUserIds.size() == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PromotionGiftSelectorDefaultImpl pi =
            WxBeanFactoryImpl.getInstance().getBean("defaultPromotionGiftSelector",
                                                    PromotionGiftSelectorDefaultImpl.class);
        for (int i = 0; i < 10; i++) {
            Date d1 = new Date();
            pi.getGiftId(3007095, 3);
            Date d2 = new Date();
            System.out.println(d1.getTime() - d2.getTime());
        }
    }

}
