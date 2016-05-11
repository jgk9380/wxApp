package org.wx;


import java.awt.image.BufferedImage;

import java.util.List;

import net.sf.json.JSONObject;

import org.menu.Menu;

import org.message.resp.Article;

import org.pojo.JsApiTicket;
import org.pojo.WeixinGroup;
import org.pojo.WeixinMedia;
import org.pojo.WeixinOauth2Token;

import org.pojo.WeixinQRCode;

import org.pojo.WeixinUserInfo;

import org.pojo.WeixinUserList;

import org.springframework.stereotype.Component;

import org.pojo.Token;


public interface WxOperator {

    boolean checkSignature(String signature, String timestamp, String nonce);

    /**
     * 获取刷新网页授权凭证及普通Token
     */
    Token getToken();
    JsApiTicket getJsApiTicket();
    WeixinOauth2Token getOauth2AccessToken(String code);
    WeixinOauth2Token refreshOauth2AccessToken(String refreshToken);

    //MenuUtil
    boolean createMenu(Menu menu);
    String getMenu();
    boolean deleteMenu();
    //MessageUtil 处理XML的工具
    //AdvancedUtil

    /**
     * 发送客服消息
     */
    boolean sendTxtMessage(String openId, String msgContent);
    boolean sendImageMessage(String openId, String imageMediaId);
    boolean sendArticlesMessage(String openId, List<Article> articleList);
    /**
     * 创建临时带参二维码
     * @param expireSeconds 二维码有效时间，单位为秒，最大不超过604800秒（7天）
     */
    WeixinQRCode createTemporaryQRCode(int sceneId, int expireSeconds);
    /**
     * 创建永久带参二维码
     * @return ticket 为String
     */
    JSONObject createPermanentQRCode(int sceneId);
    /**
     * 根据ticket换取二维码
     * @param ticket 二维码ticket
     */
    byte[] getQRCodeImage(String ticket);
    /**
     * 获取用户信息
     * @param openId 用户标识
     */
    WeixinUserInfo getUserInfo(String openId);
    /**
     * 获取关注者列表
     * @param nextOpenId 第一个拉取的openId，不填默认从头开始拉取
     */
    WeixinUserList getUserList(String nextOpenId);
    /**
     * 分组
     */
    List<WeixinGroup> getGroups();
    WeixinGroup createGroup(String groupName);
    boolean updateGroup(int groupId, String groupName);
    boolean updateMemberGroup(String openId, int groupId);
    /**
     * 上传媒体文件
     * @param type 媒体文件类型（image、voice、video和thumb）
     * @param mediaFileUrl 媒体文件的url
     */
    WeixinMedia uploadMedia(String type, String mediaFileUrl);
    WeixinMedia uploadMedia(String type, BufferedImage bi);
    /**
     * 下载媒体文件
     * @param mediaId 媒体文件标识
     * @return
     */
    String getMedia(String mediaId);

}

