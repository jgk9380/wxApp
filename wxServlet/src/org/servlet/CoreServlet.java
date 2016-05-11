package org.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import java.util.Date;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.WxBeanFactory;

import org.apache.log4j.Logger;

import org.WxBeanFactoryImpl;

import org.dao.WxAppDao;

import org.entity.WxUserMsg;

import org.message.resp.TextMessage;

import org.util.MessageUtil;
import org.util.SignUtil;

import org.wx.WxAppManager;
import org.wx.WxAppManagerBaseImpl;
import org.wx.WxAppManagerImpl;


@WebServlet(name = "CoreServlet", urlPatterns = { "/coreServlet" })
public class CoreServlet extends HttpServlet {
    @SuppressWarnings("compatibility:-5963779121706528509")
    private static final long serialVersionUID = 4440739483644821986L;

    /**
     * 请求校验（确认请求来自微信服务器）
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger.getLogger(CoreServlet.class).info("doGet");

        // 微信加密签名
        String signature = request.getParameter("signature");
        //Logger.getLogger(CoreServlet.class).info("signature=" + signature);
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        //Logger.getLogger(CoreServlet.class).info("timestamp=" + timestamp);
        // 随机数
        String nonce = request.getParameter("nonce");
        //Logger.getLogger(CoreServlet.class).info("nonce=" + nonce);
        // 随机字符串
        String echostr = request.getParameter("echostr");
        //Logger.getLogger(CoreServlet.class).info("echostr=" + echostr);
        PrintWriter out = response.getWriter();
        WxBeanFactory wfi = WxBeanFactoryImpl.getInstance();
        WxAppManager wam = wfi.getWxAppManager("yctxq");
        //        System.out.println("------------old return:" +
        //                           SignUtil.checkSignature(wam.getTokeString(), signature, timestamp, nonce));
        if (wam.getOperator().checkSignature(signature, timestamp, nonce)) {
            Logger.getLogger(CoreServlet.class).warn("匹配成功");
            out.print(echostr);
        } else {
            Logger.getLogger(CoreServlet.class).warn("没有匹配");
            out.print(echostr);
        }
        out.close();
        out = null;
    }

    /**
     * 处理微信服务器发来的消息
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");        
        //发送留言
        try {
            
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            System.out.println("yclt begin post:"+requestMap);
           
            PrintWriter out = response.getWriter(); //可以回复空串
            out.println("");
            out.close();
            WxBeanFactory wf=WxBeanFactoryImpl.getInstance();
            String appName=wf.getBean("wxAppDao", WxAppDao.class).findByUserName(requestMap.get("ToUserName")).getAppName();
            WxAppManager wam = wf.getWxAppManager(appName);
            WxUserMsg wum = wam.saveUserMsg(requestMap);
            wam.dispUserMsg(wum); 
            {//接受文字留言和文章留言
                String openId=requestMap.get("FromUserName");
                wam.getWxUserBo(openId).receiveMail(false);
                wam.getWxUserBo(openId).receiveMailArticle(false);           
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
