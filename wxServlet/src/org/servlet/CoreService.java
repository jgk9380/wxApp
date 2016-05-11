package org.servlet;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.message.resp.Article;
import org.message.resp.NewsMessage;
import org.message.resp.TextMessage;

import org.util.MessageUtil;

public class CoreService {
    /**
     * 处理微信发来的请求
     *
     * @param request
     * @return xml
     */
    public static String processRequest(HttpServletRequest request) {
        // xml格式的消息数据
        String respXml = null;
        try {
            // 调用parseXml方法解析请求消息
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            // 发送方帐号
            String fromUserName = requestMap.get("FromUserName");
            // 开发者微信号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");
           

            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            // 事件推送
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 订阅
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    textMessage.setContent("您好，欢迎盐城通信圈");
                    // 将消息对象转换成xml
                    respXml = MessageUtil.messageToXml(textMessage);
                }
                // 取消订阅
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO 暂不做处理
                }
                // 自定义菜单点击事件
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    // 事件KEY值，与创建菜单时的key值对应
                    String eventKey = requestMap.get("EventKey");
                    // 根据key值判断用户点击的按钮
                    if (eventKey.equals("oschina")) {
                        Article article = new Article();
                        article.setTitle("中国联通欢迎你");
                        article.setDescription("中国联通服务好、\n中国联通服务优");
                        article.setPicUrl("");
                        article.setUrl("http://www.10010.com");
                        List<Article> articleList = new ArrayList<Article>();
                        articleList.add(article);
                        // 创建图文消息
                        NewsMessage newsMessage = new NewsMessage();
                        newsMessage.setToUserName(fromUserName);
                        newsMessage.setFromUserName(toUserName);
                        newsMessage.setCreateTime(new Date().getTime());
                        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                        newsMessage.setArticleCount(articleList.size());
                        newsMessage.setArticles(articleList);
                        respXml = MessageUtil.messageToXml(newsMessage);
                    } else if (eventKey.equals("iteye")) {
                        textMessage.setContent("test iteye");
                        respXml = MessageUtil.messageToXml(textMessage);
                    }
                }
            }
            // 当用户发消息时
            else {
                textMessage.setContent("请通过菜单使用网址导航服务！");
                respXml = MessageUtil.messageToXml(textMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }
}

