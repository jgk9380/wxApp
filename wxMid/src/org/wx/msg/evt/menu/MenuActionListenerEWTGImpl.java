package org.wx.msg.evt.menu;

import net.sf.json.JSONObject;

import org.WxBeanFactoryImpl;

import org.dao.WxAppDao;

import org.entity.WxUserMsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.wx.WxAppManager;
import org.wx.bo.WxUserBo;
//二维推广
@Component("menuActionListenerEWTGImpl")
public class MenuActionListenerEWTGImpl implements MenuActionListener{
    public MenuActionListenerEWTGImpl() {
        super();
    }
    @Autowired
    WxAppDao wxAppDao;
    @Override
    public void doAction(WxUserMsg wum) {
      
        
        String scenenArgs = wum.getSceneArgs();
        JSONObject json = JSONObject.fromObject(scenenArgs);
        String toUserName = (String) json.get("FromUserName");
        String fromUserName = (String) json.get("ToUserName");
        String eventKey = json.getString("EventKey");
        WxAppManager wam =
            WxBeanFactoryImpl.getInstance().getWxAppManager(wum.getWxUser().getWxApp().getAppName());
        
        WxUserBo wuBo = wam.getWxUserBo(toUserName);
        String mediaId = wuBo.getShareImageMediaId();
        wam.getOperator().sendTxtMessage(toUserName,
                                         "将下面的图片分享至朋友圈或发送至你的好友，邀请你的朋友一起参加\"盐城联通\"新春送礼活动!邀请越多获奖越大，可得到IPhone，品牌智能手机等礼品!");
        wam.getOperator().sendImageMessage(toUserName, mediaId);
        
    }
}
