package org.wx.bo;

import java.math.BigDecimal;

import java.util.List;
import java.util.Map;

import org.entity.asserts.WxAssert;

import org.springframework.stereotype.Component;

public interface Account {
    // 获得礼品
    void incomeGift(String giftId);

    //话费部分
    double getLeaveFee(); //剩余话费

    boolean addFee(int fee);

    boolean transferfee(String tele, double fee);

    double getAllFeeGift(); //获得的所有话费

    double getUseFeeGift(); //使用过的话费

    //流量部分
    int getLeaveTraffic(); //剩余流量

    boolean addTraffic(int traffic); //使用流量

    boolean transferTraffic(String tele, int traffic);

    double  getTotalIncomeTraffic(); //获得流量

    double getUsedTraffic(); //使用过流量

    // 流量包
    //    List<WxAssert> getTrafficeBagList();
    //
    //    void useTrafficeBag(BigDecimal TrafficeBag);

    //代金券
    List<WxAssert> getAllCouponList();
    void useCoupon(BigDecimal CouponId);    
    boolean transferCoupon(String tele, double fee);

    //   //礼品
    //    public List<WxAssert> getUnMailMatter();
    //    public void mailMatter(String MatterId);


}


