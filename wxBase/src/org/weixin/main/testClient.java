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
     * 发送客服消息（文本消息）
     */
    public static void testSendTxt(String accessToken, String openId) {
        // 组装文本客服消息
        String jsonTextMsg = AdvancedUtil.makeTextCustomMessage(openId, "laojiang");
        // 发送客服消息
        AdvancedUtil.sendCustomMessage(accessToken, jsonTextMsg);

    }

    public static void testSendArtcle(String accessToken, String openId) {
        /**
         * 发送客服消息（图文消息）
         */
        Article article1 = new Article();
        article1.setTitle("微信上也能斗地主");
        article1.setDescription("");
        article1.setPicUrl("http://www.egouji.com/xiaoq/game/doudizhu_big.png");
        article1.setUrl("http://resource.duopao.com/duopao/games/small_games/weixingame/Doudizhu/doudizhu.htm");
        Article article2 = new Article();
        article2.setTitle("傲气雄鹰\n80后不得不玩的经典游戏");
        article2.setDescription("");
        article2.setPicUrl("http://www.egouji.com/xiaoq/game/aoqixiongying.png");
        article2.setUrl("http://resource.duopao.com/duopao/games/small_games/weixingame/Plane/aoqixiongying.html");
        List<Article> list = new ArrayList<Article>();
        list.add(article1);
        list.add(article2);
        // 组装图文客服消息
        String jsonNewsMsg = AdvancedUtil.makeNewsCustomMessage("oEdzejiHCDqafJbz4WNJtWTMbDcE", list);
        // 发送客服消息
        AdvancedUtil.sendCustomMessage(accessToken, jsonNewsMsg);

    }


    public static WeixinQRCode testCreateQRCode(String accessToken, String openId) {
        /**
             * 创建临时二维码
             */
        WeixinQRCode weixinQRCode = AdvancedUtil.createTemporaryQRCode(accessToken, 7 * 24 * 3600, 111111);
        // 临时二维码的ticket
        //System.out.println("ticket=" + weixinQRCode.getTicket());
        // 临时二维码的有效时间
        //System.out.println("有效期=" + weixinQRCode.getExpireSeconds());

        return weixinQRCode;
    }

    public static void testGetQRCode(String accessToken, String ticket) {
        /**
             * 根据ticket换取二维码
             */



        //        String ticket =
        //            "gQEj8joAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL056ci1iVERsWVdFWVEtYklFUlRXAAIE/ISHVgMEhAMAAA==";
        String savePath = "d:/temp";
        // 根据ticket换取二维码
        AdvancedUtil.getQRCode(ticket, savePath);
    }

    public static void testGetUserInfo(String accessToken, String openId) {
        /**
             * 获取用户信息
             */
        WeixinUserInfo user = AdvancedUtil.getUserInfo(accessToken, openId);
//        System.out.println("OpenID：" + user.getOpenId());
//        System.out.println("关注状态：" + user.getSubscribe());
//        System.out.println("关注时间：" + user.getSubscribeTime());
//        System.out.println("昵称：" + user.getNickname());
//        System.out.println("性别：" + user.getSex());
//        System.out.println("国家：" + user.getCountry());
//        System.out.println("省份：" + user.getProvince());
//        System.out.println("城市：" + user.getCity());
//        System.out.println("语言：" + user.getLanguage());
//        System.out.println("头像：" + user.getHeadImgUrl());
    }

    public static void testGetUserGroupList(String accessToken, String openId) {
        /**
        * 获取关注者列表
        */
        WeixinUserList weixinUserList = AdvancedUtil.getUserList(accessToken, "");
        System.out.println("总关注用户数：" + weixinUserList.getTotal());
        System.out.println("本次获取用户数：" + weixinUserList.getCount());
        System.out.println("OpenID列表：" + weixinUserList.getOpenIdList().toString());
        System.out.println("next_openid：" + weixinUserList.getNextOpenId());

        /**
         * 查询分组
         */
        List<WeixinGroup> groupList = AdvancedUtil.getGroups(accessToken);
        // 循环输出各分组信息
        for (WeixinGroup group : groupList) {
            System.out.println(String.format("ID：%d 名称：%s 用户数：%d", group.getId(), group.getName(), group.getCount()));
        }

        /**
        * 创建分组
        */
        WeixinGroup group = AdvancedUtil.createGroup(accessToken, "公司员工");
        System.out.println(String.format("成功创建分组：%s id：%d", group.getName(), group.getId()));

        /**
        * 修改分组名
        */
        AdvancedUtil.updateGroup(accessToken, 100, "同事");

        /**
                 * 移动用户分组
                 */
        AdvancedUtil.updateMemberGroup(accessToken, openId, 100);

    }

    public static void testGetMedia(String accessToken, String openId) {
        /**
                 * 上传多媒体文件
                 */
        WeixinMedia weixinMedia =
            AdvancedUtil.uploadMedia(accessToken, "voice", "http://localhost:8080/weixinmpapi/test.mp3");
        System.out.println(weixinMedia.getMediaId());
        System.out.println(weixinMedia.getType());
        System.out.println(weixinMedia.getCreatedAt());

        /**
                 * 下载多媒体文件
                 */
        AdvancedUtil.getMedia(accessToken, "N7xWhOGYSLWUMPzVcGnxKFbhXeD_lLT5sXxyxDGEsCzWIB2CcUijSeQOYjWLMpcn",
                              "G:/download");

    }


    public static void main(String args[]) throws IOException {

        String appId = "wx7dcc6b2e03a47c0b";
        String appSecret = "fb845f65afd06d318e7a961d867f877f";
        String openId = "oEsXmwWQkf6V5KaLUMHCQHpC8F1E";

        // 获取接口访问凭证
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
