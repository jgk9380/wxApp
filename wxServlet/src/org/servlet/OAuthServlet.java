package org.servlet;
import java.io.IOException;

import java.math.BigDecimal;

import java.net.URLDecoder;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import org.WxBeanFactory;

import org.apache.log4j.Logger;

import org.WxBeanFactoryImpl;


import org.WxSession;

import org.dao.WxMenuDao;

import org.entity.WxUser;

import org.entity.menu.WxViewMenu;

import org.pojo.SNSUserInfo;
import org.pojo.WeixinOauth2Token;

import org.util.AdvancedUtil;
import org.util.WxUtils;

import org.wx.WxAppManager;

import utils.system;
@WebServlet(name = "OAuthServlet", urlPatterns = { "/oAuthServlet" })
public class OAuthServlet extends HttpServlet {
    @SuppressWarnings("compatibility:6630588046399214177")
    private static final long serialVersionUID = 1229477658196517573L;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    private String initTargetUrl(String targetUrl) {
        if (targetUrl == null) {
            Logger.getLogger(OAuthServlet.class).error("没有 target");
            targetUrl = "/faces/account_2.jsf?appName=yctxq";
        } else {
            System.out.println("---targetUrl=" + targetUrl + "------------");
        }
        return targetUrl;
    }

    public static void main1(String[] args) {
        OAuthServlet oa = new OAuthServlet();
    }

    private String getOpenIdFromWxAppAndCode(String appName, String code) {
        String openId = null;
        if (!"authdeny".equals(code) && code != null) {
            WeixinOauth2Token weixinOauth2Token =
                WxBeanFactoryImpl.getInstance().getWxAppManager(appName).getOperator().getOauth2AccessToken(code);
            if (weixinOauth2Token != null) {
                openId = weixinOauth2Token.getOpenId(); //得到openId即可以了,是否关注
            }
        }
        if (openId == null) {  //TODO  默认我的OpenId  测试用          
            //String openId = "oEsXmwWQkf6V5KaLUMHCQHpC8F1E";//yctxq
            //String openId = "oYvtquJJ5uBzTl0NwBgaJS380FLo";//yclt
            openId = "oEsXmwWQkf6V5KaLUMHCQHpC8F1E";
        }
        return openId;
    }

    public WxUser getWxUserFromRequest(HttpServletRequest request) {
        String targetUrl = request.getParameter("target");
        String code = request.getParameter("code");
        targetUrl = initTargetUrl(targetUrl);
        String appName = WxUtils.getAppName(targetUrl);
        String openId = getOpenIdFromWxAppAndCode(appName, code);
        System.out.println("openId=" + openId + "  appName=" + appName);
        if (openId == null)
            return null;
        WxAppManager wxAppManager = WxBeanFactoryImpl.getInstance().getWxAppManager(appName);
        WxUser wxUser = wxAppManager.getWxUser(openId);
        return wxUser;
    }

    public WxSession initWxSession(HttpServletRequest request) {
        WxUser wxUser = getWxUserFromRequest(request);
        WxSession wxSession = (WxSession) request.getSession(true).getAttribute("wxSession");
        if (wxSession == null && wxUser != null) {
            wxSession = new WxSession(wxUser);
            request.getSession(true).setAttribute("wxSession", wxSession);
        } else {
            System.out.println("---------------openId is null-----------");
            request.getSession(true).setAttribute("wxSession", null);
        }
        return wxSession;
    }

    WxViewMenu getWxViewMenu(HttpServletRequest request) {
        String targetUrl = request.getParameter("target");
        targetUrl = initTargetUrl(targetUrl);
        String appName = WxUtils.getAppName(targetUrl);
        String urlHead = WxUtils.getUrlHead(targetUrl);
        System.out.println("urlHead=" + urlHead + " appName=" + appName);
        WxMenuDao wxMenuDao = WxBeanFactoryImpl.getInstance().getBean("wxMenuDao", WxMenuDao.class);
        WxViewMenu wxViewMenu = wxMenuDao.findByTargetUrl(appName, urlHead);

        return wxViewMenu;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String targetUrl = request.getParameter("target");
        targetUrl = initTargetUrl(targetUrl);
        response.setCharacterEncoding("gb2312");
        WxSession wxSession = initWxSession(request);
        WxViewMenu wxViewMenu = getWxViewMenu(request);
        System.out.println("wxViewMenu=" + wxViewMenu);
        //根据Target找到页面菜单
        if (wxViewMenu != null) {
            if (!wxViewMenu.isAuth()) {//无需关注
                System.out.println(1+" url="+wxViewMenu.getTargetUrl());
                RequestDispatcher rd = request.getRequestDispatcher(wxViewMenu.getTargetUrl());
                rd.forward(request, response);
            }
            if (wxViewMenu.isAuth()) {//需关注
                if (wxSession.getWxUserBo().getWxUser().getSubscribeStatus() == 1) {
                    System.out.println(2);
                    RequestDispatcher rd = request.getRequestDispatcher(wxViewMenu.getTargetUrl());
                    rd.forward(request, response);
                } else {
                    if (wxViewMenu.getNoAttenationUrl() != null) {
                        System.out.println(3);
                        RequestDispatcher rd = request.getRequestDispatcher(wxViewMenu.getNoAttenationUrl());
                        rd.forward(request, response);
                    }else{
                        System.out.println(4);
                        String info="请爱的用户，你还没有没有关注"+wxSession.getWxUserBo().getWxUser().getWxApp().getRemark();
                        response.getWriter().println(info);
                    }
                }

            }
        }else{
            String info="无效链接：" +targetUrl;
            response.getWriter().println(info);
        }
    }


}

