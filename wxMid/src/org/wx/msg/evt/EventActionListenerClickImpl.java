package org.wx.msg.evt;

import java.awt.image.BufferedImage;

import java.io.PrintWriter;

import java.util.Date;


import javax.transaction.Transactional;

import net.sf.json.JSONObject;

import org.WxBeanFactoryImpl;

import org.apache.log4j.Logger;

import org.dao.WxAppDao;
import org.dao.WxMenuDao;
import org.dao.WxPerQrCodeDao;
import org.dao.WxUserDao;
import org.dao.WxUserMsgDao;

import org.eclipse.persistence.internal.oxm.schema.model.Content;

import org.entity.WxPerQrCode;
import org.entity.WxUser;
import org.entity.WxUserMsg;

import org.entity.menu.WxClickMenu;
import org.entity.menu.WxMenu;

import org.pojo.WeixinMedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import org.util.AdvancedUtil;
import org.util.UnicomRobot;

import org.wx.WxAppManager;
import org.wx.bo.WxUserBo;
import org.wx.msg.evt.menu.MenuActionListener;

@Component("clickEvtActionListenBaseImpl")

public class EventActionListenerClickImpl implements EventActionListener {
    public EventActionListenerClickImpl() {
        super();
    }
    @Autowired
    WxUserMsgDao wxUserMsgDao;
    @Autowired
    WxUserDao wxUserDao;
    @Autowired
    WxAppDao wxAppDao;
    @Autowired
    WxPerQrCodeDao wxPerQrCodeDao;
    @Autowired
    WxMenuDao wxMenuDao;

    //   @Override
    public void doAction(WxUserMsg wum, PrintWriter out) {
      
        String scenenArgs = wum.getSceneArgs();
        JSONObject json = JSONObject.fromObject(scenenArgs);
        String toUserName = (String) json.get("FromUserName");
        String fromUserName = (String) json.get("ToUserName");
        String eventKey = json.getString("EventKey");
        WxAppManager wam = WxBeanFactoryImpl.getInstance().getWxAppManager(wum.getWxUser().getWxApp().getAppName());
        WxClickMenu wxMenu = wxMenuDao.findByKey(eventKey);
        String handleClassName = null;
        if (wxMenu != null)
            handleClassName = wxMenu.getHandelClassName();
        MenuActionListener mal = WxBeanFactoryImpl.getInstance().getMenuActionListener(handleClassName);
        mal.doAction(wum);
        wum.setHandleTime(new Date());
        wxUserMsgDao.save(wum);
    };

    @Override
    public void doAction(WxUserMsg wum) {
        
        String scenenArgs = wum.getSceneArgs();
        JSONObject json = JSONObject.fromObject(scenenArgs);
        String toUserName = (String) json.get("FromUserName");
        String fromUserName = (String) json.get("ToUserName");
        String eventKey = json.getString("EventKey");
        WxAppManager wam = WxBeanFactoryImpl.getInstance().getWxAppManager(wum.getWxUser().getWxApp().getAppName());
        WxClickMenu wxMenu = wxMenuDao.findByKey(eventKey);
        String handleClassName = null;
        if (wxMenu != null)
            handleClassName = wxMenu.getHandelClassName();
        
        MenuActionListener mal = WxBeanFactoryImpl.getInstance().getMenuActionListener(handleClassName);
        mal.doAction(wum);
        wum.setHandleTime(new Date());
        wxUserMsgDao.save(wum);
    }
}
