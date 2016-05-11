package org.wx.bo;

import java.math.BigDecimal;

import java.util.Collections;
import java.util.Date;

import java.util.List;

import org.apache.log4j.Logger;

import org.WxBeanFactory;

import org.WxBeanFactoryImpl;

import org.dao.WxAssertDao;
import org.dao.WxPromotionGiftDao;
import org.dao.WxUserDao;

import org.entity.asserts.WxAssert;
import org.entity.asserts.model.WxAssetsType;
import org.entity.WxPromotionGift;
import org.entity.WxUser;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.util.WxUtils;
import org.util.WxUtils;
import org.util.WxUtils;

public class AccountImpl implements Account {
    Long userId;
    WxAssertDao wxAssertDao = WxBeanFactoryImpl.getInstance().getBean("wxAssertDao", WxAssertDao.class);
    WxPromotionGiftDao wxPromotionGiftDao =
        WxBeanFactoryImpl.getInstance().getBean("wxPromotionGiftDao", WxPromotionGiftDao.class);
    WxUserDao wxUserDao = WxBeanFactoryImpl.getInstance().getBean("wxUserDao", WxUserDao.class);

    public AccountImpl(Long userId) {
        this.userId = userId;
    }

    @Override
    public void incomeGift(String giftId) {
        WxUser wxUser = wxUserDao.findById(userId);
        WxPromotionGift wpg = wxPromotionGiftDao.findById(giftId);
        if (wpg == null || wpg.getStatus().intValue() == 2) {
            Logger.getLogger(AccountImpl.class).error("礼品数据错误");
            return;
        }
        if (wpg.getAssertType().getId().intValue() == 0) {
            //лл����
            return;
        }
        wpg.setGainer(wxUser);
        wpg.setGainDate(new Date());
        wpg.setStatus(2);
        wxPromotionGiftDao.save(wpg);
        WxAssert war = new WxAssert();
        war.setId(WxUtils.getSeqencesValue());
        war.setFaceValue(wpg.getFaceVaule());
        war.setAssertType(wpg.getAssertType());
        war.setOccurDate(new Date());
        war.setWxPromotionGift(wpg);
        war.setWxUser(wxUser);
        war.setRemark("gift_Id=" + wpg.getId());
        wxAssertDao.save(war);
    }

    @Override
    public double getLeaveFee() {
        return wxAssertDao.getLeaveFee(userId);
    }

    @Override
    public boolean addFee(int fee) { //ֻ�޸����ݿ�
        WxUser wxUser = wxUserDao.findById(userId);
        if (wxUser == null || wxUser.getTele() == null) {
            Logger.getLogger(AccountImpl.class).error("用户号码不存在");
            return false;
        }

        WxAssert war = new WxAssert();
        war.setId(WxUtils.getSeqencesValue());
        war.setFaceValue(new BigDecimal(0 - fee));
        WxAssetsType wgm = new WxAssetsType();
        wgm.setId(new BigDecimal(2));
        war.setAssertType(wgm);
        war.setOccurDate(new Date());
        war.setWxUser(wxUser);
        war.setRemark("为号码：" + wxUser.getTele() + "缴费");
        wxAssertDao.save(war);
        return true;
    }

    @Override
    public boolean transferfee(String tele, double fee) {
        //System.out.println("���͵�fee="+fee);
        WxUser wxUser = wxUserDao.findById(userId);
        WxUser targetWxUser = wxUserDao.findByTeleAndAppId(tele, wxUser.getWxApp().getId());

        if (wxUser == null || wxUser.getTele() == null) {
            Logger.getLogger(AccountImpl.class).error("没有号码或错误的用户");
            return false;
        }
        if (targetWxUser == null) {
            Logger.getLogger(AccountImpl.class).error("号码不正确,请提醒你的好友绑定号码'");
            return false;
        }
        if (this.getLeaveFee() < fee || fee < 0) {
            Logger.getLogger(AccountImpl.class).error("余额不足或金额错误");
            return false;
        }

        //�ɷ�
        WxAssert war = new WxAssert();
        war.setId(WxUtils.getSeqencesValue());
        war.setFaceValue(new BigDecimal(0 - fee));
        WxAssetsType wgm = new WxAssetsType();
        wgm.setId(new BigDecimal(2));
        war.setAssertType(wgm);
        war.setOccurDate(new Date());
        war.setWxUser(wxUser);
        war.setRemark("赠送号码为" + targetWxUser.getTele() + "的用户，用户Id=" + targetWxUser.getId());
        wxAssertDao.save(war);
        WxAssert targetWar = new WxAssert();
        targetWar.setId(WxUtils.getSeqencesValue());
        targetWar.setFaceValue(new BigDecimal(fee));
        targetWar.setAssertType(wgm);
        targetWar.setOccurDate(new Date());
        targetWar.setWxUser(targetWxUser);
        targetWar.setRemark("来自ID=" + wxUser.getId() + "昵称为"+wxUser.getNickname()+" 的用户赠送");
        //TODO  ������Ϣ�����͵Ŀͻ�
        wxAssertDao.save(targetWar);
        return true;
    }

    public static void main(String[] args) {
        { //�������Ͳ���
            Account ac = WxBeanFactoryImpl.getInstance().getAccount(8335201);

            {
                //ac.incomeGift("LT13W3753140");
                System.out.println("leaveTraff=" + ac.getLeaveTraffic());
                ac.transferTraffic("15651554832",21);
                System.out.println("leaveTraff=" + ac.getLeaveTraffic());
            }

        }
    }


    @Override
    public double getAllFeeGift() {
        return wxAssertDao.getAllIncomeFee(this.userId);
    }

    @Override
    public double getUseFeeGift() {
        return wxAssertDao.getTotalUsedFee(this.userId);
    }


    @Override
    public List<WxAssert> getAllCouponList() {
      return  wxAssertDao.findCouponList(this.userId);         
    }


    @Override
    public void useCoupon(BigDecimal CouponId) {
        // TODO Implement this method
    }

    @Override
    public int getLeaveTraffic() {
        return wxAssertDao.getLeaveTraffic(userId);        
    }

    @Override
    public boolean addTraffic(int traffic) {
        if(this.getLeaveTraffic()<traffic){
            Logger.getLogger(AccountImpl.class).error("流量不足");
            return false;
        }
        WxUser wxUser = wxUserDao.findById(userId);
        if (wxUser == null || wxUser.getTele() == null) {
            Logger.getLogger(AccountImpl.class).error("用户号码不存在");
            return false;
        }
        WxAssetsType wgm = new WxAssetsType();
        wgm.setId(new BigDecimal(3));
        WxAssert war = new WxAssert();
        war.setId(WxUtils.getSeqencesValue());
        war.setFaceValue(new BigDecimal(0 - traffic));       
        war.setAssertType(wgm);
        war.setOccurDate(new Date());
        war.setWxUser(wxUser);
        war.setRemark("为号码：" + wxUser.getTele() + "充流量");
        wxAssertDao.save(war);
        return true;
    }

    @Override
    public boolean transferTraffic(String tele, int traffic) {
        //System.out.println("���͵�fee="+fee);
        WxUser wxUser = wxUserDao.findById(userId);
        WxUser targetWxUser = wxUserDao.findByTeleAndAppId(tele, wxUser.getWxApp().getId());

        if (wxUser == null || wxUser.getTele() == null) {
            Logger.getLogger(AccountImpl.class).error("没有号码或错误的用户");
            return false;
        }
        if (targetWxUser == null) {
            Logger.getLogger(AccountImpl.class).error("号码不正确,请提醒你的好友绑定号码'");
            return false;
        }
        if (this.getLeaveTraffic() < traffic || traffic < 0) {
            Logger.getLogger(AccountImpl.class).error("余额不足或金额错误");
            return false;
        }

        WxAssetsType wgm = new WxAssetsType();
        wgm.setId(new BigDecimal(3));
        
        WxAssert war = new WxAssert();
        war.setId(WxUtils.getSeqencesValue());
        war.setFaceValue(new BigDecimal(0 - traffic));
        
        war.setAssertType(wgm);
        war.setOccurDate(new Date());
        war.setWxUser(wxUser);
        war.setRemark("赠送号码为" + targetWxUser.getTele() + "的用户，用户Id=" + targetWxUser.getId());
        wxAssertDao.save(war);
        WxAssert targetWar = new WxAssert();
        targetWar.setId(WxUtils.getSeqencesValue());
        targetWar.setFaceValue(new BigDecimal(traffic));
        targetWar.setAssertType(wgm);
        targetWar.setOccurDate(new Date());
        targetWar.setWxUser(targetWxUser);
        targetWar.setRemark("来自ID=" + wxUser.getId() + "昵称为"+wxUser.getNickname()+" 的用户赠送");   
        wxAssertDao.save(targetWar);
        return true;
    }

    @Override
    public double getTotalIncomeTraffic() {
        // TODO Implement this method
        return wxAssertDao.getTotalIncomeTraffic(userId);  
    }

    @Override
    public double getUsedTraffic() {
         
        return wxAssertDao.getTotalUseTraffice(userId);  
    }

    @Override
    public boolean transferCoupon(String tele, double fee) {      
        return false;
    }
}
