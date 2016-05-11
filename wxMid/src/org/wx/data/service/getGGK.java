package org.wx.data.service;

;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.WxBeanFactoryImpl;

import org.WxSession;

import org.apache.log4j.Logger;

import org.entity.WxPromotionGift;

import org.springframework.stereotype.Component;
@Component("getGGKGift")
public class getGGK implements DataServiceListener {
    public getGGK() {
        super();
    }

    @Override
    public JSONObject doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                                                                                             IOException {
        String param = request.getParameter("param");
        System.out.println("param=" + param);
        
        WxSession wxSession = (WxSession) request.getSession(true).getAttribute("wxSession");
        if(wxSession==null){
            Logger.getLogger(getGGK.class).error("wxUser is null 111");
            JSONObject json=new JSONObject();
            json.put("result", "error");
            json.put("resultInfo","System Error!");
        }         
       
        WxPromotionGift wpg=wxSession.getWxUserBo().selectRandomGgkGift();        
   
        JSONObject json=new JSONObject();
        if(wpg==null) {
            json.put("error","noggk");
            return json;
        }       
     
       json.put("giftId",wpg.getId());
       json.put("cont","×£ºØÄã»ñµÃ£º"+wpg.getContent());
        return json;        
    }
}
