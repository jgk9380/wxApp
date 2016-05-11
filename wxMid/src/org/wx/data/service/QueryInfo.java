package org.wx.data.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.WxSession;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Component;

@Component("queryInfo")
public class QueryInfo implements DataServiceListener {
    public QueryInfo() {
        super();
    }

    @Override
    public JSONObject doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                                                                                             IOException {
      
       JSONObject json=new JSONObject();
       WxSession wxSession = (WxSession) request.getSession(true).getAttribute("wxSession");
        if (wxSession == null) {
            Logger.getLogger(QueryInfo.class).error("Ã»ÓÐwxSession");
            return json;
        } else
            System.out.println("current openId=" + wxSession.getWxUserBo().getWxUser().getOpenId());
       
        json.put("tele", wxSession.getWxUserBo().getWxUser().getTele());
        json.put("address", wxSession.getWxUserBo().getWxUser().getMailAddr());
        json.put("longName", wxSession.getWxUserBo().getWxUser().getLongName());
        json.put("promCode", wxSession.getWxUserBo().getWxUser().getPromotionCode());
        
        return json;
    }
}
