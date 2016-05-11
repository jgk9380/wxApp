package org.wx;

import java.awt.image.BufferedImage;

import java.io.PrintWriter;

import java.util.List;
import java.util.Map;

import org.entity.WxPerQrCode;
import org.entity.WxPromotion;
import org.entity.WxUser;
import org.entity.WxUserMsg;
import org.message.resp.TextMessage;

import org.wx.bo.WxUserBo;


public interface WxAppManager {
    WxOperator getOperator();   
    
    WxUserBo  getWxUserBo(String openId);    
    
    WxUser getWxUser(String openId);  //getWxUserBo���  
    
    WxUserMsg saveUserMsg(Map<String,String> argsMap); 
   
    void dispUserMsg(WxUserMsg wum);   
    
    void sendWxMail(long receiveUserId,String cont,long sendUserId);
    
    void sendWxArticle(long userId,String title,String desc,String picUrl,String url);  
  
}
