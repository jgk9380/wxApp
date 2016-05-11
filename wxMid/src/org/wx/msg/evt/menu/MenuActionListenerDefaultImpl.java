package org.wx.msg.evt.menu;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import org.entity.WxUserMsg;

import org.springframework.stereotype.Component;

import org.wx.msg.evt.EventActionListenerClickImpl;

@Component("menuActionListenerDefaultImpl")
public class MenuActionListenerDefaultImpl implements MenuActionListener{
    public MenuActionListenerDefaultImpl() {
        super();
    }
    @Override
    public void doAction(WxUserMsg wum) {            
        String scenenArgs = wum.getSceneArgs();
        JSONObject json = JSONObject.fromObject(scenenArgs);
        String toUserName = (String) json.get("FromUserName");
        String fromUserName = (String) json.get("ToUserName");
        String eventKey = json.getString("EventKey");
        wum.setHandleResult("û�д���");
        Logger.getLogger(EventActionListenerClickImpl.class).error("�˵���" + eventKey+"û�ж�Ӧ�Ĵ�����");
    }
}