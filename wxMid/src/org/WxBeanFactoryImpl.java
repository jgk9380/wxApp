package org;


import java.math.BigDecimal;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.naming.NamingException;


import javax.sql.DataSource;

import javax.transaction.Transactional;

import org.dao.WxAppDao;

import org.dao.WxUserDao;

import org.entity.WxApp;
import org.entity.WxUser;

import org.wx.data.service.DataServiceListener;


import org.util.UserService;


import org.pojo.WeixinUserInfo;
import org.pojo.WeixinUserList;

import org.springframework.beans.factory.annotation.Autowired;

import org.util.sms.Sms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import org.springframework.stereotype.Component;

import org.wx.PromotionManager;
import org.wx.WxAppManager;
import org.wx.WxAppManagerImpl;
import org.wx.bo.Account;
import org.wx.bo.AccountImpl;
import org.wx.PromotionGiftSelector;

import org.wx.msg.MsgActionListener;
import org.wx.msg.evt.EventActionListener;
import org.wx.bo.WxUserBo;
import org.wx.bo.WxUserBoImpl;
import org.wx.msg.evt.menu.MenuActionListener;


public class WxBeanFactoryImpl implements WxBeanFactory {
    Map<String, WxAppManager> wxAppManagerMap = new HashMap<>();
    static WxBeanFactory instance;
    ApplicationContext ctx;

    private WxBeanFactoryImpl() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
    }

    public static WxBeanFactory getInstance() {
        if (instance == null)
            instance = new WxBeanFactoryImpl();
        return instance;
    }

    @Override
    public WxAppManager getWxAppManager(String appName) {
        System.out.println("--appName="+appName);
        if (wxAppManagerMap.containsKey(appName))
            return wxAppManagerMap.get(appName);

        WxAppManagerImpl wf = new WxAppManagerImpl(appName);
        wxAppManagerMap.put(appName, wf);
        return wf;
    }

    @Override
    public MsgActionListener getMsgActionListener(String name) {
        if (name == null)
            name = "defaultMsgActionListener";
        MsgActionListener wf = (MsgActionListener) ctx.getBean(name);
        //TODO ifnull
        return wf;
    }


    @Override
    public EventActionListener getEvtActionListener(String name) {
        if (name == null)
            name = "defaultEvtActionListenBaseImpl";
        EventActionListener wf = (EventActionListener) ctx.getBean(name);
        //TODO ifnull
        return wf;
    }

    public static void main(String[] args) {
        WxBeanFactoryImpl wfi = new WxBeanFactoryImpl();
        Object o = wfi.getPromotionGiftSelector(null);
        //System.out.println("o=" + o);

    }
    @Override
    public PromotionManager getPromotionManager() {
        PromotionManager pm = (PromotionManager) ctx.getBean("promotionManager");
        return pm;
    }




    @Override
    public DataServiceListener getDataServiceListener(String key) {
        String name = key;
//        if (!this.getConfig().getTargetConifig().containsKey(key))
//            name = key;
//        else
//            name = this.getConfig().getTargetConifig().get(key);

        return (DataServiceListener) ctx.getBean(name);
    }

  


    @Override
    public UserService getUserService() {
        UserService us = (UserService) ctx.getBean("userService");
        return us;
    }


    @Override
    public <T> T getBean(String beanName, Class<T> clazz) {
        return ctx.getBean(beanName, clazz);
    }

    @Override
    public WxConfig getConfig() {
        return ctx.getBean("wxConfig", WxConfig.class);
    }


    @Override
    public JdbcTemplate getJdbcTemplate() {
        return ctx.getBean("jdbcTemplate", JdbcTemplate.class);
    }

  


    @Override
    public Account getAccount(long userId) {
        AccountImpl account = new AccountImpl(userId);
        return account;
    }

    @Override
    public WxUserBo getUserBo(WxUser wxUser) {       
        WxUserBoImpl wbi = new WxUserBoImpl(wxUser);        
        return wbi;
    }

    @Override
    public PromotionGiftSelector getPromotionGiftSelector(String name) {
        if (name == null)
            name = "defaultPromotionGiftSelector";
        //System.out.println("selectName=" + name);
        PromotionGiftSelector seletor = ctx.getBean(name, PromotionGiftSelector.class);
        return seletor;
    }

    @Override
    public MenuActionListener getMenuActionListener(String name) {
        if (name == null)
            name = "menuActionListenerDefaultImpl";
        return ctx.getBean(name, MenuActionListener.class);
    }

  
    
}
