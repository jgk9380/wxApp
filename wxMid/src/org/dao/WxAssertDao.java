package org.dao;

import java.math.BigDecimal;

import java.util.List;

import org.entity.asserts.WxAssert;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WxAssertDao extends CrudRepository<WxAssert, BigDecimal> {
    
    WxAssert findById(BigDecimal id);
    //话费部分
    @Query(value = "select round(nvl(sum(face_vaule),0),2) from wx_account_rec where user_id=?1 and gift_model=2 ",
           nativeQuery = true)
    double getLeaveFee(long userId);
    @Query(value = "select round(nvl(sum(face_vaule),0),2) from wx_account_rec where user_id=?1 and gift_model=2 and face_vaule>0",
           nativeQuery = true)   
    double getAllIncomeFee(long userId);
   
    @Query(value = "select round(nvl(sum(face_vaule),0),2) from wx_account_rec where user_id=?1 and gift_model=2 and face_vaule<0",
           nativeQuery = true)
    double getTotalUsedFee(long userId);
    
    //流量部分
    @Query(value = "select round(nvl(sum(face_vaule),0)) from wx_account_rec where user_id=?1 and gift_model=3 ",
           nativeQuery = true)
    int getLeaveTraffic(long userId);
    @Query(value = "select round(nvl(sum(face_vaule),0)) from wx_account_rec where user_id=?1 and gift_model=3 and face_vaule>0",
           nativeQuery = true)   
    double getTotalIncomeTraffic(long userId);
    @Query(value = "select round(nvl(sum(face_vaule),0)) from wx_account_rec where user_id=?1 and gift_model=3 and face_vaule<0",
           nativeQuery = true)
    double getTotalUseTraffice(long userId);
    // 代金券
    @Query("select u from WxAssert u where u.assertType.id in(select x.id from WxCouponType x) and u.wxUser.id=?1")
    List<WxAssert> findCouponList(long userId);  //����������б�

    @Query("select u from WxAssert u where u.assertType.id in(select x.id from WxCouponType x) and u.id=?1")
    WxAssert findCouponById(long couponId);  //����������б�
//    List<WxAssert> findCouponList();// ��ô���ȯ�б�
//    
//    List<WxAssert> findMatterList();//���ʵ����Ʒ�б�
    
}
