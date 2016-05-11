package org.weixin.main;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.message.resp.Article;

import org.pojo.WeixinGroup;
import org.pojo.WeixinMedia;
import org.pojo.WeixinOauth2Token;
import org.pojo.WeixinQRCode;
import org.pojo.WeixinUserInfo;
import org.pojo.WeixinUserList;

import org.util.AdvancedUtil;
import org.util.CommonUtil;

public class testClient {
    /**
     * ���Ϳͷ���Ϣ���ı���Ϣ��
     */
    public static void testSendTxt(String accessToken, String openId) {
        // ��װ�ı��ͷ���Ϣ
        String jsonTextMsg = AdvancedUtil.makeTextCustomMessage(openId, "laojiang");
        // ���Ϳͷ���Ϣ
        AdvancedUtil.sendCustomMessage(accessToken, jsonTextMsg);

    }

    public static void testSendArtcle(String accessToken, String openId) {
        /**
         * ���Ϳͷ���Ϣ��ͼ����Ϣ��
         */
        Article article1 = new Article();
        article1.setTitle("΢����Ҳ�ܶ�����");
        article1.setDescription("");
        article1.setPicUrl("http://www.egouji.com/xiaoq/game/doudizhu_big.png");
        article1.setUrl("http://resource.duopao.com/duopao/games/small_games/weixingame/Doudizhu/doudizhu.htm");
        Article article2 = new Article();
        article2.setTitle("������ӥ\n80�󲻵ò���ľ�����Ϸ");
        article2.setDescription("");
        article2.setPicUrl("http://www.egouji.com/xiaoq/game/aoqixiongying.png");
        article2.setUrl("http://resource.duopao.com/duopao/games/small_games/weixingame/Plane/aoqixiongying.html");
        List<Article> list = new ArrayList<Article>();
        list.add(article1);
        list.add(article2);
        // ��װͼ�Ŀͷ���Ϣ
        String jsonNewsMsg = AdvancedUtil.makeNewsCustomMessage("oEdzejiHCDqafJbz4WNJtWTMbDcE", list);
        // ���Ϳͷ���Ϣ
        AdvancedUtil.sendCustomMessage(accessToken, jsonNewsMsg);

    }


    public static WeixinQRCode testCreateQRCode(String accessToken, String openId) {
        /**
             * ������ʱ��ά��
             */
        WeixinQRCode weixinQRCode = AdvancedUtil.createTemporaryQRCode(accessToken, 7 * 24 * 3600, 111111);
        // ��ʱ��ά���ticket
        //System.out.println("ticket=" + weixinQRCode.getTicket());
        // ��ʱ��ά�����Чʱ��
        //System.out.println("��Ч��=" + weixinQRCode.getExpireSeconds());

        return weixinQRCode;
    }

    public static void testGetQRCode(String accessToken, String ticket) {
        /**
             * ����ticket��ȡ��ά��
             */



        //        String ticket =
        //            "gQEj8joAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL056ci1iVERsWVdFWVEtYklFUlRXAAIE/ISHVgMEhAMAAA==";
        String savePath = "d:/temp";
        // ����ticket��ȡ��ά��
        AdvancedUtil.getQRCode(ticket, savePath);
    }

    public static void testGetUserInfo(String accessToken, String openId) {
        /**
             * ��ȡ�û���Ϣ
             */
        WeixinUserInfo user = AdvancedUtil.getUserInfo(accessToken, openId);
//        System.out.println("OpenID��" + user.getOpenId());
//        System.out.println("��ע״̬��" + user.getSubscribe());
//        System.out.println("��עʱ�䣺" + user.getSubscribeTime());
//        System.out.println("�ǳƣ�" + user.getNickname());
//        System.out.println("�Ա�" + user.getSex());
//        System.out.println("���ң�" + user.getCountry());
//        System.out.println("ʡ�ݣ�" + user.getProvince());
//        System.out.println("���У�" + user.getCity());
//        System.out.println("���ԣ�" + user.getLanguage());
//        System.out.println("ͷ��" + user.getHeadImgUrl());
    }

    public static void testGetUserGroupList(String accessToken, String openId) {
        /**
        * ��ȡ��ע���б�
        */
        WeixinUserList weixinUserList = AdvancedUtil.getUserList(accessToken, "");
        System.out.println("�ܹ�ע�û�����" + weixinUserList.getTotal());
        System.out.println("���λ�ȡ�û�����" + weixinUserList.getCount());
        System.out.println("OpenID�б�" + weixinUserList.getOpenIdList().toString());
        System.out.println("next_openid��" + weixinUserList.getNextOpenId());

        /**
         * ��ѯ����
         */
        List<WeixinGroup> groupList = AdvancedUtil.getGroups(accessToken);
        // ѭ�������������Ϣ
        for (WeixinGroup group : groupList) {
            System.out.println(String.format("ID��%d ���ƣ�%s �û�����%d", group.getId(), group.getName(), group.getCount()));
        }

        /**
        * ��������
        */
        WeixinGroup group = AdvancedUtil.createGroup(accessToken, "��˾Ա��");
        System.out.println(String.format("�ɹ��������飺%s id��%d", group.getName(), group.getId()));

        /**
        * �޸ķ�����
        */
        AdvancedUtil.updateGroup(accessToken, 100, "ͬ��");

        /**
                 * �ƶ��û�����
                 */
        AdvancedUtil.updateMemberGroup(accessToken, openId, 100);

    }

    public static void testGetMedia(String accessToken, String openId) {
        /**
                 * �ϴ���ý���ļ�
                 */
        WeixinMedia weixinMedia =
            AdvancedUtil.uploadMedia(accessToken, "voice", "http://localhost:8080/weixinmpapi/test.mp3");
        System.out.println(weixinMedia.getMediaId());
        System.out.println(weixinMedia.getType());
        System.out.println(weixinMedia.getCreatedAt());

        /**
                 * ���ض�ý���ļ�
                 */
        AdvancedUtil.getMedia(accessToken, "N7xWhOGYSLWUMPzVcGnxKFbhXeD_lLT5sXxyxDGEsCzWIB2CcUijSeQOYjWLMpcn",
                              "G:/download");

    }


    public static void main(String args[]) throws IOException {

        String appId = "wx7dcc6b2e03a47c0b";
        String appSecret = "fb845f65afd06d318e7a961d867f877f";
        String openId = "oEsXmwWQkf6V5KaLUMHCQHpC8F1E";

        // ��ȡ�ӿڷ���ƾ֤
        String accessToken = CommonUtil.getToken(appId, appSecret).getAccessToken();
        BufferedImage source;
        source = ImageIO.read(new File("D:\\image\\sharebase.jpg"));
        WeixinMedia wn = AdvancedUtil.uploadBufferedImageMedia(accessToken, "image", source);
        System.out.println(wn.getMediaId());
        String imageXml = AdvancedUtil.makeImageCustomMessage("oEsXmwWQkf6V5KaLUMHCQHpC8F1E", wn.getMediaId());
        String imageXml1 = AdvancedUtil.makeTextCustomMessage("oEsXmwWQkf6V5KaLUMHCQHpC8F1E", "fjj");
        //        oEsXmwWQkf6V5KaLUMHCQHpC8F1E   jgk
        AdvancedUtil.sendCustomMessage(accessToken, imageXml1);
        AdvancedUtil.sendCustomMessage(accessToken, imageXml);


        //testSendTxt(accessToken, openId);
        //testClient.testSendArtcle(accessToken, openId);
        // testClient.testGetUserInfo(accessToken, "oEsXmwevRBKrtdgMndLT1ZzZPVyM");
        //testClient.testGetUserGroupList(accessToken, openId);
        //        WeixinQRCode wqc = testClient.testCreateQRCode(accessToken, openId);
        //        testClient.testGetQRCode(accessToken, wqc.getTicket());
        //        WeixinOauth2Token wot = AdvancedUtil.getOauth2AccessToken(appId, appSecret, "0016da850b03f065d9fa4ea8751c025r");
        //        System.out.println(wot);
        //String s="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7dcc6b2e03a47c0b&redirect_uri=http://www.ycunicom.com/wx06/oauthServlet&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect"

    }

}
