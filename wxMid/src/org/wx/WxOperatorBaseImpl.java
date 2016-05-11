package org.wx;

import java.awt.image.BufferedImage;

import java.util.List;

import javax.transaction.Transactional;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import org.WxBeanFactoryImpl;

import org.apache.log4j.Logger;

import org.dao.WxAppDao;

import org.entity.WxApp;

import org.menu.Menu;

import org.message.resp.Article;

import org.pojo.JsApiTicket;
import org.pojo.Token;

import org.pojo.WeixinGroup;
import org.pojo.WeixinMedia;
import org.pojo.WeixinOauth2Token;
import org.pojo.WeixinQRCode;
import org.pojo.WeixinUserInfo;
import org.pojo.WeixinUserList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.util.AdvancedUtil;
import org.util.CommonUtil;
import org.util.MenuUtil;
import org.util.SignUtil;


public abstract class WxOperatorBaseImpl implements WxOperator {
    private String appId; //= "wx7dcc6b2e03a47c0b";
    private String appSecret; //= "fb845f65afd06d318e7a961d867f877f";
    private String tokenString; //jgk8380
    //private Token accessToken;
    private String savePath = "d:/temp";

    //@Autowired(required = false)
    private WxAppDao wxAppDao;

    public WxOperatorBaseImpl(String appId) {
        this.appId = appId;
        wxAppDao = WxBeanFactoryImpl.getInstance().getBean("wxAppDao", WxAppDao.class);
        WxApp wa = wxAppDao.findById(appId);
        if (wa == null) {
            Logger logger = Logger.getLogger(WxOperatorBaseImpl.class);
            logger.error("�����appId��" + appId);
            return;
        }
        appSecret = wa.getAppSecret();
        tokenString = wa.getAppToken();
    }

    public Token getToken() {
        Token accessToken = null;
        WxApp wa = wxAppDao.findById(appId);
        if (wa == null)
            try {
                throw new Exception("û��ȡ��App�Ż�������");
            } catch (Exception e) {
                Logger.getLogger(WxOperatorBaseImpl.class).error("����" + e.getMessage());
                return null;
            }

        if (wa.getToken() != null) {
            accessToken = new Token();
            accessToken.setAccessToken(wa.getToken());
            accessToken.setExpiresIn(wa.getTokeExpire().intValue());
            accessToken.setProductTime(wa.getTokenDate());
        }

        if (accessToken == null || !accessToken.isValid()) {
            accessToken = CommonUtil.getToken(appId, appSecret);
            wa.setToken(accessToken.getAccessToken());
            //System.out.println("time="+accessToken.getProductTime());
            wa.setTokenDate(accessToken.getProductTime());
            wa.setTokeExpire(accessToken.getExpiresIn());
            wxAppDao.save(wa);
        }

        return accessToken;
    }

    @Override
    public JsApiTicket getJsApiTicket() {
        JsApiTicket jsApiTicket = null;
        WxApp wa = wxAppDao.findById(appId);
        if (wa == null)
            try {
                throw new Exception("û��ȡ��App�Ż�������");
            } catch (Exception e) {
                Logger.getLogger(WxOperatorBaseImpl.class).error("����" + e.getMessage());
                return null;
            }

        if (wa.getJsTicket() != null) {
            jsApiTicket = new JsApiTicket(wa.getJsTicket(), wa.getJsTicketExpire(),wa.getJsTicketDate());
        }
        
        if (jsApiTicket==null||!jsApiTicket.isValid()){
            jsApiTicket=AdvancedUtil.getJSAPITicket(this.getToken().getAccessToken());
            wa.setJsTicket(jsApiTicket.getTicket());
            wa.setJsTicketExpire(jsApiTicket.getExpires_in()); 
            wa.setJsTicketDate(jsApiTicket.getOccurDate());
            wxAppDao.save(wa);
        }
        
        return jsApiTicket; 
        
    }

    @Override
    public boolean createMenu(Menu menu) {
        return MenuUtil.createMenu(menu, getToken().getAccessToken());
    }

    @Override
    public String getMenu() {
        return MenuUtil.getMenu(getToken().getAccessToken());
    }

    @Override
    public boolean deleteMenu() {
        return MenuUtil.deleteMenu(this.getToken().getAccessToken());
    }

    @Override
    public boolean sendTxtMessage(String openId, String msgContent) {
        String jsonString = AdvancedUtil.makeTextCustomMessage(openId, msgContent);
        return AdvancedUtil.sendCustomMessage(this.getToken().getAccessToken(), jsonString);
    }

    @Override
    public boolean sendImageMessage(String openId, String imageMediaId) {
        String imageXml = AdvancedUtil.makeImageCustomMessage(openId, imageMediaId);
        AdvancedUtil.sendCustomMessage(this.getToken().getAccessToken(), imageXml);
        return false;
    }

    @Override
    public boolean sendArticlesMessage(String openId, List<Article> articleList) {
        String jsonNewsMsg = AdvancedUtil.makeNewsCustomMessage(openId, articleList);
        //System.out.println("jsonNewsMsg=" + jsonNewsMsg);
        return AdvancedUtil.sendCustomMessage(this.getToken().getAccessToken(), jsonNewsMsg);
    }

    @Override
    public WeixinOauth2Token getOauth2AccessToken(String code) {
        return AdvancedUtil.getOauth2AccessToken(appId, appSecret, code);
    }

    @Override
    public WeixinOauth2Token refreshOauth2AccessToken(String refreshToken) {
        return AdvancedUtil.refreshOauth2AccessToken(appId, refreshToken);
    }

    @Override
    public WeixinQRCode createTemporaryQRCode(int sceneId, int expireSeconds) {
        return AdvancedUtil.createTemporaryQRCode(getToken().getAccessToken().toString(), expireSeconds, sceneId);
    }

    @Override
    public JSONObject createPermanentQRCode(int sceneId) {       
      JSONObject json=   AdvancedUtil.createPermanentQRCode(getToken().getAccessToken(), sceneId);
        if (json == null) {
            Logger.getLogger(WxAppManagerImpl.class).error("取二维码失败");
            return null;
        }
      return json;
    }

    @Override
    public byte[] getQRCodeImage(String ticket) {
        return AdvancedUtil.getQRCodeImage(ticket);
    }

    @Override
    public WeixinUserInfo getUserInfo(String openId) {
        return AdvancedUtil.getUserInfo(getToken().getAccessToken(), openId);
    }

    @Override
    public WeixinUserList getUserList(String nextOpenId) {
        return AdvancedUtil.getUserList(getToken().getAccessToken(), nextOpenId);
    }

    @Override
    public List<WeixinGroup> getGroups() {
        // TODO Implement this method
        return AdvancedUtil.getGroups(getToken().getAccessToken());
    }

    @Override
    public WeixinGroup createGroup(String groupName) {

        return AdvancedUtil.createGroup(this.getToken().getAccessToken(), groupName);
    }

    @Override
    public boolean updateGroup(int groupId, String groupName) {
        return AdvancedUtil.updateGroup(this.getToken().getAccessToken(), groupId, groupName);
    }

    @Override
    public boolean updateMemberGroup(String openId, int groupId) {
        return AdvancedUtil.updateMemberGroup(this.getToken().getAccessToken(), openId, groupId);
    }

    @Override
    public WeixinMedia uploadMedia(String type, String mediaFileUrl) {
        return AdvancedUtil.uploadMedia(this.getToken().getAccessToken(), type, mediaFileUrl);
    }

    @Override
    public WeixinMedia uploadMedia(String type, BufferedImage bi) {
        return AdvancedUtil.uploadBufferedImageMedia(this.getToken().getAccessToken(), type, bi);
    }

    @Override
    public String getMedia(String mediaId) {
        return AdvancedUtil.getMedia(this.getToken().getAccessToken(), mediaId, savePath);
    }

    @Override
    public boolean checkSignature(String signature, String timestamp, String nonce) {
        return SignUtil.checkSignature(tokenString, signature, timestamp, nonce);
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    //    public String getAppId() {
    //        return appId;
    //    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    //    public String getAppSecret() {
    //        return appSecret;
    //    }

    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }

    //    public String getTokenString() {
    //        return tokenString;
    //    }
}
