package org.wx.data.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.WxSession;

import org.springframework.stereotype.Component;

@Component("queryShareInfo")
public class QueryShareInfo implements DataServiceListener {
    public QueryShareInfo() {
        super();
    }

    @Override
    public JSONObject doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject json = new JSONObject();
        WxSession wxSession = (WxSession) request.getSession(true).getAttribute("wxSession");
        if (wxSession != null) {
            json.put("shareUserId", wxSession.getWxUserBo().getWxUser().getId());
            json.put("shareName", wxSession.getWxUserBo().getWxUser().getNickname());
            json.put("shareImgUrl", wxSession.getWxUserBo().getWxUser().getHeadimgurl());
            json.put("QrCodeUrl", wxSession.getWxUserBo().getQrCodeUrl());
            json.put("allFeeGift", wxSession.getWxUserBo().getAccount().getAllFeeGift());
            json.put("useFeeGift", 0 - wxSession.getWxUserBo().getAccount().getUseFeeGift());   
            json.put("speed",   wxSession.getWxUserBo().getSpeedInfo()[0]);
            json.put("rank",   wxSession.getWxUserBo().getSpeedInfo()[1]);
            json.put("percent",   wxSession.getWxUserBo().getSpeedInfo()[2]);
        }
        System.out.println("--------------json="+json.toString());
        return json;
    }
}
