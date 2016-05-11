package org.wx.msg;

import java.io.PrintWriter;

import java.math.BigDecimal;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;

import net.sf.json.JSONObject;

import org.WxBeanFactoryImpl;

import org.dao.WxUserMsgDao;

import org.entity.WxUserMsg;

import org.message.resp.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import org.util.MessageUtil;
import org.util.UnicomRobot;

@Component("textMsgActionListener")
//TODO 改成使用客服接口
public class MsgActionListenerTextImpl implements MsgActionListener  {
    @Autowired
    WxUserMsgDao wxUserMsgDao;
    
    public String doAction(WxUserMsg wum, PrintWriter out) {
        
        String scenenArgs = wum.getSceneArgs();
        JSONObject json = JSONObject.fromObject(scenenArgs);
        String content = (String) json.get("Content");
      
        String result = null;
        String  toUserName  = (String) json.get("FromUserName");
        // 开发者微信号
        String fromUserName = (String) json.get("ToUserName");
        try {
            result = UnicomRobot.getAnswer(content, wum.getWxUser().getId().toString());
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(toUserName);
            textMessage.setFromUserName(fromUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setContent(result);
            out.println(MessageUtil.messageToXml(textMessage));
            wum.setHandleTime(new Date());
            wum.setHandleResult("回复用户："+result);
            wxUserMsgDao.save(wum);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO log;
        }        
        return result;
    }

    @Override
    public String doAction(WxUserMsg wum) {
      
        String scenenArgs = wum.getSceneArgs();
        JSONObject json = JSONObject.fromObject(scenenArgs);
        String content = (String) json.get("Content");
       
        String result = null;
        String  toUserName  = (String) json.get("FromUserName");
        // 开发者微信号
        String fromUserName = (String) json.get("ToUserName");
        try {
            result = UnicomRobot.getAnswer(content, wum.getWxUser().getId().toString( ));
            WxBeanFactoryImpl.getInstance().getWxAppManager(wum.getWxUser().getWxApp().getAppName()).getOperator().sendTxtMessage(toUserName, result);
            wum.setHandleTime(new Date());
            wum.setHandleResult("回复用户："+result);
            wxUserMsgDao.save(wum);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO log;
        }        
        return result;
    }
}
