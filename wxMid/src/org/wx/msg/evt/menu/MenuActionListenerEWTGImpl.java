package org.wx.msg.evt.menu;

import net.sf.json.JSONObject;

import org.WxBeanFactoryImpl;

import org.dao.WxAppDao;

import org.entity.WxUserMsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.wx.WxAppManager;
import org.wx.bo.WxUserBo;
//��ά�ƹ�
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
                                         "�������ͼƬ����������Ȧ��������ĺ��ѣ������������һ��μ�\"�γ���ͨ\"�´�����!����Խ���Խ�󣬿ɵõ�IPhone��Ʒ�������ֻ�����Ʒ!");
        wam.getOperator().sendImageMessage(toUserName, mediaId);
        
    }
}
