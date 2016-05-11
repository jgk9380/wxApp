package org.mvc;

import javax.servlet.http.HttpServletRequest;

import org.WxBeanFactoryImpl;
import org.WxSession;

import org.entity.WxUser;

import org.pojo.WeixinOauth2Token;

import org.wx.WxAppManager;

public class WxWebUtils {
    public static  WxSession initWxSession(String state, String code, HttpServletRequest request) {
        System.out.println("in account state=" + state + " code=" + code);
        WxSession wxSession = (WxSession) request.getSession(true).getAttribute("wxSession");
        if (wxSession != null)
            return wxSession;
        if (state == null) {
            state = "yctxq"; //appName
        }
        String openId = null;
        if (!"authdeny".equals(code) && code != null) {
            WeixinOauth2Token weixinOauth2Token =
                WxBeanFactoryImpl.getInstance().getWxAppManager(state).getOperator().getOauth2AccessToken(code);
            openId = weixinOauth2Token.getOpenId();
        } else {
            openId = "oEsXmwWQkf6V5KaLUMHCQHpC8F1E";
        }

        WxAppManager wxAppManager = WxBeanFactoryImpl.getInstance().getWxAppManager(state);
        WxUser wxUser = wxAppManager.getWxUser(openId);

        if (wxSession == null && wxUser != null) {
            wxSession = new WxSession(wxUser);
            request.getSession(true).setAttribute("wxSession", wxSession);
        }
        return wxSession;
    }
}
