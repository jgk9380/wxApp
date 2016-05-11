package org.wx;

import org.util.WxUtils;

import java.util.Date;

import javax.transaction.Transactional;

import org.WxBeanFactoryImpl;

import org.apache.log4j.Logger;

import org.dao.WxAppDao;
import org.dao.WxUserDao;

import org.entity.WxApp;
import org.entity.WxUser;

import org.pojo.WeixinUserInfo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import org.util.UserService;

public abstract class WxAppManagerBaseImpl implements WxAppManager {
    String appName;
    UserService userService = WxBeanFactoryImpl.getInstance().getBean("userService", UserService.class);
    WxAppDao wxAppDao = WxBeanFactoryImpl.getInstance().getBean("wxAppDao", WxAppDao.class);
    WxUserDao wxUserDao = WxBeanFactoryImpl.getInstance().getBean("wxUserDao", WxUserDao.class);
    WxOperator wxOperator;

    public WxAppManagerBaseImpl(String appName) {
        this.appName = appName;
        WxApp wx = wxAppDao.findByAppName(appName);
        if (wx == null) {
            Logger.getLogger(WxAppManagerBaseImpl.class).error("没有AppId：" + appName);
            return;
        }
        wxOperator = new WxOperatorImpl(wx.getId());
    }


    public WxUser refreshWxUser(String openId) {
        WxUser res;
        WxApp wx = wxAppDao.findByAppName(appName);
        res = wxUserDao.findByAppIdAndOpenId(wx.getId(), openId);
        //res = wxUserDao.findByOpenId(openId);
        if (res == null) {
            res = new WxUser();
            res.setId(WxUtils.getSeqencesValue().longValue());
        }

        WeixinUserInfo wui = wxOperator.getUserInfo(openId);
        //System.out.println("nkname="+wui.getNickname());
        if (wui == null) {
            //TODO 如果用户没有关注？
            Logger logger = Logger.getLogger(WxAppManagerImpl.class);
            logger.error("错误的openId：" + openId);
            return null;
        } else if (wui.getSubscribe() == 0) {
            if (res.getSubscribeStatus() == 1)
                res.setSubscribeStatus(-1);
            return wxUserDao.save(res);
        } else {
         
            res.setWxApp(wx);
            res.setOpenId(wui.getOpenId());
            res.setNickname(wui.getNickname());
            res.setSex("" + wui.getSex());
            res.setCountry(wui.getCountry());
            res.setCity(wui.getCity());
            res.setLanguage(wui.getLanguage());
            res.setHeadimgurl(wui.getHeadImgUrl());
            //System.out.println("ss=" + wui.getSubscribe());
            res.setSubscribeStatus(wui.getSubscribe());

            Long subTime = Long.parseLong(wui.getSubscribeTime()) * 1000;
            Date subDate = new Date(subTime);
            res.setSubscribeDate(subDate);
            res.setProvince(wui.getProvince());
            res.setRefereshDate(new Date());
            //res.setUserGroup(userGroup);更新用户分组
            return wxUserDao.save(res);
        }

    }

    public String getAppName() {
        return appName;
    }


    public static void main(String[] args) {
        ;
    }

}
