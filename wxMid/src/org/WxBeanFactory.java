package org;

import java.math.BigDecimal;

import org.dao.WxUserDao;

import org.entity.WxUser;

import org.wx.data.service.DataServiceListener;



import org.util.UserService;

import org.util.UserServiceImpl;


import org.util.sms.Sms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import org.wx.WxAppManager;
import org.wx.bo.Account;
import org.wx.PromotionGiftSelector;
import org.wx.PromotionManager;
import org.wx.bo.WxUserBo;

import org.wx.msg.MsgActionListener;
import org.wx.msg.evt.EventActionListener;
import org.wx.msg.evt.menu.MenuActionListener;

public interface WxBeanFactory {
    /**用于一个程序适用多个微信号*/
       //  WxAppManager getWxAppManagerByAppId(String appId);
       //WxAppManager getWxAppManagerByAppUserName(String appUserName);
       //WxAppManager getWxAppManagerByAppName(String fromUser);
    WxAppManager getWxAppManager(String appName);
    MsgActionListener getMsgActionListener(String name);
    EventActionListener getEvtActionListener(String name);
    MenuActionListener getMenuActionListener(String name); 
    DataServiceListener getDataServiceListener(String name); 
    UserService getUserService();  
    JdbcTemplate getJdbcTemplate();
    PromotionGiftSelector getPromotionGiftSelector(String name);
    Account getAccount(long userId);
    WxUserBo getUserBo(WxUser wxUser);  
    WxConfig getConfig();    
    PromotionManager getPromotionManager() ;
    <T> T getBean(String beanName, Class<T> clazz);   
 
}
