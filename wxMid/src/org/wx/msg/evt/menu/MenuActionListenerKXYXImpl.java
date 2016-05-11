package org.wx.msg.evt.menu;

import net.sf.json.JSONObject;

import org.WxBeanFactoryImpl;

import org.dao.WxAppDao;

import org.entity.WxUserMsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.util.UnicomRobot;

import org.wx.WxAppManager;
//����һЦ
@Component("menuActionListenerKXYXImpl")
public class MenuActionListenerKXYXImpl implements MenuActionListener {
    public MenuActionListenerKXYXImpl() {
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

        String content = UnicomRobot.getAnswer("����Ц��", wum.getWxUser().getId().toString());
        boolean res = wam.getOperator().sendTxtMessage(toUserName, content);
        wum.setHandleResult("�ظ���" + content);
    }
}
