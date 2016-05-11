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
     * ��ȡˢ����ҳ��Ȩƾ֤����ͨToken
     */
    Token getToken();
    JsApiTicket getJsApiTicket();
    WeixinOauth2Token getOauth2AccessToken(String code);
    WeixinOauth2Token refreshOauth2AccessToken(String refreshToken);

    //MenuUtil
    boolean createMenu(Menu menu);
    String getMenu();
    boolean deleteMenu();
    //MessageUtil ����XML�Ĺ���
    //AdvancedUtil

    /**
     * ���Ϳͷ���Ϣ
     */
    boolean sendTxtMessage(String openId, String msgContent);
    boolean sendImageMessage(String openId, String imageMediaId);
    boolean sendArticlesMessage(String openId, List<Article> articleList);
    /**
     * ������ʱ���ζ�ά��
     * @param expireSeconds ��ά����Чʱ�䣬��λΪ�룬��󲻳���604800�루7�죩
     */
    WeixinQRCode createTemporaryQRCode(int sceneId, int expireSeconds);
    /**
     * �������ô��ζ�ά��
     * @return ticket ΪString
     */
    JSONObject createPermanentQRCode(int sceneId);
    /**
     * ����ticket��ȡ��ά��
     * @param ticket ��ά��ticket
     */
    byte[] getQRCodeImage(String ticket);
    /**
     * ��ȡ�û���Ϣ
     * @param openId �û���ʶ
     */
    WeixinUserInfo getUserInfo(String openId);
    /**
     * ��ȡ��ע���б�
     * @param nextOpenId ��һ����ȡ��openId������Ĭ�ϴ�ͷ��ʼ��ȡ
     */
    WeixinUserList getUserList(String nextOpenId);
    /**
     * ����
     */
    List<WeixinGroup> getGroups();
    WeixinGroup createGroup(String groupName);
    boolean updateGroup(int groupId, String groupName);
    boolean updateMemberGroup(String openId, int groupId);
    /**
     * �ϴ�ý���ļ�
     * @param type ý���ļ����ͣ�image��voice��video��thumb��
     * @param mediaFileUrl ý���ļ���url
     */
    WeixinMedia uploadMedia(String type, String mediaFileUrl);
    WeixinMedia uploadMedia(String type, BufferedImage bi);
    /**
     * ����ý���ļ�
     * @param mediaId ý���ļ���ʶ
     * @return
     */
    String getMedia(String mediaId);

}

