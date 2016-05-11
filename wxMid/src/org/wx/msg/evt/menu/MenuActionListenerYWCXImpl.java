package org.wx.msg.evt.menu;

import net.sf.json.JSONObject;

import org.WxBeanFactoryImpl;

import org.dao.WxAppDao;

import org.entity.WxUserMsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.util.UnicomRobot;

import org.wx.WxAppManager;
//业务查询
@Component("menuActionListenerYWCXImpl")
public class MenuActionListenerYWCXImpl implements MenuActionListener{
    public MenuActionListenerYWCXImpl() {
        super();
    }
    @Autowired
    WxAppDao wxAppDao;
    @Override
    public void doAction(WxUserMsg wum) {
        String scenenArgs = wum.getSceneArgs();
        JSONObject json = JSONObject.fromObject(scenenArgs);
        String toUserName = (String) json.get("ToUserName");
        String fromUserName = (String) json.get("FromUserName");
        String eventKey = json.getString("EventKey");        
        WxAppManager wam =
            WxBeanFactoryImpl.getInstance().getWxAppManager(wum.getWxUser().getWxApp().getAppName());  
    
        String content = "欢迎下载手机营业厅进行话费,流量,套餐查询。\n下载地址: http://wap.10010.com/knd ";
        boolean res = wam.getOperator().sendTxtMessage(fromUserName, content);
        wum.setHandleResult("回复：" + content);
       
    
    }
}
