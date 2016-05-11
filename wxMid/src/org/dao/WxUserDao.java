package org.dao;

import java.math.BigDecimal;

import java.util.List;

import org.entity.WxUser;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//WxUserEvent

public interface WxUserDao extends CrudRepository<WxUser, Long> {
    WxUser findById(long id);
    @Query(value = "select o from WxUser o where o.openId=:openId and o.wxApp.id=:appId")
    WxUser findByAppIdAndOpenId(@Param("appId") String appId,@Param("openId")  String openId);   
    @Query(value = "select o from WxUser o where o.tele=:tele and o.wxApp.id=:appId")
    WxUser findByTeleAndAppId(@Param("tele") String tele, @Param("appId") String appId);
    @Query(value = "select count(o) from WxUser o where o.referee=?1 and o.subscribeStatus=1")
    int getRefereeCount(WxUser wxUser);
    @Query(value = "select count(o) from WxUser o where o.referee=?1 and o.subscribeStatus=-1")
    int getRefereeCacelCount(WxUser wxUser);
    @Query(value = "select o from WxUser o where o.nickname is null and o.subscribeStatus=1 and o.wxApp.id=?1")
    List<WxUser> findNullNickUsers(String appId);
    @Query(value = "select unique referee_id from wx_user where  referee_id is not null",nativeQuery=true)
    List<BigDecimal> findRefereeList();
    @Query(value = "select nickname from wx_user where  referee_id=?1 and (referee_id,subscribe_date) in (select referee_id,max(subscribe_date)    from wx_user group by referee_id)",nativeQuery=true)
    String findLastRefereeName(long id);    
    @Query(value = "select id from Wx_User o where o.subscribe_Status =0 and o.App_id=?1", nativeQuery=true)
    List<BigDecimal> findNoSubUsers(String appId);
    @Query(value="select  id from wx_user where id in (select user_id from wx_user_msg where create_time>(sysdate-2) )",nativeQuery=true)
    List<BigDecimal> find48Users();
    
}
